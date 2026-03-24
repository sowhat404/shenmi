package me.rerere.rikkahub.ui.components.ai

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.content.MediaType
import androidx.compose.foundation.content.ReceiveContentListener
import androidx.compose.foundation.content.consume
import androidx.compose.foundation.content.contentReceiver
import androidx.compose.foundation.content.hasMediaType
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.isImeVisible
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.role
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEach
import androidx.compose.ui.window.DialogProperties
import androidx.core.content.FileProvider
import androidx.core.net.toFile
import androidx.core.net.toUri
import coil3.compose.AsyncImage
import androidx.compose.ui.draw.shadow
import com.dokar.sonner.ToastType
import com.yalantis.ucrop.UCrop
import com.yalantis.ucrop.UCropActivity
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.hazeEffect
import dev.chrisbanes.haze.materials.HazeMaterials
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import me.rerere.ai.core.ReasoningLevel
import me.rerere.ai.provider.BuiltInTools
import me.rerere.ai.provider.Model
import me.rerere.ai.provider.ModelAbility
import me.rerere.ai.provider.ModelType
import me.rerere.ai.provider.ProviderSetting
import me.rerere.ai.registry.ModelRegistry
import me.rerere.ai.ui.UIMessagePart
import me.rerere.common.android.appTempFolder
import me.rerere.hugeicons.HugeIcons
import me.rerere.hugeicons.stroke.Add01
import me.rerere.hugeicons.stroke.ArrowUp02
import me.rerere.hugeicons.stroke.Book03
import me.rerere.hugeicons.stroke.Camera01
import me.rerere.hugeicons.stroke.Cancel01
import me.rerere.hugeicons.stroke.Files02
import me.rerere.hugeicons.stroke.FullScreen
import me.rerere.hugeicons.stroke.GlobalSearch
import me.rerere.hugeicons.stroke.Idea
import me.rerere.hugeicons.stroke.Idea01
import me.rerere.hugeicons.stroke.Image02
import me.rerere.hugeicons.stroke.Mic01
import me.rerere.hugeicons.stroke.MusicNote03
import me.rerere.hugeicons.stroke.Package
import me.rerere.hugeicons.stroke.Package01
import me.rerere.hugeicons.stroke.Video01
import me.rerere.hugeicons.stroke.Zap
import me.rerere.rikkahub.R
import me.rerere.rikkahub.Screen
import me.rerere.rikkahub.data.ai.mcp.McpManager
import me.rerere.rikkahub.data.datastore.Settings
import me.rerere.rikkahub.data.datastore.SettingsStore
import me.rerere.rikkahub.data.datastore.findProvider
import me.rerere.rikkahub.data.datastore.getCurrentAssistant
import me.rerere.rikkahub.data.datastore.getCurrentChatModel
import me.rerere.rikkahub.data.datastore.getQuickMessagesOfAssistant
import me.rerere.rikkahub.data.files.FilesManager
import me.rerere.rikkahub.data.model.Assistant
import me.rerere.rikkahub.data.model.Conversation
import me.rerere.rikkahub.data.model.QuickMessage
import me.rerere.rikkahub.ui.components.ui.ExtensionSelector
import me.rerere.rikkahub.ui.components.ui.KeepScreenOn
import me.rerere.rikkahub.ui.components.ui.permission.PermissionCamera
import me.rerere.rikkahub.ui.theme.ClaudeIcons
import me.rerere.rikkahub.ui.components.ui.permission.PermissionManager
import me.rerere.rikkahub.ui.components.ui.permission.rememberPermissionState
import me.rerere.rikkahub.ui.context.LocalNavController
import me.rerere.rikkahub.ui.context.LocalSettings
import me.rerere.rikkahub.ui.context.LocalToaster
import me.rerere.rikkahub.ui.hooks.ChatInputState
import org.koin.compose.koinInject
import java.io.File
import kotlin.time.Duration.Companion.seconds
import kotlin.uuid.Uuid
import me.rerere.search.SearchServiceOptions

enum class ExpandState {
    Collapsed, Files,
}

private enum class CapabilitySheetTab {
    Search,
    Reasoning,
}

@Composable
fun ChatInput(
    state: ChatInputState,
    loading: Boolean,
    conversation: Conversation,
    settings: Settings,
    mcpManager: McpManager,
    hazeState: HazeState,
    enableSearch: Boolean,
    onToggleSearch: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    onUpdateChatModel: (Model) -> Unit,
    onUpdateAssistant: (Assistant) -> Unit,
    onUpdateSearchService: (Int) -> Unit,
    onCompressContext: (additionalPrompt: String, targetTokens: Int, keepRecentMessages: Int) -> Job,
    onCancelClick: () -> Unit,
    onSendClick: () -> Unit,
    onLongSendClick: () -> Unit,
) {
    val toaster = LocalToaster.current
    val assistant = settings.getCurrentAssistant()
    val chatModel = settings.getCurrentChatModel()
    val hazeTintColor = MaterialTheme.colorScheme.surfaceContainerLow
    var showCapabilitySheet by remember { mutableStateOf(false) }

    val keyboardController = LocalSoftwareKeyboardController.current

    fun sendMessage() {
        keyboardController?.hide()
        if (loading) onCancelClick() else onSendClick()
    }

    fun sendMessageWithoutAnswer() {
        keyboardController?.hide()
        if (loading) onCancelClick() else onLongSendClick()
    }

    var expand by remember { mutableStateOf(ExpandState.Collapsed) }
    var showInjectionSheet by remember { mutableStateOf(false) }
    var showCompressDialog by remember { mutableStateOf(false) }
    fun dismissExpand() {
        expand = ExpandState.Collapsed
        showInjectionSheet = false
        showCompressDialog = false
    }

    fun expandToggle(type: ExpandState) {
        if (expand == type) {
            dismissExpand()
        } else {
            expand = type
        }
    }

    val context = LocalContext.current
    val filesManager: FilesManager = koinInject()

    // Camera launcher
    var cameraOutputUri by remember { mutableStateOf<Uri?>(null) }
    var cameraOutputFile by remember { mutableStateOf<File?>(null) }
    val (_, launchCameraCrop) = useCropLauncher(
        onCroppedImageReady = { croppedUri ->
            state.addImages(filesManager.createChatFilesByContents(listOf(croppedUri)))
            dismissExpand()
        },
        onCleanup = {
            cameraOutputFile?.delete()
            cameraOutputFile = null
            cameraOutputUri = null
        }
    )
    val cameraLauncher = rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) { captureSuccessful ->
        if (captureSuccessful && cameraOutputUri != null) {
            if (settings.displaySetting.skipCropImage) {
                state.addImages(filesManager.createChatFilesByContents(listOf(cameraOutputUri!!)))
                cameraOutputFile?.delete()
                cameraOutputFile = null
                cameraOutputUri = null
                dismissExpand()
            } else {
                launchCameraCrop(cameraOutputUri!!)
            }
        } else {
            cameraOutputFile?.delete()
            cameraOutputFile = null
            cameraOutputUri = null
        }
    }
    val onLaunchCamera: () -> Unit = {
        cameraOutputFile = context.cacheDir.resolve("camera_${Uuid.random()}.jpg")
        cameraOutputUri = FileProvider.getUriForFile(
            context, "${context.packageName}.fileprovider", cameraOutputFile!!
        )
        cameraLauncher.launch(cameraOutputUri!!)
    }

    // Image picker launcher
    var preCropTempFile by remember { mutableStateOf<File?>(null) }
    val (_, launchImageCrop) = useCropLauncher(
        onCroppedImageReady = { croppedUri ->
            state.addImages(filesManager.createChatFilesByContents(listOf(croppedUri)))
            dismissExpand()
        },
        onCleanup = {
            preCropTempFile?.delete()
            preCropTempFile = null
        }
    )
    val imagePickerLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetMultipleContents()) { selectedUris ->
            if (selectedUris.isNotEmpty()) {
                Log.d("ImagePickButton", "Selected URIs: $selectedUris")
                if (settings.displaySetting.skipCropImage) {
                    state.addImages(filesManager.createChatFilesByContents(selectedUris))
                    dismissExpand()
                } else {
                    if (selectedUris.size == 1) {
                        val tempFile = File(context.appTempFolder, "pick_temp_${System.currentTimeMillis()}.jpg")
                        runCatching {
                            context.contentResolver.openInputStream(selectedUris.first())?.use { input ->
                                tempFile.outputStream().use { output -> input.copyTo(output) }
                            }
                            preCropTempFile = tempFile
                            launchImageCrop(tempFile.toUri())
                        }.onFailure {
                            Log.e("ImagePickButton", "Failed to copy image to temp, falling back", it)
                            launchImageCrop(selectedUris.first())
                        }
                    } else {
                        state.addImages(filesManager.createChatFilesByContents(selectedUris))
                        dismissExpand()
                    }
                }
            } else {
                Log.d("ImagePickButton", "No images selected")
            }
        }

    // Video picker launcher
    val videoPickerLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetMultipleContents()) { selectedUris ->
            if (selectedUris.isNotEmpty()) {
                state.addVideos(filesManager.createChatFilesByContents(selectedUris))
                dismissExpand()
            }
        }

    // Audio picker launcher
    val audioPickerLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetMultipleContents()) { selectedUris ->
            if (selectedUris.isNotEmpty()) {
                state.addAudios(filesManager.createChatFilesByContents(selectedUris))
                dismissExpand()
            }
        }

    // File picker launcher
    val filePickerLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.OpenMultipleDocuments()) { uris ->
            if (uris.isNotEmpty()) {
                val allowedMimeTypes = setOf(
                    "text/plain", "text/html", "text/css", "text/javascript", "text/csv", "text/xml",
                    "application/json", "application/javascript", "application/pdf",
                    "application/msword",
                    "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
                    "application/vnd.ms-excel",
                    "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                    "application/vnd.ms-powerpoint",
                    "application/vnd.openxmlformats-officedocument.presentationml.presentation"
                )
                val documents = uris.mapNotNull { uri ->
                    val fileName = filesManager.getFileNameFromUri(uri) ?: "file"
                    val mime = filesManager.getFileMimeType(uri) ?: "text/plain"
                    val isAllowed = allowedMimeTypes.contains(mime) || mime.startsWith("text/") ||
                        mime == "application/vnd.openxmlformats-officedocument.wordprocessingml.document" ||
                        mime == "application/pdf" ||
                        fileName.endsWith(".txt", ignoreCase = true) ||
                        fileName.endsWith(".md", ignoreCase = true) ||
                        fileName.endsWith(".csv", ignoreCase = true) ||
                        fileName.endsWith(".json", ignoreCase = true) ||
                        fileName.endsWith(".js", ignoreCase = true) ||
                        fileName.endsWith(".html", ignoreCase = true) ||
                        fileName.endsWith(".css", ignoreCase = true) ||
                        fileName.endsWith(".xml", ignoreCase = true) ||
                        fileName.endsWith(".py", ignoreCase = true) ||
                        fileName.endsWith(".java", ignoreCase = true) ||
                        fileName.endsWith(".kt", ignoreCase = true) ||
                        fileName.endsWith(".ts", ignoreCase = true) ||
                        fileName.endsWith(".tsx", ignoreCase = true) ||
                        fileName.endsWith(".markdown", ignoreCase = true) ||
                        fileName.endsWith(".mdx", ignoreCase = true) ||
                        fileName.endsWith(".yml", ignoreCase = true) ||
                        fileName.endsWith(".yaml", ignoreCase = true)
                    if (isAllowed) {
                        val localUri = filesManager.createChatFilesByContents(listOf(uri))[0]
                        UIMessagePart.Document(url = localUri.toString(), fileName = fileName, mime = mime)
                    } else {
                        toaster.show(
                            context.getString(R.string.chat_input_unsupported_file_type, fileName),
                            type = ToastType.Error
                        )
                        null
                    }
                }
                if (documents.isNotEmpty()) {
                    state.addFiles(documents)
                    dismissExpand()
                }
            }
        }

    // Collapse when ime is visible
    val imeVisile = WindowInsets.isImeVisible
    LaunchedEffect(imeVisile, showInjectionSheet, showCompressDialog) {
        if (imeVisile && !showInjectionSheet && !showCompressDialog) {
            dismissExpand()
        }
    }

    Surface(
        color = Color.Transparent,
    ) {
        Column(
            modifier = modifier
                .imePadding()
                .navigationBarsPadding()
                .padding(start = 18.dp, top = 8.dp, end = 18.dp, bottom = 14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 64.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 2.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                    ) {
                        Row(
                            modifier = Modifier
                                .weight(1f)
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            if (settings.mcpServers.isNotEmpty()) {
                                McpPickerButton(
                                    assistant = assistant,
                                    servers = settings.mcpServers,
                                    mcpManager = mcpManager,
                                    onUpdateAssistant = {
                                        onUpdateAssistant(it)
                                    },
                                )
                            }
                        }
                    }
                }

                Surface(
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .fillMaxWidth()
                        .then(
                            if (settings.displaySetting.enableBlurEffect) Modifier.hazeEffect(
                                state = hazeState,
                                style = HazeMaterials.ultraThin(
                                    containerColor = Color.White.copy(alpha = 0.92f)
                                )
                            )
                            else Modifier
                        ),
                    shape = RoundedCornerShape(28.dp),
                    tonalElevation = 0.dp,
                    shadowElevation = 2.dp,
                    border = BorderStroke(0.5.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.1f)),
                    color = Color.White,
                ) {
                    Column(
                        modifier = Modifier.padding(horizontal = 14.dp, vertical = 7.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        if (state.messageContent.isNotEmpty()) {
                            MediaFileInputRow(state = state)
                        }

                        TextInputRow(
                            state = state,
                            onSendMessage = { sendMessage() },
                            modifier = Modifier.fillMaxWidth()
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            ActionIconButton(
                                onClick = {
                                    expandToggle(ExpandState.Files)
                                },
                                containerColor = Color.Transparent,
                                iconSize = 32.dp,
                                size = 38.dp
                            ) {
                                Icon(
                                    imageVector = if (expand == ExpandState.Files) HugeIcons.Cancel01 else ClaudeIcons.Add,
                                    contentDescription = stringResource(R.string.more_options),
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }

                            Spacer(modifier = Modifier.weight(1f))

                            ActionIconButton(
                                onClick = {
                                    dismissExpand()
                                    showCapabilitySheet = true
                                },
                                containerColor = Color.Transparent,
                                iconSize = 32.dp,
                                size = 38.dp
                            ) {
                                Icon(
                                    imageVector = ClaudeIcons.Mic,
                                    contentDescription = stringResource(R.string.setting_provider_page_reasoning),
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }

                            Spacer(modifier = Modifier.width(6.dp))

                            Box(
                                contentAlignment = Alignment.Center,
                                modifier = Modifier
                                    .size(32.dp)
                                    .clip(CircleShape)
                                    .combinedClickable(
                                        enabled = loading || !state.isEmpty(),
                                        onClick = {
                                            dismissExpand()
                                            sendMessage()
                                        }, onLongClick = {
                                            dismissExpand()
                                            sendMessageWithoutAnswer()
                                        }
                                    )
                            ) {
                                val containerColor = when {
                                    loading -> MaterialTheme.colorScheme.errorContainer
                                    else -> Color(0xFF111111)
                                }
                                val contentColor = when {
                                    loading -> MaterialTheme.colorScheme.onErrorContainer
                                    else -> Color.White
                                }
                                Surface(
                                    modifier = Modifier.fillMaxSize(),
                                    shape = CircleShape,
                                    color = containerColor,
                                    content = {}
                                )
                                if (loading) {
                                    KeepScreenOn()
                                    Icon(
                                        imageVector = HugeIcons.Cancel01,
                                        contentDescription = stringResource(R.string.stop),
                                        tint = contentColor
                                    )
                                } else {
                                    Icon(
                                        imageVector = ClaudeIcons.Send,
                                        contentDescription = stringResource(R.string.send),
                                        tint = contentColor,
                                        modifier = Modifier.size(25.dp)
                                    )
                                }
                            }
                        }
                    }
                }
            }

            val webSearchEnabledText = stringResource(R.string.web_search_enabled)
            val webSearchDisabledText = stringResource(R.string.web_search_disabled)

            if (showCapabilitySheet) {
                CapabilitySettingsSheet(
                    enableSearch = enableSearch,
                    settings = settings,
                    assistant = assistant,
                    model = chatModel,
                    onDismiss = { showCapabilitySheet = false },
                    onToggleSearch = { enabled ->
                        onToggleSearch(enabled)
                        toaster.show(
                            message = if (enabled) webSearchEnabledText else webSearchDisabledText,
                            duration = 1.seconds,
                            type = if (enabled) ToastType.Success else ToastType.Normal
                        )
                    },
                    onUpdateSearchService = onUpdateSearchService,
                    onUpdateAssistant = onUpdateAssistant,
                )
            }

            // Expanded content
            Box(
                modifier = Modifier
                    .animateContentSize()
                    .fillMaxWidth()
            ) {
                BackHandler(
                    enabled = expand != ExpandState.Collapsed,
                ) {
                    dismissExpand()
                }
                if (expand == ExpandState.Files) {
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(20.dp))
                            .then(
                                if (settings.displaySetting.enableBlurEffect) Modifier.hazeEffect(
                                    state = hazeState,
                                    style = HazeMaterials.ultraThin()
                                )
                                else Modifier
                            ),
                        shape = RoundedCornerShape(20.dp),
                        tonalElevation = 0.dp,
                        color = if (settings.displaySetting.enableBlurEffect) Color.Transparent else hazeTintColor,
                    ) {
                        FilesPicker(
                            conversation = conversation,
                            state = state,
                            assistant = assistant,
                            onCompressContext = onCompressContext,
                            onUpdateAssistant = onUpdateAssistant,
                            showInjectionSheet = showInjectionSheet,
                            onShowInjectionSheetChange = { showInjectionSheet = it },
                            showCompressDialog = showCompressDialog,
                            onShowCompressDialogChange = { showCompressDialog = it },
                            onDismiss = { dismissExpand() },
                            onTakePic = onLaunchCamera,
                            onPickImage = { imagePickerLauncher.launch("image/*") },
                            onPickVideo = { videoPickerLauncher.launch("video/*") },
                            onPickAudio = { audioPickerLauncher.launch("audio/*") },
                            onPickFile = { filePickerLauncher.launch(arrayOf("*/*")) },
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun ActionIconButton(
    onClick: () -> Unit,
    containerColor: Color = Color.Transparent,
    iconSize: androidx.compose.ui.unit.Dp = 20.dp,
    size: androidx.compose.ui.unit.Dp = 36.dp,
    content: @Composable () -> Unit,
) {
    Surface(
        onClick = onClick,
        modifier = Modifier.size(size),
        shape = CircleShape,
        tonalElevation = 0.dp,
        color = containerColor,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
        ) {
            content()
        }
    }
}

@Composable
private fun CapabilitySettingsSheet(
    enableSearch: Boolean,
    settings: Settings,
    assistant: Assistant,
    model: Model?,
    onDismiss: () -> Unit,
    onToggleSearch: (Boolean) -> Unit,
    onUpdateSearchService: (Int) -> Unit,
    onUpdateAssistant: (Assistant) -> Unit,
) {
    val settingsStore: SettingsStore = koinInject()
    val scope = rememberCoroutineScope()
    val builtInSearchSupported = model != null && (
        ModelRegistry.GEMINI_SERIES.match(model.modelId) || model.modelId.contains("gpt-")
    )
    var tab by remember { mutableStateOf(CapabilitySheetTab.Search) }
    var customReasoningInput by remember(assistant.thinkingBudget) {
        mutableStateOf((assistant.thinkingBudget ?: 0).toString())
    }

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.82f)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                CapabilitySheetTab.entries.forEach { item ->
                    val selected = tab == item
                    val containerColor by animateColorAsState(
                        if (selected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceContainerLow
                    )
                    val contentColor by animateColorAsState(
                        if (selected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Surface(
                        onClick = { tab = item },
                        modifier = Modifier.weight(1f),
                        shape = RoundedCornerShape(20.dp),
                        color = containerColor,
                        border = BorderStroke(
                            1.dp,
                            if (selected) MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)
                            else MaterialTheme.colorScheme.outline.copy(alpha = 0.10f)
                        )
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 14.dp, vertical = 12.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = if (item == CapabilitySheetTab.Search) HugeIcons.GlobalSearch else HugeIcons.Idea01,
                                contentDescription = null,
                                tint = contentColor
                            )
                            Text(
                                text = if (item == CapabilitySheetTab.Search) stringResource(R.string.search_picker_title) else stringResource(R.string.setting_provider_page_reasoning),
                                color = contentColor,
                                modifier = Modifier.padding(start = 8.dp)
                            )
                        }
                    }
                }
            }

            if (tab == CapabilitySheetTab.Search) {
                if (builtInSearchSupported && model != null) {
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = MaterialTheme.colorScheme.surface,
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.10f))
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 14.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(HugeIcons.GlobalSearch, null)
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = stringResource(R.string.built_in_search_title),
                                    style = MaterialTheme.typography.titleMedium,
                                )
                                Text(
                                    text = stringResource(R.string.built_in_search_description),
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                )
                            }
                            Switch(
                                checked = model.tools.contains(BuiltInTools.Search),
                                onCheckedChange = { checked ->
                                    val latestSettings = settingsStore.settingsFlow.value
                                    scope.launch {
                                        settingsStore.update(
                                            latestSettings.copy(
                                                providers = latestSettings.providers.map { providerSetting ->
                                                    providerSetting.editModel(
                                                        model.copy(
                                                            tools = if (checked) model.tools + BuiltInTools.Search else model.tools - BuiltInTools.Search
                                                        )
                                                    )
                                                }
                                            )
                                        )
                                    }
                                }
                            )
                        }
                    }
                }

                if (model?.tools?.contains(BuiltInTools.Search) != true) {
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = MaterialTheme.colorScheme.surface,
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.10f))
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 14.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(HugeIcons.GlobalSearch, null)
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = stringResource(R.string.use_web_search),
                                    style = MaterialTheme.typography.titleMedium,
                                )
                                Text(
                                    text = if (enableSearch) stringResource(R.string.web_search_enabled) else stringResource(R.string.web_search_disabled),
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                )
                            }
                            Switch(
                                checked = enableSearch,
                                onCheckedChange = onToggleSearch,
                            )
                        }
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f, fill = false)
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        settings.searchServices.forEachIndexed { index, service ->
                            val selected = settings.searchServiceSelected == index
                            val containerColor by animateColorAsState(
                                if (selected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface
                            )
                            val contentColor by animateColorAsState(
                                if (selected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface
                            )
                            Surface(
                                onClick = { onUpdateSearchService(index) },
                                shape = RoundedCornerShape(20.dp),
                                color = containerColor,
                                border = BorderStroke(
                                    1.dp,
                                    if (selected) MaterialTheme.colorScheme.primary.copy(alpha = 0.14f)
                                    else MaterialTheme.colorScheme.outline.copy(alpha = 0.10f)
                                )
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 16.dp, vertical = 14.dp),
                                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Icon(HugeIcons.GlobalSearch, null, tint = contentColor)
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = SearchServiceOptions.TYPES[service::class] ?: "Search",
                                            color = contentColor,
                                            style = MaterialTheme.typography.titleMedium,
                                        )
                                        Text(
                                            text = if (selected) "已启用" else "点击选择",
                                            color = contentColor.copy(alpha = 0.72f),
                                            style = MaterialTheme.typography.bodySmall,
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                if (model?.abilities?.contains(ModelAbility.REASONING) == true) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f, fill = false)
                            .verticalScroll(rememberScrollState()),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        listOf(
                            Triple(ReasoningLevel.OFF, stringResource(R.string.reasoning_off), 0),
                            Triple(ReasoningLevel.AUTO, stringResource(R.string.reasoning_auto), -1),
                            Triple(ReasoningLevel.LOW, stringResource(R.string.reasoning_light), 1024),
                            Triple(ReasoningLevel.MEDIUM, stringResource(R.string.reasoning_medium), 16_000),
                            Triple(ReasoningLevel.HIGH, stringResource(R.string.reasoning_heavy), 32_000),
                        ).forEach { (level, title, budget) ->
                            val selected = ReasoningLevel.fromBudgetTokens(assistant.thinkingBudget ?: 0) == level
                            val containerColor by animateColorAsState(
                                if (selected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface
                            )
                            val contentColor by animateColorAsState(
                                if (selected) MaterialTheme.colorScheme.onPrimaryContainer else MaterialTheme.colorScheme.onSurface
                            )
                            Surface(
                                onClick = {
                                    customReasoningInput = budget.toString()
                                    onUpdateAssistant(assistant.copy(thinkingBudget = budget))
                                },
                                shape = RoundedCornerShape(20.dp),
                                color = containerColor,
                                border = BorderStroke(
                                    1.dp,
                                    if (selected) MaterialTheme.colorScheme.primary.copy(alpha = 0.14f)
                                    else MaterialTheme.colorScheme.outline.copy(alpha = 0.10f)
                                )
                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(horizontal = 16.dp, vertical = 14.dp),
                                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    Icon(
                                        imageVector = when (level) {
                                            ReasoningLevel.OFF -> HugeIcons.Idea
                                            ReasoningLevel.AUTO -> HugeIcons.Idea01
                                            ReasoningLevel.LOW -> HugeIcons.Idea01
                                            ReasoningLevel.MEDIUM -> HugeIcons.Idea01
                                            ReasoningLevel.HIGH -> HugeIcons.Idea01
                                        },
                                        contentDescription = null,
                                        tint = contentColor
                                    )
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = title,
                                            color = contentColor,
                                            style = MaterialTheme.typography.titleMedium,
                                        )
                                        Text(
                                            text = budgetLabel(budget),
                                            color = contentColor.copy(alpha = 0.72f),
                                            style = MaterialTheme.typography.bodySmall,
                                        )
                                    }
                                }
                            }
                        }

                        OutlinedTextField(
                            value = customReasoningInput,
                            onValueChange = { value ->
                                customReasoningInput = value
                                value.toIntOrNull()?.let { tokens ->
                                    onUpdateAssistant(assistant.copy(thinkingBudget = tokens))
                                }
                            },
                            modifier = Modifier.fillMaxWidth(),
                            singleLine = true,
                            label = {
                                Text(stringResource(R.string.reasoning_custom))
                            }
                        )
                    }
                } else {
                    Surface(
                        shape = RoundedCornerShape(20.dp),
                        color = MaterialTheme.colorScheme.surface,
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.10f))
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 14.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Icon(HugeIcons.Idea, null)
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = stringResource(R.string.setting_provider_page_reasoning),
                                    style = MaterialTheme.typography.titleMedium,
                                )
                                Text(
                                    text = "当前模型不支持推理",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

private fun budgetLabel(tokens: Int): String {
    return when (tokens) {
        0 -> "Off"
        -1 -> "Auto"
        1024 -> "1K tokens"
        16_000 -> "16K tokens"
        32_000 -> "32K tokens"
        else -> "$tokens tokens"
    }
}

@Composable
private fun TextInputRow(
    state: ChatInputState,
    onSendMessage: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val settings = LocalSettings.current
    val filesManager: FilesManager = koinInject()
    val assistant = settings.getCurrentAssistant()
    val quickMessages = remember(settings.quickMessages, assistant.quickMessageIds) {
        settings.getQuickMessagesOfAssistant(assistant)
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        if (state.isEditing()) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = MaterialTheme.colorScheme.surfaceContainerHigh,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 14.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = stringResource(R.string.editing))
                    Spacer(Modifier.weight(1f))
                    Icon(
                        imageVector = HugeIcons.Cancel01,
                        contentDescription = stringResource(R.string.cancel_edit),
                        modifier = Modifier.clickable { state.clearInput() }
                    )
                }
            }
        }

        var isFocused by remember { mutableStateOf(false) }
        var isFullScreen by remember { mutableStateOf(false) }
        val receiveContentListener = remember(
            settings.displaySetting.pasteLongTextAsFile, settings.displaySetting.pasteLongTextThreshold
        ) {
            ReceiveContentListener { transferableContent ->
                when {
                    transferableContent.hasMediaType(MediaType.Image) -> {
                        transferableContent.consume { item ->
                            val uri = item.uri
                            if (uri != null) {
                                state.addImages(
                                    filesManager.createChatFilesByContents(
                                        listOf(uri)
                                    )
                                )
                            }
                            uri != null
                        }
                    }

                    settings.displaySetting.pasteLongTextAsFile && transferableContent.hasMediaType(MediaType.Text) -> {
                        transferableContent.consume { item ->
                            val text = item.text?.toString()
                            if (text != null && text.length > settings.displaySetting.pasteLongTextThreshold) {
                                val document = filesManager.createChatTextFile(text)
                                state.addFiles(listOf(document))
                                true
                            } else {
                                false
                            }
                        }
                    }

                    else -> transferableContent
                }
            }
        }
        TextField(
            state = state.textContent,
            modifier = Modifier
                .fillMaxWidth()
                .contentReceiver(receiveContentListener)
                .onFocusChanged {
                    isFocused = it.isFocused
                },
            shape = RoundedCornerShape(22.dp),
            placeholder = {
                Text(
                    text = stringResource(R.string.chat_input_placeholder),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.offset(x = (-2).dp, y = (-4).dp)
                )
            },
            lineLimits = TextFieldLineLimits.MultiLine(maxHeightInLines = 5),
            keyboardOptions = KeyboardOptions(
                imeAction = if (settings.displaySetting.sendOnEnter) ImeAction.Send else ImeAction.Default
            ),
            onKeyboardAction = {
                if (settings.displaySetting.sendOnEnter && !state.isEmpty()) {
                    onSendMessage()
                }
            },
            colors = TextFieldDefaults.colors().copy(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
            ),
            trailingIcon = {
                if (isFocused) {
                    IconButton(
                        onClick = {
                            isFullScreen = !isFullScreen
                        }) {
                        Icon(HugeIcons.FullScreen, null)
                    }
                }
            },
            leadingIcon = if (quickMessages.isNotEmpty()) {
                {
                    QuickMessageButton(quickMessages = quickMessages, state = state)
                }
            } else null,
        )
        if (isFullScreen) {
            FullScreenEditor(state = state) {
                isFullScreen = false
            }
        }
    }
}

@Composable
private fun QuickMessageButton(
    quickMessages: List<QuickMessage>,
    state: ChatInputState,
) {
    var expanded by remember { mutableStateOf(false) }
    IconButton(
        onClick = {
            expanded = !expanded
        }) {
        Icon(HugeIcons.Zap, null)
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .widthIn(min = 200.dp)
                .width(IntrinsicSize.Min)
        ) {
            quickMessages.forEach { quickMessage ->
                Surface(
                    onClick = {
                        state.appendText(quickMessage.content)
                        expanded = false
                    },
                    color = Color.Transparent,
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Column(
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(
                            text = quickMessage.title,
                            style = MaterialTheme.typography.titleMedium,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                        Text(
                            text = quickMessage.content,
                            style = MaterialTheme.typography.bodySmall,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun MediaFileInputRow(
    state: ChatInputState,
) {
    val filesManager: FilesManager = koinInject()
    val managedFiles by filesManager.observe().collectAsState(initial = emptyList())
    val displayNameByRelativePath = remember(managedFiles) {
        managedFiles.associate { it.relativePath to it.displayName }
    }
    val displayNameByFileName = remember(managedFiles) {
        managedFiles.associate { it.relativePath.substringAfterLast('/') to it.displayName }
    }

    fun removePart(part: UIMessagePart, url: String) {
        state.messageContent = state.messageContent.filterNot { it == part }
        if (state.shouldDeleteFileOnRemove(part)) {
            filesManager.deleteChatFiles(listOf(url.toUri()))
        }
    }

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 6.dp, vertical = 2.dp)
            .horizontalScroll(rememberScrollState())
    ) {
        state.messageContent.fastForEach { part ->
            when (part) {
                is UIMessagePart.Image -> {
                    AttachmentChip(
                        title = attachmentNameFromUrl(
                            url = part.url,
                            fallback = "image",
                            displayNameByRelativePath = displayNameByRelativePath,
                            displayNameByFileName = displayNameByFileName
                        ),
                        leading = {
                            Surface(
                                modifier = Modifier.size(34.dp),
                                shape = RoundedCornerShape(10.dp),
                                color = MaterialTheme.colorScheme.surfaceContainerHigh,
                            ) {
                                AsyncImage(
                                    model = part.url,
                                    contentDescription = null,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )
                            }
                        },
                        onRemove = { removePart(part, part.url) }
                    )
                }

                is UIMessagePart.Video -> {
                    AttachmentChip(
                        title = attachmentNameFromUrl(
                            url = part.url,
                            fallback = "video",
                            displayNameByRelativePath = displayNameByRelativePath,
                            displayNameByFileName = displayNameByFileName
                        ),
                        leading = { AttachmentLeadingIcon(icon = HugeIcons.Video01) },
                        onRemove = { removePart(part, part.url) }
                    )
                }

                is UIMessagePart.Audio -> {
                    AttachmentChip(
                        title = attachmentNameFromUrl(
                            url = part.url,
                            fallback = "audio",
                            displayNameByRelativePath = displayNameByRelativePath,
                            displayNameByFileName = displayNameByFileName
                        ),
                        leading = { AttachmentLeadingIcon(icon = HugeIcons.MusicNote03) },
                        onRemove = { removePart(part, part.url) }
                    )
                }

                is UIMessagePart.Document -> {
                    AttachmentChip(
                        title = attachmentNameFromUrl(
                            url = part.url,
                            fallback = part.fileName,
                            displayNameByRelativePath = displayNameByRelativePath,
                            displayNameByFileName = displayNameByFileName
                        ),
                        leading = { AttachmentLeadingIcon(icon = HugeIcons.Files02) },
                        onRemove = { removePart(part, part.url) }
                    )
                }

                else -> Unit
            }
        }
    }
}

@Composable
private fun AttachmentChip(
    title: String,
    leading: @Composable () -> Unit,
    onRemove: () -> Unit,
) {
    Surface(
        shape = RoundedCornerShape(18.dp),
        tonalElevation = 1.dp,
        shadowElevation = 0.dp,
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant.copy(alpha = 0.35f))
    ) {
        Row(
            modifier = Modifier
                .height(44.dp)
                .padding(start = 8.dp, end = 6.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            leading()
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.widthIn(min = 40.dp, max = 180.dp),
            )
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(26.dp)
                    .clickable(onClick = onRemove),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = HugeIcons.Cancel01,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

@Composable
private fun AttachmentLeadingIcon(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
) {
    Surface(
        modifier = Modifier.size(34.dp),
        shape = RoundedCornerShape(10.dp),
        color = MaterialTheme.colorScheme.surfaceContainerHigh,
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

private fun attachmentNameFromUrl(
    url: String,
    fallback: String,
    displayNameByRelativePath: Map<String, String>,
    displayNameByFileName: Map<String, String>,
): String {
    val parsed = runCatching { url.toUri() }.getOrNull()
    val relativePath = parsed?.path?.substringAfter("/files/", missingDelimiterValue = "")?.takeIf { it.isNotBlank() }
    if (relativePath != null) {
        displayNameByRelativePath[relativePath]?.let { return it }
    }

    val storedFileName = parsed?.lastPathSegment?.substringAfterLast('/')?.takeIf { it.isNotBlank() }
    if (storedFileName != null) {
        displayNameByFileName[storedFileName]?.let { return it }
        return storedFileName
    }

    return fallback
}

@Composable
private fun FilesPicker(
    conversation: Conversation,
    assistant: Assistant,
    state: ChatInputState,
    onCompressContext: (additionalPrompt: String, targetTokens: Int, keepRecentMessages: Int) -> Job,
    onUpdateAssistant: (Assistant) -> Unit,
    showInjectionSheet: Boolean,
    onShowInjectionSheetChange: (Boolean) -> Unit,
    showCompressDialog: Boolean,
    onShowCompressDialogChange: (Boolean) -> Unit,
    onDismiss: () -> Unit,
    onTakePic: () -> Unit,
    onPickImage: () -> Unit,
    onPickVideo: () -> Unit,
    onPickAudio: () -> Unit,
    onPickFile: () -> Unit,
) {
    val settings = LocalSettings.current
    val provider = settings.getCurrentChatModel()?.findProvider(providers = settings.providers)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            TakePicButton(onLaunchCamera = onTakePic)

            ImagePickButton(onClick = onPickImage)

            if (provider != null && provider is ProviderSetting.Google) {
                VideoPickButton(onClick = onPickVideo)

                AudioPickButton(onClick = onPickAudio)
            }

            FilePickButton(onClick = onPickFile)
        }

        HorizontalDivider(
            modifier = Modifier.fillMaxWidth()
        )

        // Extensions (Quick Messages + Prompt Injections + Skills)
        val activeCount =
            assistant.quickMessageIds.size + assistant.modeInjectionIds.size + assistant.lorebookIds.size + assistant.enabledSkills.size
        ListItem(
            leadingContent = {
                Icon(
                    imageVector = HugeIcons.Package,
                    contentDescription = stringResource(R.string.assistant_page_tab_extensions),
                )
            },
            headlineContent = {
                Text(stringResource(R.string.assistant_page_tab_extensions))
            },
            trailingContent = {
                if (activeCount > 0) {
                    Text(
                        text = activeCount.toString(),
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.primary,
                    )
                }
            },
            modifier = Modifier
                .clip(MaterialTheme.shapes.large)
                .clickable {
                    onShowInjectionSheetChange(true)
                },
        )

        // Compress History Button
        ListItem(
            leadingContent = {
                Icon(
                    imageVector = HugeIcons.Package01,
                    contentDescription = stringResource(R.string.chat_page_compress_context),
                )
            },
            headlineContent = {
                Text(stringResource(R.string.chat_page_compress_context))
            },
            trailingContent = {
                if (conversation.messageNodes.isNotEmpty()) {
                    Text(
                        text = stringResource(R.string.chat_page_message_count, conversation.messageNodes.size),
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            },
            modifier = Modifier
                .clip(MaterialTheme.shapes.large)
                .clickable {
                    onShowCompressDialogChange(true)
                },
        )
    }

    // Injection Bottom Sheet
    if (showInjectionSheet) {
        InjectionQuickConfigSheet(
            assistant = assistant,
            settings = settings,
            onUpdateAssistant = onUpdateAssistant,
            onDismiss = { onShowInjectionSheetChange(false) })
    }

    // Compress Context Dialog
    if (showCompressDialog) {
        CompressContextDialog(onDismiss = {
            onShowCompressDialogChange(false)
            onDismiss()
        }, onConfirm = { additionalPrompt, targetTokens, keepRecentMessages ->
            onCompressContext(additionalPrompt, targetTokens, keepRecentMessages)
        })
    }
}

@Composable
private fun FullScreenEditor(
    state: ChatInputState, onDone: () -> Unit
) {
    BasicAlertDialog(
        onDismissRequest = {
            onDone()
        },
        properties = DialogProperties(
            usePlatformDefaultWidth = false, decorFitsSystemWindows = false
        ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .safeDrawingPadding()
                .imePadding(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Surface(
                modifier = Modifier
                    .widthIn(max = 800.dp)
                    .fillMaxHeight(0.9f),
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Row {
                        TextButton(
                            onClick = {
                                onDone()
                            }) {
                            Text(stringResource(R.string.chat_page_save))
                        }
                    }
                    TextField(
                        state = state.textContent,
                        modifier = Modifier
                            .padding(bottom = 2.dp)
                            .fillMaxSize(),
                        shape = RoundedCornerShape(32.dp),
                        placeholder = {
                            Text(
                                text = stringResource(R.string.chat_input_placeholder),
                                style = MaterialTheme.typography.bodyLarge,
                                modifier = Modifier.offset(x = (-2).dp, y = (-4).dp)
                            )
                        },
                        colors = TextFieldDefaults.colors().copy(
                            unfocusedIndicatorColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            focusedContainerColor = Color.Transparent,
                            unfocusedContainerColor = Color.Transparent,
                        ),
                    )
                }
            }
        }
    }
}

@Composable
private fun useCropLauncher(
    onCroppedImageReady: (Uri) -> Unit, onCleanup: (() -> Unit)? = null
): Pair<ActivityResultLauncher<Intent>, (Uri) -> Unit> {
    val context = LocalContext.current
    var cropOutputUri by remember { mutableStateOf<Uri?>(null) }

    val cropActivityLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == android.app.Activity.RESULT_OK) {
            cropOutputUri?.let { croppedUri ->
                onCroppedImageReady(croppedUri)
            }
        }
        // Clean up crop output file
        cropOutputUri?.toFile()?.delete()
        cropOutputUri = null
        onCleanup?.invoke()
    }

    val launchCrop: (Uri) -> Unit = { sourceUri ->
        val outputFile = File(context.appTempFolder, "crop_output_${System.currentTimeMillis()}.jpg")
        cropOutputUri = Uri.fromFile(outputFile)

        val cropIntent = UCrop.of(sourceUri, cropOutputUri!!).withOptions(UCrop.Options().apply {
            setFreeStyleCropEnabled(true)
            setAllowedGestures(
                UCropActivity.SCALE, UCropActivity.ROTATE, UCropActivity.NONE
            )
            setCompressionFormat(Bitmap.CompressFormat.PNG)
        }).withMaxResultSize(4096, 4096).getIntent(context)

        cropActivityLauncher.launch(cropIntent)
    }

    return Pair(cropActivityLauncher, launchCrop)
}

@Composable
private fun ImagePickButton(onClick: () -> Unit = {}) {
    BigIconTextButton(icon = {
        Icon(HugeIcons.Image02, null)
    }, text = {
        Text(stringResource(R.string.photo))
    }) {
        onClick()
    }
}

@Composable
fun TakePicButton(onLaunchCamera: () -> Unit = {}) {
    val cameraPermission = rememberPermissionState(PermissionCamera)

    // 使用权限管理器包装
    PermissionManager(
        permissionState = cameraPermission
    ) {
        BigIconTextButton(icon = {
            Icon(HugeIcons.Camera01, null)
        }, text = {
            Text(stringResource(R.string.take_picture))
        }) {
            if (cameraPermission.allRequiredPermissionsGranted) {
                onLaunchCamera()
            } else {
                // 请求权限
                cameraPermission.requestPermissions()
            }
        }
    }
}

@Composable
fun VideoPickButton(onClick: () -> Unit = {}) {
    BigIconTextButton(icon = {
        Icon(HugeIcons.Video01, null)
    }, text = {
        Text(stringResource(R.string.video))
    }) {
        onClick()
    }
}

@Composable
fun AudioPickButton(onClick: () -> Unit = {}) {
    BigIconTextButton(icon = {
        Icon(HugeIcons.MusicNote03, null)
    }, text = {
        Text(stringResource(R.string.audio))
    }) {
        onClick()
    }
}

@Composable
fun FilePickButton(onClick: () -> Unit = {}) {
    BigIconTextButton(icon = {
        Icon(HugeIcons.Files02, null)
    }, text = {
        Text(stringResource(R.string.upload_file))
    }) {
        onClick()
    }
}


@Composable
private fun BigIconTextButton(
    modifier: Modifier = Modifier,
    icon: @Composable () -> Unit,
    text: @Composable () -> Unit,
    onClick: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable(
                interactionSource = interactionSource, indication = LocalIndication.current, onClick = onClick
            )
            .semantics {
                role = Role.Button
            }
            .wrapContentWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Surface(
            tonalElevation = 2.dp, shape = RoundedCornerShape(8.dp)
        ) {
            Box(
                modifier = Modifier.padding(horizontal = 32.dp, vertical = 16.dp)
            ) {
                icon()
            }
        }
        ProvideTextStyle(MaterialTheme.typography.bodySmall) {
            text()
        }
    }
}

@Composable
private fun InjectionQuickConfigSheet(
    assistant: Assistant, settings: Settings, onUpdateAssistant: (Assistant) -> Unit, onDismiss: () -> Unit
) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val scope = rememberCoroutineScope()
    val navController = LocalNavController.current

    ModalBottomSheet(
        onDismissRequest = onDismiss,
        sheetState = sheetState,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.75f)
                .padding(horizontal = 16.dp),
        ) {
            ExtensionSelector(
                assistant = assistant,
                settings = settings,
                onUpdate = onUpdateAssistant,
                modifier = Modifier.weight(1f),
                onNavigateToQuickMessages = {
                    scope.launch {
                        sheetState.hide()
                        onDismiss()
                        navController.navigate(Screen.QuickMessages)
                    }
                },
                onNavigateToPrompts = {
                    scope.launch {
                        sheetState.hide()
                        onDismiss()
                        navController.navigate(Screen.Prompts)
                    }
                },
                onNavigateToSkills = {
                    scope.launch {
                        sheetState.hide()
                        onDismiss()
                        navController.navigate(Screen.Skills)
                    }
                })

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BigIconTextButtonPreview() {
    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        BigIconTextButton(icon = {
            Icon(HugeIcons.Image02, null)
        }, text = {
            Text(stringResource(R.string.photo))
        }) {}
    }
}

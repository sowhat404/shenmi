package me.rerere.rikkahub.ui.theme.presets

import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import me.rerere.rikkahub.R
import me.rerere.rikkahub.ui.theme.PresetTheme

val ClaudeThemePreset by lazy {
    PresetTheme(
        id = "claude",
        name = {
            Text(stringResource(id = R.string.theme_name_claude))
        },
        standardLight = lightScheme,
        standardDark = darkScheme,
    )
}

private val primaryLight = Color(0xFFC86442)
private val onPrimaryLight = Color(0xFFFFFFFF)
private val primaryContainerLight = Color(0xFFF3D5CA)
private val onPrimaryContainerLight = Color(0xFF5B2210)
private val secondaryLight = Color(0xFFF1EEE7)
private val onSecondaryLight = Color(0xFF51473E)
private val secondaryContainerLight = Color(0xFFF5F2EC)
private val onSecondaryContainerLight = Color(0xFF4B433A)
private val tertiaryLight = Color(0xFFE9E2D7)
private val onTertiaryLight = Color(0xFF55493E)
private val tertiaryContainerLight = Color(0xFFF6F1E8)
private val onTertiaryContainerLight = Color(0xFF4F463C)
private val errorLight = Color(0xFFBA1A1A)
private val onErrorLight = Color(0xFFFFFFFF)
private val errorContainerLight = Color(0xFFFFDAD6)
private val onErrorContainerLight = Color(0xFF93000A)
private val backgroundLight = Color(0xFFFAF9F5)
private val onBackgroundLight = Color(0xFF1F2328)
private val surfaceLight = Color(0xFFFAF9F5)
private val onSurfaceLight = Color(0xFF1F2328)
private val surfaceVariantLight = Color(0xFFF5F5ED)
private val onSurfaceVariantLight = Color(0xFF6F685F)
private val outlineLight = Color(0xFFC9C2B8)
private val outlineVariantLight = Color(0xFFD6D3CE)
private val scrimLight = Color(0xFF000000)
private val inverseSurfaceLight = Color(0xFF322C26)
private val inverseOnSurfaceLight = Color(0xFFF9F6F0)
private val inversePrimaryLight = Color(0xFFFFB69F)
private val surfaceDimLight = Color(0xFFEDE8DE)
private val surfaceBrightLight = Color(0xFFFAF9F5)
private val surfaceContainerLowestLight = Color(0xFFFFFFFF)
private val surfaceContainerLowLight = Color(0xFFF8F6F0)
private val surfaceContainerLight = Color(0xFFF5F2EC)
private val surfaceContainerHighLight = Color(0xFFF1EEE7)
private val surfaceContainerHighestLight = Color(0xFFEAE5DC)

private val primaryDark = Color(0xFFFFB69F)
private val onPrimaryDark = Color(0xFF6B301B)
private val primaryContainerDark = Color(0xFF8B492F)
private val onPrimaryContainerDark = Color(0xFFFFDBCF)
private val secondaryDark = Color(0xFFE3DDD3)
private val onSecondaryDark = Color(0xFF393129)
private val secondaryContainerDark = Color(0xFF564B41)
private val onSecondaryContainerDark = Color(0xFFF5F2EC)
private val tertiaryDark = Color(0xFFD9D0C3)
private val onTertiaryDark = Color(0xFF3F352B)
private val tertiaryContainerDark = Color(0xFF5C5044)
private val onTertiaryContainerDark = Color(0xFFF6F1E8)
private val errorDark = Color(0xFFFFB4AB)
private val onErrorDark = Color(0xFF690005)
private val errorContainerDark = Color(0xFF93000A)
private val onErrorContainerDark = Color(0xFFFFDAD6)
private val backgroundDark = Color(0xFF171411)
private val onBackgroundDark = Color(0xFFF0E9E0)
private val surfaceDark = Color(0xFF171411)
private val onSurfaceDark = Color(0xFFF0E9E0)
private val surfaceVariantDark = Color(0xFF4B433C)
private val onSurfaceVariantDark = Color(0xFFD2C7BC)
private val outlineDark = Color(0xFF9A8F84)
private val outlineVariantDark = Color(0xFF534A42)
private val scrimDark = Color(0xFF000000)
private val inverseSurfaceDark = Color(0xFFF0E9E0)
private val inverseOnSurfaceDark = Color(0xFF322C26)
private val inversePrimaryDark = Color(0xFFC86442)
private val surfaceDimDark = Color(0xFF171411)
private val surfaceBrightDark = Color(0xFF403832)
private val surfaceContainerLowestDark = Color(0xFF120F0C)
private val surfaceContainerLowDark = Color(0xFF211C18)
private val surfaceContainerDark = Color(0xFF28221D)
private val surfaceContainerHighDark = Color(0xFF312A24)
private val surfaceContainerHighestDark = Color(0xFF3B342D)

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

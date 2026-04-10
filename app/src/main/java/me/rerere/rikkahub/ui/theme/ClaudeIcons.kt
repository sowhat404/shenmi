package me.rerere.rikkahub.ui.theme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

object ClaudeIcons {
    val Add: ImageVector by lazy {
        ImageVector.Builder(
            name = "AnthropiconAdd",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF141413)),
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(12f, 2.95f)
                curveTo(12.414f, 2.95f, 12.75f, 3.286f, 12.75f, 3.7f)
                verticalLineTo(11.25f)
                horizontalLineTo(20.25f)
                curveTo(20.664f, 11.25f, 21f, 11.586f, 21f, 12f)
                curveTo(21f, 12.414f, 20.664f, 12.75f, 20.25f, 12.75f)
                horizontalLineTo(12.75f)
                verticalLineTo(20.3f)
                curveTo(12.75f, 20.714f, 12.414f, 21.05f, 12f, 21.05f)
                curveTo(11.586f, 21.05f, 11.25f, 20.714f, 11.25f, 20.3f)
                verticalLineTo(12.75f)
                horizontalLineTo(3.7f)
                curveTo(3.286f, 12.75f, 2.95f, 12.414f, 2.95f, 12f)
                curveTo(2.95f, 11.586f, 3.286f, 11.25f, 3.7f, 11.25f)
                horizontalLineTo(11.25f)
                verticalLineTo(3.7f)
                curveTo(11.25f, 3.286f, 11.586f, 2.95f, 12f, 2.95f)
                close()
            }
        }.build()
    }

    val ArrowLeft: ImageVector by lazy {
        ImageVector.Builder(
            name = "AnthropiconArrowLeft",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF141413)), pathFillType = PathFillType.NonZero) {
                moveTo(11.25f, 16.5f)
                curveTo(11.664f, 16.5f, 12f, 16.836f, 12f, 17.25f)
                curveTo(12f, 17.664f, 11.664f, 18f, 11.25f, 18f)
                horizontalLineTo(4.75f)
                curveTo(4.336f, 18f, 4f, 17.664f, 4f, 17.25f)
                curveTo(4f, 16.836f, 4.336f, 16.5f, 4.75f, 16.5f)
                horizontalLineTo(11.25f)
                close()
                moveTo(19.25f, 11.25f)
                curveTo(19.664f, 11.25f, 20f, 11.586f, 20f, 12f)
                curveTo(20f, 12.414f, 19.664f, 12.75f, 19.25f, 12.75f)
                horizontalLineTo(4.75f)
                curveTo(4.336f, 12.75f, 4f, 12.414f, 4f, 12f)
                curveTo(4f, 11.586f, 4.336f, 11.25f, 4.75f, 11.25f)
                horizontalLineTo(19.25f)
                close()
                moveTo(19.25f, 6f)
                curveTo(19.664f, 6f, 20f, 6.336f, 20f, 6.75f)
                curveTo(20f, 7.164f, 19.664f, 7.5f, 19.25f, 7.5f)
                horizontalLineTo(4.75f)
                curveTo(4.336f, 7.5f, 4f, 7.164f, 4f, 6.75f)
                curveTo(4f, 6.336f, 4.336f, 6f, 4.75f, 6f)
                horizontalLineTo(19.25f)
                close()
            }
        }.build()
    }

    val Copy: ImageVector by lazy {
        ImageVector.Builder(
            name = "AnthropiconCopy",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF141413)), pathFillType = PathFillType.NonZero) {
                moveTo(15.25f, 2f)
                curveTo(16.493f, 2f, 17.5f, 3.007f, 17.5f, 4.25f)
                verticalLineTo(6.5f)
                horizontalLineTo(19.75f)
                curveTo(20.993f, 6.5f, 22f, 7.507f, 22f, 8.75f)
                verticalLineTo(19.75f)
                curveTo(22f, 20.993f, 20.993f, 22f, 19.75f, 22f)
                horizontalLineTo(8.75f)
                curveTo(7.585f, 22f, 6.627f, 21.115f, 6.512f, 19.98f)
                lineTo(6.5f, 19.75f)
                verticalLineTo(17.5f)
                horizontalLineTo(4.25f)
                curveTo(3.007f, 17.5f, 2f, 16.493f, 2f, 15.25f)
                verticalLineTo(4.25f)
                curveTo(2f, 3.007f, 3.007f, 2f, 4.25f, 2f)
                close()
                moveTo(4.25f, 3.5f)
                curveTo(3.836f, 3.5f, 3.5f, 3.836f, 3.5f, 4.25f)
                verticalLineTo(15.25f)
                curveTo(3.5f, 15.664f, 3.836f, 16f, 4.25f, 16f)
                horizontalLineTo(15.25f)
                curveTo(15.664f, 16f, 16f, 15.664f, 16f, 15.25f)
                verticalLineTo(4.25f)
                curveTo(16f, 3.836f, 15.664f, 3.5f, 15.25f, 3.5f)
                close()
                moveTo(8f, 19.75f)
                lineTo(8.004f, 19.827f)
                curveTo(8.043f, 20.205f, 8.362f, 20.5f, 8.75f, 20.5f)
                horizontalLineTo(19.75f)
                curveTo(20.164f, 20.5f, 20.5f, 20.164f, 20.5f, 19.75f)
                verticalLineTo(8.75f)
                curveTo(20.5f, 8.336f, 20.164f, 8f, 19.75f, 8f)
                horizontalLineTo(17.5f)
                verticalLineTo(15.25f)
                curveTo(17.5f, 16.493f, 16.493f, 17.5f, 15.25f, 17.5f)
                horizontalLineTo(8f)
                close()
            }
        }.build()
    }

    val Share: ImageVector by lazy {
        ImageVector.Builder(
            name = "AnthropiconShare",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = null,
                stroke = SolidColor(Color(0xFF141413)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(5.5f, 9.25f)
                curveTo(7.0188f, 9.25f, 8.25f, 10.4812f, 8.25f, 12f)
                curveTo(8.25f, 13.5188f, 7.0188f, 14.75f, 5.5f, 14.75f)
                curveTo(3.9812f, 14.75f, 2.75f, 13.5188f, 2.75f, 12f)
                curveTo(2.75f, 10.4812f, 3.9812f, 9.25f, 5.5f, 9.25f)
                close()
            }
            path(
                fill = null,
                stroke = SolidColor(Color(0xFF141413)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(18.5f, 2.75f)
                curveTo(20.0188f, 2.75f, 21.25f, 3.9812f, 21.25f, 5.5f)
                curveTo(21.25f, 7.0188f, 20.0188f, 8.25f, 18.5f, 8.25f)
                curveTo(16.9812f, 8.25f, 15.75f, 7.0188f, 15.75f, 5.5f)
                curveTo(15.75f, 3.9812f, 16.9812f, 2.75f, 18.5f, 2.75f)
                close()
            }
            path(
                fill = null,
                stroke = SolidColor(Color(0xFF141413)),
                strokeLineWidth = 1.5f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(18.5f, 15.75f)
                curveTo(20.0188f, 15.75f, 21.25f, 16.9812f, 21.25f, 18.5f)
                curveTo(21.25f, 20.0188f, 20.0188f, 21.25f, 18.5f, 21.25f)
                curveTo(16.9812f, 21.25f, 15.75f, 20.0188f, 15.75f, 18.5f)
                curveTo(15.75f, 16.9812f, 16.9812f, 15.75f, 18.5f, 15.75f)
                close()
            }
            path(fill = SolidColor(Color(0xFF141413)), pathFillType = PathFillType.NonZero) {
                moveTo(15.777f, 16.3f)
                curveTo(15.464f, 16.687f, 15.232f, 17.143f, 15.106f, 17.642f)
                lineTo(8.222f, 14.199f)
                curveTo(8.535f, 13.812f, 8.767f, 13.356f, 8.893f, 12.857f)
                close()
                moveTo(15.106f, 6.357f)
                curveTo(15.232f, 6.856f, 15.464f, 7.312f, 15.777f, 7.699f)
                lineTo(8.893f, 11.142f)
                curveTo(8.767f, 10.643f, 8.535f, 10.187f, 8.222f, 9.8f)
                close()
            }
        }.build()
    }

    val Stop: ImageVector by lazy {
        ImageVector.Builder(
            name = "AnthropiconStop",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF141413)), pathFillType = PathFillType.NonZero) {
                moveTo(17.25f, 5f)
                curveTo(18.216f, 5f, 19f, 5.784f, 19f, 6.75f)
                verticalLineTo(17.25f)
                curveTo(19f, 18.216f, 18.216f, 19f, 17.25f, 19f)
                horizontalLineTo(6.75f)
                curveTo(5.844f, 19f, 5.098f, 18.311f, 5.009f, 17.429f)
                lineTo(5f, 17.25f)
                verticalLineTo(6.75f)
                curveTo(5f, 5.784f, 5.784f, 5f, 6.75f, 5f)
                horizontalLineTo(17.25f)
                close()
                moveTo(6.75f, 6.5f)
                curveTo(6.612f, 6.5f, 6.5f, 6.612f, 6.5f, 6.75f)
                verticalLineTo(17.25f)
                lineTo(6.505f, 17.301f)
                curveTo(6.528f, 17.414f, 6.629f, 17.5f, 6.75f, 17.5f)
                horizontalLineTo(17.25f)
                curveTo(17.388f, 17.5f, 17.5f, 17.388f, 17.5f, 17.25f)
                verticalLineTo(6.75f)
                curveTo(17.5f, 6.612f, 17.388f, 6.5f, 17.25f, 6.5f)
                horizontalLineTo(6.75f)
                close()
            }
        }.build()
    }

    val Play: ImageVector by lazy {
        ImageVector.Builder(
            name = "AnthropiconPlay",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF141413)), pathFillType = PathFillType.NonZero) {
                moveTo(3f, 4.33f)
                curveTo(3f, 2.604f, 4.863f, 1.521f, 6.363f, 2.375f)
                lineTo(19.832f, 10.045f)
                curveTo(21.347f, 10.908f, 21.347f, 13.092f, 19.832f, 13.955f)
                lineTo(6.363f, 21.625f)
                curveTo(4.863f, 22.479f, 3f, 21.396f, 3f, 19.67f)
                close()
                moveTo(4.5f, 4.33f)
                verticalLineTo(19.67f)
                curveTo(4.5f, 20.245f, 5.121f, 20.606f, 5.621f, 20.321f)
                lineTo(19.09f, 12.651f)
                curveTo(19.595f, 12.364f, 19.595f, 11.636f, 19.09f, 11.349f)
                lineTo(5.621f, 3.679f)
                curveTo(5.121f, 3.394f, 4.5f, 3.755f, 4.5f, 4.33f)
                close()
            }
        }.build()
    }

    val Reload: ImageVector by lazy {
        ImageVector.Builder(
            name = "AnthropiconReload",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF141413)), pathFillType = PathFillType.NonZero) {
                moveTo(12f, 2f)
                curveTo(17.523f, 2f, 22f, 6.477f, 22f, 12f)
                curveTo(22f, 17.523f, 17.523f, 22f, 12f, 22f)
                curveTo(6.477f, 22f, 2f, 17.523f, 2f, 12f)
                curveTo(2f, 9.274f, 3.093f, 6.803f, 4.861f, 5f)
                horizontalLineTo(2.75f)
                curveTo(2.336f, 5f, 2f, 4.664f, 2f, 4.25f)
                curveTo(2f, 3.836f, 2.336f, 3.5f, 2.75f, 3.5f)
                horizontalLineTo(6.75f)
                curveTo(7.164f, 3.5f, 7.5f, 3.836f, 7.5f, 4.25f)
                verticalLineTo(8.25f)
                curveTo(7.5f, 8.664f, 7.164f, 9f, 6.75f, 9f)
                curveTo(6.336f, 9f, 6f, 8.664f, 6f, 8.25f)
                verticalLineTo(5.98f)
                curveTo(4.455f, 7.52f, 3.5f, 9.648f, 3.5f, 12f)
                curveTo(3.5f, 16.694f, 7.306f, 20.5f, 12f, 20.5f)
                curveTo(16.694f, 20.5f, 20.5f, 16.694f, 20.5f, 12f)
                curveTo(20.5f, 7.306f, 16.694f, 3.5f, 12f, 3.5f)
                curveTo(11.586f, 3.5f, 11.25f, 3.164f, 11.25f, 2.75f)
                curveTo(11.25f, 2.336f, 11.586f, 2f, 12f, 2f)
                close()
            }
        }.build()
    }

    val ThumbsUp: ImageVector by lazy {
        ImageVector.Builder(
            name = "AnthropiconThumbsUp",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF141413)), pathFillType = PathFillType.NonZero) {
                moveTo(11.6885f, 2f)
                curveTo(13.666f, 2.00006f, 15.1855f, 3.75136f, 14.9062f, 5.70898f)
                lineTo(14.4805f, 8.6875f)
                horizontalLineTo(18.3936f)
                curveTo(20.3613f, 8.6875f, 21.8776f, 10.423f, 21.6143f, 12.373f)
                lineTo(20.6738f, 19.3369f)
                curveTo(20.4699f, 20.8454f, 19.1823f, 21.9715f, 17.6602f, 21.9717f)
                horizontalLineTo(5.25f)
                curveTo(4.00759f, 21.9717f, 3.00036f, 20.964f, 3f, 19.7217f)
                verticalLineTo(12.6973f)
                curveTo(3f, 11.7824f, 3.5169f, 10.9457f, 4.33496f, 10.5361f)
                lineTo(5.45215f, 9.97754f)
                curveTo(6.42444f, 9.49103f, 7.17353f, 8.64974f, 7.54492f, 7.62793f)
                lineTo(9.21094f, 3.04297f)
                curveTo(9.43837f, 2.41709f, 10.0333f, 2.00001f, 10.6992f, 2f)
                close()
                moveTo(10.6992f, 3.5f)
                curveTo(10.6642f, 3.50001f, 10.6321f, 3.52176f, 10.6201f, 3.55469f)
                lineTo(8.9541f, 8.13965f)
                curveTo(8.45164f, 9.52214f, 7.43854f, 10.6601f, 6.12305f, 11.3184f)
                lineTo(5.00684f, 11.877f)
                curveTo(4.69649f, 12.0323f, 4.5f, 12.3502f, 4.5f, 12.6973f)
                verticalLineTo(19.7217f)
                curveTo(4.50036f, 20.1356f, 4.83602f, 20.4717f, 5.25f, 20.4717f)
                horizontalLineTo(17.6602f)
                curveTo(18.4316f, 20.4715f, 19.0841f, 19.9002f, 19.1875f, 19.1357f)
                lineTo(20.1279f, 12.1719f)
                curveTo(20.2696f, 11.1219f, 19.453f, 10.1875f, 18.3936f, 10.1875f)
                horizontalLineTo(13.6162f)
                curveTo(13.3989f, 10.1875f, 13.1913f, 10.0938f, 13.0488f, 9.92969f)
                curveTo(12.9065f, 9.76558f, 12.8425f, 9.54708f, 12.873f, 9.33203f)
                lineTo(13.4209f, 5.49707f)
                curveTo(13.5712f, 4.443f, 12.7532f, 3.50006f, 11.6885f, 3.5f)
                close()
            }
        }.build()
    }

    val ThumbsDown: ImageVector by lazy {
        ImageVector.Builder(
            name = "AnthropiconThumbsDown",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF141413)), pathFillType = PathFillType.NonZero) {
                moveTo(19.1363f, 2f)
                curveTo(20.3786f, 2.00019f, 21.386f, 3.00778f, 21.3863f, 4.25f)
                verticalLineTo(11.2822f)
                curveTo(21.3861f, 12.1917f, 20.8748f, 13.0245f, 20.064f, 13.4365f)
                lineTo(18.9869f, 13.9834f)
                curveTo(18.0195f, 14.4749f, 17.2766f, 15.3183f, 16.9107f, 16.3398f)
                lineTo(15.2711f, 20.9219f)
                curveTo(15.0458f, 21.5514f, 14.4485f, 21.9715f, 13.7799f, 21.9717f)
                horizontalLineTo(12.8551f)
                curveTo(10.8803f, 21.9717f, 9.36157f, 20.225f, 9.63631f, 18.2695f)
                lineTo(10.0562f, 15.2842f)
                horizontalLineTo(6.25057f)
                curveTo(4.28548f, 15.2842f, 2.7699f, 13.5534f, 3.02889f, 11.6055f)
                lineTo(3.95467f, 4.64062f)
                curveTo(4.156f, 3.1294f, 5.44565f, 2f, 6.97029f, 2f)
                close()
                moveTo(6.97029f, 3.5f)
                curveTo(6.19754f, 3.5f, 5.54403f, 4.07292f, 5.44197f, 4.83887f)
                lineTo(4.51521f, 11.8027f)
                curveTo(4.3757f, 12.8517f, 5.19241f, 13.7842f, 6.25057f, 13.7842f)
                horizontalLineTo(10.9185f)
                curveTo(11.1355f, 13.7843f, 11.3426f, 13.8782f, 11.4849f, 14.042f)
                curveTo(11.6272f, 14.2058f, 11.6918f, 14.4238f, 11.6617f, 14.6387f)
                lineTo(11.1217f, 18.4775f)
                curveTo(10.9736f, 19.5306f, 11.7916f, 20.4717f, 12.8551f, 20.4717f)
                horizontalLineTo(13.7799f)
                curveTo(13.8149f, 20.4715f, 13.8471f, 20.449f, 13.859f, 20.416f)
                lineTo(15.4986f, 15.835f)
                curveTo(15.9936f, 14.4524f, 16.999f, 13.3116f, 18.3082f, 12.6465f)
                lineTo(19.3844f, 12.0986f)
                curveTo(19.6917f, 11.9423f, 19.8861f, 11.627f, 19.8863f, 11.2822f)
                verticalLineTo(4.25f)
                curveTo(19.886f, 3.8362f, 19.5501f, 3.50019f, 19.1363f, 3.5f)
                close()
            }
        }.build()
    }

    val ExtendedThinking: ImageVector by lazy {
        ImageVector.Builder(
            name = "AnthropiconExtendedThinking",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF141413)), pathFillType = PathFillType.NonZero) {
                moveTo(12.515f, 2.013f)
                curveTo(17.798f, 2.281f, 22f, 6.65f, 22f, 12f)
                curveTo(22f, 17.523f, 17.523f, 22f, 12f, 22f)
                curveTo(6.477f, 22f, 2f, 17.523f, 2f, 12f)
                curveTo(2f, 11.586f, 2.336f, 11.25f, 2.75f, 11.25f)
                curveTo(3.164f, 11.25f, 3.5f, 11.586f, 3.5f, 12f)
                curveTo(3.5f, 16.694f, 7.306f, 20.5f, 12f, 20.5f)
                curveTo(16.694f, 20.5f, 20.5f, 16.694f, 20.5f, 12f)
                curveTo(20.5f, 7.452f, 16.929f, 3.738f, 12.438f, 3.511f)
                lineTo(12f, 3.5f)
                lineTo(11.923f, 3.496f)
                curveTo(11.545f, 3.457f, 11.25f, 3.138f, 11.25f, 2.75f)
                curveTo(11.25f, 2.336f, 11.586f, 2f, 12f, 2f)
                lineTo(12.515f, 2.013f)
                close()
                moveTo(12f, 6.45f)
                curveTo(12.414f, 6.45f, 12.75f, 6.786f, 12.75f, 7.2f)
                verticalLineTo(11.536f)
                lineTo(15.936f, 13.129f)
                curveTo(16.306f, 13.314f, 16.456f, 13.765f, 16.271f, 14.136f)
                curveTo(16.085f, 14.506f, 15.635f, 14.656f, 15.265f, 14.471f)
                lineTo(11.665f, 12.671f)
                curveTo(11.411f, 12.544f, 11.25f, 12.284f, 11.25f, 12f)
                verticalLineTo(7.2f)
                curveTo(11.25f, 6.786f, 11.586f, 6.45f, 12f, 6.45f)
                close()
                moveTo(3.375f, 7.779f)
                curveTo(3.858f, 7.779f, 4.25f, 8.171f, 4.25f, 8.654f)
                curveTo(4.25f, 9.138f, 3.858f, 9.529f, 3.375f, 9.529f)
                curveTo(2.892f, 9.529f, 2.5f, 9.138f, 2.5f, 8.654f)
                curveTo(2.5f, 8.171f, 2.892f, 7.779f, 3.375f, 7.779f)
                close()
                moveTo(5.479f, 4.604f)
                curveTo(5.962f, 4.604f, 6.354f, 4.995f, 6.354f, 5.479f)
                curveTo(6.353f, 5.961f, 5.961f, 6.353f, 5.479f, 6.354f)
                curveTo(4.995f, 6.354f, 4.604f, 5.962f, 4.604f, 5.479f)
                curveTo(4.604f, 4.995f, 4.995f, 4.604f, 5.479f, 4.604f)
                close()
                moveTo(8.625f, 2.5f)
                curveTo(9.108f, 2.5f, 9.5f, 2.892f, 9.5f, 3.375f)
                curveTo(9.5f, 3.858f, 9.108f, 4.25f, 8.625f, 4.25f)
                curveTo(8.142f, 4.25f, 7.75f, 3.858f, 7.75f, 3.375f)
                curveTo(7.75f, 2.892f, 8.142f, 2.5f, 8.625f, 2.5f)
                close()
            }
        }.build()
    }

    val ChevronRight: ImageVector by lazy {
        ImageVector.Builder(
            name = "AnthropiconChevronRight",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF141413)), pathFillType = PathFillType.NonZero) {
                moveTo(8.97f, 6.47f)
                curveTo(9.263f, 6.177f, 9.737f, 6.177f, 10.03f, 6.47f)
                lineTo(15.03f, 11.47f)
                curveTo(15.323f, 11.763f, 15.323f, 12.237f, 15.03f, 12.53f)
                lineTo(10.03f, 17.53f)
                curveTo(9.737f, 17.823f, 9.263f, 17.823f, 8.97f, 17.53f)
                curveTo(8.677f, 17.237f, 8.677f, 16.763f, 8.97f, 16.47f)
                lineTo(13.439f, 12f)
                lineTo(8.97f, 7.53f)
                curveTo(8.677f, 7.237f, 8.677f, 6.763f, 8.97f, 6.47f)
                close()
            }
        }.build()
    }

    val DotsVertical: ImageVector by lazy {
        ImageVector.Builder(
            name = "AnthropiconDotsVertical",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF141413)), pathFillType = PathFillType.NonZero) {
                moveTo(14.25f, 2f)
                curveTo(15.217f, 2f, 16f, 2.784f, 16f, 3.75f)
                curveTo(16f, 4.716f, 15.217f, 5.5f, 14.25f, 5.5f)
                curveTo(13.284f, 5.5f, 12.5f, 4.716f, 12.5f, 3.75f)
                curveTo(12.5f, 2.784f, 13.284f, 2f, 14.25f, 2f)
                close()
                moveTo(14.25f, 3.5f)
                curveTo(14.112f, 3.5f, 14f, 3.612f, 14f, 3.75f)
                curveTo(14f, 3.888f, 14.112f, 4f, 14.25f, 4f)
                curveTo(14.388f, 4f, 14.5f, 3.888f, 14.5f, 3.75f)
                curveTo(14.5f, 3.612f, 14.388f, 3.5f, 14.25f, 3.5f)
                close()
                moveTo(14.25f, 7f)
                curveTo(15.217f, 7f, 16f, 7.784f, 16f, 8.75f)
                curveTo(16f, 9.716f, 15.217f, 10.5f, 14.25f, 10.5f)
                curveTo(13.284f, 10.5f, 12.5f, 9.716f, 12.5f, 8.75f)
                curveTo(12.5f, 7.784f, 13.284f, 7f, 14.25f, 7f)
                close()
                moveTo(14.25f, 8.5f)
                curveTo(14.112f, 8.5f, 14f, 8.612f, 14f, 8.75f)
                curveTo(14f, 8.888f, 14.112f, 9f, 14.25f, 9f)
                curveTo(14.388f, 9f, 14.5f, 8.888f, 14.5f, 8.75f)
                curveTo(14.5f, 8.612f, 14.388f, 8.5f, 14.25f, 8.5f)
                close()
                moveTo(14.25f, 12f)
                curveTo(15.217f, 12f, 16f, 12.784f, 16f, 13.75f)
                curveTo(16f, 14.716f, 15.217f, 15.5f, 14.25f, 15.5f)
                curveTo(13.284f, 15.5f, 12.5f, 14.716f, 12.5f, 13.75f)
                curveTo(12.5f, 12.784f, 13.284f, 12f, 14.25f, 12f)
                close()
                moveTo(14.25f, 13.5f)
                curveTo(14.112f, 13.5f, 14f, 13.612f, 14f, 13.75f)
                curveTo(14f, 13.888f, 14.112f, 14f, 14.25f, 14f)
                curveTo(14.388f, 14f, 14.5f, 13.888f, 14.5f, 13.75f)
                curveTo(14.5f, 13.612f, 14.388f, 13.5f, 14.25f, 13.5f)
                close()
            }
        }.build()
    }

    val ChevronDown: ImageVector by lazy {
        ImageVector.Builder(
            name = "AnthropiconChevronDown",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF4A4A46)), pathFillType = PathFillType.NonZero) {
                moveTo(16.47f, 8.97f)
                curveTo(16.763f, 8.677f, 17.237f, 8.677f, 17.53f, 8.97f)
                curveTo(17.823f, 9.263f, 17.823f, 9.737f, 17.53f, 10.03f)
                lineTo(12.53f, 15.03f)
                curveTo(12.237f, 15.323f, 11.763f, 15.323f, 11.47f, 15.03f)
                lineTo(6.47f, 10.03f)
                curveTo(6.177f, 9.737f, 6.177f, 9.263f, 6.47f, 8.97f)
                curveTo(6.763f, 8.677f, 7.237f, 8.677f, 7.53f, 8.97f)
                lineTo(12f, 13.439f)
                lineTo(16.47f, 8.97f)
                close()
            }
        }.build()
    }

    val Mic: ImageVector by lazy {
        ImageVector.Builder(
            name = "AnthropiconMic",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF141413)), pathFillType = PathFillType.NonZero) {
                moveTo(12f, 2.5f)
                curveTo(10.481f, 2.5f, 9.25f, 3.731f, 9.25f, 5.25f)
                verticalLineTo(10.75f)
                curveTo(9.25f, 12.269f, 10.481f, 13.5f, 12f, 13.5f)
                curveTo(13.519f, 13.5f, 14.75f, 12.269f, 14.75f, 10.75f)
                verticalLineTo(5.25f)
                curveTo(14.75f, 3.731f, 13.519f, 2.5f, 12f, 2.5f)
                close()
                moveTo(10.75f, 5.25f)
                curveTo(10.75f, 4.56f, 11.31f, 4f, 12f, 4f)
                curveTo(12.69f, 4f, 13.25f, 4.56f, 13.25f, 5.25f)
                verticalLineTo(10.75f)
                curveTo(13.25f, 11.44f, 12.69f, 12f, 12f, 12f)
                curveTo(11.31f, 12f, 10.75f, 11.44f, 10.75f, 10.75f)
                close()
                moveTo(7f, 10.25f)
                curveTo(7.414f, 10.25f, 7.75f, 10.586f, 7.75f, 11f)
                curveTo(7.75f, 13.167f, 9.449f, 14.941f, 11.586f, 15.06f)
                lineTo(11.75f, 15.064f)
                verticalLineTo(17.5f)
                horizontalLineTo(9.5f)
                curveTo(9.086f, 17.5f, 8.75f, 17.836f, 8.75f, 18.25f)
                curveTo(8.75f, 18.664f, 9.086f, 19f, 9.5f, 19f)
                horizontalLineTo(14.5f)
                curveTo(14.914f, 19f, 15.25f, 18.664f, 15.25f, 18.25f)
                curveTo(15.25f, 17.836f, 14.914f, 17.5f, 14.5f, 17.5f)
                horizontalLineTo(12.25f)
                verticalLineTo(15.064f)
                lineTo(12.414f, 15.06f)
                curveTo(14.551f, 14.941f, 16.25f, 13.167f, 16.25f, 11f)
                curveTo(16.25f, 10.586f, 16.586f, 10.25f, 17f, 10.25f)
                curveTo(17.414f, 10.25f, 17.75f, 10.586f, 17.75f, 11f)
                curveTo(17.75f, 13.966f, 15.408f, 16.399f, 12.478f, 16.546f)
                lineTo(12.25f, 16.551f)
                lineTo(12.25f, 17.5f)
                horizontalLineTo(11.75f)
                verticalLineTo(16.551f)
                lineTo(11.522f, 16.546f)
                curveTo(8.592f, 16.399f, 6.25f, 13.966f, 6.25f, 11f)
                curveTo(6.25f, 10.586f, 6.586f, 10.25f, 7f, 10.25f)
                close()
            }
        }.build()
    }

    val Send: ImageVector by lazy {
        ImageVector.Builder(
            name = "AnthropiconSend",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFFFFFFF)),
                stroke = null,
                strokeLineWidth = 0f,
                strokeLineCap = StrokeCap.Butt,
                strokeLineJoin = StrokeJoin.Miter,
                pathFillType = PathFillType.NonZero
            ) {
                moveTo(10.25f, 2f)
                curveTo(10.664f, 2f, 11f, 2.336f, 11f, 2.75f)
                verticalLineTo(21.25f)
                curveTo(11f, 21.664f, 10.664f, 22f, 10.25f, 22f)
                curveTo(9.836f, 22f, 9.5f, 21.664f, 9.5f, 21.25f)
                verticalLineTo(2.75f)
                curveTo(9.5f, 2.336f, 9.836f, 2f, 10.25f, 2f)
                close()
                moveTo(17.75f, 5.25f)
                curveTo(18.164f, 5.25f, 18.5f, 5.586f, 18.5f, 6f)
                verticalLineTo(18f)
                curveTo(18.5f, 18.414f, 18.164f, 18.75f, 17.75f, 18.75f)
                curveTo(17.336f, 18.75f, 17f, 18.414f, 17f, 18f)
                verticalLineTo(6f)
                curveTo(17f, 5.586f, 17.336f, 5.25f, 17.75f, 5.25f)
                close()
                moveTo(6.5f, 7.25f)
                curveTo(6.914f, 7.25f, 7.25f, 7.586f, 7.25f, 8f)
                verticalLineTo(16f)
                curveTo(7.25f, 16.414f, 6.914f, 16.75f, 6.5f, 16.75f)
                curveTo(6.086f, 16.75f, 5.75f, 16.414f, 5.75f, 16f)
                verticalLineTo(8f)
                curveTo(5.75f, 7.586f, 6.086f, 7.25f, 6.5f, 7.25f)
                close()
                moveTo(14f, 7.25f)
                curveTo(14.414f, 7.25f, 14.75f, 7.586f, 14.75f, 8f)
                verticalLineTo(16f)
                curveTo(14.75f, 16.414f, 14.414f, 16.75f, 14f, 16.75f)
                curveTo(13.586f, 16.75f, 13.25f, 16.414f, 13.25f, 16f)
                verticalLineTo(8f)
                curveTo(13.25f, 7.586f, 13.586f, 7.25f, 14f, 7.25f)
                close()
                moveTo(2.75f, 10.25f)
                curveTo(3.164f, 10.25f, 3.5f, 10.586f, 3.5f, 11f)
                verticalLineTo(13f)
                curveTo(3.5f, 13.414f, 3.164f, 13.75f, 2.75f, 13.75f)
                curveTo(2.336f, 13.75f, 2f, 13.414f, 2f, 13f)
                verticalLineTo(11f)
                curveTo(2f, 10.586f, 2.336f, 10.25f, 2.75f, 10.25f)
                close()
                moveTo(21.25f, 10.25f)
                curveTo(21.664f, 10.25f, 22f, 10.586f, 22f, 11f)
                verticalLineTo(13f)
                curveTo(22f, 13.414f, 21.664f, 13.75f, 21.25f, 13.75f)
                curveTo(20.836f, 13.75f, 20.5f, 13.414f, 20.5f, 13f)
                verticalLineTo(11f)
                curveTo(20.5f, 10.586f, 20.836f, 10.25f, 21.25f, 10.25f)
                close()
            }
        }.build()
    }

    val ClaudeMark: ImageVector by lazy {
        ImageVector.Builder(
            name = "ClaudeMark",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 43f,
            viewportHeight = 43f
        ).apply {
            path(fill = SolidColor(Color(0xFFD97757)), pathFillType = PathFillType.NonZero) {
                moveTo(8.437f, 28.595f)
                lineTo(16.898f, 23.851f)
                lineTo(17.037f, 23.435f)
                lineTo(16.898f, 23.204f)
                horizontalLineTo(16.479f)
                lineTo(15.062f, 23.117f)
                lineTo(10.227f, 22.988f)
                lineTo(6.043f, 22.815f)
                lineTo(1.976f, 22.6f)
                lineTo(0.953f, 22.384f)
                lineTo(0f, 21.112f)
                lineTo(0.093f, 20.486f)
                lineTo(0.953f, 19.904f)
                lineTo(2.185f, 20.012f)
                lineTo(4.904f, 20.206f)
                lineTo(8.995f, 20.486f)
                lineTo(11.947f, 20.659f)
                lineTo(16.34f, 21.112f)
                horizontalLineTo(17.037f)
                lineTo(17.13f, 20.831f)
                lineTo(16.898f, 20.659f)
                lineTo(16.712f, 20.486f)
                lineTo(12.482f, 17.618f)
                lineTo(7.903f, 14.599f)
                lineTo(5.509f, 12.853f)
                lineTo(4.23f, 11.968f)
                lineTo(3.579f, 11.149f)
                lineTo(3.301f, 9.338f)
                lineTo(4.463f, 8.044f)
                lineTo(6.043f, 8.151f)
                lineTo(6.438f, 8.259f)
                lineTo(8.042f, 9.488f)
                lineTo(11.459f, 12.141f)
                lineTo(15.922f, 15.419f)
                lineTo(16.572f, 15.958f)
                lineTo(16.834f, 15.781f)
                lineTo(16.875f, 15.656f)
                lineTo(16.572f, 15.16f)
                lineTo(14.155f, 10.782f)
                lineTo(11.575f, 6.318f)
                lineTo(10.413f, 4.464f)
                lineTo(10.111f, 3.364f)
                curveTo(9.994f, 2.903f, 9.925f, 2.521f, 9.925f, 2.049f)
                lineTo(11.25f, 0.237f)
                lineTo(11.993f, 0f)
                lineTo(13.783f, 0.237f)
                lineTo(14.527f, 0.884f)
                lineTo(15.643f, 3.429f)
                lineTo(17.432f, 7.418f)
                lineTo(20.222f, 12.853f)
                lineTo(21.035f, 14.47f)
                lineTo(21.477f, 15.958f)
                lineTo(21.639f, 16.411f)
                horizontalLineTo(21.918f)
                verticalLineTo(16.152f)
                lineTo(22.151f, 13.09f)
                lineTo(22.569f, 9.338f)
                lineTo(22.988f, 4.507f)
                lineTo(23.127f, 3.148f)
                lineTo(23.801f, 1.51f)
                lineTo(25.149f, 0.625f)
                lineTo(26.195f, 1.121f)
                lineTo(27.055f, 2.351f)
                lineTo(26.939f, 3.148f)
                lineTo(26.428f, 6.469f)
                lineTo(25.428f, 11.667f)
                lineTo(24.777f, 15.16f)
                horizontalLineTo(25.149f)
                lineTo(25.591f, 14.707f)
                lineTo(27.357f, 12.378f)
                lineTo(30.309f, 8.669f)
                lineTo(31.611f, 7.203f)
                lineTo(33.145f, 5.585f)
                lineTo(34.121f, 4.809f)
                horizontalLineTo(35.98f)
                lineTo(37.329f, 6.836f)
                lineTo(36.724f, 8.928f)
                lineTo(34.818f, 11.343f)
                lineTo(33.238f, 13.392f)
                lineTo(30.972f, 16.428f)
                lineTo(29.565f, 18.869f)
                lineTo(29.691f, 19.07f)
                lineTo(30.03f, 19.042f)
                lineTo(35.144f, 17.942f)
                lineTo(37.91f, 17.446f)
                lineTo(41.21f, 16.885f)
                lineTo(42.698f, 17.575f)
                lineTo(42.861f, 18.287f)
                lineTo(42.279f, 19.732f)
                lineTo(38.746f, 20.594f)
                lineTo(34.609f, 21.435f)
                lineTo(28.448f, 22.886f)
                lineTo(28.38f, 22.941f)
                lineTo(28.461f, 23.06f)
                lineTo(31.239f, 23.311f)
                lineTo(32.424f, 23.376f)
                horizontalLineTo(35.33f)
                lineTo(40.745f, 23.786f)
                lineTo(42.163f, 24.713f)
                lineTo(43f, 25.856f)
                lineTo(42.861f, 26.74f)
                lineTo(40.676f, 27.84f)
                lineTo(37.747f, 27.15f)
                lineTo(30.89f, 25.511f)
                lineTo(28.543f, 24.929f)
                horizontalLineTo(28.217f)
                verticalLineTo(25.123f)
                lineTo(30.17f, 27.042f)
                lineTo(33.772f, 30.277f)
                lineTo(38.258f, 34.46f)
                lineTo(38.491f, 35.495f)
                lineTo(37.91f, 36.315f)
                lineTo(37.305f, 36.229f)
                lineTo(33.354f, 33.253f)
                lineTo(31.82f, 31.916f)
                lineTo(28.38f, 29.004f)
                horizontalLineTo(28.148f)
                verticalLineTo(29.306f)
                lineTo(28.938f, 30.471f)
                lineTo(33.145f, 36.789f)
                lineTo(33.354f, 38.73f)
                lineTo(33.052f, 39.356f)
                lineTo(31.959f, 39.744f)
                lineTo(30.774f, 39.528f)
                lineTo(28.287f, 36.056f)
                lineTo(25.753f, 32.174f)
                lineTo(23.708f, 28.681f)
                lineTo(23.461f, 28.837f)
                lineTo(22.244f, 41.835f)
                lineTo(21.686f, 42.504f)
                lineTo(20.384f, 43f)
                lineTo(19.292f, 42.181f)
                lineTo(18.711f, 40.843f)
                lineTo(19.292f, 38.191f)
                lineTo(19.989f, 34.741f)
                lineTo(20.547f, 32.002f)
                lineTo(21.058f, 28.595f)
                lineTo(21.371f, 27.456f)
                lineTo(21.343f, 27.38f)
                lineTo(21.094f, 27.422f)
                lineTo(18.525f, 30.945f)
                lineTo(14.62f, 36.229f)
                lineTo(11.529f, 39.528f)
                lineTo(10.785f, 39.83f)
                lineTo(9.506f, 39.161f)
                lineTo(9.623f, 37.975f)
                lineTo(10.343f, 36.919f)
                lineTo(14.62f, 31.485f)
                lineTo(17.2f, 28.099f)
                lineTo(18.863f, 26.155f)
                lineTo(18.847f, 25.874f)
                lineTo(18.755f, 25.866f)
                lineTo(7.391f, 33.274f)
                lineTo(5.369f, 33.533f)
                lineTo(4.486f, 32.714f)
                lineTo(4.602f, 31.377f)
                lineTo(5.021f, 30.945f)
                close()
            }
        }.build()
    }
}

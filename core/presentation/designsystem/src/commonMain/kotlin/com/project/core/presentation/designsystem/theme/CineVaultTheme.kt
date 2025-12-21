package com.project.core.presentation.designsystem.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

val LocalCustomColors = staticCompositionLocalOf {
    getLightColorScheme()
}
val LocalCustomTypography = staticCompositionLocalOf {
    CineVaultTypography()
}

val LocalCustomShapes = staticCompositionLocalOf {
    CineVaultShape()
}

val LocalCustomSpacing = staticCompositionLocalOf {
    CineVaultSpacing()
}

@Composable
fun CineVaultTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val customColors = if (darkTheme) getDarkColorScheme() else getLightColorScheme()
    val customTypography = CustomTypography
    val customShapes = CineVaultShape()
    val customSpacing = CineVaultSpacing()

    CompositionLocalProvider(
        LocalCustomColors provides customColors,
        LocalCustomTypography provides customTypography,
        LocalCustomShapes provides customShapes,
        LocalCustomSpacing provides customSpacing,
        content = content
    )
}

object CineVaultTheme {
    val colors: CineVaultColor
        @Composable
        get() = LocalCustomColors.current

    val typography: CineVaultTypography
        @Composable
        get() = LocalCustomTypography.current

    val shape: CineVaultShape
        @Composable
        get() = LocalCustomShapes.current

    val spacing: CineVaultSpacing
        @Composable
        get() = LocalCustomSpacing.current
}
package com.project.core.presentation.designsystem.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val LocalExtendedColors = staticCompositionLocalOf { LightExtendedColors }

val ColorScheme.extended: ExtendedColors
    @ReadOnlyComposable
    @Composable
    get() = LocalExtendedColors.current

@Immutable
data class ExtendedColors(
    // Button states
    val primaryHover: Color,
    val destructiveHover: Color,
    val destructiveSecondaryOutline: Color,
    val disabledOutline: Color,
    val disabledFill: Color,
    val successOutline: Color,
    val success: Color,
    val onSuccess: Color,
    val secondaryFill: Color,

    // Text variants
    val textPrimary: Color,
    val textTertiary: Color,
    val textSecondary: Color,
    val textPlaceholder: Color,
    val textDisabled: Color,

    // Surface variants
    val surfaceLower: Color,
    val surfaceHigher: Color,
    val surfaceOutline: Color,
    val overlay: Color,

    // Accent colors
    val accentBlue: Color,
    val accentPurple: Color,
    val accentViolet: Color,
    val accentPink: Color,
    val accentOrange: Color,
    val accentYellow: Color,
    val accentGreen: Color,
    val accentTeal: Color,
    val accentLightBlue: Color,
    val accentGrey: Color,

    // Cake colors for chat bubbles
    val cakeViolet: Color,
    val cakeGreen: Color,
    val cakeBlue: Color,
    val cakePink: Color,
    val cakeOrange: Color,
    val cakeYellow: Color,
    val cakeTeal: Color,
    val cakePurple: Color,
    val cakeRed: Color,
    val cakeMint: Color,
)

val LightExtendedColors = ExtendedColors(
    primaryHover = CineVaultBrand600,
    destructiveHover = CineVaultRed600,
    destructiveSecondaryOutline = CineVaultRed200,
    disabledOutline = CineVaultBase200,
    disabledFill = CineVaultBase150,
    successOutline = CineVaultBrand100,
    success = CineVaultBrand600,
    onSuccess = CineVaultBase0,
    secondaryFill = CineVaultBase100,

    textPrimary = CineVaultBase1000,
    textTertiary = CineVaultBase800,
    textSecondary = CineVaultBase900,
    textPlaceholder = CineVaultBase700,
    textDisabled = CineVaultBase400,

    surfaceLower = CineVaultBase100,
    surfaceHigher = CineVaultBase100,
    surfaceOutline = CineVaultBase1000Alpha14,
    overlay = CineVaultBase1000Alpha80,

    accentBlue = CineVaultBlue,
    accentPurple = CineVaultPurple,
    accentViolet = CineVaultViolet,
    accentPink = CineVaultPink,
    accentOrange = CineVaultOrange,
    accentYellow = CineVaultYellow,
    accentGreen = CineVaultGreen,
    accentTeal = CineVaultTeal,
    accentLightBlue = CineVaultLightBlue,
    accentGrey = CineVaultGrey,

    cakeViolet = CineVaultCakeLightViolet,
    cakeGreen = CineVaultCakeLightGreen,
    cakeBlue = CineVaultCakeLightBlue,
    cakePink = CineVaultCakeLightPink,
    cakeOrange = CineVaultCakeLightOrange,
    cakeYellow = CineVaultCakeLightYellow,
    cakeTeal = CineVaultCakeLightTeal,
    cakePurple = CineVaultCakeLightPurple,
    cakeRed = CineVaultCakeLightRed,
    cakeMint = CineVaultCakeLightMint,
)

val DarkExtendedColors = ExtendedColors(
    primaryHover = CineVaultBrand600,
    destructiveHover = CineVaultRed600,
    destructiveSecondaryOutline = CineVaultRed200,
    disabledOutline = CineVaultBase900,
    disabledFill = CineVaultBase1000,
    successOutline = CineVaultBrand500Alpha40,
    success = CineVaultBrand500,
    onSuccess = CineVaultBase1000,
    secondaryFill = CineVaultBase900,

    textPrimary = CineVaultBase0,
    textTertiary = CineVaultBase200,
    textSecondary = CineVaultBase150,
    textPlaceholder = CineVaultBase400,
    textDisabled = CineVaultBase500,

    surfaceLower = CineVaultBase1000,
    surfaceHigher = CineVaultBase900,
    surfaceOutline = CineVaultBase100Alpha10Alt,
    overlay = CineVaultBase1000Alpha80,

    accentBlue = CineVaultBlue,
    accentPurple = CineVaultPurple,
    accentViolet = CineVaultViolet,
    accentPink = CineVaultPink,
    accentOrange = CineVaultOrange,
    accentYellow = CineVaultYellow,
    accentGreen = CineVaultGreen,
    accentTeal = CineVaultTeal,
    accentLightBlue = CineVaultLightBlue,
    accentGrey = CineVaultGrey,

    cakeViolet = CineVaultCakeDarkViolet,
    cakeGreen = CineVaultCakeDarkGreen,
    cakeBlue = CineVaultCakeDarkBlue,
    cakePink = CineVaultCakeDarkPink,
    cakeOrange = CineVaultCakeDarkOrange,
    cakeYellow = CineVaultCakeDarkYellow,
    cakeTeal = CineVaultCakeDarkTeal,
    cakePurple = CineVaultCakeDarkPurple,
    cakeRed = CineVaultCakeDarkRed,
    cakeMint = CineVaultCakeDarkMint,
)

val LightColorScheme = lightColorScheme(
    primary = CineVaultBrand500,
    onPrimary = CineVaultBrand1000,
    primaryContainer = CineVaultBrand100,
    onPrimaryContainer = CineVaultBrand900,

    secondary = CineVaultBase700,
    onSecondary = CineVaultBase0,
    secondaryContainer = CineVaultBase100,
    onSecondaryContainer = CineVaultBase900,

    tertiary = CineVaultBrand900,
    onTertiary = CineVaultBase0,
    tertiaryContainer = CineVaultBrand100,
    onTertiaryContainer = CineVaultBrand1000,

    error = CineVaultRed500,
    onError = CineVaultBase0,
    errorContainer = CineVaultRed200,
    onErrorContainer = CineVaultRed600,

    background = CineVaultBrand1000,
    onBackground = CineVaultBase0,
    surface = CineVaultBase0,
    onSurface = CineVaultBase1000,
    surfaceVariant = CineVaultBase100,
    onSurfaceVariant = CineVaultBase900,

    outline = CineVaultBase1000Alpha8,
    outlineVariant = CineVaultBase200,
)

val DarkColorScheme = darkColorScheme(
    primary = CineVaultBrand500,
    onPrimary = CineVaultBrand1000,
    primaryContainer = CineVaultBrand900,
    onPrimaryContainer = CineVaultBrand500,

    secondary = CineVaultBase400,
    onSecondary = CineVaultBase1000,
    secondaryContainer = CineVaultBase900,
    onSecondaryContainer = CineVaultBase150,

    tertiary = CineVaultBrand500,
    onTertiary = CineVaultBase1000,
    tertiaryContainer = CineVaultBrand900,
    onTertiaryContainer = CineVaultBrand500,

    error = CineVaultRed500,
    onError = CineVaultBase0,
    errorContainer = CineVaultRed600,
    onErrorContainer = CineVaultRed200,

    background = CineVaultBase1000,
    onBackground = CineVaultBase0,
    surface = CineVaultBase950,
    onSurface = CineVaultBase0,
    surfaceVariant = CineVaultBase900,
    onSurfaceVariant = CineVaultBase150,

    outline = CineVaultBase100Alpha10,
    outlineVariant = CineVaultBase800,
)
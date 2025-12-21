package com.project.core.presentation.designsystem.theme

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.dp

@Immutable
class CineVaultShape(
    val fourPixelRounded: CornerBasedShape = CineVaultShapeDefaults.FourPixelRounded,
    val sixPixelRounded: CornerBasedShape = CineVaultShapeDefaults.SixPixelRounded,
    val eightPixelRounded: CornerBasedShape = CineVaultShapeDefaults.EightPixelRounded,
    val tenPixelRounded: CornerBasedShape = CineVaultShapeDefaults.TenPixelRounded,
    val twelvePixelRounded: CornerBasedShape = CineVaultShapeDefaults.TwelvePixelRounded,
    val fourteenPixelRounded: CornerBasedShape = CineVaultShapeDefaults.FourteenPixelRounded,
    val sixteenPixelRounded: CornerBasedShape = CineVaultShapeDefaults.SixteenPixelRounded,
    val sixteenPixelBottomRounded: CornerBasedShape = CineVaultShapeDefaults.SixteenPixelBottomRounded,
    val eighteenPixelRounded: CornerBasedShape = CineVaultShapeDefaults.EighteenPixelRounded,
    val twentyPixelRounded: CornerBasedShape = CineVaultShapeDefaults.TwentyPixelRounded,
    val twentyTwoPixelRounded: CornerBasedShape = CineVaultShapeDefaults.TwentyTwoPixelRounded,
    val twentyFourPixelRounded: CornerBasedShape = CineVaultShapeDefaults.TwentyFourPixelRounded,
    val twentySixPixelRounded: CornerBasedShape = CineVaultShapeDefaults.TwentySixPixelRounded,
    val twentyEightPixelRounded: CornerBasedShape = CineVaultShapeDefaults.TwentyEightPixelRounded,
    val thirtyPixelRounded: CornerBasedShape = CineVaultShapeDefaults.ThirtyPixelRounded,
    val thirtyTwoPixelRounded: CornerBasedShape = CineVaultShapeDefaults.ThirtyTwoPixelRounded,
    val fortyPixelRounded: CornerBasedShape = CineVaultShapeDefaults.FortyPixelRounded,
    val thirtyTwoPixelBottomRounded: CornerBasedShape = CineVaultShapeDefaults.ThirtyTwoPixelBottomRounded,
    val twentyFourPixelBottomRounded: CornerBasedShape = CineVaultShapeDefaults.TwentyFourPixelBottomRounded,
    val twentyFourPixelTopRounded: CornerBasedShape = CineVaultShapeDefaults.TwentyFourPixelTopRounded,
    val sixteenPixelTopRounded: CornerBasedShape = CineVaultShapeDefaults.SixteenPixelTopRounded,
    val bottomSheetRounded: CornerBasedShape = CineVaultShapeDefaults.TwentyFourPixelTopRounded,
)

private object CineVaultShapeDefaults {
    val FourPixelRounded: CornerBasedShape = RoundedCornerShape(size = 4.dp)
    val SixPixelRounded: CornerBasedShape = RoundedCornerShape(size = 6.dp)
    val EightPixelRounded: CornerBasedShape = RoundedCornerShape(size = 8.dp)
    val TenPixelRounded: CornerBasedShape = RoundedCornerShape(size = 10.dp)
    val TwelvePixelRounded: CornerBasedShape = RoundedCornerShape(size = 12.dp)
    val FourteenPixelRounded: CornerBasedShape = RoundedCornerShape(size = 14.dp)
    val SixteenPixelRounded: CornerBasedShape = RoundedCornerShape(size = 16.dp)
    val SixteenPixelBottomRounded: CornerBasedShape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
    val EighteenPixelRounded: CornerBasedShape = RoundedCornerShape(size = 18.dp)
    val TwentyPixelRounded: CornerBasedShape = RoundedCornerShape(size = 20.dp)
    val TwentyTwoPixelRounded: CornerBasedShape = RoundedCornerShape(size = 22.dp)
    val TwentyFourPixelRounded: CornerBasedShape = RoundedCornerShape(size = 24.dp)
    val TwentySixPixelRounded: CornerBasedShape = RoundedCornerShape(size = 26.dp)
    val TwentyEightPixelRounded: CornerBasedShape = RoundedCornerShape(size = 28.dp)
    val ThirtyPixelRounded: CornerBasedShape = RoundedCornerShape(size = 30.dp)
    val ThirtyTwoPixelRounded: CornerBasedShape = RoundedCornerShape(size = 32.dp)
    val FortyPixelRounded: CornerBasedShape = RoundedCornerShape(size = 40.dp)
    val ThirtyTwoPixelBottomRounded: CornerBasedShape = RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp)
    val TwentyFourPixelBottomRounded: CornerBasedShape = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)
    val TwentyFourPixelTopRounded: CornerBasedShape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
    val SixteenPixelTopRounded: CornerBasedShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
}
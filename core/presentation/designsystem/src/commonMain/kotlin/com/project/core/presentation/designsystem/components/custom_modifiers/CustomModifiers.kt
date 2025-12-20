package com.project.core.presentation.designsystem.components.custom_modifiers

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.project.core.presentation.designsystem.theme.CineVaultTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

fun Modifier.shimmerEffect(
    duration: Int = 1000,
    colors: List<Color> = listOf(
        Color(0xFFEEEEEE),
        Color(0xFF888888),
        Color(0xFFEEEEEE),
    )
): Modifier = composed {
    var size by remember { mutableStateOf(IntSize.Zero) }
    val transition = rememberInfiniteTransition(label = "Infinite Animation")
    val startOffsetX by transition.animateFloat(
        label = "Float Animation",
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(duration)
        )
    )

    background(
        brush = Brush.linearGradient(
            colors = colors,
            start = Offset(startOffsetX, 0f),
            end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
        )
    )
        .onGloballyPositioned {
            size = it.size
        }
}

@Preview(showBackground = true)
@Composable
private fun TestShimmerEffectPreview() {
    CineVaultTheme {
       Column(
           modifier = Modifier.fillMaxSize().background(color = Color.Black),
           verticalArrangement = Arrangement.spacedBy(12.dp)
       ) {
           Box(
               modifier = Modifier
                   .fillMaxWidth()
                   .aspectRatio(1f)
                   .shimmerEffect()
           )
       }
    }
}
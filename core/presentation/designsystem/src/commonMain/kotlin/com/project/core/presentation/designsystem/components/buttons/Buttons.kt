package com.project.core.presentation.designsystem.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.project.core.presentation.designsystem.theme.CineVaultTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun CircularButton(
    modifier: Modifier = Modifier,
    buttonText: String = "Continue",
    onClick: () -> Unit = {}
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onPrimary
        ),
        content = {
            Text(
                text = buttonText,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun CircularTextButton(
    modifier: Modifier = Modifier,
    buttonText: String = "Continue",
    buttonColor: Color = MaterialTheme.colorScheme.onPrimary,
    paddingValues: PaddingValues = PaddingValues(vertical = 10.dp, horizontal = 24.dp),
    onClick: () -> Unit = {}
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier =
            modifier
                .clip(shape = CircleShape)
                .background(color = buttonColor)
                .clickable(onClick = onClick)
    ) {
        Text(
            text = buttonText,
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ButtonsPreview() {
    CineVaultTheme {
        Column(
            modifier = Modifier.fillMaxSize().background(color = Color.Black),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CircularButton()
            CircularTextButton()
        }
    }
}
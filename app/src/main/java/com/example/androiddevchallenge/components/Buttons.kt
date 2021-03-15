/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonElevation
import androidx.compose.material.ContentAlpha
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.WeTradeTheme
import java.util.Locale

object WeTradeButtons {
    @Composable
    fun Primary(
        text: String,
        modifier: Modifier = Modifier,
        onClick: () -> Unit,
    ) {
        WeTradeButton(text = text, onClick = onClick, modifier = modifier)
    }

    @Composable
    fun Outlined(
        text: String,
        modifier: Modifier = Modifier,
        onClick: () -> Unit,
    ) {
        WeTradeOutlinedButton(text = text, onClick = onClick, modifier = modifier)
    }

    @Composable
    fun TabButton(
        text: String,
        modifier: Modifier = Modifier,
        onClick: () -> Unit,
    ) {
        WeTradeTextButton(text = text, onClick = onClick, modifier = modifier)
    }
}

@Composable
internal fun WeTradeTextButton(
    text: String,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.textButtonColors(
        backgroundColor = Color.Transparent,
        contentColor = WeTradeTheme.colors.onBackground,
        disabledContentColor = WeTradeTheme.colors.onBackground.copy(alpha = ContentAlpha.disabled)
    ),
    onClick: () -> Unit,
) {
    TextButton(
        onClick = onClick,
        colors = colors,
        modifier = modifier,
    ) {
        Text(text = text.toUpperCase(Locale.getDefault()))
    }
}

@Composable
internal fun WeTradeOutlinedButton(
    text: String,
    modifier: Modifier = Modifier,
    shape: Shape = WeTradeTheme.shapes.large,
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(
        backgroundColor = Color.Transparent,
        contentColor = WeTradeTheme.colors.primary,
        disabledContentColor = WeTradeTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled)
    ),
    elevation: ButtonElevation = ButtonDefaults.elevation(
        defaultElevation = 0.dp,
        pressedElevation = 0.dp,
        disabledElevation = 0.dp
    ),
    onClick: () -> Unit,
) {
    OutlinedButton(
        onClick = onClick,
        colors = colors,
        shape = shape,
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        elevation = elevation,
        border = BorderStroke(width = 1.dp, color = colors.contentColor(enabled = true).value)
    ) {
        Text(text = text.toUpperCase(Locale.getDefault()))
    }
}

@Composable
internal fun WeTradeButton(
    text: String,
    modifier: Modifier = Modifier,
    shape: Shape = WeTradeTheme.shapes.large,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        backgroundColor = WeTradeTheme.colors.primary,
        contentColor = WeTradeTheme.colors.onPrimary,
        disabledBackgroundColor = WeTradeTheme.colors.onSurface.copy(alpha = 0.12f),
        disabledContentColor = WeTradeTheme.colors.onSurface.copy(alpha = ContentAlpha.disabled)
    ),
    elevation: ButtonElevation = ButtonDefaults.elevation(
        defaultElevation = 0.dp,
        pressedElevation = 0.dp,
        disabledElevation = 0.dp
    ),
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        colors = colors,
        shape = shape,
        elevation = elevation,
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {
        Text(text = text.toUpperCase(Locale.getDefault()))
    }
}

@Preview
@Composable
fun WeTradeButtonPreview() {
    MyTheme {
        Column {
            WeTradeButtons.Primary("Get Started") {}
            Spacer(modifier = Modifier.height(5.dp))
            WeTradeButtons.Outlined("Log in") {}
            Spacer(modifier = Modifier.height(5.dp))
            WeTradeButtons.TabButton("Account") {}
        }
    }
}

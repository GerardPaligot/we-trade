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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable

@Composable
fun MyTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette
    CompositionLocalProvideWeTradeColors(colors) {
        MaterialTheme(
            colors = debugColors(darkTheme = darkTheme),
            typography = typography,
            shapes = shapes,
            content = content
        )
    }
}

object WeTradeTheme {
    val colors: WeTradeColors
        @Composable
        @ReadOnlyComposable
        get() = LocalWeTradeColors.current

    val typography: Typography
        @Composable
        @ReadOnlyComposable
        get() = com.example.androiddevchallenge.ui.theme.typography

    val shapes: Shapes
        @Composable
        @ReadOnlyComposable
        get() = com.example.androiddevchallenge.ui.theme.shapes
}

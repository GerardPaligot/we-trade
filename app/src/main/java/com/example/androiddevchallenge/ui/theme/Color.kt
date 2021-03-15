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

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val red = Color(0xFFD93C19)
val yellow = Color(0xFFE3DA00)
val green = Color(0xFF39A844)
val purple = Color(0xFF322049)
val gray = Color(0xFF353435)
val gray700 = Color(0xFF2D2D2D)
val gray900 = Color(0xFF232323)
val white = Color(0xFFFFFFFF)

val LightColorPalette = WeTradeColors(
    primary = yellow,
    onPrimary = gray900,
    background = purple,
    onBackground = white,
    surface = white,
    onSurface = gray900,
    chartGrid = gray,
    success = green,
    failure = red
)

val DarkColorPalette = WeTradeColors(
    primary = yellow,
    onPrimary = gray900,
    background = gray900,
    onBackground = white,
    surface = gray700,
    onSurface = white,
    chartGrid = gray,
    success = green,
    failure = red
)

@Stable
class WeTradeColors(
    primary: Color,
    onPrimary: Color,
    background: Color,
    onBackground: Color,
    surface: Color,
    onSurface: Color,
    chartGrid: Color,
    success: Color,
    failure: Color
) {
    var primary by mutableStateOf(primary)
        private set
    var onPrimary by mutableStateOf(onPrimary)
        private set
    var background by mutableStateOf(background)
        private set
    var onBackground by mutableStateOf(onBackground)
        private set
    var surface by mutableStateOf(surface)
        private set
    var onSurface by mutableStateOf(onSurface)
        private set
    var chartGrid by mutableStateOf(chartGrid)
        private set
    var success by mutableStateOf(success)
        private set
    var failure by mutableStateOf(failure)
        private set

    fun update(other: WeTradeColors) {
        primary = other.primary
        onPrimary = other.onPrimary
        background = other.background
        onBackground = other.onBackground
        surface = other.surface
        onSurface = other.onSurface
        chartGrid = other.chartGrid
        success = other.success
        failure = other.failure
    }
}

@Composable
fun CompositionLocalProvideWeTradeColors(
    colors: WeTradeColors,
    content: @Composable () -> Unit
) {
    val colorPalette = remember { colors }
    colorPalette.update(colors)
    CompositionLocalProvider(LocalWeTradeColors provides colorPalette, content = content)
}

internal val LocalWeTradeColors = staticCompositionLocalOf<WeTradeColors> {
    error("No WeTradeColors provided")
}

fun debugColors(
    darkTheme: Boolean,
    debugColor: Color = Color.Magenta
) = Colors(
    primary = debugColor,
    primaryVariant = debugColor,
    secondary = debugColor,
    secondaryVariant = debugColor,
    background = debugColor,
    surface = debugColor,
    error = debugColor,
    onPrimary = debugColor,
    onSecondary = debugColor,
    onBackground = debugColor,
    onSurface = debugColor,
    onError = debugColor,
    isLight = !darkTheme
)

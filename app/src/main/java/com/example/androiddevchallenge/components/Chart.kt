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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.FakeData
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.WeTradeTheme

@Composable
internal fun ChartLine(
    paths: List<Offset>,
    color: Color,
    modifier: Modifier = Modifier,
    lineWidth: Float = 4f,
    brush: Brush? = null,
) {
    val state = remember(paths) { ChartLineState(paths) }
    val xSize = state.getMaxX()
    val ySize = state.getMaxY()
    val minX = state.pathsSorted.minOf { it.x }
    val minY = state.pathsSorted.minOf { it.y }
    Box(
        modifier = modifier
            .fillMaxSize()
            .drawBehind {
                val strokePath = Path()
                val path = Path()
                state.pathsSorted.forEachIndexed { index, offset ->
                    val x = (offset.x - minX) * size.width / xSize
                    val y = (offset.y - minY) * size.height / ySize
                    if (index == 0) {
                        path.moveTo(x, size.height - y)
                        strokePath.moveTo(x, size.height - y)
                    } else {
                        path.lineTo(x, size.height - y)
                        strokePath.lineTo(x, size.height - y)
                    }
                }
                path.lineTo(size.width, size.height)
                path.lineTo(0f, size.height)
                brush?.let {
                    drawPath(path = path, brush = it, style = Fill)
                }
                drawPath(
                    path = strokePath,
                    color = color,
                    style = Stroke(width = lineWidth)
                )
            }
    )
}

internal class ChartLineState(
    private val paths: List<Offset>,
    val pathsSorted: List<Offset> = paths.sortedBy { it.x }
) {
    fun getMaxX() = pathsSorted.last().x - pathsSorted.first().x
    fun getMaxY() = pathsSorted.maxOf { it.y } - pathsSorted.minOf { it.y }
}

@Composable
internal fun Grid(
    xLegends: List<String>,
    yLegends: List<String>,
    modifier: Modifier = Modifier,
    lineWidth: Float = 4f,
    gridColor: Color = WeTradeTheme.colors.chartGrid,
    textColor: Color = WeTradeTheme.colors.onBackground,
    style: TextStyle = WeTradeTheme.typography.h4,
    content: @Composable BoxScope.() -> Unit
) {
    val bottomOffset = style.fontSize.value.dp + 15.dp
    BoxWithConstraints(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = bottomOffset)
            .drawBehind {
                val xSize = size.width / (xLegends.size + 1)
                (0..(xLegends.size + 1)).forEach { index ->
                    val xPosition = xSize * (index + 1)
                    drawLine(
                        color = gridColor,
                        start = Offset(xPosition, 0f),
                        end = Offset(xPosition, size.height),
                        strokeWidth = lineWidth
                    )
                }
                val ySize = size.height / yLegends.size
                (0..yLegends.size).forEach { index ->
                    val yPosition = ySize * index
                    drawLine(
                        color = gridColor,
                        start = Offset(0f, yPosition),
                        end = Offset(size.width, yPosition),
                        strokeWidth = lineWidth
                    )
                }
            },
        content = {
            xLegends.forEachIndexed { index, it ->
                val xSize = this.maxWidth / (xLegends.size + 1) * index
                Text(
                    text = it,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = xSize)
                        .offset(y = bottomOffset),
                    color = textColor,
                    style = style
                )
            }
            yLegends.reversed().forEachIndexed { index, it ->
                val ySize = this.maxHeight / yLegends.size * index
                Text(
                    text = it,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = ySize + 2.dp, end = 2.dp),
                    color = textColor,
                    style = style
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = this.maxWidth / (xLegends.size + 1)),
                content = content
            )
        }
    )
}

@Preview
@Composable
fun GridPreview() {
    MyTheme {
        Box(
            Modifier
                .fillMaxSize()
                .background(WeTradeTheme.colors.background)
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Grid(
                    xLegends = FakeData.charts[0].xLegends,
                    yLegends = FakeData.charts[0].yLegends,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp)
                ) {
                    ChartLine(
                        paths = FakeData.charts[0].paths,
                        color = WeTradeTheme.colors.success,
                        brush = Brush.verticalGradient(
                            arrayListOf(
                                WeTradeTheme.colors.success.copy(alpha = .2f),
                                WeTradeTheme.colors.success.copy(alpha = .2f),
                                WeTradeTheme.colors.success.copy(alpha = .2f),
                                WeTradeTheme.colors.success.copy(alpha = .2f),
                                Color.Transparent
                            )
                        )
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    ChartLine(
                        paths = FakeData.charts[0].paths,
                        color = WeTradeTheme.colors.success,
                        modifier = Modifier
                            .width(80.dp)
                            .height(16.dp)
                    )
                    ChartLine(
                        paths = FakeData.charts[1].paths,
                        color = WeTradeTheme.colors.failure,
                        modifier = Modifier
                            .width(80.dp)
                            .height(16.dp)
                    )
                    ChartLine(
                        paths = FakeData.charts[2].paths,
                        color = WeTradeTheme.colors.success,
                        modifier = Modifier
                            .width(80.dp)
                            .height(16.dp)
                    )
                }
            }
        }
    }
}

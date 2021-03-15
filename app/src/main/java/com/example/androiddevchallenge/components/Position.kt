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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.FakeData
import com.example.androiddevchallenge.data.Position
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.WeTradeTheme

@Composable
fun CompanyPosition(
    position: Position,
    modifier: Modifier = Modifier,
    background: Color = WeTradeTheme.colors.surface,
    contentColor: Color = WeTradeTheme.colors.onSurface
) {
    val percentage = String.format("%.2f", position.percentage)
    val sign = if (position.percentage >= 0) "+" else ""
    val status = if (position.percentage >= 0) WeTradeTheme.colors.success
    else WeTradeTheme.colors.failure
    Box(
        modifier = modifier
            .height(56.dp)
            .fillMaxWidth()
            .background(color = background)
    ) {
        Column {
            Text(
                text = position.price,
                modifier = Modifier.paddingFromBaseline(24.dp),
                color = contentColor,
                style = WeTradeTheme.typography.body1
            )
            Text(
                text = "$sign$percentage%",
                modifier = Modifier.paddingFromBaseline(16.dp),
                color = status,
                style = WeTradeTheme.typography.body1
            )
        }
        Column(modifier = Modifier.padding(start = 64.dp)) {
            Text(
                text = position.name,
                modifier = Modifier.paddingFromBaseline(24.dp),
                color = contentColor,
                style = WeTradeTheme.typography.h3
            )
            Text(
                text = position.company,
                modifier = Modifier.paddingFromBaseline(16.dp),
                color = contentColor,
                style = WeTradeTheme.typography.body1
            )
        }
        Box(modifier = Modifier.align(Alignment.CenterEnd)) {
            ChartLine(
                paths = position.paths,
                color = status,
                modifier = Modifier
                    .width(80.dp)
                    .height(16.dp)
            )
        }
    }
}

@Preview
@Composable
fun PositionPreview() {
    MyTheme {
        CompanyPosition(FakeData.positions[0])
    }
}

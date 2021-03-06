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
package com.example.androiddevchallenge.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.components.CompanyPosition
import com.example.androiddevchallenge.data.FakeData
import com.example.androiddevchallenge.data.Position
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.WeTradeTheme

@Composable
fun Positions(
    positions: List<Position>,
    modifier: Modifier = Modifier,
    gridColor: Color = WeTradeTheme.colors.chartGrid,
    backgroundColor: Color = WeTradeTheme.colors.surface,
    contentColor: Color = WeTradeTheme.colors.onSurface
) {
    LazyColumn(
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        item {
            Text(
                text = "Positions",
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentWidth(align = Alignment.CenterHorizontally)
                    .paddingFromBaseline(40.dp),
                style = WeTradeTheme.typography.subtitle1,
                color = contentColor
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
        items(positions) { position ->
            Column {
                Box(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(gridColor)
                )
                CompanyPosition(position = position)
            }
        }
    }
}

@Preview
@Composable
fun PositionsPreview() {
    MyTheme {
        Positions(positions = FakeData.positions)
    }
}

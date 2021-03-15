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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.components.ChartLine
import com.example.androiddevchallenge.components.Chip
import com.example.androiddevchallenge.components.Grid
import com.example.androiddevchallenge.components.WeTradeButtons
import com.example.androiddevchallenge.data.Chart
import com.example.androiddevchallenge.data.FakeData
import com.example.androiddevchallenge.data.Filter
import com.example.androiddevchallenge.data.Position
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.WeTradeTheme
import dev.chrisbanes.accompanist.insets.LocalWindowInsets
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import dev.chrisbanes.accompanist.insets.statusBarsPadding

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Home(
    chart: Chart,
    filters: List<Filter>,
    positions: List<Position>,
    backgroundColor: Color = WeTradeTheme.colors.background,
    contentColor: Color = WeTradeTheme.colors.onBackground,
    onTransact: () -> Unit
) {
    val scaffoldState = rememberBottomSheetScaffoldState()
    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        backgroundColor = backgroundColor,
        sheetShape = RectangleShape,
        sheetPeekHeight = 64.dp + LocalWindowInsets.current.navigationBars.bottom.dp,
        sheetBackgroundColor = backgroundColor,
        sheetContent = {
            Positions(positions = positions, modifier = Modifier.statusBarsPadding())
        },
        sheetElevation = 0.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundColor),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
                    .paddingFromBaseline(64.dp)
            ) {
                WeTradeButtons.TabButton(
                    text = "Account",
                    onClick = {}
                )
                WeTradeButtons.TabButton(
                    text = "Watchlist",
                    onClick = {}
                )
                WeTradeButtons.TabButton(
                    text = "Profile",
                    onClick = {}
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Balance",
                style = WeTradeTheme.typography.subtitle1,
                color = contentColor,
                modifier = Modifier.paddingFromBaseline(32.dp)
            )
            Text(
                text = "$73,589.01",
                style = WeTradeTheme.typography.h1,
                color = contentColor,
                modifier = Modifier.paddingFromBaseline(48.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "+412.35 today",
                style = WeTradeTheme.typography.subtitle1,
                color = WeTradeTheme.colors.success,
                modifier = Modifier.paddingFromBaseline(16.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            WeTradeButtons.Primary(
                text = "Transact",
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                onClick = onTransact
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(start = 16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(filters) { filter ->
                    Chip(
                        text = filter.text,
                        icon = if (filter.expanded) Icons.Filled.ExpandMore else null
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Grid(
                xLegends = chart.xLegends,
                yLegends = chart.yLegends,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                ChartLine(
                    paths = chart.paths,
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
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun HomePreview() {
    MyTheme {
        ProvideWindowInsets {
            Home(
                chart = FakeData.charts[0],
                filters = FakeData.filters,
                positions = FakeData.positions
            ) {}
        }
    }
}

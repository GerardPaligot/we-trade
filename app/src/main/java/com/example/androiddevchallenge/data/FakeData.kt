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
package com.example.androiddevchallenge.data

import androidx.compose.ui.geometry.Offset

data class Position(
    val price: String,
    val percentage: Float,
    val name: String,
    val company: String,
    val paths: List<Offset>
)

data class Chart(
    val paths: List<Offset>,
    val xLegends: List<String>,
    val yLegends: List<String>
)

data class Filter(
    val text: String,
    val expanded: Boolean = false
)

object FakeData {
    val filters = arrayListOf(
        Filter("Week", true),
        Filter("ETFs"),
        Filter("Stocks"),
        Filter("Funds"),
        Filter("Crypto"),
        Filter("Options"),
    )
    val charts = arrayListOf(
        Chart(
            paths = arrayListOf(
                Offset(4f, 63.630f),
                Offset(4.35f, 64.112f),
                Offset(5f, 64.112f),
                Offset(5.35f, 63.630f),
                Offset(6f, 65.112f),
                Offset(6.45f, 65.512f),
                Offset(7f, 65.512f),
                Offset(7.40f, 67.620f),
                Offset(8f, 68.300f),
                Offset(8.4f, 69.610f),
                Offset(9f, 69.200f),
                Offset(9.4f, 69.610f),
                Offset(10f, 69.610f),
                Offset(10.45f, 72.530f),
                Offset(11f, 73.630f)
            ),
            xLegends = arrayListOf("4", "5", "6", "7", "8", "9", "10"),
            yLegends = arrayListOf("65,631", "67,620", "69,610", "73,589")
        ),
        Chart(
            paths = arrayListOf(
                Offset(0f, 4f),
                Offset(0.4f, 3.2f),
                Offset(1.2f, 3.2f),
                Offset(2f, 3.5f),
                Offset(3.5f, 0.8f),
                Offset(4f, 1.1f),
                Offset(5f, 1.1f),
                Offset(5.5f, 0f),
                Offset(6.2f, 0.8f),
                Offset(7.6f, 1.6f),
                Offset(8.5f, 1f),
                Offset(9f, 1f),
                Offset(10f, 0f)
            ),
            xLegends = emptyList(),
            yLegends = emptyList()
        ),
        Chart(
            paths = arrayListOf(
                Offset(0f, 0f),
                Offset(0.4f, 1.5f),
                Offset(1.2f, 1.3f),
                Offset(2f, 1.3f),
                Offset(2.7f, 1.5f),
                Offset(3.4f, 1.5f),
                Offset(4f, 2f),
                Offset(5f, 2f),
                Offset(5.6f, 1.6f),
                Offset(6.1f, 1.6f),
                Offset(7f, 1.4f),
                Offset(7.8f, 1.4f),
                Offset(8.4f, 2f),
                Offset(9f, 1.4f),
                Offset(10f, 2f),
            ),
            xLegends = emptyList(),
            yLegends = emptyList()
        ),
        Chart(
            paths = arrayListOf(
                Offset(0f, 1f),
                Offset(0.7f, 0f),
                Offset(1.2f, 0.8f),
                Offset(3.5f, 1.1f),
                Offset(4f, 2f),
                Offset(4.9f, 1.9f),
                Offset(5.5f, 2.1f),
                Offset(6.2f, 2f),
                Offset(7f, 3f),
                Offset(7.9f, 2.1f),
                Offset(9.2f, 0.7f),
                Offset(10f, 2.5f),
            ),
            xLegends = emptyList(),
            yLegends = emptyList()
        ),
        Chart(
            paths = arrayListOf(
                Offset(0f, 0f),
                Offset(0.4f, 0.9f),
                Offset(1.1f, 1.1f),
                Offset(2f, 1.1f),
                Offset(2.8f, 0.6f),
                Offset(4f, 2.2f),
                Offset(4.9f, 2.2f),
                Offset(5.5f, 3f),
                Offset(6.2f, 3f),
                Offset(7f, 2.8f),
                Offset(8.5f, 3f),
                Offset(9f, 2.8f),
                Offset(10f, 2.8f),
            ),
            xLegends = emptyList(),
            yLegends = emptyList()
        ),
        Chart(
            paths = arrayListOf(
                Offset(0f, 1.5f),
                Offset(0.45f, 1f),
                Offset(1.3f, 1.6f),
                Offset(2f, 0.7f),
                Offset(2.8f, 0f),
                Offset(3.2f, 1.1f),
                Offset(4.1f, 1f),
                Offset(4.9f, 1.2f),
                Offset(5.6f, 2.95f),
                Offset(7f, 1f),
                Offset(7.8f, 1.7f),
                Offset(8.2f, 3f),
                Offset(10f, 3f),
            ),
            xLegends = emptyList(),
            yLegends = emptyList()
        ),
        Chart(
            paths = arrayListOf(
                Offset(0f, 0.5f),
                Offset(0.5f, 2.2f),
                Offset(2.8f, 0f),
                Offset(3.2f, 1f),
                Offset(4.1f, 0.8f),
                Offset(4.9f, 1.2f),
                Offset(5.5f, 1f),
                Offset(6.1f, 1.8f),
                Offset(8.5f, 2.4f),
                Offset(9f, 3f),
                Offset(10f, 2f),
            ),
            xLegends = emptyList(),
            yLegends = emptyList()
        ),
        Chart(
            paths = arrayListOf(
                Offset(0f, 1.1f),
                Offset(0.5f, 1.8f),
                Offset(1.3f, 1.3f),
                Offset(2f, 1.8f),
                Offset(2.5f, 1.5f),
                Offset(3.5f, 1.5f),
                Offset(4f, 1f),
                Offset(4.8f, 1.9f),
                Offset(5.5f, 1f),
                Offset(6.2f, 1.9f),
                Offset(7f, 0.8f),
                Offset(7.7f, 1.5f),
                Offset(8.5f, 2f),
                Offset(9f, 0.8f),
                Offset(10f, 2.5f),
            ),
            xLegends = emptyList(),
            yLegends = emptyList()
        ),
        Chart(
            paths = arrayListOf(
                Offset(0f, 1.1f),
                Offset(0.4f, 0.95f),
                Offset(1.2f, 1.2f),
                Offset(2f, 1.2f),
                Offset(2.8f, 0.8f),
                Offset(3.5f, 1.8f),
                Offset(4f, 4.1f),
                Offset(4.9f, 2f),
                Offset(5.5f, 2.9f),
                Offset(6.2f, 2.7f),
                Offset(7f, 3.4f),
                Offset(7.7f, 3f),
                Offset(8.5f, 3.2f),
                Offset(10f, 4.2f),
            ),
            xLegends = emptyList(),
            yLegends = emptyList()
        ),
        Chart(
            paths = arrayListOf(
                Offset(0f, 1f),
                Offset(0.5f, 1.5f),
                Offset(1.2f, 2f),
                Offset(2f, 2f),
                Offset(2.8f, 0f),
                Offset(3.2f, 2.2f),
                Offset(4f, 3f),
                Offset(4.9f, 1.9f),
                Offset(5.5f, 2.5f),
                Offset(6.2f, 2.5f),
                Offset(7f, 2f),
                Offset(7.8f, 2f),
                Offset(8.5f, 3f),
                Offset(9f, 2f),
                Offset(10f, 3f),
            ),
            xLegends = emptyList(),
            yLegends = emptyList()
        ),
        Chart(
            paths = arrayListOf(
                Offset(0f, 1.5f),
                Offset(0.5f, 0.8f),
                Offset(2f, 2.5f),
                Offset(3f, 2f),
                Offset(4.1f, 0.4f),
                Offset(5.5f, 3.2f),
                Offset(6.2f, 1.7f),
                Offset(7f, 3f),
                Offset(7.8f, 3f),
                Offset(8.5f, 4.1f),
                Offset(9f, 2.1f),
                Offset(10f, 3f),
            ),
            xLegends = emptyList(),
            yLegends = emptyList()
        )
    )
    val positions = arrayListOf(
        Position(
            price = "$7.918",
            percentage = -0.54f,
            name = "ALK",
            company = "Alaska Air Group, Inc.",
            paths = charts[1].paths
        ),
        Position(
            price = "$1,293",
            percentage = 4.18f,
            name = "BA",
            company = "Boeing Co.",
            paths = charts[2].paths
        ),
        Position(
            price = "$893.50",
            percentage = -0.54f,
            name = "DAL",
            company = "Delta Airlines Inc.",
            paths = charts[3].paths
        ),
        Position(
            price = "$12,301",
            percentage = 2.51f,
            name = "EXPE",
            company = "Expedia Group Inc.",
            paths = charts[4].paths
        ),
        Position(
            price = "$12,301",
            percentage = 1.38f,
            name = "EADSY",
            company = "Airbus SE",
            paths = charts[5].paths
        ),
        Position(
            price = "$8,521",
            percentage = 1.56f,
            name = "JBLU",
            company = "Jetblue Airways Corp.",
            paths = charts[6].paths
        ),
        Position(
            price = "$521",
            percentage = 2.75f,
            name = "MAR",
            company = "Marriott International Inc.",
            paths = charts[7].paths
        ),
        Position(
            price = "$5,481",
            percentage = 0.14f,
            name = "CCL",
            company = "Carnival Corp",
            paths = charts[8].paths
        ),
        Position(
            price = "$9,184",
            percentage = 1.69f,
            name = "RCL",
            company = "Royal Caribbean Cruises",
            paths = charts[9].paths
        ),
        Position(
            price = "$654",
            percentage = 3.23f,
            name = "TRVL",
            company = "Travelocity Inc.",
            paths = charts[10].paths
        ),
    )
}

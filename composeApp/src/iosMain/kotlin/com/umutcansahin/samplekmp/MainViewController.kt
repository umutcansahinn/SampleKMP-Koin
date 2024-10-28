package com.umutcansahin.samplekmp

import androidx.compose.ui.window.ComposeUIViewController
import com.umutcansahin.samplekmp.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = { initKoin() }) { App() }
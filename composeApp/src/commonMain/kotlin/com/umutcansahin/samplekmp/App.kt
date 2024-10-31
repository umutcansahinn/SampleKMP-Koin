package com.umutcansahin.samplekmp

import androidx.compose.runtime.Composable
import com.umutcansahin.samplekmp.ui.MainScreen
import com.umutcansahin.samplekmp.ui.ktor.KtorClientScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    KoinContext {
        //MainScreen()
        KtorClientScreen()

    }
}
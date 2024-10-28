package com.umutcansahin.samplekmp.di

import com.umutcansahin.samplekmp.data.MySingleton
import com.umutcansahin.samplekmp.data.MySingletonImpl
import com.umutcansahin.samplekmp.ui.MainViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val platformModule = module {
    singleOf(::MySingletonImpl).bind(MySingleton::class)
    viewModelOf(::MainViewModel)

}
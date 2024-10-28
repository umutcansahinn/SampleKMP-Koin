package com.umutcansahin.samplekmp.di

import com.umutcansahin.samplekmp.data.MyFactory
import com.umutcansahin.samplekmp.data.MyFactoryImpl
import com.umutcansahin.samplekmp.data.MySingleton
import com.umutcansahin.samplekmp.data.MySingletonImpl
import com.umutcansahin.samplekmp.ui.MainViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(provideMyClass, provideViewModel)
    }
}

expect val platformModule: Module

val provideMyClass = module {
    singleOf(::MySingletonImpl).bind(MySingleton::class)
    factoryOf(::MyFactoryImpl).bind(MyFactory::class)
}

val provideViewModel = module {
    viewModelOf(::MainViewModel)
}
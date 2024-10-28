package com.umutcansahin.samplekmp.ui

import androidx.lifecycle.ViewModel
import com.umutcansahin.samplekmp.data.MyFactory
import com.umutcansahin.samplekmp.data.MySingleton
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel(
    private val mySingletonClassFirst: MySingleton,
    private val mySingletonClassSecond: MySingleton,
    private val myFactoryFirst: MyFactory,
    private val myFactorySecond: MyFactory
) : ViewModel() {

    private val _singletonFirst = MutableStateFlow(mySingletonClassFirst.number)
    val singletonFirst = _singletonFirst.asStateFlow()

    private val _singletonSecond = MutableStateFlow(mySingletonClassSecond.number)
    val singletonSecond = _singletonSecond.asStateFlow()

    fun increaseSingletonFirst() {
        _singletonFirst.update {
            ++mySingletonClassFirst.number
        }
    }

    fun increaseSingletonSecond() {
        _singletonSecond.update {
            ++mySingletonClassSecond.number
        }
    }

    private val _factoryFirst = MutableStateFlow(myFactoryFirst.number)
    val factoryFirst = _factoryFirst.asStateFlow()

    private val _factorySecond = MutableStateFlow(myFactorySecond.number)
    val factorySecond = _factorySecond.asStateFlow()

    fun increaseFactoryFirst() {
        _factoryFirst.update {
            ++myFactoryFirst.number
        }
    }

    fun increaseFactorySecond() {
        _factorySecond.update {
            ++myFactorySecond.number
        }
    }
}
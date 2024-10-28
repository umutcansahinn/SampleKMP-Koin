package com.umutcansahin.samplekmp.data


interface MySingleton {
    var number: Int
}

class MySingletonImpl : MySingleton {
    override var number: Int = 0
}


interface MyFactory {
    var number: Int
}

class MyFactoryImpl : MyFactory {
    override var number: Int = 0
}


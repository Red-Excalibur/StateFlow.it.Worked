package com.jetpack_compose_trainning_01

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.concurrent.Flow

class MainViewModel:ViewModel() {

    private val _data = MutableStateFlow<Int>(0)

    val data :StateFlow<Int> = _data



    suspend fun changeTheDataContinuously(){
       while (true){
           _data.value++
           delay(1000)
       }

    }
}

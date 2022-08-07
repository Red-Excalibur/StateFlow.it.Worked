package com.jetpack_compose_trainning_01

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import com.jetpack_compose_trainning_01.ui.theme.Jetpack_Compose_trainning_01Theme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.launch

val viewModelObject = MainViewModel()
var x : Int =0
var context :Context? = null
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        context = this


        lifecycleScope.launchWhenStarted {
               lifecycleScope.launchWhenStarted{ viewModelObject.changeTheDataContinuously() }
            viewModelObject.data.collect{
                x =viewModelObject.data.value

                lifecycleScope.launch(Dispatchers.Main){

                   Toast.makeText(context,"$x",Toast.LENGTH_SHORT).show()
               }
            }
        }



        setContent {
            Jetpack_Compose_trainning_01Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "$name !")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Jetpack_Compose_trainning_01Theme {
    }
}
package com.tops.kotlin.coroutinesapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main4)

        // val job = CoroutineScope(Dispatchers.IO).launch{} // return deferred<T> object

        CoroutineScope(Dispatchers.IO).launch {
            printFollowers()
        }

    }

    private suspend fun printFollowers() {
        val job = CoroutineScope(Dispatchers.IO).async {
            getFbFollowers()
            // "Hello World"
        }

        val job2 = CoroutineScope(Dispatchers.IO).async {
            getInstagramFollowers()
        }
        Log.d(
            "KOTLIN_COROUTINES",
            "printFollowers: Facebook : ${job.await()} & Instagram : ${job2.await()}"
        )
    }

    private suspend fun getFbFollowers(): Int {
        delay(1000)
        return 54
    }

    private suspend fun getInstagramFollowers(): Int {
        delay(1000)
        return 113
    }
}
package com.tops.kotlin.coroutinesapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        CoroutineScope(Dispatchers.Main).launch {
            task1()
        }

        CoroutineScope(Dispatchers.Main).launch {
            task2()
        }
    }

    suspend fun task1() {
        Log.d("KOTLIN_COROUTINES", "STARTING TASK 1")
        //suspension points by coroutines
        yield()
        // delay(1000)
        Log.d("KOTLIN_COROUTINES", "ENDING TASK 1")
    }

    suspend fun task2() {
        Log.d("KOTLIN_COROUTINES", "STARTING TASK 2")
        //suspension points by coroutines
        yield()
        // delay(2000)
        Log.d("KOTLIN_COROUTINES", "ENDING TASK 2")
    }
}
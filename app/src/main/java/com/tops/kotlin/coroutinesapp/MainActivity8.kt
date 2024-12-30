package com.tops.kotlin.coroutinesapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main8)

        GlobalScope.launch {
            executeTask()
        }
    }

    // Non Blocking
    /*private suspend fun executeTask() {
        Log.d("KOTLIN_COROUTINES", "executeTask: Before")
        GlobalScope.launch {
            delay(1000)
            Log.d("KOTLIN_COROUTINES", "executeTask: Inside")
        }
        Log.d("KOTLIN_COROUTINES", "executeTask: After")
    }*/

    // Blocking (withContext)
    private suspend fun executeTask() {
        Log.d("KOTLIN_COROUTINES", "executeTask: Before")
        withContext(Dispatchers.IO) {
            delay(1000)
            Log.d("KOTLIN_COROUTINES", "executeTask: Inside")
        }
        Log.d("KOTLIN_COROUTINES", "executeTask: After")
    }

    // Blocking (runBlocking)
}
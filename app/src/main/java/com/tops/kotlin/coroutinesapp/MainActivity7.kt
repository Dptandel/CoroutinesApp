package com.tops.kotlin.coroutinesapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class MainActivity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main7)

        GlobalScope.launch(Dispatchers.Main) {
            execute()
        }
    }

    private suspend fun execute() {
        val parentJob = CoroutineScope(Dispatchers.IO).launch {
            for (i in 1..1000) {
                /*executeLongRunningTask()
                Log.d("KOTLIN_COROUTINES", i.toString())*/
                if (isActive) {
                    executeLongRunningTask()
                    Log.d("KOTLIN_COROUTINES", i.toString())
                }
            }
        }
        delay(100)
        Log.d("KOTLIN_COROUTINES", "Cancelling Job")
        parentJob.cancel()
        parentJob.join()
        Log.d("KOTLIN_COROUTINES", "Parent Completed")
    }

    private fun executeLongRunningTask() {
        for (i in 1..10000000) {
        }
    }
}
package com.tops.kotlin.coroutinesapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main6)

        GlobalScope.launch(Dispatchers.Main) {
            execute()
        }
    }

    private suspend fun execute() {
        val parentJob = GlobalScope.launch(Dispatchers.Main) {
            // Log.d("KOTLIN_COROUTINES", "Parent- $coroutineContext")
            Log.d("KOTLIN_COROUTINES", "Parent Started")

            val childJob = launch(Dispatchers.IO) {
                // Log.d("KOTLIN_COROUTINES", "Child- $coroutineContext")
                /*Log.d("KOTLIN_COROUTINES", "Child Started")
                delay(5000)
                Log.d("KOTLIN_COROUTINES", "Child Ended")*/
                try {
                    Log.d("KOTLIN_COROUTINES", "Child Started")
                    delay(5000)
                    Log.d("KOTLIN_COROUTINES", "Child Ended")
                } catch (e: CancellationException) {
                    Log.d("KOTLIN_COROUTINES", "Child Job Cancelled")
                }
            }

            delay(3000)
            // Log.d("KOTLIN_COROUTINES", "Child Job Cancelled")
            childJob.cancel()
            Log.d("KOTLIN_COROUTINES", "Parent Ended")
        }

        /*delay(1000)
        parentJob.cancel()*/
        parentJob.join()
        Log.d("KOTLIN_COROUTINES", "Parent Completed")
    }
}
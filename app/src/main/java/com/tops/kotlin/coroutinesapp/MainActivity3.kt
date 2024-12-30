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

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main3)

        // val job = CoroutineScope(Dispatchers.IO).launch{} // return job object
        // job.cancel() //to cancel coroutine
        // job.join() //make coroutine suspended until job is done

        CoroutineScope(Dispatchers.IO).launch {
            printFollowers()
        }

    }

    private suspend fun printFollowers() {
        var fbFollowers = 0
        var instagramFollowers = 0

        val job = CoroutineScope(Dispatchers.IO).launch {
            fbFollowers = getFbFollowers()
        }

        val job2 = CoroutineScope(Dispatchers.IO).launch {
            instagramFollowers = getInstagramFollowers()
        }

        job.join()
        job2.join()
        Log.d(
            "KOTLIN_COROUTINES",
            "printFollowers: Facebook : $fbFollowers & Instagram : $instagramFollowers"
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
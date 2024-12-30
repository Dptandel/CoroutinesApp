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

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main5)

        CoroutineScope(Dispatchers.IO).launch {
            printFollowers()
        }
    }

    private fun printFollowers() {
        CoroutineScope(Dispatchers.IO).launch {
            val fbFollowers = async { getFbFollowers() }
            val instagramFollowers = async { getInstagramFollowers() }
            Log.d(
                "KOTLIN_COROUTINES",
                "printFollowers: Facebook : ${fbFollowers.await()} & Instagram : ${instagramFollowers.await()}"
            )
        }
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
package com.tops.kotlin.coroutinesapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.tops.kotlin.coroutinesapp.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        Log.d("KOTLIN_COROUTINES", Thread.currentThread().name)
    }

    @SuppressLint("SetTextI18n")
    fun updateCounter(view: View) {
        Log.d("KOTLIN_COROUTINES", Thread.currentThread().name)
        binding.tvCounter.text = "${binding.tvCounter.text.toString().toInt() + 1}"
    }

    private fun executeLongRunningTask() {
        for (i in 1..1000000000L) {

        }
    }

    fun doAction(view: View) {

        /*thread(start = true) {
            executeLongRunningTask()
        }*/

        CoroutineScope(Dispatchers.IO).launch {
            Log.d("KOTLIN_COROUTINES", "1- ${Thread.currentThread().name}")
        }

        GlobalScope.launch(Dispatchers.Main) {
            Log.d("KOTLIN_COROUTINES", "2- ${Thread.currentThread().name}")
        }

        MainScope().launch(Dispatchers.Default) {
            Log.d("KOTLIN_COROUTINES", "3- ${Thread.currentThread().name}")
        }
    }
}
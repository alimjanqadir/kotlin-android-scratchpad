package com.example.kotlin_android_scratchpad

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val container = findViewById<LinearLayout>(R.id.container)

        repeat(10) {
            val imageView = ImageView(this)

            val options = BitmapFactory.Options()
            options.inSampleSize = it + 2
            val bitmap = BitmapFactory.decodeResource(resources, R.drawable.original_image, options)
            imageView.setImageBitmap(bitmap)

            container.addView(imageView)
        }

    }
}
package com.example.test

import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the views
        val imageView = findViewById<ImageView>(R.id.imageView)
        val buttonRed = findViewById<Button>(R.id.buttonRed)
        val buttonGreen = findViewById<Button>(R.id.buttonGreen)
        val buttonBlue = findViewById<Button>(R.id.buttonBlue)

        // Button click listeners to trigger image change with fade effect
        buttonRed.setOnClickListener {
            fadeImage(imageView, R.drawable.image1)  // Set image with fade effect
        }

        buttonGreen.setOnClickListener {
            fadeImage(imageView, R.drawable.image2)  // Set image with fade effect
        }

        buttonBlue.setOnClickListener {
            fadeImage(imageView, R.drawable.image3)  // Set image with fade effect
        }
    }

    private fun fadeImage(imageView: ImageView, newImageRes: Int) {
        // Fade out the current image
        val fadeOut = AlphaAnimation(1f, 0f)
        fadeOut.duration = 500 // Duration of fade-out animation
        fadeOut.fillAfter = true // Keep the image invisible after fading out
        imageView.startAnimation(fadeOut)

        // Once fade-out is complete, change the image and fade it in
        fadeOut.setAnimationListener(object : android.view.animation.Animation.AnimationListener {
            override fun onAnimationStart(animation: android.view.animation.Animation?) {}

            override fun onAnimationEnd(animation: android.view.animation.Animation?) {
                imageView.setImageResource(newImageRes)  // Set new image
                val fadeIn = AlphaAnimation(0f, 1f)
                fadeIn.duration = 500 // Duration of fade-in animation
                imageView.startAnimation(fadeIn)  // Fade in the new image
            }

            override fun onAnimationRepeat(animation: android.view.animation.Animation?) {}
        })
    }
}







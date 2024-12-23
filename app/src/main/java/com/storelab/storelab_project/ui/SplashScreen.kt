package com.storelab.storelab_project.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.storelab.storelab_project.R

class SplashScreen : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                this.requestWindowFeature(Window.FEATURE_NO_TITLE);
                setContentView(R.layout.activity_splash)
                window.setFlags(
                        WindowManager.LayoutParams.FLAG_FULLSCREEN,
                        WindowManager.LayoutParams.FLAG_FULLSCREEN
                )
                Handler(Looper.getMainLooper()).postDelayed({
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                }, 3000) // 3000 is the delayed time in milliseconds.
        }
}

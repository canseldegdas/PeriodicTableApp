package com.example.periodictableapp.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.periodictableapp.R


class SplachScreenActivity : AppCompatActivity() {
    var topAnimation:Animation?=null
    var bottomAnimation:Animation?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splach_screen)

        topAnimation=AnimationUtils.loadAnimation(this,R.anim.top_animation)
        bottomAnimation=AnimationUtils.loadAnimation(this,R.anim.bottom_animation)
        var image1=findViewById<ImageView>(R.id.imageView)
        var image4=findViewById<ImageView>(R.id.imageView4)
        var image6=findViewById<ImageView>(R.id.imageView6)
        var image3=findViewById<ImageView>(R.id.imageView3)
        var image5=findViewById<ImageView>(R.id.imageView5)

        image1.animation=topAnimation;
        image4.animation=topAnimation;
        image6.animation=bottomAnimation;
        image3.animation=bottomAnimation;
        image5.animation=bottomAnimation;
        Handler().postDelayed({ //This method will be executed once the timer is over
            // Start your app main activity
            val i = Intent(this@SplachScreenActivity, MainActivity::class.java)
            startActivity(i)
            // close this activity
            finish()
        }, 1000)


    }
}
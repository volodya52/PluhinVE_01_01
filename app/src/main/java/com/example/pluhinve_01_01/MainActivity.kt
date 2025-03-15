package com.example.pluhinve_01_01

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun GoNextScreen(view:View){
        val intent=Intent(this,SecondScreen::class.java)
        startActivity(intent)
    }
}
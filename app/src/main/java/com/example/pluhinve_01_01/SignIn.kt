package com.example.pluhinve_01_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result)
        val result = intent.getDoubleExtra("result", 0.0)
        val resultTextView = findViewById<TextView>(R.id.resultTextView1)
        resultTextView.text = "${result}"
        val input=intent.getDoubleExtra("input",0.0)
        var inputTV=findViewById<TextView>(R.id.inputTextView2)
        inputTV.text="${input}"
    }
}
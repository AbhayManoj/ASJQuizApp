package com.example.asjquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    private lateinit var scoreboard: TextView
    private lateinit var backbutton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)
        scoreboard=findViewById(R.id.textView7)
        backbutton=findViewById(R.id.button4)


        scoreboard.text=intent.getStringExtra("score")+"/50"

        backbutton.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}
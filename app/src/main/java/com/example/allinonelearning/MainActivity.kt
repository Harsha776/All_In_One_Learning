package com.example.allinonelearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var tvText:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvText=findViewById(R.id.tvText)
        tvText.setText((applicationContext as MyApplication).networking.getBaseUrl()+" "+
                (applicationContext as MyApplication).roomDB.dbName+" "+
                (applicationContext as MyApplication).roomDB.version)
    }
}
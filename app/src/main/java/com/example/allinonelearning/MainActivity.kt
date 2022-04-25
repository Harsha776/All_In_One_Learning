package com.example.allinonelearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.allinonelearning.di.components.ApplicationComponent
import com.example.allinonelearning.di.components.DaggerActivityComponent
import com.example.allinonelearning.di.module.ActivityModule
import com.example.allinonelearning.di.module.ApplicationModule
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject lateinit var mainViewModel: MainViewModel
    lateinit var tvText:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvText=findViewById(R.id.tvText)
        DaggerActivityComponent.builder()
            .applicationComponent((application as (MyApplication)).applicationComponent)
            .activityModule(ActivityModule(this))
            .build().inject(this)
        tvText.setText("mainViewModel.getData()")
        mainViewModel.getData()
    }
}
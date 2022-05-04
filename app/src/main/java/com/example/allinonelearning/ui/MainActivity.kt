package com.example.allinonelearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.allinonelearning.di.components.ActivityComponent
import com.example.allinonelearning.di.components.DaggerActivityComponent
import com.example.allinonelearning.di.module.ActivityModule
import com.example.allinonelearning.room.entityPojo.Note
import com.example.allinonelearning.ui.base.BaseActivity
import java.util.*
import javax.inject.Inject

class MainActivity : BaseActivity<MainViewModel>() {
    @Inject lateinit var mainViewModel: MainViewModel
    lateinit var tvText:TextView
    lateinit var btn:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tvText=findViewById(R.id.tvText)
        btn=findViewById(R.id.btn)
        tvText.setText("mainViewModel.getData()")
        mainViewModel.getData()


        btn.setOnClickListener {
            mainViewModel.printDB()
        }

    }

    override fun getLayout(): Int =R.layout.activity_main

    override fun injectDependency(activityComponent: ActivityComponent) =
        activityComponent.inject(this)
}
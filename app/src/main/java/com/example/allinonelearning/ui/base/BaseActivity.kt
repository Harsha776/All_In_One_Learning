package com.example.allinonelearning.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.allinonelearning.MyApplication
import com.example.allinonelearning.di.components.ActivityComponent
import com.example.allinonelearning.di.components.DaggerActivityComponent
import com.example.allinonelearning.di.module.ActivityModule
import javax.inject.Inject

abstract class BaseActivity<vm : BaseViewModel>: AppCompatActivity() {

    abstract fun getLayout():Int

    @Inject
    lateinit var viewmodel: vm
    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependency(provideInject())
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
    }

    fun provideInject():ActivityComponent{
       return DaggerActivityComponent.builder().applicationComponent((applicationContext as MyApplication).applicationComponent)
            .activityModule(ActivityModule(this)).build()
    }

    abstract fun injectDependency(activityComponent: ActivityComponent)
}
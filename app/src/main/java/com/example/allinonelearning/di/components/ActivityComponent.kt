package com.example.allinonelearning.di.components

import com.example.allinonelearning.MainActivity
import com.example.allinonelearning.di.module.ActivityModule
import com.example.allinonelearning.di.scope.ActivityScope
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent{

    fun inject(mainActivity: MainActivity)
}
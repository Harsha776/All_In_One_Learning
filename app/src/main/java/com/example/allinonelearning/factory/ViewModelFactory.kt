package com.example.allinonelearning.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException
import javax.inject.Singleton
import kotlin.reflect.KClass

@Singleton
class ViewModelFactory<T:ViewModel>(
    private val kClass: KClass<T>,
    private val creator : ()->T
): ViewModelProvider.NewInstanceFactory() {

    @Throws(IllegalArgumentException::class)
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(kClass.java)) return creator() as T
        throw IllegalArgumentException("class not found")
    }
}
package com.geomecha.pricetracker.core.delegate

import android.app.Activity
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

inline fun <reified T : ViewBinding> AppCompatActivity.viewBinding(
    noinline factory: (LayoutInflater) -> T
): ReadOnlyProperty<AppCompatActivity, T> {
    return ActivityViewBindingProperty(this, factory)
}

class ActivityViewBindingProperty<T : ViewBinding>(
    private val activity: AppCompatActivity,
    private val factory: (LayoutInflater) -> T
) : ReadOnlyProperty<Activity, T>, DefaultLifecycleObserver {
    private var binding: T? = null

    init {
        activity.lifecycle.addObserver(this)
    }

    override fun onCreate(owner: LifecycleOwner) {
        super.onCreate(owner)
        inflateIfNull()
        activity.setContentView(binding?.root!!)
    }

    override fun onDestroy(owner: LifecycleOwner) {
        activity.lifecycle.removeObserver(this)
        binding = null
        super.onDestroy(owner)
    }

    override fun getValue(thisRef: Activity, property: KProperty<*>): T {
        inflateIfNull()
        return binding!!
    }

    private fun inflateIfNull() {
        if (binding == null)
            binding = factory.invoke(activity.layoutInflater)
    }

}
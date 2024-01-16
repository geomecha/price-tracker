package com.geomecha.pricetracker.core.base.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

typealias Inflate<T> = (LayoutInflater, ViewGroup?, Boolean) -> T

abstract class BaseFragment<viewBinding : ViewBinding>(
    private val inflate: Inflate<viewBinding>
) : Fragment() {

    private var _binding: viewBinding? = null
    val binding get() = _binding!!

    protected val navController by lazy { findNavController() }

    open val diModule: Module = module { }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        loadKoinModules(diModule)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onStop() {
        unloadKoinModules(diModule)
        super.onStop()
    }


}
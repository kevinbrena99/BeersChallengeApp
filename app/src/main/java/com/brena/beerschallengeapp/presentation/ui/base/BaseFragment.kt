package com.brena.beerschallengeapp.presentation.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import java.util.*

/**
 * Created by Kevin Breña on 4/06/2021.
 * kevin.brena99@gmail.com
 *
 * Lima, Peru.
 **/

abstract class BaseFragment<T : ViewDataBinding, out ViewModelAny : BaseViewModel<*>> : Fragment() {

    companion object{
        val TAG = BaseFragment::class.java.simpleName
    }

    protected lateinit var binding: T
    private lateinit var rootView: View

    abstract val myViewModel : ViewModelAny
    abstract val getLayoutId: Int
    abstract val getBindingVariable: Int

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId, container, false)
        rootView = binding.root
        binding.setVariable(getBindingVariable, myViewModel)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.executePendingBindings()
        onFragmentViewReady(view)
    }

    abstract fun onFragmentViewReady(view: View)

    override fun onDestroyView() {
        super.onDestroyView()
        myViewModel.clear()
    }
}
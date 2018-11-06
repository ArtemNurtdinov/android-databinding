package com.nefrit.databinding.ui.operations

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.nefrit.databinding.R
import com.nefrit.databinding.databinding.ActivityOperationsBinding
import com.nefrit.databinding.util.viewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class OperationsActivity : DaggerAppCompatActivity() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var operationsViewModel: OperationsViewModel

    private lateinit var adapter: OperationAdapter

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, OperationsActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        operationsViewModel = viewModelProvider(viewModelFactory)

        val binding = DataBindingUtil.setContentView<ActivityOperationsBinding>(this, R.layout.activity_operations).apply {
            viewModel = operationsViewModel
            setLifecycleOwner(this@OperationsActivity)
        }

        adapter = OperationAdapter(this)

        binding.operationsList.apply {
            adapter = this@OperationsActivity.adapter
            (layoutManager as LinearLayoutManager).recycleChildrenOnDetach = true
        }

        operationsViewModel.operations.observe(this, Observer { points ->
            points?.let {
                adapter.submitList(it)
            }
        })

        lifecycle.addObserver(operationsViewModel)
    }
}
package com.nefrit.databinding.ui.operations

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.nefrit.databinding.R
import com.nefrit.databinding.databinding.ActivityOperationsBinding
import com.nefrit.databinding.util.viewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class OperationsActivity : DaggerAppCompatActivity() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, OperationsActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityOperationsBinding>(this, R.layout.activity_operations).apply {
            viewModel = viewModelProvider(viewModelFactory)
            setLifecycleOwner(this@OperationsActivity)
        }
    }
}
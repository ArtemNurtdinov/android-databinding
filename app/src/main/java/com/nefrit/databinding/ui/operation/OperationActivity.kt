package com.nefrit.databinding.ui.operation

import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.nefrit.databinding.R
import com.nefrit.databinding.databinding.ActivityOperationBinding
import com.nefrit.databinding.util.viewModelProvider
import com.nefrit.model.Operation
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class OperationActivity : DaggerAppCompatActivity() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var operationViewModel: OperationViewModel

    companion object {
        private const val KEY_OPERATION_ID = "OPERATION_ID"
        fun start(context: Context, operation: Operation) {
            val intent = Intent(context, OperationActivity::class.java).apply {
                putExtra(KEY_OPERATION_ID, operation.id)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val operationId = intent.getIntExtra(KEY_OPERATION_ID, 0)

        operationViewModel = viewModelProvider(viewModelFactory)

        val binding =
            DataBindingUtil.setContentView<ActivityOperationBinding>(this, R.layout.activity_operation).apply {
                viewModel = operationViewModel
                setLifecycleOwner(this@OperationActivity)
            }
    }

    override fun onStart() {
        super.onStart()
        operationViewModel.setOperationId(intent.getIntExtra(KEY_OPERATION_ID, 0))
    }

    override fun onStop() {
        super.onStop()
        // Force a refresh when this screen gets added to a backstack and user comes back to it.
        operationViewModel.setOperationId(0)
    }
}
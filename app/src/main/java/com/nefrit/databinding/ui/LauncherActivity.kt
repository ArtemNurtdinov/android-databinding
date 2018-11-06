package com.nefrit.databinding.ui

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import com.nefrit.data.result.EventObserver
import com.nefrit.databinding.ui.LaunchDestination.MAIN_ACTIVITY
import com.nefrit.databinding.ui.operations.OperationsActivity
import com.nefrit.databinding.util.viewModelProvider
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class LauncherActivity : DaggerAppCompatActivity() {

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: LauncherViewModel = viewModelProvider(viewModelFactory)

        viewModel.launchLiveData.observe(this, EventObserver { destination ->
            when (destination) {
                MAIN_ACTIVITY -> OperationsActivity.start(this)
            }
            finish()
        })
    }
}
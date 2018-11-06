package com.nefrit.databinding.ui

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.nefrit.data.result.Event
import javax.inject.Inject

class LauncherViewModel @Inject constructor(

) : ViewModel() {

    val launchLiveData = MutableLiveData<Event<LaunchDestination>>()

    init {
        launchLiveData.value = Event(LaunchDestination.MAIN_ACTIVITY)
    }
}

enum class LaunchDestination {
    MAIN_ACTIVITY
}
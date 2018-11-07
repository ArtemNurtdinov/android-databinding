package com.nefrit.databinding.ui.operations

import android.content.Context
import com.nefrit.model.Operation

interface OperationClickListener {

    fun onClick(context: Context, operation: Operation)
}
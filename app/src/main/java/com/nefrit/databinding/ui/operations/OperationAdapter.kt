package com.nefrit.databinding.ui.operations

import android.arch.lifecycle.LifecycleOwner
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.nefrit.databinding.databinding.ListItemOperationBinding
import com.nefrit.model.Operation

class OperationAdapter(
    private val lifecycleOwner: LifecycleOwner,
    private val clickListener: OperationClickListener
) : ListAdapter<Operation, OperationViewHolder>(PointDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OperationViewHolder {
        val binding =
            ListItemOperationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OperationViewHolder(binding, clickListener, lifecycleOwner)
    }

    override fun onBindViewHolder(holder: OperationViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class OperationViewHolder(
    private val binding: ListItemOperationBinding,
    private val clickListener: OperationClickListener,
    private val lifecycleOwner: LifecycleOwner
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(operation: Operation) {
        binding.operation = operation
        binding.clickListener = clickListener
        binding.setLifecycleOwner(lifecycleOwner)
        binding.executePendingBindings()
    }
}

object PointDiff : DiffUtil.ItemCallback<Operation>() {
    override fun areItemsTheSame(
        oldItem: Operation,
        newItem: Operation
    ): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Operation, newItem: Operation): Boolean {
        return oldItem == newItem
    }
}
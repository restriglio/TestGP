package com.rest.testgeopagos.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rest.testgeopagos.databinding.PartialInstallmentItemBinding
import com.rest.testgeopagos.model.Installment
import kotlin.reflect.KFunction0

class InstallmentsAdapter(
    private val list: List<Installment.PayerCosts>,
    private val onClickMethod: KFunction0<Unit>
) :
    RecyclerView.Adapter<InstallmentsAdapter.InstallmentsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InstallmentsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PartialInstallmentItemBinding.inflate(inflater)
        return InstallmentsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: InstallmentsViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item, View.OnClickListener {
            onClickMethod()
        })
    }

    class InstallmentsViewHolder(private val binding: PartialInstallmentItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Installment.PayerCosts, listener: View.OnClickListener) {
            with(binding) {
                recommendedMessage.text = item.recommendedMessage
                binding.container.setOnClickListener(listener)
            }
        }
    }
}
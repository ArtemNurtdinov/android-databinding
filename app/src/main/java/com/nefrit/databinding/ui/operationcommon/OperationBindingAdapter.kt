package com.nefrit.databinding.ui.operationcommon

import android.databinding.BindingAdapter
import android.widget.ImageView
import android.widget.TextView
import com.nefrit.databinding.R
import java.text.SimpleDateFormat
import java.util.*

@BindingAdapter("operationValue")
fun operationValue(textView: TextView, value: Double) {
    val rub = value.toLong()
    var balanceRub = Math.abs(rub).toString()
    if (value < 0) {
        balanceRub = "-$balanceRub"
    }

    val kopeck = Math.abs(Math.round((value - rub) * 100)).toInt()

    val currency = Currency.getInstance(Locale.getDefault()).symbol

    val ss: String = if (kopeck == 0) {
        "$balanceRub $currency"
    } else {
        val balanceKop = if (kopeck < 10) "0$kopeck" else kopeck.toString()
        "$balanceRub,$balanceKop $currency"
    }
    textView.text = ss
}

@BindingAdapter("imageId")
fun imageId(imageView: ImageView, imageId: Int) {
    val imageResource = when (imageId) {
        1 -> R.drawable.ic_android
        2 -> R.drawable.ic_apple
        else -> R.drawable.ic_flower
    }
    imageView.setImageResource(imageResource)
}

@BindingAdapter("time")
fun time(textView: TextView, date: Long) {
    val date = Date(date)
    val hourMinutesFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    textView.text = hourMinutesFormat.format(date)
}
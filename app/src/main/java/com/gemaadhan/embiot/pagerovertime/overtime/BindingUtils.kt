package com.gemaadhan.embiot.pagerovertime.overtime

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.gemaadhan.embiot.database.OvertimeEntity


@BindingAdapter("job")
fun TextView.setJob(item: OvertimeEntity?) {
    item?.let {
        text = item?.job
    }
}


@BindingAdapter("starttime")
fun TextView.setstarttime(item: OvertimeEntity?) {
    item?.let {
        text = item.starttime
    }
}


@BindingAdapter("stoptime")
fun TextView.setstoptime(item: OvertimeEntity?) {
    item?.let {
        text = item.stoptime
    }
}

@BindingAdapter("customer")
fun TextView.setcustomer(item: OvertimeEntity?) {
    item?.let {
        text = item.customer
    }
}

@BindingAdapter("pay")
fun TextView.setpay(item: OvertimeEntity?) {
    item?.let {
        text = item.pay.toString()
    }
}

@BindingAdapter("date")
fun TextView.setdate(item: OvertimeEntity?) {
    item?.let {
        text = item.date
    }
}


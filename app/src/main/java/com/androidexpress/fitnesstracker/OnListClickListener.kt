package com.androidexpress.fitnesstracker
import com.androidexpress.fitnesstracker.model.Calc
interface OnListClickListener {
    fun onClick(id: Int, type: String)
    fun onLongClick(position: Int, calc: Calc)
}
package com.tp2021.tp_simple_vending_machine.view.common

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager

class LinearLayoutManagerWrapper : LinearLayoutManager {

    constructor(context: Context) : super(context)

    constructor(context: Context, orientation: Int, reverseLayout: Boolean) : super(context, orientation, reverseLayout)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int, defStyleRes: Int)
            : super(context, attrs, defStyleAttr, defStyleRes)

    override fun supportsPredictiveItemAnimations(): Boolean = false

}


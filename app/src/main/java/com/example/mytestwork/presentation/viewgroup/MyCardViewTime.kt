package com.example.mytestwork.presentation.viewgroup

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mytestwork.R
import com.example.mytestwork.databinding.MyCardViewTimeBinding

class MyCardViewTime @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {
    private var binding: MyCardViewTimeBinding

    init {
        val inflatedView =inflate(context, R.layout.my_card_view_date, this)
        binding = MyCardViewTimeBinding.bind(inflatedView)
    }

    fun setTimeText(signatures: String, time: String) {
        binding.signatures.text = signatures
        binding.title.text = time

    }
}
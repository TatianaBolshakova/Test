package com.example.mytestwork.presentation.viewgroup

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mytestwork.R
import com.example.mytestwork.databinding.MyCardViewBinding

class MyCardView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {
    private var binding: MyCardViewBinding

    init {
        val inflatedView =inflate(context, R.layout.my_card_view, this)
        binding = MyCardViewBinding.bind(inflatedView)
    }

    fun setSignatureText(signatures: String) {
        binding.signatures.text = signatures
    }
    fun setTitleText(title: String) {
        binding.title.text = title
        if (title==""){
            binding.title.visibility = View.GONE
        }
    }
}
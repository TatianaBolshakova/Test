package com.example.mytestwork.presentation.viewgroup

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.mytestwork.R
import com.example.mytestwork.databinding.MyCardViewDateBinding

class MyCardViewDate @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {
    private var binding: MyCardViewDateBinding

    init {
        val inflatedView =inflate(context, R.layout.my_card_view_date, this)
        binding = MyCardViewDateBinding.bind(inflatedView)
    }

    fun setDateText(signatures: String, date: String) {
        binding.signatures.text = signatures
        binding.title.text = date
    }

}
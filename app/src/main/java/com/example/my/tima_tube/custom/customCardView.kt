package com.example.my.tima_tube.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.cardview.widget.CardView
import com.example.my.tima_tube.databinding.CustomCardViewBinding

class CustomCardView(private val context: Context, private val attributeSet: AttributeSet) :
    CardView(context, attributeSet) {

    private val binding = CustomCardViewBinding.inflate(LayoutInflater.from(context), this, false)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width = MeasureSpec.getSize(widthMeasureSpec)
        val height = MeasureSpec.getSize(heightMeasureSpec)
        setMeasuredDimension(width, height)
    }
    fun onCustomButtonClick(onClick: () -> Unit) = with(binding) {
        customButton.setOnClickListener {
            onClick()
        }
    }

    fun changeText(text: String) {
        binding.customTextView.text = text
    }

}
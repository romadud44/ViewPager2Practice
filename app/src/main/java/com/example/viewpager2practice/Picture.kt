package com.example.viewpager2practice

import org.w3c.dom.Text
import java.io.Serializable

class Picture(
    val namePicture: String,
    val infoPicture: String,
    val picture: Int,
    val checkButton: Boolean
) : Serializable {
    companion object {
        val pictures = mutableListOf(
            Picture("Urbank", "Добрый день!", R.drawable.first, true),
            Picture("Urbank", "Urbank - лучший банк!", R.drawable.second, true),
            Picture("Urbank", "Храним активы в активити!", R.drawable.third, true),
            Picture("Urbank", "Приступим!", R.drawable.first, false)
        )
    }
}
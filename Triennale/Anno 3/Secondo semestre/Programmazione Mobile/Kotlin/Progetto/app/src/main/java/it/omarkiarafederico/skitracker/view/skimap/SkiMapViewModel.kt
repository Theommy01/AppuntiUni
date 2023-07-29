package it.omarkiarafederico.skitracker.view.skimap

import androidx.lifecycle.ViewModel
import model.Comprensorio

class SkiMapViewModel: ViewModel() {
    private var selectedFragmentTag = "map"
    private lateinit var skiArea: Comprensorio

    fun getSelectedFragmentTag(): String {
        return this.selectedFragmentTag
    }

    fun updateSelectedFragmentTag(tag: String) {
        this.selectedFragmentTag = tag
    }

    fun setSkiArea(skiArea: Comprensorio) {
        this.skiArea = skiArea
    }

    fun getSkiArea(): Comprensorio {
        return this.skiArea
    }
}
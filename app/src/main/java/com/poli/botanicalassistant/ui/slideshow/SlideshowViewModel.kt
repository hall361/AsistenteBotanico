package com.poli.botanicalassistant.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is tutorials/blogs Fragment"
    }
    val text: LiveData<String> = _text
}

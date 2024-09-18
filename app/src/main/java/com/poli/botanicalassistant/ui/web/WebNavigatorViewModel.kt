package com.poli.botanicalassistant.ui.web

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WebNavigatorViewModel : ViewModel() {

    private val _url = MutableLiveData<String>()
    val url: LiveData<String> get() = _url

    fun processInput(input: String) {
        val resultUrl = generateUrl(input)
        _url.value = resultUrl
    }

    private fun generateUrl(input: String): String {
        return if (input.matches(Regex(REGEX_URL))) {
            formatUrl(input)
        } else {
            "https://www.google.com/search?q=${input.trim().replace(" ", "+")}"
        }
    }

    private fun formatUrl(url: String): String {
        return if (!url.startsWith("http://") && !url.startsWith("https://")) {
            "https://$url"
        } else {
            url
        }
    }

    companion object {
        const val REGEX_URL = "^(https?://)?(www\\.)?[a-zA-Z0-9-]+\\.[a-z]{2,}(/.*)?$"
    }
}

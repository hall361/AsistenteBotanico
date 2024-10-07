package com.poli.botanicalassistant.ui.garden.ui

import android.content.Context

object GardenTextUiUtils {

    private const val LINE_BREAK = "\n"

    fun Context.getProfileTextValue(value: String, resourceId: Int): String {
        return StringBuilder().apply {
            append("${getText(resourceId)}:")
            append(LINE_BREAK)
            append(value)
        }.toString()
    }
}

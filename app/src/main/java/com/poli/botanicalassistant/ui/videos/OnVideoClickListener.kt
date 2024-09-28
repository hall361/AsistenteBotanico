package com.poli.botanicalassistant.ui.videos

import com.poli.botanicalassistant.domain.video.Video

/**
 * Interface to handle video item click events.
 */
interface OnVideoClickListener {
    /**
     * Function to handle the event when a video is clicked.
     *
     * @param video The video that was clicked.
     */
    fun onVideoClick(video: Video)
}

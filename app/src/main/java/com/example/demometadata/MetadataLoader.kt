package com.example.demometadata

import android.graphics.Bitmap
import android.media.MediaMetadataRetriever
import android.util.Log
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.List

object MetadataLoader {

    fun loadMetaData(mUri: String): List<MetaData>? {
        // Retrieve all metadata.
        val metadata = ArrayList<MetaData>()

        if (mUri == null) {
            return metadata
        }

        val metadataRetriever = MediaMetadataRetriever()
        try {
            metadataRetriever.setDataSource(mUri, HashMap())

            for (element in Constants.METADATA_KEYS) {
                val value = metadataRetriever.extractMetadata(element)

                if (value != null) {
                    metadata.add(MetaData(element, value))
                    Log.i(MetadataLoader::class.java.name, "Key: $element Value: $value")
                }
            }

            var b: Bitmap? = metadataRetriever.frameAtTime

            if (b != null) {
                val b2 = metadataRetriever.getFrameAtTime(
                    4000000,
                    MediaMetadataRetriever.OPTION_CLOSEST_SYNC
                )
                if (b2 != null) {
                    b = b2
                }
            }

            if (b != null) {
                metadata.add(MetaData(MediaMetadataRetriever.METADATA_KEY_HAS_IMAGE, b))
                Log.i(MetadataLoader::class.java.name, "Extracted frame")
            } else {
                Log.e(MetadataLoader::class.java.name, "Failed to extract frame")
            }
        } catch (ex: IllegalArgumentException) {
            ex.printStackTrace()
        }
        return metadata
    }
}

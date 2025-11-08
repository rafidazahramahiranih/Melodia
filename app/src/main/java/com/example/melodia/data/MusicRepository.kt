package com.example.melodia.data

import com.example.melodia.model.Music
import com.example.melodia.model.MusicData

class MusicRepository {
    fun getMusic(): List<Music> {
        return MusicData.music
    }

    fun searchMusic(query: String): List<Music> {
        return MusicData.music.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }
}
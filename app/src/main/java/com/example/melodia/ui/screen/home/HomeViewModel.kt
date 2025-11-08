package com.example.melodia.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.melodia.data.MusicRepository
import com.example.melodia.model.Music
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel(private val repository: MusicRepository) : ViewModel() {
    private val _getMusics = MutableStateFlow(
        repository.getMusic()
            .groupBy { it.name[0] }
    )
    val getMusics: StateFlow<Map<Char, List<Music>>> get() = _getMusics

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        _getMusics.value = repository.searchMusic(_query.value)
            .groupBy { it.name[0] }
    }
}
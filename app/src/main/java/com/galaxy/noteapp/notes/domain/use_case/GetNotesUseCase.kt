package com.galaxy.noteapp.notes.domain.use_case

import com.galaxy.noteapp.notes.domain.model.Note
import com.galaxy.noteapp.notes.domain.repository.NoteRepository
import com.galaxy.noteapp.notes.domain.util.NoteOrder
import com.galaxy.noteapp.notes.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase(private val repository: NoteRepository) {

    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<Note>>{
        return repository.getNotes().map {notes->
            when(noteOrder.orderType){
                is OrderType.Ascending ->{
                    when(noteOrder){
                        is NoteOrder.Title -> notes.sortedBy { it.title }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                    }
                }
                is OrderType.Descending -> {
                    when(noteOrder){
                         is NoteOrder.Title -> notes.sortedByDescending { it.title }
                         is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                    }
                }
            }
        }
    }
}
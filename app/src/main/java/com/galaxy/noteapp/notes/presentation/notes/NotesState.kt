package com.galaxy.noteapp.notes.presentation.notes

import com.galaxy.noteapp.notes.domain.model.Note
import com.galaxy.noteapp.notes.domain.util.NoteOrder
import com.galaxy.noteapp.notes.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible : Boolean = false,

    )

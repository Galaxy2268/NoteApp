package com.galaxy.noteapp.notes.presentation.notes

import com.galaxy.noteapp.notes.domain.model.Note
import com.galaxy.noteapp.notes.domain.util.NoteOrder

sealed class NotesEvent {
    data class Order(val noteOrder: NoteOrder): NotesEvent()
    data class DeleteNote(val note: Note): NotesEvent()
    data object RestoreNote: NotesEvent()
    data object ToggleOrderSection: NotesEvent()
}
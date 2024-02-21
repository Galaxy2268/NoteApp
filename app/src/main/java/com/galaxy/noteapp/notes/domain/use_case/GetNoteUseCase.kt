package com.galaxy.noteapp.notes.domain.use_case

import com.galaxy.noteapp.notes.domain.model.Note
import com.galaxy.noteapp.notes.domain.repository.NoteRepository

class GetNoteUseCase(private val repository: NoteRepository) {

    suspend operator fun invoke(id: Int): Note?{
        return repository.getNoteById(id)
    }

}
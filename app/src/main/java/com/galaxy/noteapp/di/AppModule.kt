package com.galaxy.noteapp.di

import android.app.Application
import androidx.room.Room
import com.galaxy.noteapp.notes.data.data_source.NoteDatabase
import com.galaxy.noteapp.notes.data.repository.NoteRepositoryImpl
import com.galaxy.noteapp.notes.domain.repository.NoteRepository
import com.galaxy.noteapp.notes.domain.use_case.AddNoteUseCase
import com.galaxy.noteapp.notes.domain.use_case.DeleteNoteUseCase
import com.galaxy.noteapp.notes.domain.use_case.GetNotesUseCase
import com.galaxy.noteapp.notes.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDataBase(app: Application): NoteDatabase{
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository{
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases{
        return NoteUseCases(
            getNotesUseCase = GetNotesUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository),
            addNoteUseCase = AddNoteUseCase(repository)
        )
    }
}
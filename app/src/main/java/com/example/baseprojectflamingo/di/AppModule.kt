package com.example.baseprojectflamingo.di

import android.content.Context
import com.example.baseprojectflamingo.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = AppDatabase.getDatabase(context)

    @Provides
    fun provideNoteDao(database: AppDatabase) =
        database.noteDao()
}
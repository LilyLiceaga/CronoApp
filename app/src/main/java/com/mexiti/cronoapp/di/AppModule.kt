package com.mexiti.cronoapp.di

import android.content.Context
import androidx.room.Room
import com.mexiti.cronoapp.room.CronosDatabase
import com.mexiti.cronoapp.room.CronosDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providesCronosDao(cronoDataBase : CronosDatabase):CronosDatabaseDao{
        return cronoDataBase.cronosDao()
    }
    @Singleton
    @Provides
    fun providesCronosDatabase(@ApplicationContext context: Context):CronosDatabase{
        return Room.databaseBuilder(
            context= context,
            CronosDatabase::class.java,
            name = "cronos_db"
        ).fallbackToDestructiveMigration()
            .build()
    }

}
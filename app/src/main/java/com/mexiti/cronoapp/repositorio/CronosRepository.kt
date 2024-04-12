package com.mexiti.cronoapp.repositorio

import com.mexiti.cronoapp.model.Cronos
import com.mexiti.cronoapp.room.CronosDatabaseDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CronosRepository @Inject constructor(private val cronoDatabaseDao: CronosDatabaseDao){
    suspend fun addCrono(crono: Cronos) = cronoDatabaseDao.insert(crono)
    suspend fun updateCrono(crono: Cronos) = cronoDatabaseDao.update(crono)
    suspend fun deleteCrono(crono: Cronos) = cronoDatabaseDao.delete(crono)

    fun getAllcronos(): Flow<List<Cronos>> = cronoDatabaseDao
        .getCronos()
        .flowOn(Dispatchers.IO)
        .conflate()
    fun getCronById(id:Long): Flow<Cronos> = cronoDatabaseDao
        .getCronosById(id)
        .flowOn(Dispatchers.IO)
        .conflate()
}
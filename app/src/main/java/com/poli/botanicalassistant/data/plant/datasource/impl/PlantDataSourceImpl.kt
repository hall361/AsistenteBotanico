package com.poli.botanicalassistant.data.plant.datasource.impl

import com.google.firebase.firestore.FirebaseFirestore
import com.poli.botanicalassistant.data.plant.datasource.PlantDataSource
import com.poli.botanicalassistant.data.plant.model.Plant
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await

class PlantDataSourceImpl(
    private val firestore: FirebaseFirestore,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : PlantDataSource {

    override fun getPlants(): Flow<List<Plant>> = flow {
        val plants = firestore.collection(COLLECTION_NAME)
            .get()
            .await()
            .toObjects(Plant::class.java)
        emit(plants)
    }.flowOn(dispatcher)

    companion object {
        private const val COLLECTION_NAME = "plants"
    }
}

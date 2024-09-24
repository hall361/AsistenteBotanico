package com.poli.botanicalassistant.ui.garden

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.poli.botanicalassistant.domain.plant.CareInfo
import com.poli.botanicalassistant.domain.plant.LifeCycle
import com.poli.botanicalassistant.domain.plant.Plant
import com.poli.botanicalassistant.domain.plant.PlantType

class GardenViewModel : ViewModel() {

    private val _plants = MutableLiveData<List<Plant>>()
    val plants: LiveData<List<Plant>> get() = _plants

    fun loadInitialPlants() {
        val initialPlants = listOf(
            Plant(
                id = "1",
                commonName = "Monstera Deliciosa",
                scientificName = "Monstera deliciosa",
                imageUrl = "https://example.com/monstera.jpg",
                classification = PlantType.INDOOR,
                careInfo = CareInfo(
                    waterAmount = "Moderada",
                    light = "Luz indirecta brillante",
                    temperature = "18-27°C",
                    humidity = "60-80%"
                ),
                lifeCycle = LifeCycle(
                    growthSpeed = "Moderada",
                    seasonality = "Perenne"
                ),
                isOwned = true
            ),
            Plant(
                id = "2",
                commonName = "Ficus Lyrata",
                scientificName = "Ficus lyrata",
                imageUrl = "https://example.com/ficus.jpg",
                classification = PlantType.INDOOR,
                careInfo = CareInfo(
                    waterAmount = "Baja",
                    light = "Luz indirecta",
                    temperature = "16-24°C",
                    humidity = "40-60%"
                ),
                lifeCycle = LifeCycle(
                    growthSpeed = "Lenta",
                    seasonality = "Perenne"
                ),
                isOwned = false
            ),
            Plant(
                id = "3",
                commonName = "Sansevieria",
                scientificName = "Sansevieria trifasciata",
                imageUrl = "https://example.com/sansevieria.jpg",
                classification = PlantType.INDOOR,
                careInfo = CareInfo(
                    waterAmount = "Baja",
                    light = "Luz indirecta",
                    temperature = "15-30°C",
                    humidity = "40-60%"
                ),
                lifeCycle = LifeCycle(
                    growthSpeed = "Lenta",
                    seasonality = "Perenne"
                ),
                isOwned = true
            ),
            Plant(
                id = "4",
                commonName = "Aloe Vera",
                scientificName = "Aloe barbadensis",
                imageUrl = "https://example.com/aloe_vera.jpg",
                classification = PlantType.SUCCULENT,
                careInfo = CareInfo(
                    waterAmount = "Baja",
                    light = "Luz directa",
                    temperature = "13-27°C",
                    humidity = "40-50%"
                ),
                lifeCycle = LifeCycle(
                    growthSpeed = "Rápida",
                    seasonality = "Perenne"
                ),
                isOwned = false
            ),
            Plant(
                id = "5",
                commonName = "Cactus Echinopsis",
                scientificName = "Echinopsis",
                imageUrl = "https://example.com/cactus.jpg",
                classification = PlantType.SUCCULENT,
                careInfo = CareInfo(
                    waterAmount = "Muy baja",
                    light = "Luz directa",
                    temperature = "10-30°C",
                    humidity = "20-40%"
                ),
                lifeCycle = LifeCycle(
                    growthSpeed = "Lenta",
                    seasonality = "Perenne"
                ),
                isOwned = false
            ),
            Plant(
                id = "6",
                commonName = "Lavanda",
                scientificName = "Lavandula",
                imageUrl = "https://example.com/lavanda.jpg",
                classification = PlantType.OUTDOOR,
                careInfo = CareInfo(
                    waterAmount = "Moderada",
                    light = "Luz directa",
                    temperature = "15-25°C",
                    humidity = "40-60%"
                ),
                lifeCycle = LifeCycle(
                    growthSpeed = "Moderada",
                    seasonality = "Estacional"
                ),
                isOwned = false
            ),
            Plant(
                id = "7",
                commonName = "Helecho",
                scientificName = "Nephrolepis exaltata",
                imageUrl = "https://example.com/helecho.jpg",
                classification = PlantType.INDOOR,
                careInfo = CareInfo(
                    waterAmount = "Alta",
                    light = "Luz indirecta",
                    temperature = "18-24°C",
                    humidity = "60-80%"
                ),
                lifeCycle = LifeCycle(
                    growthSpeed = "Rápida",
                    seasonality = "Perenne"
                ),
                isOwned = true
            ),
            Plant(
                id = "8",
                commonName = "Orquídea",
                scientificName = "Phalaenopsis",
                imageUrl = "https://example.com/orquidea.jpg",
                classification = PlantType.INDOOR,
                careInfo = CareInfo(
                    waterAmount = "Moderada",
                    light = "Luz indirecta",
                    temperature = "18-30°C",
                    humidity = "50-70%"
                ),
                lifeCycle = LifeCycle(
                    growthSpeed = "Lenta",
                    seasonality = "Estacional"
                ),
                isOwned = true
            ),
            Plant(
                id = "9",
                commonName = "Suculenta",
                scientificName = "Sedum morganianum",
                imageUrl = "https://example.com/suculenta.jpg",
                classification = PlantType.SUCCULENT,
                careInfo = CareInfo(
                    waterAmount = "Baja",
                    light = "Luz directa",
                    temperature = "10-30°C",
                    humidity = "20-40%"
                ),
                lifeCycle = LifeCycle(
                    growthSpeed = "Lenta",
                    seasonality = "Perenne"
                ),
                isOwned = false
            ),
            Plant(
                id = "10",
                commonName = "Lavanda",
                scientificName = "Lavandula angustifolia",
                imageUrl = "https://example.com/lavanda.jpg",
                classification = PlantType.OUTDOOR,
                careInfo = CareInfo(
                    waterAmount = "Moderada",
                    light = "Luz directa",
                    temperature = "15-25°C",
                    humidity = "40-60%"
                ),
                lifeCycle = LifeCycle(
                    growthSpeed = "Moderada",
                    seasonality = "Estacional"
                ),
                isOwned = true
            )
        )

        _plants.value = initialPlants
    }
}

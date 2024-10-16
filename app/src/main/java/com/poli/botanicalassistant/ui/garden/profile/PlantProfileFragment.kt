package com.poli.botanicalassistant.ui.garden.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.poli.botanicalassistant.databinding.FragmentPlantProfileBinding
import org.koin.android.ext.android.inject

class PlantProfileFragment : Fragment() {

    private var _binding: FragmentPlantProfileBinding? = null
    private val binding get() = _binding!!
    private val plantProfileAdapter: PlantProfileAdapter by inject()
    private val args: PlantProfileFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlantProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupList()
    }

    private fun setupRecyclerView() {
        binding.plantProfileRecyclerView.apply {
            adapter = plantProfileAdapter
        }
    }

    private fun setupList() {
        val list = listOf(
            getBasicInfo(),
            getLifeCycleInfo(),
            getCareInfo(),
        )
        plantProfileAdapter.submitList(list)
    }

    private fun getBasicInfo() = with(args.plant) {
        PlantProfileUi.BasicInfo(
            imageUrl = imageUrl,
            commonName = commonName,
            scientificName = scientificName,
            classification = classification
        )
    }

    private fun getLifeCycleInfo() = with(args.plant.lifeCycle) {
        PlantProfileUi.LifeCycleInfo(
            growthSpeed = growthSpeed,
            seasonality = seasonality
        )
    }

    private fun getCareInfo() = with(args.plant.careInfo) {
        PlantProfileUi.CareInfo(
            waterAmount = waterAmount,
            light = light,
            humidity = humidity,
            temperature = temperature
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

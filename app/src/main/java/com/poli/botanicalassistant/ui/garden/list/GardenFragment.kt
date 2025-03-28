package com.poli.botanicalassistant.ui.garden.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.poli.botanicalassistant.databinding.FragmentGardenBinding
import com.poli.botanicalassistant.ui.garden.model.PlantUi
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class GardenFragment : Fragment(), OnPlantClickListener {

    private var _binding: FragmentGardenBinding? = null
    private val binding get() = _binding!!
    private val gardenViewModel: GardenViewModel by viewModel()
    private val gardenAdapter: GardenAdapter by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGardenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        observePlants()
        configSwipeRefreshLayout()

        gardenViewModel.loadPlants()
    }

    private fun setupRecyclerView() {
        gardenAdapter.setListener(this)
        binding.recyclerView.apply {
            adapter = gardenAdapter
        }
    }

    private fun configSwipeRefreshLayout() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            gardenViewModel.loadPlants()
        }
    }

    private fun observePlants() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                gardenViewModel.gardenUiState.collect { gardenUiState ->
                    when (gardenUiState) {
                        is GardenUiState.Loading -> binding.swipeRefreshLayout.isRefreshing = true
                        is GardenUiState.Success -> updatePlants(gardenUiState.plants)
                    }
                }
            }
        }
    }

    private fun updatePlants(plants: List<PlantUi>) {
        gardenAdapter.submitList(plants)
        binding.swipeRefreshLayout.isRefreshing = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onPlantClick(plant: PlantUi) {
        val action = GardenFragmentDirections.actionNavGardenToPlantProfileFragment(plant)
        findNavController().navigate(action)
    }
}

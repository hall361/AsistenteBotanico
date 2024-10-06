package com.poli.botanicalassistant.ui.garden.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.poli.botanicalassistant.databinding.FragmentGardenBinding
import com.poli.botanicalassistant.ui.garden.model.PlantUi
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class GardenFragment : Fragment(), OnPlantClickListener {

    private var _binding: FragmentGardenBinding? = null
    private val binding get() = _binding!!
    private val gardenViewModel: GardenViewModel by viewModel()
    private val plantAdapter by lazy { PlantAdapter(this) }

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
        binding.recyclerView.apply {
            adapter = plantAdapter
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
        plantAdapter.submitList(plants)
        binding.swipeRefreshLayout.isRefreshing = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onPlantClick(plant: PlantUi) {
        Toast.makeText(requireContext(), "Clicked: ${plant.commonName}", Toast.LENGTH_SHORT).show()
    }
}

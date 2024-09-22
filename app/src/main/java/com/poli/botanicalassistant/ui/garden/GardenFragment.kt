package com.poli.botanicalassistant.ui.garden

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.poli.botanicalassistant.databinding.FragmentGardenBinding
import com.poli.botanicalassistant.domain.plant.Plant

class GardenFragment : Fragment(), OnPlantClickListener {

    private var _binding: FragmentGardenBinding? = null
    private val binding get() = _binding!!
    private var _gardenViewModel: GardenViewModel? = null
    private val gardenViewModel get() = _gardenViewModel!!
    private val plantAdapter by lazy {
        PlantAdapter(this)
    }

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
        _gardenViewModel = ViewModelProvider(this).get(GardenViewModel::class.java)

        setupRecyclerView()
        observePlants()
        configSwipeRefreshLayout()
        gardenViewModel.loadInitialPlants()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            adapter = plantAdapter
        }
    }

    private fun configSwipeRefreshLayout() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            gardenViewModel.loadInitialPlants()
        }
    }

    private fun observePlants() {
        gardenViewModel.plants.observe(viewLifecycleOwner) { plants ->
            plants?.let {
                plantAdapter.submitList(it)
                binding.swipeRefreshLayout.isRefreshing = false
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onPlantClick(plant: Plant) {
        Toast.makeText(requireContext(), "Clicked: ${plant.commonName}", Toast.LENGTH_SHORT).show()
    }
}

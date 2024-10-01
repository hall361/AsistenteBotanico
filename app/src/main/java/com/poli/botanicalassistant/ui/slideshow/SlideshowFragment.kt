package com.poli.botanicalassistant.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.poli.botanicalassistant.R
import com.poli.botanicalassistant.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // Esta propiedad es solo válida entre onCreateView y onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Obtiene el ViewModel asociado al Fragmento
        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        // Inflar el layout usando View Binding
        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Configurar el TextView para mostrar el texto del ViewModel
        val textView: TextView = binding.textSlideshow
        slideshowViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        // Configurar el botón para navegar a VideosFragment
        val buttonToVideos: Button = binding.buttonToVideos // Asegúrate de que este ID coincida con el de tu XML
        buttonToVideos.setOnClickListener {
            findNavController().navigate(R.id.videosFragment) // Navega al fragmento de videos
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null // Limpia la referencia al binding
    }
}

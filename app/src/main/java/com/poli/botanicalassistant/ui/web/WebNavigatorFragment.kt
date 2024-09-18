package com.poli.botanicalassistant.ui.web

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.poli.botanicalassistant.databinding.FragmentWebNavigatorBinding

class WebNavigatorFragment : Fragment() {

    private var _binding: FragmentWebNavigatorBinding? = null
    private val binding get() = _binding!!
    private val viewModel: WebNavigatorViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWebNavigatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.url.observe(viewLifecycleOwner) {
            loadUrlInWebView(it)
        }

        binding.buttonLoadUrl.setOnClickListener {
            val input = binding.editTextUrl.text.toString()
            if (input.isNotEmpty()) {
                viewModel.processInput(input)
            } else {
                Toast.makeText(requireContext(), "Please enter a valid URL", Toast.LENGTH_SHORT).show()
            }
        }

        binding.webview.apply {
            settings.javaScriptEnabled = true
            this.webViewClient = WebViewClient()
        }
    }

    private fun loadUrlInWebView(url: String) {
        binding.webview.loadUrl(url)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

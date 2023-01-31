package com.codelab.compose.playground

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.codelab.compose.databinding.FragmentComposeViewDemoBinding
import com.codelab.compose.databinding.FragmentViewSystemDemoBinding

class ViewSystemDemo : Fragment() {

    private var binding: FragmentViewSystemDemoBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentViewSystemDemoBinding.inflate(inflater, container, false).also { it ->
            binding = it
        }.root
    }
}
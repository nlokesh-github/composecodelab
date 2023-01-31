package com.codelab.compose.playground

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.codelab.compose.R
import com.codelab.compose.databinding.FragmentComposeViewDemoBinding

class ComposeViewDemo : Fragment() {

    private var binding: FragmentComposeViewDemoBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentComposeViewDemoBinding.inflate(inflater, container, false).also { it ->
            binding = it
            binding?.composeView?.setContent {

                val context = LocalContext.current
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        modifier = Modifier
                            .wrapContentWidth()
                            .padding(0.dp, 0.dp, 20.dp, 0.dp)
                            .onFocusChanged {
                                Log.d(
                                    "InterOp",
                                    " Text hasFocus ${it.hasFocus}, isFocused ${it.isFocused}"
                                )
                                if (it.isFocused) {
                                    Toast.makeText(
                                        context,
                                        "Sample Text focused",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                            .clickable {
                                Toast.makeText(context, "Sample Text Clicked", Toast.LENGTH_SHORT).show()
                            },
                        text = "Sample Text"
                    )

                    Button(
                        modifier = Modifier
                            .onFocusChanged {
                                Log.d(
                                    "InterOp",
                                    "Button hasFocus ${it.hasFocus}, isFocused ${it.isFocused}"
                                )
                                if (it.isFocused) {
                                    Toast.makeText(
                                        context,
                                        "Compose Button is focused",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            }
                            .clickable {  },
                        onClick = {
                            Toast.makeText(context, "Compose Button Clicked", Toast.LENGTH_SHORT).show()
                        }) {
                        Text(
                            modifier = Modifier
                                .wrapContentWidth(),
                            text = "Compose Button"
                        )
                    }
                }
            }
        }.root
    }

}
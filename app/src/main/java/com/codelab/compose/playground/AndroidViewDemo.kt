package com.codelab.compose.playground

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton

class AndroidViewDemo : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            // Dispose of the Composition when the view's LifecycleOwner
            // is destroyed
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                KeyboardNavigationDemo()
            }
        }
    }
}

@Composable
private fun KeyboardNavigationDemo() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(PaddingValues(start = 16.dp)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        val context = LocalContext.current
        AndroidView(
            modifier = Modifier
                .onFocusChanged {
                    if (it.isFocused) {
                        Toast
                            .makeText(
                                context,
                                "View Button focused",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
                }
                .focusable(),
            factory = {
                MaterialButton(it)
            },
            update = {
                it.text = "View Button"
                it.isAllCaps = false
                it.setOnClickListener { view ->
                    Toast.makeText(view.context, "View Button Clicked", Toast.LENGTH_SHORT).show()
                }
            }
        )

        Text(
            modifier = Modifier
                .wrapContentWidth()
                .onFocusChanged {
                    if (it.isFocused) {
                        Toast
                            .makeText(
                                context,
                                "Compose Text focused",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
                }
                .clickable {  },
            text = "Compose Text",
        )

        Button(
            modifier = Modifier
                .onFocusChanged {
                    if (it.hasFocus && it.isFocused) {
                        Toast
                            .makeText(
                                context,
                                "Compose Button focused",
                                Toast.LENGTH_SHORT
                            )
                            .show()
                    }
                }
                .clickable {  },
            onClick = {
                Toast.makeText(context, "Compose Button Clicked", Toast.LENGTH_SHORT).show()
            }) {
            Text(
                modifier = Modifier
                    .wrapContentSize()
                    .onFocusChanged {
                        if (it.isFocused) {
                            Toast
                                .makeText(
                                    context,
                                    "Text inside Compose Button focused",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        }
                    }
                    .clickable {  },
                text = "Compose Button"
            )
        }

    }
}
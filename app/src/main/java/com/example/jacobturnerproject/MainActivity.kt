package com.example.jacobturnerproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jacobturnerproject.ui.theme.JacobTurnerProjectTheme
import androidx.compose.foundation.background
import androidx.compose.material3.Surface


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            JacobTurnerProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xADD8E6) // Set background color here
                ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xADD8E6))  // Light blue background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                            .background(Color(0x2C2C2C)),  // Light gray background
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        // State to manage the current image
                        val currentImage = remember { mutableStateOf(R.drawable.giraffe) }

                        // Crossfade for smooth image transition
                        Crossfade(targetState = currentImage.value) { imageResource ->
                            val image: Painter = painterResource(id = imageResource)
                            Image(
                                painter = image,
                                contentDescription = "Current Image",
                                modifier = Modifier.size(200.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(20.dp)) // Space between image and buttons

                        // Row to display the buttons side by side
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            // Button 1 - Giraffe
                            Button(
                                onClick = { currentImage.value = R.drawable.giraffe },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(
                                        0xFFADD8E6
                                    ), contentColor = Color.White
                                ) // Light Blue button
                            ) {
                                Text(text = "Button 1")
                            }

                            Spacer(modifier = Modifier.width(16.dp)) // Space between buttons

                            // Button 2 - Thing
                            Button(
                                onClick = { currentImage.value = R.drawable.thing },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(
                                        0xFFFFDAB9
                                    ), contentColor = Color.White
                                ) // Peach button
                            ) {
                                Text(text = "Button 2")
                            }

                            Spacer(modifier = Modifier.width(16.dp)) // Space between buttons

                            // Button 3 - Sloth
                            Button(
                                onClick = { currentImage.value = R.drawable.sloth },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(
                                        0xFF98FF98
                                    ), contentColor = Color.White
                                ) // Mint Green button
                            ) {
                                Text(text = "Button 3")
                            }
                        }
                    }
                }
            }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JacobTurnerProjectTheme {
        MainActivity()
    }
}

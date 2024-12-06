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
                ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()

                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp),
                        verticalArrangement = Arrangement.Center, //vertical arr. and horizontal arr. are here to help us get the buttons centered.
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        //create a varibale to hold the current image.
                        val currentImage = remember { mutableStateOf(R.drawable.giraffe) }

                        //this will handle the smooth transitions from picture to picture
                        Crossfade(targetState = currentImage.value) { imageResource ->
                            val image: Painter = painterResource(id = imageResource)
                            Image(
                                painter = image,
                                contentDescription = "Current Image",
                                modifier = Modifier.size(200.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(20.dp)) //space between image and buttons

                        //estabolish a row so that everything inside of it will be in the same line.
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            //define button 1
                            Button(
                                onClick = { currentImage.value = R.drawable.giraffe },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(
                                        0xFFADD8E6
                                    ), contentColor = Color.White
                                )
                            ) {
                                Text(text = "Button 1")
                            }

                            Spacer(modifier = Modifier.width(16.dp)) // Space between buttons

                            // define button 2
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

                            //define button 3
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

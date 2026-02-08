package com.example.fase1.fase1

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.fase1.ui.viewmodel.ContactViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LoginScreen(navController: NavController) {
    // Obtener ViewModel con Hilt
    val viewModel: ContactViewModel = hiltViewModel()

    val isLoading = viewModel.isLoading.value
    val contacts = viewModel.contacts.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Login", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar indicador de carga mientras se importa la API
        if (isLoading) {
            CircularProgressIndicator()
        } else {

            var text4 by remember {
                mutableStateOf("") }
            OutlinedTextField(
                modifier =
                    Modifier.padding(16.dp),
                label = {Text("Usuario: ")},
                        value = text4,
                    onValueChange = { newValue:
                                      String -> text4 = newValue},
                    singleLine = true
                )

            var text5 by remember {
                mutableStateOf("") }
            OutlinedTextField(
                modifier =
                    Modifier.padding(16.dp),
                label = {Text("Password")},
                value = text5,
                onValueChange = { newValue:
                                  String -> text5 = newValue},
                singleLine = true,
                visualTransformation =
                    PasswordVisualTransformation()
            )

                            Button(onClick = {

                viewModel.importContacts()
                navController.navigate("home")
            }) {
                Text("Login")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Opcional: mostrar contactos cargados
        contacts.forEach { contact ->
            Text(contact)
        }
    }
}



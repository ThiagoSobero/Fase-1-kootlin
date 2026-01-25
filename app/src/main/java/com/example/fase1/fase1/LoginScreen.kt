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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
            Button(onClick = {
                // Por ejemplo, puedes llamar a importar contactos al login
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



package com.sulbaranjc.holamundo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sulbaranjc.holamundo.ui.theme.HolamundoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HolamundoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // LocalContext da acceso al Context de Android desde un composable.
                    // Lo necesitamos para mostrar un Toast (un mensaje breve flotante).
                    val context = LocalContext.current
                    val mensaje = stringResource(R.string.mensaje_boton)

                    PantallaPrincipal(
                        name = "Android",
                        onSaludarClick = {
                            Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show()
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

/**
 * Lección 2: organizar elementos en pantalla y reaccionar a un botón.
 *
 * - Column apila sus hijos de arriba a abajo.
 * - verticalArrangement / horizontalAlignment los centran en la pantalla.
 * - Spacer deja un hueco fijo entre el texto y el botón.
 * - onSaludarClick es una función (lambda) que recibe la pantalla: el composable
 *   no decide qué pasa al pulsar, solo avisa. Así es fácil de reutilizar y de testear.
 */
@Composable
fun PantallaPrincipal(
    name: String,
    onSaludarClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Greeting(name = name)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = onSaludarClick) {
            Text(text = stringResource(R.string.boton_saludar))
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.greeting, name),
        style = MaterialTheme.typography.headlineMedium,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun PantallaPrincipalPreview() {
    HolamundoTheme {
        PantallaPrincipal(name = "Juan Carlos", onSaludarClick = {})
    }
}

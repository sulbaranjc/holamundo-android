package com.sulbaranjc.holamundo

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sulbaranjc.holamundo.ui.theme.HolamundoTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Test de UI: pinta el composable Greeting y comprueba que el saludo se ve en pantalla.
 */
@RunWith(AndroidJUnit4::class)
class GreetingTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun greeting_muestraElNombre() {
        composeTestRule.setContent {
            HolamundoTheme {
                Greeting(name = "Android")
            }
        }

        composeTestRule.onNodeWithText("¡Hola, Android!").assertIsDisplayed()
    }
}

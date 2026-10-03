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
 * Test de UI de la lección 2: el saludo se muestra en pantalla.
 */
@RunWith(AndroidJUnit4::class)
class PantallaPrincipalTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun saludo_seMuestra() {
        composeTestRule.setContent {
            HolamundoTheme {
                PantallaPrincipal(name = "Android")
            }
        }

        composeTestRule.onNodeWithText("¡Hola, Android!").assertIsDisplayed()
    }
}

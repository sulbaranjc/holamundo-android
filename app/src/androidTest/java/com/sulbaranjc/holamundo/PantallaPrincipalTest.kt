package com.sulbaranjc.holamundo

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.sulbaranjc.holamundo.ui.theme.HolamundoTheme
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Test de UI de la lección 2: el botón se ve y al pulsarlo llama a onSaludarClick.
 */
@RunWith(AndroidJUnit4::class)
class PantallaPrincipalTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun boton_alPulsar_llamaAOnSaludarClick() {
        var pulsaciones = 0

        composeTestRule.setContent {
            HolamundoTheme {
                PantallaPrincipal(name = "Android", onSaludarClick = { pulsaciones++ })
            }
        }

        composeTestRule.onNodeWithText("¡Hola, Android!").assertIsDisplayed()
        composeTestRule.onNodeWithText("Saludar").assertIsDisplayed().performClick()

        assertEquals(1, pulsaciones)
    }
}

package br.univali.ecobairro

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test
import java.time.LocalDate

class EcoBairroAppTest {
    @get:Rule val rule = createComposeRule()

    private val guias = listOf(
        WasteGuide("Papel", "Mantenha seco e limpo."),
        WasteGuide("Vidro", "Enxágue e embale cacos com cuidado.")
    )

    private val pontoVerificado = DeliveryPoint(
        name = "Ecoponto Central",
        address = "Rua das Flores, 100",
        materials = setOf("Vidro", "Papel"),
        source = "Prefeitura (site oficial)",
        verifiedAt = LocalDate.of(2026, 11, 20)
    )

    private fun abrirApp(pontos: List<DeliveryPoint> = emptyList()) = rule.setContent {
        MaterialTheme {
            EcoBairroApp(
                guideService = GuideService(guias),
                scheduleService = ScheduleService(emptyList()),
                pointService = PointService(pontos)
            )
        }
    }

    @Test fun guia_buscaPorVidro() {
        abrirApp()
        rule.onNodeWithText("Guia de separação").performClick()
        rule.onNodeWithTag("busca").performTextInput("vidro")
        rule.onNodeWithTag("conteudo").assertTextContains("Vidro", substring = true)
    }

    @Test fun pontos_mostramAvisoQuandoNaoHaDados() {
        abrirApp()
        rule.onNodeWithText("Pontos de entrega").performClick()
        rule.onNodeWithTag("conteudo").assertTextContains("Nenhum ponto", substring = true)
    }

    @Test fun calendario_avisaQuandoNaoHaDadoConfirmado() {
        abrirApp()
        rule.onNodeWithText("Calendário de coleta").performClick()
        rule.onNodeWithTag("conteudo").assertTextContains("não confirmada", substring = true)
    }

    @Test fun pontos_listaPontoVerificado() {
        abrirApp(listOf(pontoVerificado))
        rule.onNodeWithText("Pontos de entrega").performClick()
        rule.onNodeWithTag("conteudo").assertTextContains("Ecoponto Central", substring = true)
    }

    @Test fun pontos_buscaPorMaterial() {
        abrirApp(listOf(pontoVerificado))
        rule.onNodeWithText("Pontos de entrega").performClick()
        rule.onNodeWithTag("busca").performTextInput("pilha")
        rule.onNodeWithTag("conteudo").assertTextContains("Nenhum ponto encontrado", substring = true)
    }
}

package br.univali.ecobairro

import org.junit.Assert.*
import org.junit.Test

class GuideServiceTest {
    private val guias = listOf(
        WasteGuide("Papel", "Mantenha seco e limpo."),
        WasteGuide("Vidro", "Enxágue e embale cacos com cuidado.")
    )

    @Test fun buscaVazia_retornaTodos() = assertEquals(2, GuideService(guias).search("  ").size)

    @Test fun busca_ignoraMaiusculas() =
        assertEquals("Vidro", GuideService(guias).search("vIdRo").single().category)

    @Test fun buscaSemResultado_retornaListaVazia() =
        assertTrue(GuideService(guias).search("pilha").isEmpty())
}

package br.univali.ecobairro

import org.junit.Assert.*
import org.junit.Test
import java.time.LocalDate

class PointServiceTest {
    private val verificado = DeliveryPoint(
        name = "Ecoponto Central",
        address = "Rua das Flores, 100",
        materials = setOf("Vidro", "Papel"),
        source = "Prefeitura (site oficial)",
        verifiedAt = LocalDate.of(2026, 11, 20)
    )

    @Test fun pontoSemFonte_naoEPublicavel() =
        assertFalse(DataValidator.isPointPublishable(verificado.copy(source = "")))

    @Test fun pontoSemDataDeVerificacao_naoEPublicavel() =
        assertFalse(DataValidator.isPointPublishable(verificado.copy(verifiedAt = null)))

    @Test fun pontoSemEndereco_naoEPublicavel() =
        assertFalse(DataValidator.isPointPublishable(verificado.copy(address = "  ")))

    @Test fun pontoSemMateriais_naoEPublicavel() =
        assertFalse(DataValidator.isPointPublishable(verificado.copy(materials = emptySet())))

    @Test fun pontoCompleto_ePublicavel() =
        assertTrue(DataValidator.isPointPublishable(verificado))

    @Test fun publishable_retornaSomentePontosVerificados() {
        val naoVerificado = verificado.copy(name = "Ponto sem fonte", source = "")
        val service = PointService(listOf(verificado, naoVerificado))
        assertEquals(listOf(verificado), service.publishable())
    }
}

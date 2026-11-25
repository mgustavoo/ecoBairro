package br.univali.ecobairro

import org.junit.Assert.*
import org.junit.Test
import java.time.DayOfWeek
import java.time.LocalDate

class ScheduleServiceTest {
    private val verificado = CollectionSchedule(
        "Região piloto", "Coleta comum",
        setOf(DayOfWeek.MONDAY, DayOfWeek.THURSDAY), "07:00",
        "Prefeitura (site oficial)", LocalDate.of(2026, 11, 1)
    )

    @Test fun semFonte_naoEPublicavel() {
        assertFalse(DataValidator.isPublishable(verificado.copy(source = "")))
    }

    @Test fun semDataDeVerificacao_naoEPublicavel() {
        assertFalse(DataValidator.isPublishable(verificado.copy(verifiedAt = null)))
    }

    @Test fun semDias_naoEPublicavel() {
        assertFalse(DataValidator.isPublishable(verificado.copy(days = emptySet())))
    }

    @Test fun proximaColeta_mesmoDiaSeHojeForDiaDeColeta() {
        val s = ScheduleService(listOf(verificado))
        assertEquals(LocalDate.of(2026, 11, 9), s.nextCollection("Coleta comum", LocalDate.of(2026, 11, 9)))
    }

    @Test fun proximaColeta_proximoDiaDaSemana() {
        val s = ScheduleService(listOf(verificado))
        // 10/11/2026 é terça-feira, a próxima coleta é quinta (12/11)
        assertEquals(LocalDate.of(2026, 11, 12), s.nextCollection("Coleta comum", LocalDate.of(2026, 11, 10)))
    }

    @Test fun proximaColeta_nuloSeNaoHouverDadoConfirmado() {
        val s = ScheduleService(listOf(verificado.copy(verifiedAt = null)))
        assertNull(s.nextCollection("Coleta comum", LocalDate.of(2026, 11, 10)))
    }
}

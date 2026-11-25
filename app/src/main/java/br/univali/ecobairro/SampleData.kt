package br.univali.ecobairro

import java.time.DayOfWeek
import java.time.LocalDate

object SampleData {
    val guides = listOf(
        WasteGuide("Papel", "Mantenha seco e limpo. Retire fitas e grampos quando possível."),
        WasteGuide("Plástico", "Esvazie e enxágue embalagens antes de descartar."),
        WasteGuide("Vidro", "Enxágue e embale cacos de forma segura."),
        WasteGuide("Metal", "Esvazie e enxágue latas. Amasse se possível."),
        WasteGuide("Óleo de cozinha", "Guarde em garrafa PET fechada e leve a um ponto de entrega.")
    )

    // Dados oficiais da região piloto: Itajaí - SC
    val schedules = listOf(
        CollectionSchedule(
            region = "Centro - Itajaí",
            type = "Coleta Seletiva (Recicláveis)",
            days = setOf(DayOfWeek.TUESDAY, DayOfWeek.FRIDAY),
            time = "08:00",
            source = "Prefeitura de Itajaí / Ambiental (site oficial)",
            verifiedAt = LocalDate.of(2026, 2, 25)
        ),
        CollectionSchedule(
            region = "Centro - Itajaí",
            type = "Coleta Comum (Orgânicos)",
            days = setOf(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY),
            time = "07:00",
            source = "Prefeitura de Itajaí / Ambiental (site oficial)",
            verifiedAt = LocalDate.of(2026, 2, 25)
        )
    )

    // Pontos de entrega voluntária (PEVs) verificados da região de Itajaí - SC
    val points = listOf(
        DeliveryPoint(
            name = "PEV Central Itajaí",
            address = "Rua Silva, 300 - Centro, Itajaí - SC",
            materials = setOf("Vidro", "Papel", "Plástico", "Metal", "Óleo de cozinha"),
            source = "Prefeitura de Itajaí (INIS - Instituto Nacional de Meio Ambiente)",
            verifiedAt = LocalDate.of(2026, 2, 25)
        ),
        DeliveryPoint(
            name = "Ecoponto Itaipava",
            address = "Av. Teotônio Vilela, 100 - Itaipava, Itajaí - SC",
            materials = setOf("Vidro", "Papel", "Plástico", "Metal"),
            source = "Prefeitura de Itajaí (Site Oficial)",
            verifiedAt = LocalDate.of(2026, 2, 25)
        )
    )
}

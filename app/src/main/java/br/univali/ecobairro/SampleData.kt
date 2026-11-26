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

    val schedules = listOf(
        CollectionSchedule(
            region = "Centro - Itajaí",
            type = "Coleta Seletiva (Recicláveis)",
            days = setOf(DayOfWeek.TUESDAY, DayOfWeek.FRIDAY),
            time = "08:00",
            source = "Dado fictício de demonstração",
            verifiedAt = LocalDate.of(2026, 11, 25)
        ),
        CollectionSchedule(
            region = "Centro - Itajaí",
            type = "Coleta Comum (Orgânicos)",
            days = setOf(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY),
            time = "07:00",
            source = "Dado fictício de demonstração",
            verifiedAt = LocalDate.of(2026, 11, 25)
        )
    )

    val points = listOf(
        DeliveryPoint(
            name = "PEV Central Itajaí",
            address = "Rua Silva, 300 - Centro, Itajaí - SC",
            materials = setOf("Vidro", "Papel", "Plástico", "Metal", "Óleo de cozinha"),
            source = "Dado fictício de demonstração",
            verifiedAt = LocalDate.of(2026, 11, 25)
        ),
        DeliveryPoint(
            name = "Ecoponto Itaipava",
            address = "Av. Teotônio Vilela, 100 - Itaipava, Itajaí - SC",
            materials = setOf("Vidro", "Papel", "Plástico", "Metal"),
            source = "Dado fictício de demonstração",
            verifiedAt = LocalDate.of(2026, 11, 25)
        )
    )
}

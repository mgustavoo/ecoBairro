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

    // ATENÇÃO: trocar pelos dados OFICIAIS da região piloto.
    // Enquanto a fonte estiver vazia e a data for null, o app mostra "não confirmado".
    // Exemplo preenchido:
    //   "Site da Prefeitura", LocalDate.of(2026, 11, 10)
    val schedules = listOf(
        CollectionSchedule(
            "Região piloto", "Coleta comum",
            setOf(DayOfWeek.MONDAY, DayOfWeek.THURSDAY), "07:00",
            "", null
        )
    )
}

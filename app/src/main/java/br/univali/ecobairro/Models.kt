package br.univali.ecobairro

import java.time.DayOfWeek
import java.time.LocalDate

data class WasteGuide(val category: String, val instructions: String)

data class CollectionSchedule(
    val region: String,
    val type: String,
    val days: Set<DayOfWeek>,
    val time: String,
    val source: String,
    val verifiedAt: LocalDate?
)

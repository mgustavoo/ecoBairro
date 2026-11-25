package br.univali.ecobairro

import java.time.LocalDate

class ScheduleService(private val schedules: List<CollectionSchedule>) {
    fun publishable() = schedules.filter(DataValidator::isPublishable)

    fun nextCollection(type: String, from: LocalDate): LocalDate? {
        val s = publishable().firstOrNull { it.type == type } ?: return null
        return (0..6).map { from.plusDays(it.toLong()) }.firstOrNull { it.dayOfWeek in s.days }
    }
}

package br.univali.ecobairro

object DataValidator {
    fun isPublishable(s: CollectionSchedule) =
        s.source.isNotBlank() && s.verifiedAt != null && s.days.isNotEmpty()
}

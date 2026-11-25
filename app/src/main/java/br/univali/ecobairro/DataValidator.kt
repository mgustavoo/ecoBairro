package br.univali.ecobairro

object DataValidator {
    fun isPublishable(s: CollectionSchedule) =
        s.source.isNotBlank() && s.verifiedAt != null && s.days.isNotEmpty()

    fun isPointPublishable(p: DeliveryPoint) =
        p.name.isNotBlank() && p.address.isNotBlank() && p.materials.isNotEmpty() &&
            p.source.isNotBlank() && p.verifiedAt != null
}

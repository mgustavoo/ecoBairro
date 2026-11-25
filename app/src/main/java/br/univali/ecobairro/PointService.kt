package br.univali.ecobairro

class PointService(private val points: List<DeliveryPoint>) {
    fun publishable() = points.filter(DataValidator::isPointPublishable)

    fun byMaterial(material: String): List<DeliveryPoint> {
        val m = material.trim()
        val base = publishable()
        return if (m.isEmpty()) base
        else base.filter { p -> p.materials.any { it.contains(m, ignoreCase = true) } }
    }
}

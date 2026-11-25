package br.univali.ecobairro

class PointService(private val points: List<DeliveryPoint>) {
    fun publishable() = points.filter(DataValidator::isPointPublishable)
}

package br.univali.ecobairro

class GuideService(private val guides: List<WasteGuide>) {
    fun search(query: String): List<WasteGuide> {
        val q = query.trim()
        return if (q.isEmpty()) guides else guides.filter { it.category.contains(q, ignoreCase = true) }
    }
}

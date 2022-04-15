package shapes

class ShapeCollector {
    private val storage = mutableListOf<ColoredShape2d>()
    val list: List<ColoredShape2d>
        get() = storage

    val size
        get() = storage.size

    fun add(shape: ColoredShape2d) {
        storage.add(shape)
    }

    fun minByArea() = storage.minByOrNull { it.calcArea() } ?: error("Collector is empty!")
    fun maxByArea() = storage.maxByOrNull { it.calcArea() } ?: error("Collector is empty!")

    fun sumArea() = storage.sumOf { it.calcArea() }

    fun findAllByFillColor(color: Color) = storage.filter { it.fillColor == color }
    fun findAllByBorderColor(color: Color) = storage.filter { it.borderColor == color }

    fun groupByFillColor() = storage.groupBy { it.fillColor }
    fun groupByBorderColor() = storage.groupBy { it.borderColor }

    inline fun <reified T> findAllOfType() = list.filterIsInstance<T>()
}

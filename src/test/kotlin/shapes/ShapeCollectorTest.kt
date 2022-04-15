package shapes

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ShapeCollectorTest {
    private val collector = ShapeCollector()
    private val backupList = listOf(
            Circle(2.0, Color("FF0000FF"), Color("FF0000FF")),
            Square(3.0, Color("00FF00FF"), Color("FF0000FF")),
            Triangle(3.0, 4.0, 5.0, Color("0000FFFF"), Color("00FF00FF")),
            Rectangle(5.0, 8.0, Color("FFFFFFFF"), Color("000000FF")),
            Circle(1.0, Color("00FF00FF"), Color("00000000"))
        )
    init {
        for (i in backupList) collector.add(i)
    }

    @Test
    fun testSize() {
        assertEquals(backupList.size, collector.size)
    }

    @Test
    fun testListsEquality() {
        assertEquals(backupList, collector.list)
    }

    @Test
    fun testFindMinByArea() {
        assertDoesNotThrow { collector.minByArea() }
        assertEquals(backupList.minByOrNull { it.calcArea() }!!, collector.minByArea())
    }

    @Test
    fun testFindMaxByArea() {
        assertDoesNotThrow { collector.maxByArea() }
        assertEquals(backupList.maxByOrNull { it.calcArea() }!!, collector.maxByArea())
    }

    @Test
    fun testSumArea() {
        assertEquals(backupList.sumOf { it.calcArea() }, collector.sumArea())
    }

    @Test
    fun testFindAllByFillColor() {
        assertTrue(backupList.containsAll(collector.findAllByFillColor(Color("00FF00FF"))))
    }

    @Test
    fun testFindAllByBorderColor() {
        assertTrue(backupList.containsAll(collector.findAllByBorderColor(Color("FF0000FF"))))
    }

    @Test
    fun testGroupByFillColor() {
        assertEquals(backupList.groupBy { it.fillColor }, collector.groupByFillColor())
    }

    @Test
    fun testGroupByBorderColor() {
        assertEquals(backupList.groupBy { it.borderColor }, collector.groupByBorderColor())
    }

    @Test
    fun testFindAllOfType() {
        for (shape in listOf("Circle", "Square", "Rectangle", "Triangle"))
            assertEquals(backupList.filter { it.shapeType == "Circle" }, collector.findAllOfType("Circle"))
    }
}
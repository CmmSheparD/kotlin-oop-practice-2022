package shapes

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

internal class BaseShapeCollectorTest {
    @Test
    fun creationTest() {
        val c = ShapeCollector()
        assertEquals(0, c.size)

        assertFailsWith<Exception>("Collector is empty!", block = { c.maxByArea() })
        assertFailsWith<Exception>("Collector is empty!", block = { c.minByArea() })

        assertEquals(0.0, c.sumArea())
    }

    @Test
    fun additionTest() {
        val c = ShapeCollector()
        val circle = Circle(2.0, Color("FFFFFFFF"), Color("FFFFFFFF"))

        assertDoesNotThrow { c.add(circle) }

        assertEquals(1, c.size)
        assertEquals(circle.calcArea(), c.sumArea())

        assertDoesNotThrow { c.minByArea() }
        assertDoesNotThrow { c.maxByArea() }
    }
}

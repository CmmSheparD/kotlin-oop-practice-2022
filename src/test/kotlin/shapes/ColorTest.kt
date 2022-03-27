package shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertFailsWith

internal class ColorTest {
    @Test
    fun createColorTest() {
        val color = Color(0U, 2U, 4U)
        assertEquals(0.toUByte(), color.red)
        assertEquals(2.toUByte(), color.green)
        assertEquals(4.toUByte(), color.blue)
    }

    @Test
    fun createColorFromStringTest() {
        val color = Color("12ffA5")
        assertEquals(0x12.toUByte(), color.red)
        assertEquals(0xff.toUByte(), color.green)
        assertEquals(0xa5.toUByte(), color.blue)
    }

    @Test
    fun createColorFromInvalidString() {
        assertFailsWith(NumberFormatException::class, block = { Color("invalid") })
    }

    @Test
    fun createColorFromShortString() {
        assertFailsWith(StringIndexOutOfBoundsException::class, block = { Color("") })
        assertFailsWith(StringIndexOutOfBoundsException::class, block = { Color("aaaaa") })
    }
}
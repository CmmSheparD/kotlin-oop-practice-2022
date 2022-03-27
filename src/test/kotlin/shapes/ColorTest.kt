package shapes

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertFailsWith

internal class ColorTest {
    @Test
    fun createColorTest() {
        val color = Color(0U, 2U, 4U, 6U)
        assertEquals(0.toUByte(), color.red)
        assertEquals(2.toUByte(), color.green)
        assertEquals(4.toUByte(), color.blue)
        assertEquals(6.toUByte(), color.alpha)
    }

    @Test
    fun createColorFromStringTest() {
        val color = Color("12f0A5ff")
        assertEquals(0x12.toUByte(), color.red)
        assertEquals(0xf0.toUByte(), color.green)
        assertEquals(0xa5.toUByte(), color.blue)
        assertEquals(0xff.toUByte(), color.alpha)
    }

    @Test
    fun createColorFromInvalidString() {
        assertFailsWith(NumberFormatException::class, block = { Color("invalid string") })
    }

    @Test
    fun createColorFromShortString() {
        assertFailsWith(StringIndexOutOfBoundsException::class, block = { Color("") })
        assertFailsWith(StringIndexOutOfBoundsException::class, block = { Color("aaaaa") })
    }
}
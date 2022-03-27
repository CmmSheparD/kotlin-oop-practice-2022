package address_parser

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.assertDoesNotThrow
import kotlin.test.Test

internal class AddressKtTest {
    @Test
    fun testEmptyStringParsingProducesNoError() {
        assertDoesNotThrow { parseAddresses("") }
    }

    @Test
    fun testEmptyStringParsingReturnsEmptyList() {
        assertEquals(0, parseAddresses("").size)
    }

    @Test
    fun testNoValuableStringParsingProducesNoError() {
        assertDoesNotThrow { parseAddresses("definitely nothing interesting here") }
    }

    @Test
    fun testNoValuableStringParsingReturnsEmptyList() {
        assertEquals(0, parseAddresses("nothing interesting here too").size)
    }

    @Test
    fun testParseSingleValue() {
        val input = "1. 123456, Санкт-Петербург, ул. Медиков, д. 1"
        val expected = Address(123456, "Санкт-Петербург", "Медиков", 1)
        val output = parseAddresses(input)
        assertTrue(output.isNotEmpty())
        assertEquals(1, output.size)
        assertEquals(expected, output[0])
    }

    @Test
    fun testParseMultipleValues() {
        val example = """
            1. 123456, СПб, ул. Невский проспект, д. 45
            2. 743233, Москва, ул. Самая московская, д. 1
            3. 228228, Екатеринбург, ул. Акашная, д. 47
            4. 346723, New York, ул. Какие там улицы есть?, д. 32
            5. 983200, Асмщиков, ул. Микрооптимизаций, д. 2
            6. 123456, Санкт-Петербург, ул. Медиков, д. 1
        """.trimIndent()
        val expectedOutput = mutableListOf<Address>()
        for (line in example.split("\n")) expectedOutput += parseAddresses(line)
        val output = parseAddresses(example)
        assertEquals(expectedOutput, output)
    }
}
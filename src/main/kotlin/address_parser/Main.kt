package address_parser

import java.io.File

fun main(args: Array<String>) {
    val example: String
    if (args.isNotEmpty()) {
        try {
            example = File(args[0]).readText()
        } catch (e: Exception) {
            println("Cannot read from file ${args[0]}!")
            return
        }
    } else {
        example = """
            1. 123456, СПб, ул. Невский проспект, д. 45
            2. 743233, Москва, ул. Самая московская, д. 1
            3. 228228, Екатеринбург, ул. Ака, д. 47
            4. 346723, New York, ул. Какие там улицы есть?, д. 32
            5. 983200, Асмщиков, ул. Микрооптимизаций, д. 2
        """.trimIndent()
    }
    val addresses = parseAddresses(example)
    for (a in addresses) println(a)
    val minInd = addresses.minByOrNull { it.index }
    val maxInd = addresses.maxByOrNull { it.index }
    val shortestStreet = addresses.minByOrNull { it.street.length }
    val longestStreet = addresses.maxByOrNull { it.street.length }
    println("Address with minimal index: $minInd")
    println("Address with maximal index: $maxInd")
    println("Address with shortest street name: $shortestStreet")
    println("Address with longest street name: $longestStreet")
}
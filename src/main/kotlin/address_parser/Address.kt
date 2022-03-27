package address_parser

data class Address(val index: Int, val city: String, val street: String, val building: Int) {
    override fun toString() = "$index, $city, $street, $building"
}

fun parseAddresses(input: String): List<Address> {
    val scanner =
        "\\d+\\. (?<index>\\d{6}), (?<city>[^,\\n]+), ул\\. (?<street>[^,\\n]+), д\\. (?<building>\\d+)".toRegex()
    return scanner.findAll(input).map {
        Address(
            it.groups["index"]!!.value.toInt(),
            it.groups["city"]!!.value,
            it.groups["street"]!!.value,
            it.groups["building"]!!.value.toInt(),
        )
    }.toList()
}
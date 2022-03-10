package address_parser

data class Address(val index: Int, val city: String, val street: String, val building: Int) {
    override fun toString() = "$index, $city, $street, $building"
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Address

        if (index != other.index) return false
        if (city != other.city) return false
        if (street != other.street) return false
        if (building != other.building) return false

        return true
    }

    override fun hashCode(): Int {
        var result = index
        result = 31 * result + city.hashCode()
        result = 31 * result + street.hashCode()
        result = 31 * result + building
        return result
    }
}

fun parseAddresses(input: String): List<Address> {
    val scan = "\\d+\\. (?<index>\\d{6}), (?<city>[^,\\n]+), ул\\. (?<street>[^,\\n]+), д\\. (?<building>\\d+)".toRegex()
    val list = mutableListOf<Address>()
    for (i in scan.findAll(input)) {
        list.add(
            Address(
                i.groups["index"]!!.value.toInt(),
                i.groups["city"]!!.value,
                i.groups["street"]!!.value,
                i.groups["building"]!!.value.toInt(),
            )
        )
    }
    return list
}
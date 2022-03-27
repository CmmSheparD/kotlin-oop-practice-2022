package shapes

data class Color(val red: UByte, val green: UByte, val blue: UByte) {
    constructor(value: String) : this(
        value.slice(0..1).toUByte(16),
        value.slice(2..3).toUByte(16),
        value.slice(4..5).toUByte(16),
    )
}

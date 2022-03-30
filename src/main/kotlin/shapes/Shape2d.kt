package shapes

interface Shape2d {
    val shapeType: String
    fun calcArea(): Double
}

interface ColoredShape2d : Shape2d {
    val fillColor: Color
    val borderColor: Color
}
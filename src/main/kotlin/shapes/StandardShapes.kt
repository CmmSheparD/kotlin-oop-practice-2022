package shapes

import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.math.PI

class Circle(val radius: Double, _fillColor: Color, _borderColor: Color) : ColoredShape2d {
    override val fillColor = _fillColor
    override val borderColor = _borderColor

    override fun calcArea() = PI * radius.pow(2)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Circle

        if (radius != other.radius) return false
        if (fillColor != other.fillColor) return false
        if (borderColor != other.borderColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = radius.hashCode()
        result = 31 * result + fillColor.hashCode()
        result = 31 * result + borderColor.hashCode()
        return result
    }
}

class Square(val sideLen: Double, _fillColor: Color, _borderColor: Color) : ColoredShape2d {
    override val fillColor = _fillColor
    override val borderColor = _borderColor

    override fun calcArea() = sideLen.pow(2)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Square

        if (sideLen != other.sideLen) return false
        if (fillColor != other.fillColor) return false
        if (borderColor != other.borderColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = sideLen.hashCode()
        result = 31 * result + fillColor.hashCode()
        result = 31 * result + borderColor.hashCode()
        return result
    }
}

class Rectangle(val length: Double, val width: Double, _fillColor: Color, _borderColor: Color) : ColoredShape2d {
    override val fillColor = _fillColor
    override val borderColor = _borderColor

    override fun calcArea() = length * width

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Rectangle

        if (length != other.length) return false
        if (width != other.width) return false
        if (fillColor != other.fillColor) return false
        if (borderColor != other.borderColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = length.hashCode()
        result = 31 * result + width.hashCode()
        result = 31 * result + fillColor.hashCode()
        result = 31 * result + borderColor.hashCode()
        return result
    }
}

class Triangle(
    val sideA: Double,
    val sideB: Double,
    val sideC: Double,
    _fillColor: Color,
    _borderColor: Color
) : ColoredShape2d {
    override val fillColor = _fillColor
    override val borderColor = _borderColor

    override fun calcArea(): Double {
        val halfP = (sideA + sideB + sideC) / 2.0
        return sqrt(halfP * (halfP - sideA) * (halfP - sideB) * (halfP - sideC))
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Triangle

        if (sideA != other.sideA) return false
        if (sideB != other.sideB) return false
        if (sideC != other.sideC) return false
        if (fillColor != other.fillColor) return false
        if (borderColor != other.borderColor) return false

        return true
    }

    override fun hashCode(): Int {
        var result = sideA.hashCode()
        result = 31 * result + sideB.hashCode()
        result = 31 * result + sideC.hashCode()
        result = 31 * result + fillColor.hashCode()
        result = 31 * result + borderColor.hashCode()
        return result
    }
}
package shapes

import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sqrt

data class Circle(
    val radius: Double,
    override val fillColor: Color,
    override val borderColor: Color
) : ColoredShape2d {
    init {
        require(radius > 0.0)
    }

    override fun calcArea() = PI * radius.pow(2)
}

data class Square(
    val sideLen: Double,
    override val fillColor: Color,
    override val borderColor: Color
) : ColoredShape2d {
    init {
        require(sideLen > 0.0)
    }

    override fun calcArea() = sideLen.pow(2)
}

data class Rectangle(
    val length: Double,
    val width: Double,
    override val fillColor: Color,
    override val borderColor: Color
) : ColoredShape2d {
    init {
        require(length > 0.0)
        require(width > 0.0)
    }

    override fun calcArea() = length * width
}

data class Triangle(
    val sideA: Double,
    val sideB: Double,
    val sideC: Double,
    override val fillColor: Color,
    override val borderColor: Color
) : ColoredShape2d {
    init {
        require(sideA > 0.0 && sideB > 0.0 && sideC > 0.0)
        require(sideA < sideB + sideC)
        require(sideB < sideA + sideC)
        require(sideC < sideA + sideB)
    }

    override fun calcArea(): Double {
        val halfP = (sideA + sideB + sideC) / 2.0
        return sqrt(halfP * (halfP - sideA) * (halfP - sideB) * (halfP - sideC))
    }
}
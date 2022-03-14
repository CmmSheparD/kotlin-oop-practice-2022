import matrix.Matrix

fun main() {
    val A = Matrix(
        arrayOf(
            doubleArrayOf(1.0, 2.0),
            doubleArrayOf(3.0, 4.0),
        )
    )

    val element = A[0, 0]

    A[0, 0] = 100.0
}
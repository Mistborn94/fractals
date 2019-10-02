import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

data class Line(
    val x1: Double,
    val y1: Double,
    val x2: Double,
    val y2: Double
)

data class AngledLine(
    val x: Double,
    val y: Double,
    val length: Double,
    val rotation: Double
) {
    val line: Line by lazy { Line(x, y, x + length * cos(rotation), y + length * sin(rotation)) }
}


data class KochLines(val erase: Iterable<Line>, val draw: Iterable<Line>)


private fun Int.toRadians() = this * PI / 180
private val degrees60 = 60.toRadians()
private val degrees120 = 120.toRadians()

class KochCurve(
    val startX: Double,
    val startY: Double,
    val startLength: Double,
    val startRotation: Double = 0.0
) : Fractal<KochLines> {

    override fun draw(consumer: Consumer<KochLines>) {
        val base = AngledLine(startX, startY, startLength, startRotation)
        draw(base, consumer)
    }

    /**
     * Draw an iteration
     * @param length The current length of the line
     * @param theta The current angle
     *
     */
    private fun draw(currentLine: AngledLine, consumer: Consumer<KochLines>) {
        consumer(KochLines(emptyList(), listOf(currentLine.line)))
        if (currentLine.length > 10) {
            val newLength = currentLine.length / 3

            val fragment1 = AngledLine(currentLine.x, currentLine.y, newLength, currentLine.rotation)
            val fragment2 = AngledLine(fragment1.line.x2, fragment1.line.y2, newLength, currentLine.rotation)
            val fragment3 = AngledLine(fragment2.line.x2, fragment2.line.y2, newLength, currentLine.rotation)

            consumer(KochLines(listOf(fragment2.line), emptyList()))

            val side1 = AngledLine(fragment1.line.x2, fragment1.line.y2, newLength, currentLine.rotation - degrees60)
            val side2 = AngledLine(side1.line.x2, side1.line.y2, newLength, currentLine.rotation + degrees60)

            draw(fragment1, consumer)
            draw(fragment3, consumer)
            draw(side1, consumer)
            draw(side2, consumer)
        }
    }
}
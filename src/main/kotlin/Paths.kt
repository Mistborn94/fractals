import org.w3c.dom.Path2D
import kotlin.math.cos
import kotlin.math.sin

object Paths {

    fun circle(x: Double, y: Double, r: Double): Path2D {
        return Path2D().apply {
            arc(x, y, r, 0.0, 360.0)
        }
    }

    fun line(x1: Double, y1: Double, x2: Double, y2: Double): Path2D = Path2D().apply {
        moveTo(x1, y1)
        lineTo(x2, y2)
    }

    fun line(lineDefinition: Line): Path2D = Path2D().apply {
        return lineDefinition.run { line(x1, y1, x2, y2) }
    }

    fun angledLine(x: Double, y: Double, r: Double, theta: Double): Path2D {
        return Path2D().apply {
            moveTo(x, y)
            lineTo(x + r * cos(theta), y + r * sin(theta))
        }
    }
}
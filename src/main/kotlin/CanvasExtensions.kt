import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.Path2D

fun CanvasRenderingContext2D.eraseStroke(path: Path2D, offset: Double) {

    val tmpOperation = globalCompositeOperation
    globalCompositeOperation = "destination-out"
    lineWidth += offset

    stroke(path)

    lineWidth -= offset
    globalCompositeOperation = tmpOperation
}

fun CanvasRenderingContext2D.eraseFill(path: Path2D) {
    val tmpOperation = globalCompositeOperation
    globalCompositeOperation = "destination-out"
    fill(path)
    globalCompositeOperation = tmpOperation
}

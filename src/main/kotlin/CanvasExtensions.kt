import org.w3c.dom.CanvasRenderingContext2D

fun CanvasRenderingContext2D.drawCircle(x: Double, y: Double, r: Double) {
    beginPath()
    arc(x, y, r, 0.0, 360.0)
    closePath()
    stroke()
}

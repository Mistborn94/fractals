import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.HTMLCanvasElement
import kotlin.browser.document
import kotlin.browser.window

fun main() {
    window.onload = {
        val renderingContext = getRenderingContext("canvas")
        circleFractal(renderingContext)
    }
}

private fun getRenderingContext(elementId: String): CanvasProperties {
    val canvasElement = document.getElementById(elementId) as HTMLCanvasElement
    val context = canvasElement.getContext("2d") as CanvasRenderingContext2D
    return CanvasProperties(context, canvasElement.width, canvasElement.height)
}

fun circleFractal(canvasProperties: CanvasProperties) {
    val (canvasContext, width, height) = canvasProperties

    val fractal = CircleFractal(width / 4.0, 2.0, width / 2.0, height / 2.0)
    fractal.draw { (x, y, r) -> canvasContext.drawCircle(x, y, r)}
}



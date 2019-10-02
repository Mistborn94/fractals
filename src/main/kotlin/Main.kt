import org.w3c.dom.*
import kotlin.browser.document
import kotlin.browser.window

fun main() {
    window.onload = {
        val renderingContext = getRenderingContext("canvas")
        circleFractal(renderingContext)
//        renderingContext.context.globalCompositeOperation = "destination-out"
        renderingContext.context.strokeStyle = "#F00"
        kochCurve(renderingContext)
    }
}

private fun getRenderingContext(elementId: String): CanvasProperties {
    val canvasElement = document.getElementById(elementId) as HTMLCanvasElement
    val context = canvasElement.getContext("2d") as CanvasRenderingContext2D
    return CanvasProperties(context, canvasElement.width, canvasElement.height)
}

fun circleFractal(canvasProperties: CanvasProperties) {
    val (canvasContext, width, height) = canvasProperties
    val fractal = CircleFractal(width / 4.0, 2.0, width / 2.0, width / 2.0)
    fractal.draw { (x, y, r) -> canvasContext.stroke(Paths.circle(x, y, r)) }
}

fun kochCurve(canvasProperties: CanvasProperties) {

    val (canvasContext, width, height) = canvasProperties

    val fractal = KochCurve(0.0, height / 2.0, width.toDouble())
    fractal.draw { (erase, draw) ->
        erase.forEach { canvasContext.eraseStroke(Paths.line(it), 2.0) }
        draw.forEach { canvasContext.stroke(Paths.line(it)) }
    }
}




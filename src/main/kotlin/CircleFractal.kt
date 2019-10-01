
data class Circle(val x: Double, val y: Double, val r: Double)

class CircleFractal(private val startRadius: Double,
                    private val stopRadius: Double,
                    private val startX: Double,
                    private val startY: Double) : Fractal<Circle> {

    override fun draw(consumer: Consumer<Circle>) = draw(startX, startY, startRadius, consumer)

    private fun draw(x: Double = startX, y: Double = startY, r: Double = startRadius, consumer: Consumer<Circle>) {
        if (r > stopRadius) {
            consumer(Circle(x, y, r))

            draw(x + r, y, r / 2, consumer)
            draw(x - r, y, r / 2, consumer)
            draw(x, y + r, r / 2, consumer)
            draw(x, y - r, r / 2, consumer)
        }
    }

}

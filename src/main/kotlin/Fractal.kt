typealias Consumer<T> = (T) -> Unit

interface Fractal<T> {
    fun draw(consumer: Consumer<T>)
}

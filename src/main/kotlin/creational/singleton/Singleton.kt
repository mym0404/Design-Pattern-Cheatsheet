package creational.singleton

open class Singleton protected constructor() {
    companion object {
        private val registry = hashMapOf<String, Singleton>()
        fun register(key: String, obj: Singleton) {
            registry[key] = obj
        }

        fun lookup(key: String) = registry[key] ?: throw RuntimeException("No singleton registered with key $key")
    }
}

class SingletonOne private constructor() : Singleton() {
    companion object{
        init {
            register("One", SingletonOne())
        }
    }
}
package creational.singleton

fun singleton() {
    SingletonOne // need for companion object init block run
    val one = Singleton.lookup("One")
    val one2 = Singleton.lookup("One")
    assert(one == one2)
}
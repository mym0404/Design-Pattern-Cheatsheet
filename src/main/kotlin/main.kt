import behavioral.observer.IntegerObserver
import behavioral.observer.IntegerSubject
import behavioral.observer.SimpleHashMapEvenIntegerObserverMediator

fun main() {
    val mediator = SimpleHashMapEvenIntegerObserverMediator()
    val subject = IntegerSubject(mediator, 1)
    val observer = IntegerObserver(99)

    subject.attach(observer)

    subject.value = 5

    assert(observer.value == 99)

    subject.value = 4

    assert(observer.value == 4)

    subject.detach(observer)

    subject.value = 2

    assert(observer.value == 4)
}
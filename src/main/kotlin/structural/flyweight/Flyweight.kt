package structural.flyweight

import structural.flyweight.Bullet.LargeBullet
import structural.flyweight.Bullet.SmallBullet

// Flyweight
sealed interface Bullet {
    // Intrinsic States
    val radius: Int
    val damage: Int
    val initialSpeed: Int

    class SmallBullet : Bullet {
        override val radius = 10
        override val damage = 10
        override val initialSpeed = 15
    }

    class LargeBullet : Bullet {
        override val radius = 15
        override val damage = 20
        override val initialSpeed = 10
    }
}

// Extrinsic State Wrapper
class MovingBullet(val bullet: Bullet) {
    private var speed = 0
    fun shoot() {
        this.speed = bullet.initialSpeed
    }
}

// Flyweight Factory
class BulletFactory {
    private val cache = hashMapOf<String, Bullet>()
    fun getBullet(key: String): Bullet =
        if (key == "Small") cache.getOrPut(key) { SmallBullet() } else cache.getOrPut(key) { LargeBullet() }

}

// Client
class Shooter(private val factory: BulletFactory) {
    fun shootSmall() = shoot("Small")
    fun shootLarge() = shoot("Large")
    private fun shoot(key: String) = MovingBullet(factory.getBullet(key)).also { it.shoot() }
}
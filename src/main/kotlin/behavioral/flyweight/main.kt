package behavioral.flyweight

fun flyweight() {
    val factory = BulletFactory()
    val shooter1 = Shooter(factory)
    val shooter2 = Shooter(factory)

    assert(shooter1.shootLarge() != shooter2.shootLarge())
    assert(shooter1.shootLarge().bullet == shooter2.shootLarge().bullet)
}
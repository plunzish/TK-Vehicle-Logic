package eu.monsbot.turbokarts.vehiclelogic.karts.vehicles

import org.bukkit.entity.EntityType
import org.bukkit.entity.ItemDisplay
import org.bukkit.inventory.ItemStack
import org.bukkit.util.Transformation
import org.joml.AxisAngle4f
import org.joml.Vector3f

class Wheel(parent: TKVehicle, item: ItemStack, translation: Vector3f?, scale: Vector3f, rotationAxis: Vector3f?, radius: Float, rotateClockwise: Boolean, canSteer: Boolean, steeringAxis: Vector3f?) : AbstractWheel() {
    // Core
    private val entity: ItemDisplay
    var parent: TKVehicle

    init {
        val entity = parent.getMainEntity().world.spawnEntity(parent.getLocation(), EntityType.ITEM_DISPLAY) as ItemDisplay
        entity.itemStack = item
        entity.transformation = Transformation(
                translation!!,
                AxisAngle4f(0f, rotationAxis),
                scale,
                AxisAngle4f(0f, steeringAxis)
        )
        this.entity = entity
        this.parent = parent

        this.item = item
        this.translation = translation
        this.scale = scale

        this.rotationAxis = rotationAxis
        this.radius = radius
        this.rotateClockwise = rotateClockwise

        this.canSteer = canSteer
        this.steeringAxis = if (canSteer) steeringAxis else null
    }

    fun destroy() {
        parent.removeWheel(this)
        entity.remove()
    }
}

package eu.monsbot.turbokarts.vehiclelogic.karts.vehicles

import org.bukkit.Material
import org.joml.Vector3f

abstract class AbstractWheel {
    // Display
    var material: Material? = null
    var customModelData: Int = 0
    var translation: Vector3f? = null
    var size: Vector3f? = null
    var left_rotation_axis: Vector3f? = null
    var left_rotation_value: Float = 0f
    var right_rotation_axis: Vector3f? = null
    var right_rotation_value: Float = 0f

    // Rolling
    var rotationAxis: Vector3f? = null
    var radius: Float = 0f //in blocks
    var rotateClockwise: Boolean = false

    // Steering
    var canSteer: Boolean = false
    var steeringAxis: Vector3f? = null
}

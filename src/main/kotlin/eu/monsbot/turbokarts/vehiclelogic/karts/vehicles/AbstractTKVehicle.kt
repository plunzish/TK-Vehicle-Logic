package eu.monsbot.turbokarts.vehiclelogic.karts.vehicles

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.bukkit.Color
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.LeatherArmorMeta
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.util.Transformation
import org.joml.AxisAngle4f
import org.joml.Vector3f

abstract class AbstractTKVehicle {
    /** -- physics --  */
    var maxSpeed: Int = 0 //  kb/h = km/h
    var acceleration: Float = 0f //  b/s²
    var deceleration: Float = 0f //  b/s²
    var mass: Int = 0 //  g
    var grip: Float = 0f //  μ on concrete
    var handlingRadius: Float = 0f //  b
    var hitbox: Vector3f? = null //  bxbxb xyz

    /** -- visuals --  */ // name
    private val name: String? = null
    private val brand: String? = null

    // primary
    var primaryMaterial: Material? = null
    var primaryCustomModelData: Int = 0
    var primaryColor: Int = 0
    var primaryTranslation: Vector3f? = null
    var primarySize: Vector3f? = null
    var primaryLeftRotation: AxisAngle4f? = null
    var primaryRightRotation: AxisAngle4f? = null

    // accent1
    var accent1Material: Material? = null
    var accent1CustomModelData: Int = 0
    var accent1Color: Int = 0
    var accent1Translation: Vector3f? = null
    var accent1Size: Vector3f? = null
    var accent1LeftRotation: AxisAngle4f? = null
    var accent1RightRotation: AxisAngle4f? = null

    // accent2
    var accent2Material: Material? = null
    var accent2CustomModelData: Int = 0
    var accent2Color: Int = 0
    var accent2Translation: Vector3f? = null
    var accent2Size: Vector3f? = null
    var accent2LeftRotation: AxisAngle4f? = null
    var accent2RightRotation: AxisAngle4f? = null

    // steering wheel
    var steeringWHeelMaterial: Material? = null
    var steeringWHeelCustomModelData: Int = 0
    var steeringWHeelColor: Int = 0
    var steeringWHeelTranslation: Vector3f? = null
    var steeringWHeelSize: Vector3f? = null
    var steeringWheelLeftRotation: AxisAngle4f? = null
    var steeringWheelRightRotation: AxisAngle4f? = null

    // dummy
    var headTranslation: Vector3f? = null
    var headLeftRotation: AxisAngle4f? = null
    var headRightRotation: AxisAngle4f? = null

    var bodyTranslation: Vector3f? = null
    var bodyLeftRotation: AxisAngle4f? = null
    var bodyRightRotation: AxisAngle4f? = null

    var leftArmTranslation: Vector3f? = null
    var leftArmLeftRotation: AxisAngle4f? = null
    var leftArmRightRotation: AxisAngle4f? = null
    var rightArmTranslation: Vector3f? = null
    var rightArmLeftRotation: AxisAngle4f? = null
    var rightArmRightRotation: AxisAngle4f? = null

    var leftLegTranslation: Vector3f? = null
    var leftLegLeftRotation: AxisAngle4f? = null
    var leftLegRightRotation: AxisAngle4f? = null
    var rightLegTranslation: Vector3f? = null
    var rightLegLeftRotation: AxisAngle4f? = null
    var rightLegRightRotation: AxisAngle4f? = null

    val basePrimaryTransformation: Transformation
        get() = Transformation(
                primaryTranslation!!,
                primaryLeftRotation!!,
                primarySize!!,
                primaryRightRotation!!
        )


    /**
     * The json needed to write down a vehicle model ([AbstractTKVehicle]):
     * [ physics ]
     * - max speed
     * - acceleration
     * - mass
     * - hitbox
     * - handling
     * - grip
     * [ visual ]
     * - name
     * - array for the values for the body displays
     * - dummy pose
     * - wheel item display properties
     * - wheel position
     * - wheel rotation direction & axis (Vector)
     * - steering wheel position
     * META: brand
     */
    fun toJson(): String {
        val gson = Gson()
        return gson.toJson(this)
    }

    private fun getItem(material: Material?, customModelData: Int, color: Int): ItemStack {
        val itemStack = ItemStack(material!!)
        val itemMeta = itemStack.itemMeta
        itemMeta.setCustomModelData(customModelData)
        if (itemMeta is PotionMeta && color > -1) {
            itemMeta.color = Color.fromRGB(color)
        } else if (itemMeta is LeatherArmorMeta && color > -1) {
            itemMeta.setColor(Color.fromRGB(color))
        }
        itemStack.setItemMeta(itemMeta)
        return itemStack
    }

    val basePrimaryItem: ItemStack
        get() = getItem(primaryMaterial, primaryCustomModelData, primaryColor)

    val baseAccent1Transformation: Transformation
        get() = Transformation(
                accent1Translation!!,
                accent1LeftRotation!!,
                accent1Size!!,
                accent1RightRotation!!
        )

    val baseAccent1Item: ItemStack
        get() = getItem(accent1Material, accent1CustomModelData, accent1Color)

    val baseAccent2Transformation: Transformation
        get() = Transformation(
                accent2Translation!!,
                accent2LeftRotation!!,
                accent2Size!!,
                accent2RightRotation!!
        )

    val baseAccent2Item: ItemStack
        get() = getItem(accent2Material, accent2CustomModelData, accent2Color)

    val steeringWheelTransformation: Transformation
        get() = Transformation(
                headTranslation!!,
                headLeftRotation!!,
                Vector3f(1f, 1f, 1f),
                headRightRotation!!
        )


    val steeringWheelItem: ItemStack
        get() = getItem(steeringWHeelMaterial, steeringWHeelCustomModelData, steeringWHeelColor)

    companion object {
        fun fromJson(json: String?): AbstractTKVehicle {
            val gson = Gson()
            return gson.fromJson(json, object : TypeToken<AbstractTKVehicle?>() {}.type)
        }
    }
}
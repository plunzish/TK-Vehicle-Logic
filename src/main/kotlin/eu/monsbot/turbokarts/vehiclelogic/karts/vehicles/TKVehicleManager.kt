package eu.monsbot.turbokarts.vehiclelogic.karts.vehicles

import org.bukkit.Location
import org.bukkit.entity.Interaction
import org.bukkit.entity.ItemDisplay

class TKVehicleManager {
    fun summonVehicle(vehicleModel: AbstractTKVehicle, location: Location) {
        /*
         * [entities]                [tags]
         * - interaction             VEHICLE, VEHICLE_CORE, V+UUID
         * |- player                 RIDER
         * |- base primary           VEHICLE, BODY
         * |  |- base accent 1       VEHICLE, ACCENT, A1
         * |  |- base accent 2       VEHICLE, ACCENT, A2
         * |- steering wheel         VEHICLE, STEERING_WHEEL, STEER
         * |  |- wheel 1 (front)     VEHICLE, WHEEL, LEFT, STEER
         * |  |- wheel 2 (front)     VEHICLE, WHEEL, RIGHT, STEER
         * |  |- wheel 3             VEHICLE, WHEEL, LEFT
         * |  |- wheel 4             VEHICLE, WHEEL, RIGHT
         * |- dummy-head             DUMMY, HEAD
         * |  |- dummy-body          DUMMY, BODY
         * |  |- dummy-arm           DUMMY, ARM, LEFT
         * |  |- dummy-arm           DUMMY, ARM, RIGHT
         * |  |- dummy-leg           DUMMY, LEG, LEFT
         * |  |- dummy-leg           DUMMY, LEG, RIGHT*/

        val mainEntity = location.world.createEntity(location, Interaction::class.java)
        mainEntity.scoreboardTags.add("VEHICLE")
        mainEntity.scoreboardTags.add("VEHICLE_CORE")
        mainEntity.scoreboardTags.add("V" + mainEntity.uniqueId)

        val basePrimary = location.world.createEntity(location, ItemDisplay::class.java)
        mainEntity.addPassenger(basePrimary)
        basePrimary.scoreboardTags.add("VEHICLE")
        basePrimary.scoreboardTags.add("BODY")
        basePrimary.transformation = vehicleModel.basePrimaryTransformation
        basePrimary.itemStack = vehicleModel.basePrimaryItem

        val baseAccent1 = location.world.createEntity(location, ItemDisplay::class.java)
        basePrimary.addPassenger(baseAccent1)
        baseAccent1.scoreboardTags.add("VEHICLE")
        baseAccent1.scoreboardTags.add("ACCENT")
        baseAccent1.scoreboardTags.add("ACCENT_1")
        baseAccent1.transformation = vehicleModel.baseAccent1Transformation
        baseAccent1.itemStack = vehicleModel.baseAccent1Item

        val baseAccent2 = location.world.createEntity(location, ItemDisplay::class.java)
        basePrimary.addPassenger(baseAccent2)
        baseAccent2.scoreboardTags.add("VEHICLE")
        baseAccent2.scoreboardTags.add("ACCENT")
        baseAccent2.scoreboardTags.add("ACCENT_2")
        baseAccent2.transformation = vehicleModel.baseAccent2Transformation
        baseAccent2.itemStack = vehicleModel.baseAccent2Item


        val steeringWheel = location.world.createEntity(location, ItemDisplay::class.java)
        mainEntity.addPassenger(steeringWheel)
        steeringWheel.scoreboardTags.add("VEHICLE")
        steeringWheel.scoreboardTags.add("STEERING_WHEEL")
        steeringWheel.scoreboardTags.add("STEER")
        steeringWheel.transformation = vehicleModel.steeringWheelTransformation
        steeringWheel.itemStack = vehicleModel.steeringWheelItem
    }
}
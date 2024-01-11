package eu.monsbot.turbokarts.vehiclelogic.karts.vehicles

import org.bukkit.Color
import org.bukkit.Location
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import org.bukkit.entity.Interaction

class TKVehicle internal constructor(spawnLocation: Location, model: AbstractTKVehicle?, primary: Color?, accent_1: Color?, accent_2: Color?) : AbstractTKVehicle() {
    private val wheels: MutableList<Wheel> = ArrayList()
    val mainEntity: Interaction = spawnLocation.world.spawnEntity(spawnLocation, EntityType.INTERACTION) as Interaction
    var location: Location? = null

    fun removeWheel(wheel: Wheel) {
        wheels.remove(wheel)
    }

    fun getMainEntity(): Entity {
        return mainEntity
    }
}

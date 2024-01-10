package eu.monsbot.turbokarts.vehiclelogic.karts.vehicles;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Interaction;

import java.util.ArrayList;
import java.util.List;

public class TKVehicle extends AbstractTKVehicle {
    private final List<Wheel> wheels = new ArrayList<>();
    final Interaction mainEntity;
    Location location;

    TKVehicle(Location spawnLocation, AbstractTKVehicle model, Color primary, Color accent_1, Color accent_2) {
        this.mainEntity = (Interaction) spawnLocation.getWorld().spawnEntity(spawnLocation, EntityType.INTERACTION);


    }

    public void removeWheel(Wheel wheel) {
        wheels.remove(wheel);
    }
    public Entity getMainEntity() {
        return mainEntity;
    }
    public Location getLocation() {
        return location;
    }
}

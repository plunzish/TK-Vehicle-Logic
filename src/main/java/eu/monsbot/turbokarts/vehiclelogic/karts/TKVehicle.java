package eu.monsbot.turbokarts.vehiclelogic.karts;

import org.bukkit.Location;
import org.bukkit.entity.ItemDisplay;

import java.util.ArrayList;
import java.util.List;

public class TKVehicle extends AbstractTKVehicle {
    private List<Wheel> wheels = new ArrayList<>();
    Interaction mainEntity;
    Location location;

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

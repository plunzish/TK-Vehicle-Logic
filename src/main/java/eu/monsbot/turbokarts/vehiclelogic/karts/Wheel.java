package eu.monsbot.turbokarts.vehiclelogic.kartManagement;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.ItemDisplay;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import org.joml.AxisAngle4f;
import org.joml.Vector3f;

public class Wheel {
    // Core
    private final ItemDisplay entity;
    TKVehicle parent;

    // Display
    private final ItemStack item;
    private final Vector3f scale;
    private final Vector3f translation;

    // Rolling
    private final Vector3f rotationAxis;
    private final float radius; //in blocks
    private final boolean rotateClockwise;

    // Steering
    private final boolean canSteer;
    private final Vector3f steeringAxis;

    public Wheel(TKVehicle parent, ItemStack item, Vector3f translation, Vector3f scale, Vector3f rotationAxis, float radius, boolean rotateClockwise, boolean canSteer, Vector3f steeringAxis) {
        ItemDisplay entity = (ItemDisplay) parent.getMainEntity().getWorld().spawnEntity(parent.getLocation(), EntityType.ITEM_DISPLAY);
        entity.setItemStack(item);
        entity.setTransformation(new Transformation(
                translation,
                new AxisAngle4f(0f, rotationAxis),
                scale,
                new AxisAngle4f(0f, steeringAxis)
        ));
        this.entity = entity;
        this.parent = parent;

        this.item = item;
        this.translation = translation;
        this.scale = scale;

        this.rotationAxis = rotationAxis;
        this.radius = radius;
        this.rotateClockwise = rotateClockwise;

        this.canSteer = canSteer;
        this.steeringAxis = canSteer ? steeringAxis : null;
    }
    public void destroy() {
        parent.removeWheel(this);
        entity.remove();
    }
}

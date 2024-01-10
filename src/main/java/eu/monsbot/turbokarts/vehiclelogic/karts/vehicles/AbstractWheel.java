package eu.monsbot.turbokarts.vehiclelogic.karts.vehicles;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.joml.Vector3f;

public abstract class AbstractWheel {
    // Display

    Material material;
    int      customModelData;
    Vector3f translation;
    Vector3f size;
    Vector3f left_rotation_axis;
    float    left_rotation_value;
    Vector3f right_rotation_axis;
    float    right_rotation_value;

    // Rolling
    Vector3f rotationAxis;
    float radius; //in blocks
    boolean rotateClockwise;

    // Steering
    boolean canSteer;
    Vector3f steeringAxis;
}

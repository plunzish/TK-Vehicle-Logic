package eu.monsbot.turbokarts.vehiclelogic.karts.vehicles;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.util.Transformation;
import org.joml.AxisAngle4f;
import org.joml.Vector3f;

public abstract class AbstractTKVehicle {

    /** -- physics -- **/
    int maxSpeed;           //  kb/h = km/h
    float acceleration;     //  b/s²
    float deceleration;     //  b/s²
    int mass;               //  g
    float grip;             //  μ on concrete
    float handlingRadius;   //  b
    Vector3f hitbox;        //  bxbxb xyz

    /** -- visuals -- **/
    // name
    private String name;
    private String brand;
    // primary
    Material primaryMaterial;
    int      primaryCustomModelData;
    int      primaryColor;
    Vector3f primaryTranslation;
    Vector3f primarySize;
    AxisAngle4f primaryLeftRotation;
    AxisAngle4f primaryRightRotation;
    // accent1
    Material accent1Material;
    int      accent1CustomModelData;
    int      accent1Color;
    Vector3f accent1Translation;
    Vector3f accent1Size;
    AxisAngle4f accent1LeftRotation;
    AxisAngle4f accent1RightRotation;

    // accent2
    Material accent2Material;
    int      accent2CustomModelData;
    int      accent2Color;
    Vector3f accent2Translation;
    Vector3f accent2Size;
    AxisAngle4f accent2LeftRotation;
    AxisAngle4f accent2RightRotation;

    // steering wheel
    Material steeringWHeelMaterial;
    int      steeringWHeelCustomModelData;
    int      steeringWHeelColor;
    Vector3f steeringWHeelTranslation;
    Vector3f steeringWHeelSize;
    AxisAngle4f steeringWheelLeftRotation;
    AxisAngle4f steeringWheelRightRotation;

    // dummy
    Vector3f headTranslation;
    AxisAngle4f headLeftRotation;
    AxisAngle4f headRightRotation;

    Vector3f bodyTranslation;
    AxisAngle4f bodyLeftRotation;
    AxisAngle4f bodyRightRotation;

    Vector3f leftArmTranslation;
    AxisAngle4f leftArmLeftRotation;
    AxisAngle4f leftArmRightRotation;
    Vector3f rightArmTranslation;
    AxisAngle4f rightArmLeftRotation;
    AxisAngle4f rightArmRightRotation;

    Vector3f leftLegTranslation;
    AxisAngle4f leftLegLeftRotation;
    AxisAngle4f leftLegRightRotation;
    Vector3f rightLegTranslation;
    AxisAngle4f rightLegLeftRotation;
    AxisAngle4f rightLegRightRotation;

    public Transformation getBasePrimaryTransformation() {
        return new Transformation(
                primaryTranslation,
                primaryLeftRotation,
                primarySize,
                primaryRightRotation
        );
    }


    /**
     *  The json needed to write down a vehicle model ({@link AbstractTKVehicle}):
     * [ physics ]
     *  - max speed
     *  - acceleration
     *  - mass
     *  - hitbox
     *  - handling
     *  - grip
     * [ visual ]
     *  - name
     *  - array for the values for the body displays
     *  - dummy pose
     *  - wheel item display properties
     *  - wheel position
     *  - wheel rotation direction & axis (Vector)
     *  - steering wheel position
     *  META: brand
     **/

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public static AbstractTKVehicle fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, new TypeToken<AbstractTKVehicle>(){}.getType());
    }

    private ItemStack getItem(Material material, int customModelData, int color) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setCustomModelData(customModelData);
        if (itemMeta instanceof PotionMeta && color > -1) {
            PotionMeta potionMeta = (PotionMeta) itemMeta;
            potionMeta.setColor(Color.fromRGB(color));

        } else if (itemMeta instanceof LeatherArmorMeta && color > -1) {
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) itemMeta;
            leatherArmorMeta.setColor(Color.fromRGB(color));
        }
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public ItemStack getBasePrimaryItem() {
        return getItem(primaryMaterial, primaryCustomModelData, primaryColor);
    }

    public Transformation getBaseAccent1Transformation() {
        return new Transformation(
                accent1Translation,
                accent1LeftRotation,
                accent1Size,
                accent1RightRotation
        );
    }

    public ItemStack getBaseAccent1Item() {
        return getItem(accent1Material, accent1CustomModelData, accent1Color);
    }

    public Transformation getBaseAccent2Transformation() {
        return new Transformation(
                accent2Translation,
                accent2LeftRotation,
                accent2Size,
                accent2RightRotation
        );
    }

    public ItemStack getBaseAccent2Item() {
        return getItem(accent2Material, accent2CustomModelData, accent2Color);
    }

    public Transformation getSteeringWheelTransformation() {
        return new Transformation(
                headTranslation,
                headLeftRotation,
                new Vector3f(1, 1, 1),
                headRightRotation
        );
    }

    public ItemStack getSteeringWheelItem() {
        return getItem(steeringWHeelMaterial, steeringWHeelCustomModelData, steeringWHeelColor);
    }
}
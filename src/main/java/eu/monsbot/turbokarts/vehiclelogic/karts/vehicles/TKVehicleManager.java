package eu.monsbot.turbokarts.vehiclelogic.karts.vehicles;

import org.bukkit.Location;
import org.bukkit.entity.Interaction;
import org.bukkit.entity.ItemDisplay;

public class TKVehicleManager {
    public void summonVehicle(AbstractTKVehicle vehicleModel, Location location) {
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

        Interaction mainEntity = location.getWorld().createEntity(location, Interaction.class);
        mainEntity.getScoreboardTags().add("VEHICLE");
        mainEntity.getScoreboardTags().add("VEHICLE_CORE");
        mainEntity.getScoreboardTags().add("V" + mainEntity.getUniqueId());

            ItemDisplay basePrimary = location.getWorld().createEntity(location, ItemDisplay.class);
        mainEntity.addPassenger(basePrimary);
            basePrimary.getScoreboardTags().add("VEHICLE");
            basePrimary.getScoreboardTags().add("BODY");
            basePrimary.setTransformation(vehicleModel.getBasePrimaryTransformation());
            basePrimary.setItemStack(vehicleModel.getBasePrimaryItem());

                ItemDisplay baseAccent1 = location.getWorld().createEntity(location, ItemDisplay.class);
        basePrimary.addPassenger(baseAccent1);
                baseAccent1.getScoreboardTags().add("VEHICLE");
                baseAccent1.getScoreboardTags().add("ACCENT");
                baseAccent1.getScoreboardTags().add("ACCENT_1");
                baseAccent1.setTransformation(vehicleModel.getBaseAccent1Transformation());
                baseAccent1.setItemStack(vehicleModel.getBaseAccent1Item());

                ItemDisplay baseAccent2 = location.getWorld().createEntity(location, ItemDisplay.class);
        basePrimary.addPassenger(baseAccent2);
                baseAccent2.getScoreboardTags().add("VEHICLE");
                baseAccent2.getScoreboardTags().add("ACCENT");
                baseAccent2.getScoreboardTags().add("ACCENT_2");
                baseAccent2.setTransformation(vehicleModel.getBaseAccent2Transformation());
                baseAccent2.setItemStack(vehicleModel.getBaseAccent2Item());


            ItemDisplay steeringWheel = location.getWorld().createEntity(location, ItemDisplay.class);
        mainEntity.addPassenger(steeringWheel);
            steeringWheel.getScoreboardTags().add("VEHICLE");
            steeringWheel.getScoreboardTags().add("STEERING_WHEEL");
            steeringWheel.getScoreboardTags().add("STEER");
            steeringWheel.setTransformation(vehicleModel.getSteeringWheelTransformation());
            steeringWheel.setItemStack(vehicleModel.getSteeringWheelItem());



    }

}
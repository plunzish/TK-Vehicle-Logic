package eu.monsbot.turbokarts.vehiclelogic.kartManagement;

import java.math.BigInteger;

public class EntityManager {

    public EntityManager() {
        /*
        * identify all carts already present
        * how do you identify a kart? everything with the tag "VEHICLE_CORE" and it's passengers
        * what even is a kart?
        * this is a kart in game:
        * [entities]                [tags]
        * - interaction             VEHICLE, VEHICLE_CORE, V+UUID
        * |- player                 RIDER
        * |- body base              VEHICLE, BODY
        * |  |- body accent 1       VEHICLE, ACCENT, A1
        * |  |- body accent 2       VEHICLE, ACCENT, A2
        * |- steering wheel         VEHICLE, STEERING_WHEEL, STEER
        * |  |- wheel 1 (front)     VEHICLE, WHEEL, LEFT, STEER
        * |  |- wheel 2 (front)     VEHICLE, WHEEL, RIGHT, STEER
        * |  |- wheel 3             VEHICLE, WHEEL, LEFT
        * |  |- wheel 4             VEHICLE, WHEEL, RIGHT
        * |- dummy-head             DUMMY, HEAD
        * |  |- d-body              DUMMY, BODY
        * |  |- d-arm               DUMMY, ARM, LEFT
        * |  |- d-arm               DUMMY, ARM, RIGHT
        * |  |- d-leg               DUMMY, LEG, LEFT
        * |  |- d-leg               DUMMY, LEG, RIGHT
        *
        *  The json needed to write down a vehicle:
        * [ physics ]
        *  - max speed
        *  - acceleration
        *  - mass
        *  - hitbox
        *  - handling
        *  - grip
        * [ visual ]
        *  - array for the values for the body displays
        *  - dummy pose
        *  - wheel item display properties
        *  - wheel position
        *  - wheel rotation direction & axis (Vector)
        *  - steering wheel position
        *  -
        * */
    }



}

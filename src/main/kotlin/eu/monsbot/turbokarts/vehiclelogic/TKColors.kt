package eu.monsbot.turbokarts.vehiclelogic

import net.kyori.adventure.text.format.TextColor

object TKColors {
    var RED_INT: Int = 0xff5555
    var GRAY_INT: Int = 0x555555
    var LIGHT_GRAY_INT: Int = 0xaaaaaa

    var RED: TextColor = TextColor.color(RED_INT)
    var GRAY: TextColor = TextColor.color(GRAY_INT)
    var LIGHT_GRAY: TextColor = TextColor.color(LIGHT_GRAY_INT)
}

package com.codelab.compose

import java.util.*

enum class LabelPosition (val value: Int) {
    START(0),
    END(1),
    ABOVE(2),
    BELOW(3),

    ;companion object {
        @JvmOverloads
        @JvmStatic
        fun fromValue(type: Int, default: LabelPosition? = null) = when (type) {
            0 -> START
            1 -> END
            2 -> ABOVE
            3 -> BELOW
            else -> null
        } ?: default ?: START

        @JvmOverloads
        @JvmStatic
        fun fromValue(type: String, default: LabelPosition? = null): LabelPosition {
            return try { valueOf(type.uppercase(Locale.ENGLISH)) } catch (t: Throwable) { null } ?: default ?: START
        }
    }
}
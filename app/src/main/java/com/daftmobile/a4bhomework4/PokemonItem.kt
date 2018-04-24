package com.daftmobile.a4bhomework4

import android.support.annotation.ColorInt
import java.io.Serializable

data class PokemonItem(val name: String, val number: String, @ColorInt val color: Int): Serializable

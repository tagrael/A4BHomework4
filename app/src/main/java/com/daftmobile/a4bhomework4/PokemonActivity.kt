package com.daftmobile.a4bhomework4

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pokemon.*

class PokemonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon)

        val pokemon = intent.getSerializableExtra("pokeItem") as PokemonItem

        nameView.setText(pokemon.name)
        numberView.setText(pokemon.number)
        colorView.setBackgroundColor(pokemon.color)

    }
}

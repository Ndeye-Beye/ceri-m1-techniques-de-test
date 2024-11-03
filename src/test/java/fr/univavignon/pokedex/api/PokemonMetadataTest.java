package fr.univavignon.pokedex.api;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonMetadataTest {
    @Test
    public void testPokemonMetadata() {
        // Crée une instance de PokemonMetadata avec des valeurs d'exemple
        int index = 1;
        String name = "Bulbasaur";
        int attack = 126;
        int defense = 126;
        int stamina = 90;

        PokemonMetadata metadata = new PokemonMetadata(index, name, attack, defense, stamina);

        // Vérifie que les valeurs sont correctement assignées
        assertEquals(index, metadata.getIndex());
        assertEquals(name, metadata.getName());
        assertEquals(attack, metadata.getAttack());
        assertEquals(defense, metadata.getDefense());
        assertEquals(stamina, metadata.getStamina());
    }
}

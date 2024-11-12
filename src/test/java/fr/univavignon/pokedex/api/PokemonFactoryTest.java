package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PokemonFactoryTest {

    private PokemonFactory factory;
    private IPokemonMetadataProvider metadataProvider;

    @BeforeEach
    public void setUp() {
        // Mock du provider de métadonnées
        metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        factory = new PokemonFactory(metadataProvider);
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        // Données de métadonnées pour Bulbasaur
        int index = 0;
        String name = "Bulbasaur";
        int attack = 49;
        int defense = 49;
        int stamina = 45;
        int cp = 500;
        int hp = 60;
        int dust = 3000;
        int candy = 3;

        // Configuration du mock pour retourner des métadonnées
        when(metadataProvider.getPokemonMetadata(index)).thenReturn(new PokemonMetadata(index, name, attack, defense, stamina));

        // Création du Pokémon
        Pokemon pokemon = factory.createPokemon(index, cp, hp, dust, candy);

        // Vérification des valeurs du Pokémon créé
        assertEquals(index, pokemon.getIndex());
        assertEquals(name, pokemon.getName());
        assertEquals(attack, pokemon.getAttack());
        assertEquals(defense, pokemon.getDefense());
        assertEquals(stamina, pokemon.getStamina());
        assertEquals(cp, pokemon.getCp());
        assertEquals(hp, pokemon.getHp());
        assertEquals(dust, pokemon.getDust());
        assertEquals(candy, pokemon.getCandy());

        // Vérification de la valeur IV (calculée comme moyenne)
        double expectedIv = (attack + defense + stamina) / 3.0;
        assertEquals(expectedIv, pokemon.getIv(), 0.001);  // Tolérance de 0.001 pour le calcul en double
    }
    @Test
    public void testCalculateIv() throws PokedexException {
        double iv = factory.calculateIv(126, 126, 90);
        assertEquals(114.0, iv);
    }

}

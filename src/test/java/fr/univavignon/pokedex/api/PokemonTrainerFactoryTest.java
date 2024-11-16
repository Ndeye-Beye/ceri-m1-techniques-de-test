package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class PokemonTrainerFactoryTest {
    PokemonTrainerFactory pokemonTrainerFactory;
    IPokedexFactory pokedexFactory;
    IPokedex pokedex;


    @BeforeEach
    public void setUp(){
        pokemonTrainerFactory = new PokemonTrainerFactory();
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
        IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(PokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);
        pokedex = Mockito.mock(IPokedex.class);

        Mockito.when(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory)).thenReturn(pokedex);
    }






    @Test
    public void testCreateTrainer(){
        PokemonTrainer pokemonTrainer = new PokemonTrainer("Ndeye", Team.MYSTIC, pokedex);
        assertNotNull(pokemonTrainer);
        assertEquals("Ndeye", pokemonTrainer.getName());
        assertEquals(Team.MYSTIC, pokemonTrainer.getTeam());
        assertEquals(pokedex, pokemonTrainer.getPokedex());

    }
}

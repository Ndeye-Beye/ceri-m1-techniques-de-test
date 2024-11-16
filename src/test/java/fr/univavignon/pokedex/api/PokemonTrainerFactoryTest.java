package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PokemonTrainerFactoryTest {
    PokemonTrainerFactory pokemonTrainerFactory;
    IPokedexFactory pokedexFactory;
    IPokedex pokedex;


    @BeforeEach
    public void setUp(){
        pokemonTrainerFactory = new PokemonTrainerFactory();
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
        pokedex = Mockito.mock(IPokedex.class);

        IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(PokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);


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

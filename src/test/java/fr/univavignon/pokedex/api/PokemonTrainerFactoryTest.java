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
        pokedex = Mockito.mock(IPokedex.class);

        IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);

        //when(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory)).thenReturn(pokedex);
        when(pokedexFactory.createPokedex(Mockito.any(IPokemonMetadataProvider.class), Mockito.any(IPokemonFactory.class))).thenReturn(pokedex);


    }



    /*@Test
    public void testCreateTrainer(){
        PokemonTrainer pokemonTrainer = pokemonTrainerFactory.createTrainer("Ndeye", Team.MYSTIC, pokedexFactory);
        assertNotNull(pokemonTrainer);
        assertEquals("Ndeye", pokemonTrainer.getName());
        assertEquals(Team.MYSTIC, pokemonTrainer.getTeam());
        assertEquals(pokedex, pokemonTrainer.getPokedex());

    }*/

    @Test
    public void testCreateTrainer() {
        // Appeler la méthode à tester
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("Ndeye", Team.MYSTIC, pokedexFactory);

        // Vérifications
        assertNotNull(trainer, "Trainer should not be null.");
        assertEquals("Ndeye", trainer.getName(), "Trainer's name should be Ndeye.");
        assertEquals(Team.MYSTIC, trainer.getTeam(), "Trainer's team should be MYSTIC.");
        assertEquals(pokedex, trainer.getPokedex(), "Trainer's pokedex should match the mocked pokedex.");
    }



}

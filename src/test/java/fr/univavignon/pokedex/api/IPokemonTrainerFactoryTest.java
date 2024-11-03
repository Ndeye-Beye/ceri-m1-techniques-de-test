package fr.univavignon.pokedex.api;



import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {
    IPokemonTrainerFactory pokemonTrainerFactory;
    IPokedexFactory pokedexFactory;
    IPokedex pokedex;
    PokemonTrainer mystic;
    PokemonTrainer instinct;
    PokemonTrainer valor;

    @BeforeEach
    public void setUp(){
        pokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
        pokedex = Mockito.mock(IPokedex.class);

        mystic = new PokemonTrainer("mystic", Team.MYSTIC, pokedex);
        instinct = new PokemonTrainer("instinct", Team.INSTINCT, pokedex);
        valor = new PokemonTrainer("valor", Team.VALOR, pokedex);

        when(pokemonTrainerFactory.createTrainer("mystic", Team.MYSTIC,pokedexFactory)).thenReturn(mystic);
        when(pokemonTrainerFactory.createTrainer("instinct", Team.INSTINCT,pokedexFactory)).thenReturn(instinct);
        when(pokemonTrainerFactory.createTrainer("valor", Team.VALOR,pokedexFactory)).thenReturn(valor);


    }

    @Test
    public void testCreateTrainer(){
        PokemonTrainer createMystic = pokemonTrainerFactory.createTrainer("mystic", Team.MYSTIC,pokedexFactory);

        assertNotNull(createMystic);
        assertEquals("mystic", createMystic.getName());
        assertEquals(Team.MYSTIC, createMystic.getTeam());
        assertEquals(pokedex, createMystic.getPokedex());

        PokemonTrainer createInstinct = pokemonTrainerFactory.createTrainer("instinct", Team.INSTINCT,pokedexFactory);

        assertNotNull(createInstinct);
        assertEquals("instinct", createInstinct.getName());
        assertEquals(Team.INSTINCT, createInstinct.getTeam());
        assertEquals(pokedex, createInstinct.getPokedex());

        PokemonTrainer createValor = pokemonTrainerFactory.createTrainer("valor", Team.VALOR,pokedexFactory);

        assertNotNull(createValor);
        assertEquals("valor", createValor.getName());
        assertEquals(Team.VALOR, createValor.getTeam());
        assertEquals(pokedex, createValor.getPokedex());
    }

}

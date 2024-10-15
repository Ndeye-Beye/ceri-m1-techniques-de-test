package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {
    IPokemonFactory pokemonFactory;

    @Before
    public void setUp(){
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
        when(pokemonFactory.createPokemon(0,613,64,4000,4)).thenReturn(new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56));
        when(pokemonFactory.createPokemon(133,2729,202,5000,4)).thenReturn(new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100));
    }

    @Test
    public void createPokemon(){
        Pokemon pokemonExample1 = pokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals(pokemonExample1.getIndex(),0);
        assertEquals(pokemonExample1.getCp(),613);
        assertEquals(pokemonExample1.getHp(),64);
        assertEquals(pokemonExample1.getDust(),4000);
        assertEquals(pokemonExample1.getCandy(),4);

        Pokemon pokemonExample2 = pokemonFactory.createPokemon(133,2729,202,5000,4);
        assertEquals(pokemonExample2.getIndex(),133);
        assertEquals(pokemonExample2.getCp(),2729);
        assertEquals(pokemonExample2.getHp(),202);
        assertEquals(pokemonExample2.getDust(),5000);
        assertEquals(pokemonExample2.getCandy(),4);
    }
}

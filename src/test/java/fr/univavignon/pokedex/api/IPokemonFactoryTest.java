package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {
    IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setUp(){
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
        when(pokemonFactory.createPokemon(0,613,64,4000,4)).thenReturn(new Pokemon(0,"Bulbizarre",126,126,90,613,64,4000,4,56));
        when(pokemonFactory.createPokemon(133,2729,202,5000,4)).thenReturn(new Pokemon(133,"Aquali",186,168,260,2729,202,5000,4,100));
    }

    @Test
    public void createPokemon(){
        Pokemon pokemon = pokemonFactory.createPokemon(0,613,64,4000,4);
        assertEquals(pokemon.getIndex(),0);
        assertEquals(pokemon.getCp(),613);
        assertEquals(pokemon.getHp(),64);
        assertEquals(pokemon.getDust(),4000);
        assertEquals(pokemon.getCandy(),4);

        pokemon = pokemonFactory.createPokemon(133,2729,202,5000,4);
        assertEquals(pokemon.getIndex(),133);
        assertEquals(pokemon.getCp(),2729);
        assertEquals(pokemon.getHp(),202);
        assertEquals(pokemon.getDust(),5000);
        assertEquals(pokemon.getCandy(),4);
    }
}

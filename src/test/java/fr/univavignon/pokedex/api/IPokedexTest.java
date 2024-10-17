package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class IPokedexTest {
    IPokedex pokedex;
    Pokemon pokemonExample1 = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);
    Pokemon pokemonExample2 = new Pokemon(133, "Aquali", 186,168,260,2729,202,5000,4,100);

    @Before
    public void setUp() throws PokedexException {
        pokedex = Mockito.mock(IPokedex.class);



        when(pokedex.size()).thenReturn(2);

        when(pokedex.getPokemon(0)).thenReturn(pokemonExample1);
        when(pokedex.getPokemon(133)).thenReturn(pokemonExample2);

        when(pokedex.addPokemon(pokemonExample1)).thenReturn(0);
        when(pokedex.addPokemon(pokemonExample2)).thenReturn(133);

        when(pokedex.getPokemons()).thenReturn(Arrays.asList(pokemonExample1,pokemonExample2));

        when(pokedex.getPokemons(any(Comparator.class))).thenAnswer(invocationOnMock -> {
            Comparator<Pokemon> comparator = invocationOnMock.getArgument(0);
            List<Pokemon> pokemons = Arrays.asList(pokemonExample1,pokemonExample2);
            pokemons.sort(comparator);
            return pokemons;
        });

        
    }

    @Test
    public void TestAddPokemon(){


        int indexPokemonExample1 = pokedex.addPokemon(pokemonExample1);
        int indexPokemonExample2 = pokedex.addPokemon(pokemonExample2);

        assertEquals(0, indexPokemonExample1);
        assertEquals(133, indexPokemonExample2);

        assertEquals(2, pokedex.size());
        
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        assertEquals(pokedex.getPokemon(0), pokemonExample1);
        assertEquals(pokedex.getPokemon(133), pokemonExample2);
    }

    @Test
    public void testGetPokemons(){
        assertNotNull(pokedex.getPokemons());
        assertEquals(2,pokedex.size());
        assertTrue(pokedex.getPokemons().contains(pokemonExample1));
        assertTrue(pokedex.getPokemons().contains(pokemonExample2));
    }

    @Test
    public void testGetPokemonsSortedByName(){
        List<Pokemon> sortedByName = pokedex.getPokemons(Comparator.comparing(Pokemon::getName));

        assertEquals("Aquali", sortedByName.get(0).getName());
        assertEquals("Bulbizarre", sortedByName.get(1).getName());

    }

    @Test
    public void testGetPokemonsSortedByCp(){
        List<Pokemon> sortedByCp = pokedex.getPokemons(Comparator.comparing(Pokemon::getCp));

        assertEquals(pokemonExample1.getCp(), sortedByCp.get(0).getCp());
        assertEquals(pokemonExample2.getCp(), sortedByCp.get(1).getCp());

    }

}

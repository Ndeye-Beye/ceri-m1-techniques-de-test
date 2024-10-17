package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class IPokedexTest {
    IPokedex pokedex;
    IPokemonMetadataProvider pokemonMetadataProvider;
    IPokemonFactory pokemonFactory;
    Pokemon pokemonExample1;
    Pokemon pokemonExample2;

    @Before
    public void setUp() throws PokedexException {
        pokedex = Mockito.mock(IPokedex.class);
        pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        pokemonFactory = Mockito.mock(IPokemonFactory.class);

        pokemonExample1 = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);
        pokemonExample2 = new Pokemon(133, "Aquali", 186,168,260,2729,202,5000,4,100);

        when(pokedex.size()).thenReturn(2);
        when(pokedex.getPokemon(0)).thenReturn(pokemonExample1);
        when(pokedex.getPokemon(1)).thenReturn(pokemonExample2);
        when(pokedex.getPokemons()).thenReturn(Arrays.asList(pokemonExample1,pokemonExample2));
        
    }

    @Test

    public void TestAddPokemon(){
        pokemonExample1 = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);
        pokemonExample2 = new Pokemon(133, "Aquali", 186,168,260,2729,202,5000,4,100);
        when(pokedex.addPokemon(pokemonExample1)).thenReturn(0);
        when(pokedex.addPokemon(pokemonExample2)).thenReturn(1);
        int indexPokemonExample1 = pokedex.addPokemon(pokemonExample1);
        int indexPokemonExample2 = pokedex.addPokemon(pokemonExample2);

        assertEquals(0, indexPokemonExample1);
        assertEquals(1, indexPokemonExample2);

        assertEquals(2, pokedex.size());
        
    }
}

package fr.univavignon.pokedex.api;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {
    IPokemonMetadataProvider pokemonMetadataProvider;

    @Before
    public void setUp() throws PokedexException {
        pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0,"bulbizarre",126,126,90));
        when(pokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(new PokemonMetadata(133,"Aquali",186, 168,260));
    }

    @Test
    public void getPokemonMetadata() throws PokedexException {
        PokemonMetadata metadataExample1 = pokemonMetadataProvider.getPokemonMetadata(0);
        assertEquals(metadataExample1.getIndex(), 0);
        assertEquals(metadataExample1.getName(), "bulbizarre");
        assertEquals(metadataExample1.getAttack(), 126);
        assertEquals(metadataExample1.getDefense(),126);
        assertEquals(metadataExample1.getStamina(),90);

        PokemonMetadata metadataExample2 = pokemonMetadataProvider.getPokemonMetadata(133);
        assertEquals(metadataExample2.getIndex(), 133);
        assertEquals(metadataExample2.getName(), "Aquali");
        assertEquals(metadataExample2.getAttack(), 186);
        assertEquals(metadataExample2.getDefense(),168);
        assertEquals(metadataExample2.getStamina(),260);

    }


}

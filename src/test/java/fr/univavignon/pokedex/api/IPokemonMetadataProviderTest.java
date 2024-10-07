package fr.univavignon.pokedex.api;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {
    IPokemonMetadataProvider pokemonMetadataProvider;

    @Before
    public void setUp() throws PokedexException {
        pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0,"bulbizarre",126,126,90));
        System.out.println(pokemonMetadataProvider.getPokemonMetadata(0));
        when(pokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(new PokemonMetadata(133,"Aquali",186, 168,260));
        System.out.println(pokemonMetadataProvider.getPokemonMetadata(133));
    }

    @Test
    public void getPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = pokemonMetadataProvider.getPokemonMetadata(0);
        assertEquals(metadata.getIndex(), 0);
        assertEquals(metadata.getName(), "bulbizarre");
        assertEquals(metadata.getAttack(), 126);
        assertEquals(metadata.getDefense(),126);
        assertEquals(metadata.getStamina(),90);

    }


}

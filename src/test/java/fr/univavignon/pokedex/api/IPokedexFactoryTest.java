package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {
    IPokedexFactory pokedexFactory;
    IPokemonMetadataProvider metadataProvider;
    IPokemonFactory pokemonFactory;
    IPokedex pokedex;

    @Before
    public void setUp(){
        pokedexFactory = Mockito.mock(IPokedexFactory.class);
        metadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        pokemonFactory = Mockito.mock(IPokemonFactory.class);
        pokedex = Mockito.mock(IPokedex.class);


        when(pokedexFactory.createPokedex(metadataProvider,pokemonFactory)).thenReturn(pokedex);


    }
    @Test
    public void testCreatePokedex() throws PokedexException {
        IPokedex createPokedex = pokedexFactory.createPokedex(metadataProvider,pokemonFactory);
        assertNotNull(createPokedex);
        assertEquals(pokedex, createPokedex);
        verify(pokedexFactory).createPokedex(metadataProvider,pokemonFactory);
    }

}

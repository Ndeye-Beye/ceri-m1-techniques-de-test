package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

/**
 * Classe de test pour PokedexFactory.
 */
public class PokedexFactoryTest {

    private PokedexFactory factory;
    private IPokemonMetadataProvider metadataProvider;
    private IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setUp() {
        // Initialisation de PokedexFactory et de ses dépendances
        factory = new PokedexFactory();
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokedex() {
        IPokedex pokedex = factory.createPokedex(metadataProvider, pokemonFactory);

        assertNotNull(pokedex);
        //assertEquals();
    }
}

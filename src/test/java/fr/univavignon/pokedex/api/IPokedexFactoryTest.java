package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class IPokedexFactoryTest {
    IPokedexFactory pokedexFactory;
    IPokemonMetadataProvider metadataProvider;
    IPokemonFactory pokemonFactory;
    IPokedex pokedex;

    /**
     * Prépare les mocks pour les tests.
     * - Mocke les dépendances nécessaires : IPokedexFactory, IPokemonMetadataProvider, IPokemonFactory, et IPokedex.
     * - Configure le comportement attendu pour la méthode createPokedex.
     */

    @Before
    public void setUp(){
        pokedexFactory = mock(IPokedexFactory.class);
        metadataProvider = mock(IPokemonMetadataProvider.class);
        pokemonFactory = mock(IPokemonFactory.class);
        pokedex = mock(IPokedex.class);


        when(pokedexFactory.createPokedex(metadataProvider,pokemonFactory)).thenReturn(pokedex);


    }

    /**
     * Teste que la méthode createPokedex de IPokedexFactory retourne une instance non nulle et correcte.
     * - Vérifie que l'objet retourné est égal au mock attendu.
     * - Vérifie que la méthode a été appelée avec les bons paramètres.
     *
     * @throws PokedexException si une erreur survient (exception simulée dans un autre test possible).
     */
    @Test
    public void testCreatePokedex() throws PokedexException {
        // Configurer le mock pour lancer une exception
        IPokedex createPokedex = pokedexFactory.createPokedex(metadataProvider,pokemonFactory);
        assertNotNull(createPokedex);
        assertEquals(pokedex, createPokedex);
        // Appeler la méthode pour vérifier le comportement
        verify(pokedexFactory).createPokedex(metadataProvider,pokemonFactory);

    }



}

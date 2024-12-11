package fr.univavignon.pokedex.api;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {
    IPokemonMetadataProvider pokemonMetadataProvider;

    @Before
    public void setUp() throws PokedexException {
        pokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0,"bulbizarre",126,126,90));
        when(pokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(new PokemonMetadata(133,"Aquali",186, 168,260));
    }


    /**
     * Teste que getPokemonMetadata retourne les bonnes métadonnées
     * pour des indices valides.
     *
     * @throws PokedexException si une erreur se produit
     */
    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = pokemonMetadataProvider.getPokemonMetadata(0);
        assertEquals(metadata.getIndex(), 0);
        assertEquals(metadata.getName(), "bulbizarre");
        assertEquals(metadata.getAttack(), 126);
        assertEquals(metadata.getDefense(),126);
        assertEquals(metadata.getStamina(),90);

        metadata = pokemonMetadataProvider.getPokemonMetadata(133);
        assertEquals(metadata.getIndex(), 133);
        assertEquals(metadata.getName(), "Aquali");
        assertEquals(metadata.getAttack(), 186);
        assertEquals(metadata.getDefense(),168);
        assertEquals(metadata.getStamina(),260);
    }

    @Test
    public void testGetPokemonMetadataInvalidIndex(){
        // Configurer le comportement pour un index invalide
        try{
            when(pokemonMetadataProvider.getPokemonMetadata(-1)).thenThrow(new PokedexException("Invalid Index"));
        }catch (PokedexException e){
            e.getMessage();
        }
        // Vérifier que l'exception est bien levée
        assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(-1));
    }







}

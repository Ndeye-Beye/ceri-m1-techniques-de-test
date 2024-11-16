package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de test pour PokemonMetadataProvider.
 */
public class PokemonMetadataProviderTest {

    private PokemonMetadataProvider provider;

    @BeforeEach
    public void setUp() {
        List<PokemonMetadata> metadataList = new ArrayList<>();
        metadataList.add(new PokemonMetadata(0, "Bulbizarre", 49, 49, 45));
        metadataList.add(new PokemonMetadata(1, "Ivysaur", 62, 63, 60));
        metadataList.add(new PokemonMetadata(2, "Venusaur", 82, 83, 80));

        provider = new PokemonMetadataProvider(metadataList);
    }

    @Test
    public void testGetPokemonMetadataValidIndex() throws PokedexException {
        // Test avec un index valide, ici 0 pour Bulbasaur
        PokemonMetadata metadata = provider.getPokemonMetadata(0);


        assertEquals(0, metadata.getIndex());
        assertEquals("Bulbizarre", metadata.getName());
        assertEquals(49, metadata.getAttack());
        assertEquals(49, metadata.getDefense());
        assertEquals(45, metadata.getStamina());
    }


}

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
        // Initialisation de la liste de métadonnées pour les tests
        List<PokemonMetadata> metadataList = new ArrayList<>();
        metadataList.add(new PokemonMetadata(0, "Bulbasaur", 49, 49, 45));
        metadataList.add(new PokemonMetadata(1, "Ivysaur", 62, 63, 60));
        metadataList.add(new PokemonMetadata(2, "Venusaur", 82, 83, 80));

        // Initialisation du provider avec la liste
        provider = new PokemonMetadataProvider(metadataList);
    }

    @Test
    public void testGetPokemonMetadataValidIndex() throws PokedexException {
        // Test avec un index valide, ici 0 pour Bulbasaur
        PokemonMetadata metadata = provider.getPokemonMetadata(0);

        // Vérification des valeurs de Bulbasaur
        assertEquals(0, metadata.getIndex());
        assertEquals("Bulbasaur", metadata.getName());
        assertEquals(49, metadata.getAttack());
        assertEquals(49, metadata.getDefense());
        assertEquals(45, metadata.getStamina());
    }

    /*@Test
    public void testGetPokemonMetadataInvalidIndex() throws PokedexException {
        // Test avec un index invalide, devrait lancer une PokedexException
        provider.getPokemonMetadata(999);  // Index hors de portée
    }

    @Test
    public void testGetPokemonMetadataNegativeIndex() throws PokedexException {
        // Test avec un index négatif, devrait également lancer une PokedexException
        provider.getPokemonMetadata(-1);
    }*/
}

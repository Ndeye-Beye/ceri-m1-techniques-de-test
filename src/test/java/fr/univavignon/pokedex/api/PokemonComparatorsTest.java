package fr.univavignon.pokedex.api;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PokemonComparatorsTest {
    @Test
    public void testNameComparatorWithMocks() {
        // Crée deux mocks de Pokemon
        Pokemon pokemon1 = mock(Pokemon.class);
        Pokemon pokemon2 = mock(Pokemon.class);

        // Définit les valeurs retournées par getName()
        when(pokemon1.getName()).thenReturn("Bulbizarre");
        when(pokemon2.getName()).thenReturn("Aquali");

        // Test du comparateur NAME
        assertTrue(PokemonComparators.NAME.compare(pokemon1, pokemon2) > 0,
                "Bulbizarre devrait être après Aquali par le nom");
        assertTrue(PokemonComparators.NAME.compare(pokemon2, pokemon1) < 0,
                "Aquali devrait être avant Bulbizarre par le nom");
        assertTrue(PokemonComparators.NAME.compare(pokemon1, pokemon1) == 0,
                "Un Pokémon devrait être égal à lui-même par le nom");
    }

    @Test
    public void testIndexComparatorWithMocks() {
        Pokemon pokemon1 = mock(Pokemon.class);
        Pokemon pokemon2 = mock(Pokemon.class);

        when(pokemon1.getIndex()).thenReturn(1);
        when(pokemon2.getIndex()).thenReturn(133);

        // Test du comparateur INDEX
        assertTrue(PokemonComparators.INDEX.compare(pokemon1, pokemon2) < 0,
                "Index de Bulbizarre devrait être inférieur à celui d'Aquali");
        assertTrue(PokemonComparators.INDEX.compare(pokemon2, pokemon1) > 0,
                "Index d'Aquali devrait être supérieur à celui de Bulbizarre");
        assertTrue(PokemonComparators.INDEX.compare(pokemon1, pokemon1) == 0,
                "Un Pokémon devrait être égal à lui-même par l'index");
    }

    @Test
    public void testCpComparatorWithMocks() {
        Pokemon pokemon1 = mock(Pokemon.class);
        Pokemon pokemon2 = mock(Pokemon.class);

        when(pokemon1.getCp()).thenReturn(613);
        when(pokemon2.getCp()).thenReturn(2729);

        // Test du comparateur CP
        assertTrue(PokemonComparators.CP.compare(pokemon1, pokemon2) < 0,
                "CP de Bulbizarre devrait être inférieur à celui d'Aquali");
        assertTrue(PokemonComparators.CP.compare(pokemon2, pokemon1) > 0,
                "CP d'Aquali devrait être supérieur à celui de Bulbizarre");
        assertTrue(PokemonComparators.CP.compare(pokemon1, pokemon1) == 0,
                "Un Pokémon devrait être égal à lui-même par les CP");
    }
}

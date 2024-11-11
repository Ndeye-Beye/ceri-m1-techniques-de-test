package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.PokedexException;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class PokedexExceptionTest{
    @Test
    public void testExceptionMessage() {
        String message = "Erreur Pokedex";

        PokedexException exception = new PokedexException(message);

        assertEquals(message, exception.getMessage());
    }
}

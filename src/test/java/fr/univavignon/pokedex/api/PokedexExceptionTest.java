package fr.univavignon.pokedex.api;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PokedexExceptionTest {
    @Test
    public void testPokedexException() {
        String errorMessage = "Error in Pokedex";
        PokedexException exception = new PokedexException(errorMessage);

        // Vérifie que le message de l'exception est bien celui passé au constructeur
        assertEquals(errorMessage, exception.getMessage());
    }
}

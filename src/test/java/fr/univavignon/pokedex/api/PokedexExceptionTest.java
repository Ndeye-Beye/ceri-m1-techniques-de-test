package fr.univavignon.pokedex.api;

import fr.univavignon.pokedex.api.PokedexException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PokedexExceptionTest{
    @Test
    public void testExceptionMessage() {
        // Message d'erreur à tester
        String message = "Erreur Pokedex";

        // Crée une instance de l'exception avec le message d'erreur
        PokedexException exception = new PokedexException(message);

        // Vérifie que le message est bien celui passé au constructeur
        assertEquals(message, exception.getMessage());
    }
}

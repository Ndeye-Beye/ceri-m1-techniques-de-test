package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PokemonComparatorsTest {
    @Test
    public void comparePokemonByName(){
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186,168,260,2729,202,5000,4,100);
        Pokemon pokemon3 = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);


        assertEquals(0,PokemonComparators.NAME.compare(pokemon1, pokemon3),"pokemon1 et pokemon3 qui ont le même nom, doit être égaux.");
        assertTrue(PokemonComparators.NAME.compare(pokemon1, pokemon2) > 0, "Bulbizare doit être apres Aquali");
        assertTrue(PokemonComparators.NAME.compare(pokemon2, pokemon1) < 0, "Aquali doit être avant Bulbizarre");
    }
    @Test
    public void comparePokemonByIndex(){
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186,168,260,2729,202,5000,4,100);
        Pokemon pokemon3 = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);

        assertEquals(0, PokemonComparators.INDEX.compare(pokemon1,pokemon3), "les 2 pokémons qui ont le même index doit être égaux");
        assertTrue(PokemonComparators.INDEX.compare(pokemon1, pokemon2)<0,"le pokemon1 avec l'index 0 devrait etre devant le pokemon2 avec l'index 1 ");
        assertTrue(PokemonComparators.INDEX.compare(pokemon2, pokemon1)>0,"le pokemon2 avec l'index 1 devrait etre aprés le pokemon1 avec l'index 0 ");
    }

    @Test
    public void comparePokemonByCp(){
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186,168,260,2729,202,5000,4,100);
        Pokemon pokemon3 = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);

        assertEquals(0, PokemonComparators.CP.compare(pokemon1, pokemon3), "Deux pokémons avec le même Cp devraient être égaux.");
        assertTrue(PokemonComparators.CP.compare(pokemon1, pokemon2)<0, "Le Cp du pokémon1 devrait être avant le Cp du pokémon2, ");
        assertTrue(PokemonComparators.CP.compare(pokemon2, pokemon1)>0, "Le Cp du pokémon1 devrait être aprés le Cp du pokémon2, ");

    }

}
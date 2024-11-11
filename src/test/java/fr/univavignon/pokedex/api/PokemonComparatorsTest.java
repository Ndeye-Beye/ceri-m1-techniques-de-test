package fr.univavignon.pokedex.api;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class PokemonComparatorsTest {
    @Test
    public void comparePokemonByName(){
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186,168,260,2729,202,5000,4,100);


        assertTrue(PokemonComparators.NAME.compare(pokemon1, pokemon2) > 0, "Bulbizare doit être apres Aquali");
    }
    @Test
    public void comparePokemonByIndex(){
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186,168,260,2729,202,5000,4,100);

        assertTrue(PokemonComparators.INDEX.compare(pokemon1, pokemon2)<0,"le pokemon1 avec l'index 0 devrait etre devant le pokemon2 avec l'index 1 ");
    }

    @Test
    public void comparePokemonByCp(){
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186,168,260,2729,202,5000,4,100);

        assertTrue(PokemonComparators.CP.compare(pokemon1, pokemon2)<0, "Le Cp du pokémon1 devrait être avant le Cp du pokémon2, ");

    }

}
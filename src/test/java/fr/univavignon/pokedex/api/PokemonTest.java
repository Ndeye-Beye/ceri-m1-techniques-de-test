package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class PokemonTest {
    @Test
    public void testGetCp(){
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186,168,260,2729,202,5000,4,100);

        assertEquals(613, pokemon1.getCp());
        assertEquals(2729, pokemon2.getCp());


    }
    @Test
    public void testGetHp(){
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186,168,260,2729,202,5000,4,100);

        assertEquals(64, pokemon1.getHp());
        assertEquals(202, pokemon2.getHp());

    }
    @Test
    public void testGetDust(){
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186,168,260,2729,202,5000,4,100);

        assertEquals(4000, pokemon1.getDust());
        assertEquals(5000, pokemon2.getDust());

    }
    @Test
    public void testGetCandy(){
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186,168,260,2729,202,5000,4,100);

        assertEquals(4, pokemon1.getCandy());
        assertEquals(4, pokemon2.getCandy());

    }@Test
    public void testGetIv(){
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56.0);
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186,168,260,2729,202,5000,4,100);

        assertEquals(56, pokemon1.getIv());
        assertEquals(100, pokemon2.getIv());

    }
}

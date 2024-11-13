package fr.univavignon.pokedex.api;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.Comparator;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class PokedexTest {
    IPokemonMetadataProvider pokemonMetadataProvider;
    IPokemonFactory pokemonFactory;
    Pokedex pokedex;

    @BeforeEach
    public void setUp() throws PokedexException {
        pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
        pokemonFactory = Mockito.mock(IPokemonFactory.class);

        pokedex = new Pokedex(pokemonMetadataProvider, pokemonFactory);

        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);

        PokemonMetadata bulbizarreMetadata = new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(bulbizarreMetadata);
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(pokemon1);

    }

    @Test
    public void testSize() {
        assertEquals(0, pokedex.size());
        pokedex.addPokemon(new Pokemon(0, "Bulbasaur", 49, 49, 45, 500, 60, 3000, 3, 0.8));
        assertEquals(1, pokedex.size());
    }

    @Test
    public void TestAddPokemon(){
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186,168,260,2729,202,5000,4,100);


        int indexPokemonExample1 = pokedex.addPokemon(pokemon1);
        int indexPokemonExample2 = pokedex.addPokemon(pokemon2);

        assertEquals(0, indexPokemonExample1);
        assertEquals(1, indexPokemonExample2);

        assertEquals(2, pokedex.size());

    }

   @Test
    public void testGetPokemon() throws PokedexException {
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186,168,260,2729,202,5000,4,100);

        int indexPokemon1 = pokedex.addPokemon(pokemon1);
        int indexPokemon2 = pokedex.addPokemon(pokemon2);
        assertEquals(pokemon1,pokedex.getPokemon(indexPokemon1));
        assertEquals(pokemon2,pokedex.getPokemon(indexPokemon2));
    }

    @Test
    public void testGetPokemons(){
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186,168,260,2729,202,5000,4,100);

        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);
        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(2, pokemons.size());
        assertEquals(pokemon1, pokemons.get(0));
        assertEquals(pokemon2, pokemons.get(1));
    }
    @Test
    public void testGetPokemonsSortedByName(){
        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186,168,260,2729,202,5000,4,100);

        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);
        List<Pokemon> sortedByName = pokedex.getPokemons(Comparator.comparing(Pokemon::getName));

        assertEquals(2, sortedByName.size());
        assertEquals(pokemon2.getName(), sortedByName.get(0).getName());
        assertEquals(pokemon1.getName(), sortedByName.get(1).getName());

    }

    @Test
    public void testGetPokemonsSortedByCp(){

        Pokemon pokemon1 = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);
        Pokemon pokemon2 = new Pokemon(133, "Aquali", 186,168,260,2729,202,5000,4,100);

        pokedex.addPokemon(pokemon1);
        pokedex.addPokemon(pokemon2);
        List<Pokemon> sortedByCp = pokedex.getPokemons(Comparator.comparing(Pokemon::getCp));

        assertEquals(2, sortedByCp.size());
        assertEquals(pokemon1.getCp(), sortedByCp.get(0).getCp());
        assertEquals(pokemon2.getCp(), sortedByCp.get(1).getCp());

    }

    @Test
    public void testCreatePokemon() throws PokedexException {

        Pokemon createPokemon = pokedex.createPokemon(0, 613, 64, 4000, 4);

        assertEquals(0, createPokemon.getIndex());

        assertEquals(613, createPokemon.getCp());
        assertEquals(64, createPokemon.getHp());
        assertEquals(4000, createPokemon.getDust());
        assertEquals(4, createPokemon.getCandy());
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata metadata = pokedex.getPokemonMetadata(0);

        assertEquals(0, metadata.getIndex());
        assertEquals("Bulbizarre", metadata.getName());
        assertEquals(126, metadata.getAttack());
        assertEquals(126, metadata.getDefense());
        assertEquals(90, metadata.getStamina());


    }



}

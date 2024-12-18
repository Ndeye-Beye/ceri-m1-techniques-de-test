package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RocketPokemonFactoryTest {

	@Test
	public void testCreatePokemonValidIndex() throws PokedexException {
		IPokemonFactory factory = new RocketPokemonFactory();
		Pokemon pokemon = factory.createPokemon(1, 500, 60, 1000, 50);

		assertEquals("Bulbasaur", pokemon.getName());
		assertTrue(pokemon.getAttack() >= 0 && pokemon.getAttack() <= 1000);
		assertTrue(pokemon.getDefense() >= 0 && pokemon.getDefense() <= 1000);
		assertTrue(pokemon.getStamina() >= 0 && pokemon.getStamina() <= 1000);
	}

	@Test
	public void testCreatePokemonUnknownIndex() throws PokedexException {
		IPokemonFactory factory = new RocketPokemonFactory();
		Pokemon pokemon = factory.createPokemon(999, 500, 60, 1000, 50);

		assertEquals("MISSINGNO", pokemon.getName());
	}


	@Test
	public void testCreatePokemonNegativeIndex() throws PokedexException {
		IPokemonFactory factory = new RocketPokemonFactory();
		Pokemon pokemon = factory.createPokemon(-1, 500, 60, 1000, 50);

		assertEquals(1000, pokemon.getAttack());
		assertEquals(1000, pokemon.getDefense());
		assertEquals(1000, pokemon.getStamina());
		assertEquals(0.0, pokemon.getIv(), 0.01);
		assertEquals("Ash's Pikachu", pokemon.getName());
	}

	@Test
	public void testGenerateRandomStat() {
		for (int i = 0; i < 100; i++) {
			int stat = RocketPokemonFactory.generateRandomStat();
			assertTrue(stat >= 0 && stat <= 100); // Ajustez les bornes selon l'implémentation
		}
	}






}

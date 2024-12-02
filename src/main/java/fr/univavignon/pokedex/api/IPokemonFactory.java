package fr.univavignon.pokedex.api;

/**
 * Factory interface for class that aims to create Pokemon instance.
 * This interface is responsible for generating instances of Pokemon
 * with pre-computed Individual Values (IVs).
 * @author fv
 */
public interface IPokemonFactory {

	/**
	 * Creates a pokemon instance computing it IVs.
	 * 
	 * @param index Pokemon index.
	 * @param cp Pokemon CP.
	 * @param hp Pokemon HP.
	 * @param dust Required dust for upgrading pokemon.
	 * @param candy Required candy for upgrading pokemon.
	 * @return Created pokemon instance.
	 * @throws PokedexException If the provided index is invalid or does not correspond
	 *     to a valid Pokemon in the Pokedex.
	 */
	Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException;
	
}

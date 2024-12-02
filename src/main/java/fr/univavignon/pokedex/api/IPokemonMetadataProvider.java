package fr.univavignon.pokedex.api;

/**
 * Implementation of the {@link IPokemonMetadataProvider} interface.
 * This class provides metadata for a given Pokemon index, including
 * attributes such as name, attack, defense, and stamina.
 * 
 * @author fv
 */
public interface IPokemonMetadataProvider {

	/**
	 * Retrieves and returns the metadata for the pokemon
	 * denoted by the given <code>index</code>.
	 * 
	 * @param index Index of the pokemon to retrieve metadata for.
	 * @return Metadata of the pokemon.
	 * @throws PokedexException If the given <code>index</code> is not valid.
	 */
	PokemonMetadata getPokemonMetadata(int index) throws PokedexException;
	
}

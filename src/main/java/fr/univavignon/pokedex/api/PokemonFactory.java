package fr.univavignon.pokedex.api;

/**
 * A factory implementation for creating Pokemon instances.
 * It utilizes metadata provided by an {@link IPokemonMetadataProvider}.
 *
 * @author fv
 */

public class PokemonFactory implements IPokemonFactory{
    /**
     * Metadata provider used for fetching Pokemon metadata.
     */
    private final IPokemonMetadataProvider metadataProvider;

    /**
     * An instance of {@link IPokemonMetadataProvider} used to retrieve metadata.
     * @param metadataProvider
     */

    public PokemonFactory(IPokemonMetadataProvider metadataProvider) {
        this.metadataProvider = metadataProvider;
    }

    /**
     * Creates a Pokemon instance by computing its Individual Values (IVs).
     *
     * @param index Pokemon index.
     * @param cp Pokemon CP.
     * @param hp Pokemon HP.
     * @param dust Required dust for upgrading pokemon.
     * @param candy Required candy for upgrading pokemon.
     * @return
     * @throws PokedexException
     */

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        PokemonMetadata metadata = metadataProvider.getPokemonMetadata(index);


        String name = metadata.getName();
        int attack = metadata.getAttack();
        int defense = metadata.getDefense();
        int stamina = metadata.getStamina();
        double iv = calculateIv(attack, defense, stamina);
        Pokemon pokemon = new Pokemon(index, name, attack, defense,stamina, cp, hp, dust, candy, iv);
        return pokemon;
    }

    /**
     * Calculates the Individual Value (IV) of a Pokemon.
     *
     * @param attack The attack stat of the Pokemon.
     * @param defense The defense stat of the Pokemon.
     * @param stamina The defense stat of the Pokemon.
     * @return The calculated Individual Value (IV) as a double.
     */

    public double calculateIv(int attack, int defense, int stamina){
        double iv = (attack + defense + stamina) / 3.0;
        return iv;
    }
}

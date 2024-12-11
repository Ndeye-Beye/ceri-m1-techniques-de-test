package fr.univavignon.pokedex.api;

import java.util.*;

/**
 * Implémentation du Pokedex, une liste de Pokémon avec des fonctionnalités de gestion.
 */
public class Pokedex implements IPokedex{
    /**
     * Liste interne des Pokémon.
     */
    private List<Pokemon> pokemons;
    /**
     * Fournisseur de métadonnées sur les Pokémon.
     */
    IPokemonMetadataProvider metadataProvider;
    /**
     * Fabrique de Pokémon.
     */
    IPokemonFactory pokemonFactory;


    /**
     * Constructeur de la classe Pokedex.
     *
     * @param metadataProvider Fournisseur de métadonnées sur les Pokémon.
     * @param pokemonFactory Fabrique de Pokémon.
     * @throws IllegalArgumentException Si metadataProvider ou pokemonFactory est null.
     */
    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory){
        pokemons = new ArrayList<>();
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    /**
     * Retourne la taille actuelle du Pokedex.
     *
     * @return Le nombre de Pokémon dans le Pokedex.
     */
    @Override
    public int size() {
        return pokemons.size();
    }

    /**
     * Retourne la taille actuelle du Pokedex.
     *
     * @return Le nombre de Pokémon dans le Pokedex.
     */
    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size() - 1;
    }

    /**
     * Retourne un Pokémon par son index.
     *
     * @param id L'index du Pokémon.
     * @return Le Pokémon correspondant à l'index donné.
     * @throws PokedexException Si l'index est invalide.
     */
    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        return pokemons.get(id);
    }

    /**
     * Retourne une liste non modifiable de tous les Pokémon dans le Pokedex.
     *
     * @return Une liste non modifiable de Pokémon.
     */
    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(new ArrayList<>(pokemons));
    }

    /**
     * Retourne une liste triée de Pokémon selon un comparateur donné.
     *
     * @param order Le comparateur utilisé pour trier les Pokémon.
     * @return Une liste triée de Pokémon.
     */
    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> pokemonsSorted = new ArrayList<>(pokemons);
        pokemonsSorted.sort(order);
        return pokemonsSorted;
    }

    /**
     * Crée un Pokémon avec les attributs donnés.
     *
     * @param index L'index du Pokémon.
     * @param cp Les points de combat (CP) du Pokémon.
     * @param hp Les points de vie (HP) du Pokémon.
     * @param dust La quantité de poussière d'étoile requise.
     * @param candy La quantité de bonbons requise.
     * @return Le Pokémon créé.
     * @throws PokedexException Si une erreur survient lors de la création.
     */
    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }



    /**
     * Retourne les métadonnées d'un Pokémon par son index.
     *
     * @param index L'index du Pokémon.
     * @return Les métadonnées du Pokémon.
     * @throws PokedexException Si une erreur survient lors de la récupération des métadonnées.
     */
    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {

        return metadataProvider.getPokemonMetadata(index);
    }

}

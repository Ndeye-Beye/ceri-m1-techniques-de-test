package fr.univavignon.pokedex.api;

import java.util.*;

public class Pokedex implements IPokedex{
    private List<Pokemon> pokemons;
    IPokemonMetadataProvider metadataProvider;
    IPokemonFactory pokemonFactory;

    public Pokedex(IPokemonMetadataProvider metadataProvider, IPokemonFactory pokemonFactory){
        pokemons = new ArrayList<>();
        this.metadataProvider = metadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    @Override
    public int size() {
        return pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemons.size() - 1;
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        return pokemons.get(id);
    }

    @Override
    public List<Pokemon> getPokemons() {
        return Collections.unmodifiableList(new ArrayList<>(pokemons));
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> pokemonsSorted = new ArrayList<>(pokemons);
        pokemonsSorted.sort(order);
        return pokemonsSorted;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }



    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if(index < 0 || index >= pokemons.size()){
            throw new PokedexException("Index non trouvé" + index);
        }
        return metadataProvider.getPokemonMetadata(index);
    }

}

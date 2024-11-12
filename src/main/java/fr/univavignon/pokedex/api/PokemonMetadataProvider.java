package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonMetadataProvider implements IPokemonMetadataProvider{
    private List<PokemonMetadata> metadataList;

    public PokemonMetadataProvider(List<PokemonMetadata> metadatas) {

        this.metadataList = metadatas;

    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {

        return this.metadataList.get(index);
    }
}

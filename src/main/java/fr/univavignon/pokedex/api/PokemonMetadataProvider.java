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
        if (index < 0 || index >= metadataList.size()) {
            throw new PokedexException("Aucune métadonnée trouvée pour l'index : " + index);
        }
        Pokemon pokemonExample1 = new Pokemon(0, "Bulbizarre", 126,126,90,613,64,4000,4,56);
        Pokemon pokemonExample2 = new Pokemon(133, "Aquali", 186,168,260,2729,202,5000,4,100);

        return this.metadataList.get(index);
    }
}

package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Fournit les métadonnées des Pokémon.
 */

public class PokemonMetadataProvider implements IPokemonMetadataProvider{
    /**
     * Liste des métadonnées des Pokémon.
     */
    private List<PokemonMetadata> metadataList;

    /**
     * Constructeur de la classe PokemonMetadataProvider.
     *
     * @param metadatas La liste des métadonnées des Pokémon.
     * @throws IllegalArgumentException si la liste des métadonnées est null.
     */
    public PokemonMetadataProvider(List<PokemonMetadata> metadatas) {

        this.metadataList = metadatas;

    }

    /**
     * Renvoie les métadonnées d'un Pokémon en fonction de son index.
     *
     * @param index L'index du Pokémon.
     * @return Les métadonnées du Pokémon.
     * @throws PokedexException Si l'index est invalide.
     */

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {

        return this.metadataList.get(index);
    }
}

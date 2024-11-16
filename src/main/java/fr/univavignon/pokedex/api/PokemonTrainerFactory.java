package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonTrainerFactory implements IPokemonTrainerFactory{


    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {

        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("le nom n'est pas null");
        }
        if (team == null) {
            throw new IllegalArgumentException("Team n'est pas null.");
        }
        if (pokedexFactory == null) {
            throw new IllegalArgumentException("PokedexFactory n'est pas null.");
        }

        List<PokemonMetadata> metadataList = new ArrayList<>();
        metadataList.add(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));

        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider(metadataList);
        PokemonFactory pokemonFactory = new PokemonFactory(metadataProvider);

        IPokedex pokedexFactory1 = pokedexFactory.createPokedex(metadataProvider,pokemonFactory);

        return new PokemonTrainer(name, team, pokedexFactory1);
    }


}

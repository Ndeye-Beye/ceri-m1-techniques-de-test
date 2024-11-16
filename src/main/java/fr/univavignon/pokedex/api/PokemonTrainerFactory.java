package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.List;

public class PokemonTrainerFactory implements IPokemonTrainerFactory{


    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {


        List<PokemonMetadata> metadataList = new ArrayList<>();
        metadataList.add(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));

        PokemonMetadataProvider metadataProvider = new PokemonMetadataProvider(metadataList);
        PokemonFactory pokemonFactory = new PokemonFactory(metadataProvider);

        IPokedex pokedexFactory1 = pokedexFactory.createPokedex(metadataProvider,pokemonFactory);

        return new PokemonTrainer(name, team, pokedexFactory1);
    }


}

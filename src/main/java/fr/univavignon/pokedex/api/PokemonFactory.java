package fr.univavignon.pokedex.api;

public class PokemonFactory implements IPokemonFactory{
    private final IPokemonMetadataProvider metadataProvider;

    public PokemonFactory(IPokemonMetadataProvider metadataProvider) {
        this.metadataProvider = metadataProvider;
    }

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

    public double calculateIv(int attack, int defense, int stamina){
        double iv = (attack + defense + stamina) / 3.0;
        return iv;
    }
}

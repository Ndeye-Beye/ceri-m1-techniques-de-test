package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections4.map.UnmodifiableMap;


/**
 * Implémentation de l'interface IPokemonFactory par la Team Rocket.
 * Cette classe permet de créer des Pokémon avec des caractéristiques générées aléatoirement.
 */
public class RocketPokemonFactory implements IPokemonFactory {

	/**
	 * Mapping des indices des Pokémon vers leurs noms respectifs.
	 * Contient des indices spéciaux pour des cas particuliers comme -1 ou 0.
	 */
	private static Map<Integer, String> index2name; // Initialisation statique de la map index2name
	private static final Random random = new Random(); // Instance unique pour l'ensemble de la classe
	private static final int SPECIAL_STAT_VALUE = 1000;
	private static final double SPECIAL_IV_VALUE = 0.0;

	static {
		Map<Integer, String> aMap = new HashMap<Integer, String>();
        aMap.put(-1, "Ash's Pikachu");
        aMap.put(0, "MISSINGNO");
        aMap.put(1, "Bulbasaur");
        //TODO : Gotta map them all !
        index2name = UnmodifiableMap.unmodifiableMap(aMap);
	}

	/**
	 * Génère une statistique aléatoire en simulant un processus pseudo-aléatoire coûteux.
	 * Cette méthode est inefficace et doit être optimisée.
	 *
	 * @return une valeur moyenne calculée aléatoirement (entre 0 et 1 ici).
	 */
	static int generateRandomStat() {
		return random.nextInt(16); // Génère un entier entre 0 et 15
	}




	/**
	 * Crée une instance de Pokémon avec des statistiques générées.
	 *
	 * @param index L'indice du Pokémon (correspondant à son ID dans le Pokédex).
	 * @param cp Points de Combat (Combat Power).
	 * @param hp Points de Vie (Health Points).
	 * @param dust Quantité de poussière d'étoiles nécessaire pour améliorer le Pokémon.
	 * @param candy Nombre de bonbons nécessaires pour améliorer le Pokémon.
	 * @return Une instance de {@link Pokemon} avec les caractéristiques fournies ou générées.
	 */


	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		String name = index2name.getOrDefault(index, index2name.get(0));

		int attack, defense, stamina;
		double iv;

		if (index < 0) {
			attack = SPECIAL_STAT_VALUE;
			defense = SPECIAL_STAT_VALUE;
			stamina = SPECIAL_STAT_VALUE;
			iv = SPECIAL_IV_VALUE;
		} else {
			attack = generateRandomStat();
			defense = generateRandomStat();
			stamina = generateRandomStat();
			iv = 1.0;
		}

		return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);
	}

}
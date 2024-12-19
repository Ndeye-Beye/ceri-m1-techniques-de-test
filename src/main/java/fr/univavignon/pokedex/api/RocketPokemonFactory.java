package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections4.map.UnmodifiableMap;

import fr.univavignon.pokedex.api.IPokemonFactory;
import fr.univavignon.pokedex.api.Pokemon;

/**
 * Classe implémentant l'interface IPokemonFactory pour générer des instances de Pokémon.
 * Cette classe utilise une carte statique pour mapper des indices à des noms de Pokémon
 * et génère des statistiques aléatoires pour les Pokémon créés.
 */
public class RocketPokemonFactory implements IPokemonFactory {

	/**
	 * Carte statique associant les indices de Pokémon à leurs noms.
	 * Les noms sont initialisés dans un bloc statique et la carte est rendue immuable.
	 */
	private static Map<Integer, String> index2name;
	static {
		// Initialisation de la carte des indices aux noms des Pokémon
		Map<Integer, String> aMap = new HashMap<Integer, String>();
		aMap.put(-1, "Ash's Pikachu"); // Cas spécial pour un Pokémon spécifique
		aMap.put(0, "MISSINGNO");      // Pokémon par défaut pour les indices inconnus
		aMap.put(1, "Bulbasaur");      // Exemple de Pokémon standard
		// TODO : Ajouter les autres Pokémon ici
		index2name = UnmodifiableMap.unmodifiableMap(aMap); // Rendre la carte immuable
	}

	/**
	 * Méthode générant une statistique aléatoire.
	 * Cette méthode utilise une boucle avec un grand nombre d'itérations,
	 * ce qui peut être inefficace en termes de performance.
	 *
	 * @return Une statistique aléatoire normalisée.
	 */
	static int generateRandomStat() {
		int total = 0;
		// Boucle pour générer une statistique basée sur des valeurs aléatoires
		for (int i = 0; i < 1000000; i++) {
			Random rn = new Random();
			int r = rn.nextInt(2); // Génère un entier aléatoire entre 0 et 1
			total = total + r;
		}
		return total / 10000; // Retourne une statistique moyenne
	}

	/**
	 * Méthode implémentant la création d'un Pokémon.
	 * Les statistiques du Pokémon sont générées en fonction de l'indice fourni.
	 *
	 * @param index Index du Pokémon (doit correspondre à un nom dans index2name).
	 * @param cp Points de Combat (Combat Power) du Pokémon.
	 * @param hp Points de Vie (Hit Points) du Pokémon.
	 * @param dust Poussière nécessaire pour améliorer le Pokémon.
	 * @param candy Bonbons nécessaires pour améliorer ou faire évoluer le Pokémon.
	 * @return Une instance de Pokémon initialisée avec les paramètres fournis.
	 */
	@Override
	public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
		// Détermination du nom du Pokémon en fonction de l'indice
		String name;
		if (!index2name.containsKey(index)) {
			name = index2name.get(0); // Utilisation du nom par défaut "MISSINGNO"
		} else {
			name = index2name.get(index);
		}

		// Initialisation des statistiques du Pokémon
		int attack;
		int defense;
		int stamina;
		double iv; // Valeur individuelle (Individual Value)

		if (index < 0) {
			// Cas des indices négatifs : valeurs fixes pour des Pokémon spéciaux
			attack = 1000;
			defense = 1000;
			stamina = 1000;
			iv = 0; // Valeur individuelle nulle
		} else {
			// Génération de statistiques aléatoires pour les indices valides
			attack = RocketPokemonFactory.generateRandomStat();
			defense = RocketPokemonFactory.generateRandomStat();
			stamina = RocketPokemonFactory.generateRandomStat();
			iv = 1; // Valeur individuelle maximale
		}

		// Retourne une nouvelle instance de Pokémon avec les paramètres définis
		return new Pokemon(index, name, attack, defense, stamina, cp, hp, dust, candy, iv);
	}
}

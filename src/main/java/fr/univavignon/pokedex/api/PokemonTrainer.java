package fr.univavignon.pokedex.api;

/**
 * Trainer POJO.
 * 
 * @author fv
 */
public class PokemonTrainer {

	/** @return Trainer name. **/
	private final String name;

	/** @return Trainer team. **/
	private final Team team;
	
	/** @return Trainer pokedex. **/
	private final IPokedex pokedex;
	
	/**
	 * Default constructor.
	 * 
	 * @param name Trainer name.
	 * @param team Trainer team.
	 * @param pokedex Trainer pokedex.
	 */
	public PokemonTrainer(final String name, final Team team, final IPokedex pokedex) {
		this.name = name;
		this.team = team;
		this.pokedex = pokedex;
	}
	
	/** @return Name getter. **/
	public String getName() {

		return name;
	}

	/** @return Team getter. **/
	public Team getTeam() {

		return team;
	}
	
	/**@return  Pokedex getter. **/
	public IPokedex getPokedex() {

		return pokedex;
	}
	
}

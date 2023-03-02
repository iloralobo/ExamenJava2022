package utilidades;

import modelos.Pokemon;
import modelos.TipoPokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadesPokemon {

    public List<Pokemon> obtenerPokemonConTipos(List<Pokemon> pokemons, List<TipoPokemon> tipos){
        List<Pokemon> listaPokemons = new ArrayList<>();
        for (Pokemon pokemon : pokemons){
            for (TipoPokemon tipo : tipos){
                if (pokemon.getTipos().contains(tipo)){
                    listaPokemons.add(pokemon);
                }
            }
        }
        return listaPokemons;
    }

    public Map<TipoPokemon, List<Pokemon>> obtenerPokemonPurosPorTipo(List<Pokemon> pokemons){
        Map<TipoPokemon, List<Pokemon>> pokemonsPorTipo = new HashMap<>();
                for (Pokemon pokemon : pokemons){
                    if (pokemon.getTipos().size()==1){
                        if (pokemonsPorTipo.containsKey(pokemon.getTipos().get(0))){

                            pokemonsPorTipo.get(pokemon.getTipos().get(0)).add(pokemon);
                }else{
                            pokemonsPorTipo.put(pokemon.getTipos().get(0), List.of(pokemon));
                        }
                }
            }
        return pokemonsPorTipo;
    }


}

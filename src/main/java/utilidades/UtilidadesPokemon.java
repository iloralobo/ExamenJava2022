package utilidades;

import modelos.Movimiento;
import modelos.Pokemon;
import modelos.TipoPokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadesPokemon {

    public static List<Pokemon> obtenerPokemonConTipos(List<Pokemon> pokemons, List<TipoPokemon> tipos){
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


    public static Map<TipoPokemon, List<Pokemon>> obtenerPokemonPurosPorTipo(List<Pokemon> pokemons){
        Map<TipoPokemon, List<Pokemon>> pokemonsPorTipo = new HashMap<>();
        for (Pokemon pokemon : pokemons){
            if (pokemon.getTipos().size()==1){
                if (pokemonsPorTipo.containsKey(pokemon.getTipos().get(0))){
                    pokemonsPorTipo.get(pokemon.getTipos().get(0)).add(pokemon);
                }else{
                    pokemonsPorTipo.put(pokemon.getTipos().get(0), new ArrayList<>(List.of(pokemon)));
                }
            }
        }
        return pokemonsPorTipo;
    }


//    El método devuelve la lista de movimientos de los pasados que
//    puede aprender el pokemon que se le pasa, siempre y cuando el
//    movimiento coincida con los tipos del pokemon.

    public  static List<Movimiento> movimientosQuePuedeAprender(Pokemon pokemon, List<Movimiento> movimientos){

        List<Movimiento> listaMovimientos = new ArrayList<>();
        for (Movimiento movimiento : movimientos){
            if (pokemon.getTipos().contains(movimiento.getTipo())){
                listaMovimientos.add(movimiento);
            }
        }
        return listaMovimientos;
    }

    public Pokemon obtenerEvolucionPosible(Pokemon pokemon){

        Pokemon pokemonEvolucionado = new Pokemon();



        //Que devuelve el pokemon de la línea evolutiva al que
        //evolucionará el pokemon que se pasa , siempre y cuando pueda
        //evolucionar, esto significa que el pokemon devuelto es el
        //existente en la línea evolutiva siempre y cuando sea de orden
        //siguiente justo al pasado y tenga nivel inferior o igual al pokemon
        //pasado . Si no puede evolucionar devuelve null.

        return pokemonEvolucionado;
    }

}


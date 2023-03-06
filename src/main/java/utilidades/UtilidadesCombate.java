package utilidades;

import modelos.Entrenador;
import modelos.LineaEvolutiva;
import modelos.Pokemon;
import modelos.TipoPokemon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilidadesCombate {

    private static Integer getPuntosEntrenador(Entrenador e){
        int puntos = 0;

        for (Pokemon pokemon : e.getEquipoPokemon()){
            List<TipoPokemon> list = new ArrayList<>(e.getTiposPreferidos());
            list.retainAll(pokemon.getTipos());
            puntos += list.size();
        }
        return puntos;
    }

    public static Map<Entrenador, Integer> repartirPokemon(List<Entrenador> entrenadores, List<Pokemon> pokemon){

        Map<Entrenador, Integer> jugadoresPuntuacion = new HashMap<>();

        if (pokemon.size() % 2 ==0 && entrenadores.size() % 2 == 0 && pokemon.size() % entrenadores.size() == 0) {

            int numPokemonsEntrenador = pokemon.size()/entrenadores.size();

            int indiceListInicial = 0;
            for (Entrenador entrenador : entrenadores) {
                entrenador.setEquipoPokemon(pokemon.subList(indiceListInicial,numPokemonsEntrenador));
                indiceListInicial += numPokemonsEntrenador;
                jugadoresPuntuacion.put(entrenador,getPuntosEntrenador(entrenador));
            }
        }
        return jugadoresPuntuacion;
    }

    public static void subirAlNivel(Pokemon pokemon , Integer nivel){

        pokemon.setNivel(nivel);
        pokemon.getStats().setAt(pokemon.getStats().getAt() + (2 * nivel));
        pokemon.getStats().setDf(pokemon.getStats().getDf() + (2 * nivel));
        pokemon.getStats().setPs(pokemon.getStats().getPs() + (2 * nivel));
        pokemon.getStats().setSpa(pokemon.getStats().getSpa() + (2 * nivel));
        pokemon.getStats().setSpd(pokemon.getStats().getSpd() + (2 * nivel));
        pokemon.getStats().setSpdf(pokemon.getStats().getSpdf() + (2 * nivel));

    }

    public static boolean puedeEvolucionar(Pokemon pokemon){
        LineaEvolutiva lineaEvolutivaPokemon = null;
        boolean hayOrdenSuperior = false;
        boolean hayNivelRequerido = false;

        for(LineaEvolutiva lineaEvolutiva : pokemon.getLineaEvolutiva()){
            if (lineaEvolutiva.getPokemon().equals(pokemon)){
                lineaEvolutivaPokemon = lineaEvolutiva;
            }
        }

        for(LineaEvolutiva lineaEvolutiva : pokemon.getLineaEvolutiva()){
            if (lineaEvolutiva.getPokemon().equals(pokemon)){
                hayOrdenSuperior = true;
                break;
            }
        }

        for(LineaEvolutiva lineaEvolutiva : pokemon.getLineaEvolutiva()){
            if (lineaEvolutiva.getNivelParaEvolucionar() <= pokemon.getNivel() && !lineaEvolutiva.getPokemon().equals(pokemon)){
                hayNivelRequerido = true;
                break;
            }
        }
        return hayOrdenSuperior && hayNivelRequerido ;
    }


}








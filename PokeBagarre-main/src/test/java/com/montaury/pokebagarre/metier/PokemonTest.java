package com.montaury.pokebagarre.metier;

import com.montaury.pokebagarre.fixtures.ConstructeurDePokemon;
import org.junit.jupiter.api.Test;

import static com.montaury.pokebagarre.fixtures.ConstructeurDePokemon.unPokemon;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
class PokemonTest {
    @Test
    public void premier_devrait_gagner_car_meilleure_attaque() {
        // GIVEN
        //Pokemon pokemon1 = new Pokemon("Pikachu", "url", new Stats(15, 10));
        //Pokemon pokemon2 = new Pokemon("Salamèche", "url", new Stats(10, 15));
        Pokemon pokemon1 = unPokemon().avecAttaque(15).construire();
        
        // WHEN
        boolean actualResult = pokemon1.estVainqueurContre(pokemon2);
        // THEN
        assertThat(actualResult).isTrue();
    }
    @Test
    public void estVainqueurContreAttEgaleDefEgale() {
        Pokemon pokemon1 = new Pokemon("Pikachu", "url", new Stats(10, 10));
        Pokemon pokemon2 = new Pokemon("Salamèche", "url", new Stats(10, 10));
        assertThat(pokemon1.estVainqueurContre(pokemon2)).isTrue();
    }
    @Test
    public void estVainqueurContreAttDiffDefEgale() {
        Pokemon pokemon1 = new Pokemon("Pikachu", "url", new Stats(15, 10));
        Pokemon pokemon2 = new Pokemon("Salamèche", "url", new Stats(10, 10));
        assertThat(pokemon1.estVainqueurContre(pokemon2)).isTrue();
    }
    @Test
    public void estVainqueurContreAttEgaleDefDiff() {
        Pokemon pokemon1 = new Pokemon("Pikachu", "url", new Stats(10, 15));
        Pokemon pokemon2 = new Pokemon("Salamèche", "url", new Stats(10, 10));
        assertThat(pokemon1.estVainqueurContre(pokemon2)).isTrue();
    }
    @Test
    public void estVainqueurContreMemePokemon() {
        Pokemon pokemon1 = new Pokemon("Pikachu", "url", new Stats(10, 10));
        Pokemon pokemon2 = new Pokemon("Pikachu", "url", new Stats(10, 10));
        assertThat(pokemon1.estVainqueurContre(pokemon2)).isTrue();
    }
}
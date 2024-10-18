package TrabalhoAlgoritmos;

import java.util.Objects;

// Acadêmico: Erick Augusto Warmling
public class Carta {
    private final String nome;

    public Carta (String nome){
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carta carta = (Carta) o;
        return Objects.equals(nome, carta.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome);
    }

    @Override
    public String toString() {
        return nome;
    }

}

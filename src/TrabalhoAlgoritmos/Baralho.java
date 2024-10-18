package TrabalhoAlgoritmos;

import stack.LinkedStack;
import stack.Stack;

// Acadêmico: Erick Augusto Warmling
public class Baralho {
    private final Stack<Carta> cartas = new LinkedStack<>();

    public Baralho (String embaralhamento){
        String[] cartas = embaralhamento.split(" ");

        for (String carta : cartas) {
            Carta novaCarta = new Carta(carta);
            this.cartas.push(novaCarta);
        }
    }

    public Carta comprarCarta (){
        if (cartas.isEmpty()){
            return null;
        }
        return cartas.pop();
    }

    public boolean baralhoVazio() {
        return cartas.isEmpty();
    }

}

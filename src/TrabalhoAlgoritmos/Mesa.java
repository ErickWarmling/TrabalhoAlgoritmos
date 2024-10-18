package TrabalhoAlgoritmos;

import deque.LinkedDeque;
import deque.Deque;

// Acadêmico: Erick Augusto Warmling
public class Mesa {

    private Deque<Carta> deque = new LinkedDeque<>();

    public void inicializarMesa(Baralho baralho) {
        for (int i = 0; i < 4; i++) {
            Carta carta = baralho.comprarCarta();
            deque.addFirst(carta);
        }
    }

    public boolean coletarCartaEsquerda(Jogador jogador) {
        if (!deque.isEmpty()) {
            Carta cartaMesa = deque.removeFirst();

            for (int i = 0; i < jogador.getCartasMao().size(); i++) {
                if (jogador.getCartasMao().get(i).equals(cartaMesa)) {
                    jogador.getCartasMao().remove(i);
                    jogador.getMonte().push(cartaMesa);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean coletarCartaDireita(Jogador jogador) {
        if (!deque.isEmpty()) {
            Carta cartaMesa = deque.removeLast();

            for (int i = 0; i < jogador.getCartasMao().size(); i++) {
                if (jogador.getCartasMao().get(i).equals(cartaMesa)) {
                    jogador.getCartasMao().remove(i);
                    jogador.getMonte().push(cartaMesa);
                    return true;
                }
            }
        }
        return false;
    }

    public void adicionarCartaEsquerda(Carta carta){
        deque.addFirst(carta);
    }

    public void adicionarCartaDireita(Carta carta){
        deque.addLast(carta);
    }

    public Deque<Carta> getDeque() {
        return deque;
    }

    public Carta cartaExtremidadeEsquerda (){
        return deque.first();
    }

    public Carta cartaExtremidadeDireita (){
        return deque.last();
    }

    public boolean permiteColetaEsquerda(Carta carta){
        return carta.equals(cartaExtremidadeEsquerda());
    }

    public boolean permiteColetaDireita(Carta carta){
        return carta.equals(cartaExtremidadeDireita());
    }
}
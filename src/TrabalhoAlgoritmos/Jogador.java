package TrabalhoAlgoritmos;

import list.LinkedList;
import list.List;
import stack.LinkedStack;
import stack.Stack;

// Acadêmico: Erick Augusto Warmling
public abstract class Jogador {

    protected Stack<Carta> monte = new LinkedStack<>();
    protected List<Carta> cartasMao = new LinkedList<>();
    protected Baralho baralho;

    public Jogador (Baralho baralho) {
        this.baralho = baralho;
        for (int i = 0; i < 4; i++){
            cartasMao.add(i, baralho.comprarCarta());
        }
    }

    public void coletarCarta (Carta carta) {
        monte.push(carta);
    }

    public List<Carta> getCartasMao() {
        return cartasMao;
    }

    public int cartasColetadas () {
        return monte.size();
    }

    public void adicionarCartaMonte (Carta carta) {
        monte.push(carta);
    }

    public Stack<Carta> getMonte() {
        return monte;
    }

    public boolean comprarCarta(){
        Carta cartaComprada = baralho.comprarCarta();
        if (cartaComprada != null){
            int index = cartasMao.size();
            cartasMao.add(index, cartaComprada);
            return true;
        }

        return false;

    }

    public abstract boolean executarTurno(Mesa mesa);

    protected boolean verificarExtremidades(Mesa mesa, Carta cartaMaoJogador, Carta cartaExtremidadeEsquerda, Carta cartaExtremidadeDireita) {
        boolean permiteEsquerda = cartaMaoJogador.equals(cartaExtremidadeEsquerda);
        boolean permiteDireita = cartaMaoJogador.equals(cartaExtremidadeDireita);

        if (permiteDireita){
            coletarCarta(cartaExtremidadeDireita);
            return true;
        }

        if (permiteEsquerda){
            coletarCarta(cartaExtremidadeEsquerda);
            return true;
        }

        return false;
    }
}

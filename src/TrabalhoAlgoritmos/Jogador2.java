package TrabalhoAlgoritmos;

import deque.LinkedDeque;
import deque.Deque;

// Acadêmico: Erick Augusto Warmling
public class Jogador2 extends Jogador {

    public Jogador2(Baralho baralho) {
        super(baralho);
    }

    @Override
    public boolean executarTurno(Mesa mesa) {
        boolean podeColetarEsquerda = false;
        boolean podeColetarDireita = false;

        for (int i = 0; i < cartasMao.size(); i++) {
            Carta cartaMaoJogador = cartasMao.get(i);
            if (mesa.permiteColetaDireita(cartaMaoJogador)) podeColetarDireita = true;
            if (mesa.permiteColetaEsquerda(cartaMaoJogador)) podeColetarEsquerda = true;
        }

        boolean coletou = false;

        if (podeColetarEsquerda || podeColetarDireita) {
            Carta cartaEsquerdaMesa = mesa.getDeque().first();
            Carta cartaDireitaMesa = mesa.getDeque().last();
            int quantidadeEsquerdaDireita = 1;
            int quantidadeDireitaEsquerda = 1;

            if (podeColetarEsquerda) {
                Deque<Carta> tempDeque = new LinkedDeque<>();
                while (!mesa.getDeque().isEmpty()) {
                    Carta atual = mesa.getDeque().removeFirst();
                    tempDeque.addLast(atual);
                    if (atual.equals(cartaEsquerdaMesa)) {
                        quantidadeEsquerdaDireita++;
                    } else {
                        break;
                    }
                }
                while (!tempDeque.isEmpty()) {
                    mesa.getDeque().addFirst(tempDeque.removeLast());
                }
            }

            if (podeColetarDireita) {
                Deque<Carta> tempDeque = new LinkedDeque<>();
                while (!mesa.getDeque().isEmpty()) {
                    Carta atual = mesa.getDeque().removeLast();
                    tempDeque.addFirst(atual);
                    if (atual.equals(cartaDireitaMesa)) {
                        quantidadeDireitaEsquerda++;
                    } else {
                        break;
                    }
                }

                while (!tempDeque.isEmpty()) {
                    mesa.getDeque().addLast(tempDeque.removeFirst());
                }
            }

            if (quantidadeEsquerdaDireita > quantidadeDireitaEsquerda) {
                for (int i = 0; i < quantidadeEsquerdaDireita; i++) {
                    Carta coleta = mesa.getDeque().removeFirst();
                    adicionarCartaMonte(coleta);
                }
            } else {
                for (int i = 0; i < quantidadeEsquerdaDireita; i++) {
                    Carta coleta = mesa.getDeque().removeLast();
                    adicionarCartaMonte(coleta);
                }
            }
            coletou = true;
        }

        if (!coletou) {
            int lastIndex = cartasMao.size() - 1;
            Carta ultimaCartaMao = cartasMao.get(lastIndex);
            mesa.adicionarCartaDireita(ultimaCartaMao);

            Carta novaCartaMesa = baralho.comprarCarta();
            if (novaCartaMesa == null) return false;
            mesa.adicionarCartaEsquerda(novaCartaMesa);
        }

        return comprarCarta();
    }
}

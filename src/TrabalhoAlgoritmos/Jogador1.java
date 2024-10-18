package TrabalhoAlgoritmos;

// Acadêmico: Erick Augusto Warmling
public class Jogador1 extends Jogador {

    public Jogador1(Baralho baralho) {
        super(baralho);
    }

    @Override
    public boolean executarTurno(Mesa mesa){
        Carta cartaExtremidadeEsquerda;
        Carta cartaExtremidadeDireita;
        Carta cartaMaoJogador;
        boolean coletou = false;

        for (int i = 0; i < cartasMao.size(); i++){
            cartaExtremidadeEsquerda = mesa.cartaExtremidadeEsquerda();
            cartaExtremidadeDireita = mesa.cartaExtremidadeDireita();
            cartaMaoJogador = cartasMao.get(i);

            coletou = verificarExtremidades(mesa, cartaMaoJogador, cartaExtremidadeEsquerda, cartaExtremidadeDireita);

            if (coletou) {
                adicionarCartaMonte(cartaMaoJogador);
                break;
            }
        }

        if (!coletou){
            Carta primeiraCartaMao = cartasMao.get(0);
            mesa.adicionarCartaEsquerda(primeiraCartaMao);

            Carta novaCartaMesa = baralho.comprarCarta();
            if (novaCartaMesa == null) return false;
            mesa.adicionarCartaDireita(novaCartaMesa);
        }

        return comprarCarta();
    }
}

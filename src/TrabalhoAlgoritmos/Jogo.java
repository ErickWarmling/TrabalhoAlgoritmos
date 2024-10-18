package TrabalhoAlgoritmos;

import utils.LeitorArquivoTexto;

// Acadêmico: Erick Augusto Warmling
public class Jogo {

    private Baralho baralho;
    private Jogador jogador1;
    private Jogador jogador2;
    private Mesa mesa;

    public void jogarEnferrujados (){

        String[] embaralhamentos = LeitorArquivoTexto.lerArquivo("src/partidas.txt");

        for (String embaralhamento : embaralhamentos) {
            baralho = new Baralho(embaralhamento);

            jogador1 = new Jogador1(baralho);
            jogador2 = new Jogador2(baralho);

            mesa = new Mesa();
            mesa.inicializarMesa(baralho);

            while (true){
                if (!turno(jogador1)) break;
                if (!turno(jogador2)) break;
            }
            resultadoFinal();
        }
    }

    public boolean turno (Jogador jogador) {
        return jogador.executarTurno(mesa);
    }

    public void resultadoFinal() {
        int resultadoJogador1 = jogador1.cartasColetadas();
        int resultadoJogador2 = jogador2.cartasColetadas();
        int diferenca = resultadoJogador1 - resultadoJogador2;

        String ganhador;
        if(diferenca > 0){
            ganhador = "Jogador 1";
        } else if (diferenca == 0){
            ganhador = "Empate";
        } else {
            ganhador = "Jogador 2";
        }

        System.out.println(resultadoJogador1 + " " + resultadoJogador2 + " " + ganhador);
    }
}

import java.util.HashMap;

/**
 * Classe Ambiente - um ambiente em um jogo adventure.
 *
 * Esta classe eh parte da aplicacao "World of Zuul".
 * "World of Zuul" eh um jogo de aventura muito simples, baseado em texto.
 *
 * Um "Ambiente" representa uma localizacao no cenario do jogo. Ele eh
 * conectado aos outros ambientes atraves de saidas. As saidas sao
 * nomeadas como norte, sul, leste e oeste. Para cada direcao, o ambiente
 * guarda uma referencia para o ambiente vizinho, ou null se nao ha
 * saida naquela direcao.
 * 
 * @author Michael Kölling and David J. Barnes (traduzido por Julio Cesar Alves)
 * @version 2011.07.31 (2016.02.01)
 */
public class Ambiente {
    private String descricao;
    private HashMap<String, Ambiente> saidas;

    /**
     * Cria um ambiente com a "descricao" passada. Inicialmente, ele
     * nao tem saidas. "descricao" eh algo como "uma cozinha" ou
     * "
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "um jardim aberto".
     * 
     * @param descricao A descricao do ambiente.
     */
    public Ambiente(String descricao) {
        this.descricao = descricao;
    }

    /*
     * Vai percorrer o HashMap e so vai pegar as direções(norte, sul, leste, oeste)
     * e depois vai concatenar na variavel saidasDisponiveis
     */
    public String getSaidas() {
        String saidasDisponiveis = "";
        for (String direcao : saidas.keySet()) {
            saidasDisponiveis += direcao + " ";
        }
        return saidasDisponiveis;
    }

    /**
     * @return O ambiente atual
     */
    public Ambiente getAmbiente(String direcao) {
        return saidas.get(direcao);
    }

    /**
     * Ajusta o ambiente fazendo o seguinte: no ambiente em que você está, pode definir qual ambiente está nas direções.
     * Ex: você esta no ambienteA e quer que ao norte esteja o ambienteB, então faz o seguinte no metodo criarAmbientes() da classe Jogo: ambienteA.ajustarSaidas("norte", ambienteB).
     */

    public void ajustarSaidas(String direcao, Ambiente ambiente) {
        saidas.put(direcao, ambiente);
    }

    /**
     * @return A descricao do ambiente.
     */
    public String getDescricao() {
        return descricao;
    }

}

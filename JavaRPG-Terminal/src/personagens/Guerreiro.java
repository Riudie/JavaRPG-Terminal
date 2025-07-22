package personagens;

import inimigos.Inimigo;

public class Guerreiro extends Personagem {
    public Guerreiro(String nome) {
        super(nome, 120);
    }

    @Override
    public int calcularDano() {
        return 10 + (int)(Math.random() * 6); // 10-15 de dano
    }

    @Override
    public void usarHabilidade(Inimigo inimigo) {
        System.out.println(getNome() + " usa GOLPE PODEROSO!");
        int dano = 25;
        inimigo.receberDano(dano);
    }
}
package personagens;

import inimigos.Inimigo;

public class Ladrao extends Personagem {
    public Ladrao(String nome) {
        super(nome, 85);  // HP médio-baixo
    }

    @Override
    public int calcularDano() {
        return 7 + (int)(Math.random() * 10);  // 7-16 de dano básico (alta variação)
    }

    @Override
    public void usarHabilidade(Inimigo inimigo) {
        System.out.println(getNome() + " usa GOLPE FURTIVO!");
        int dano = 22 + (int)(Math.random() * 10);  // 22-31 de dano
        if (!inimigo.estaVivo()) {
            System.out.println("⚔️ O golpe furtivo eliminou o inimigo!");
        } else {
            System.out.println("⚔️ O golpe furtivo causou " + dano + " de dano!");
        }
        inimigo.receberDano(dano);
    }
}
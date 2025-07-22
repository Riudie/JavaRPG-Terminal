package personagens;

import inimigos.Inimigo;

public class Mago extends Personagem {
    public Mago(String nome) {
        super(nome, 80);  // HP menor, mas com ataque forte
    }

    @Override
    public int calcularDano() {
        return 8 + (int)(Math.random() * 5);  // 8-12 de dano básico
    }

    @Override
    public void usarHabilidade(Inimigo inimigo) {
        System.out.println(getNome() + " conjura BOLA DE FOGO!");
        int dano = 30 + (int)(Math.random() * 10);  // 30-39 de dano
        inimigo.receberDano(dano);
        System.out.println("🔥 A bola de fogo causou " + dano + " de dano!");
    }
}
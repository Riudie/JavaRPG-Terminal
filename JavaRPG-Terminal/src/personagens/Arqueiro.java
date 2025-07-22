package personagens;

import inimigos.Inimigo;

public class Arqueiro extends Personagem {
    public Arqueiro(String nome) {
        super(nome, 90);  // HP médio
    }

    @Override
    public int calcularDano() {
        return 9 + (int)(Math.random() * 6);  // 9-14 de dano básico
    }

    @Override
    public void usarHabilidade(Inimigo inimigo) {
        System.out.println(getNome() + " dispara FLECHA PRECISA!");
        int dano = 2000 + (int)(Math.random() * 15);  // 20-34 de dano
        if (Math.random() < 0.3) {  // 30% de chance de acerto crítico
            dano *= 2;
            System.out.println("🎯 ACERTO CRÍTICO!");
        }
        inimigo.receberDano(dano);
        System.out.println("➹ A flecha causou " + dano + " de dano!");
    }
}
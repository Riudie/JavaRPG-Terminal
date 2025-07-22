package personagens;

import inimigos.Inimigo;

public class Curandeiro extends Personagem {
    public Curandeiro(String nome) {
        super(nome, 100);  // HP padrão
    }

    @Override
    public int calcularDano() {
        return 6 + (int)(Math.random() * 5);  // 6-10 de dano básico
    }

    @Override
    public void usarHabilidade(Inimigo inimigo) {
        System.out.println(getNome() + " invoca CURA DIVINA!");
        int cura = 25 + (int)(Math.random() * 10);  // 25-34 de cura
        this.recuperarHp(cura);
        System.out.println("✨ " + getNome() + " recuperou " + cura + " de HP!");
    }
}
package personagens;

import inimigos.Inimigo;

public class Paladino extends Personagem {
    public Paladino(String nome) {
        super(nome, 110);  // HP alto
    }

    @Override
    public int calcularDano() {
        return 9 + (int)(Math.random() * 4);  // 9-12 de dano básico
    }

    @Override
    public void usarHabilidade(Inimigo inimigo) {
        System.out.println(getNome() + " invoca LUZ SAGRADA!");
        int dano = 15 + (int)(Math.random() * 10);  // 15-24 de dano
        int cura = 15;
        
        inimigo.receberDano(dano);
        this.recuperarHp(cura);
        
        System.out.println("☀️ A luz sagrada causou " + dano + " de dano ao inimigo!");
        System.out.println("✨ " + getNome() + " recuperou " + cura + " de HP!");
    }
}
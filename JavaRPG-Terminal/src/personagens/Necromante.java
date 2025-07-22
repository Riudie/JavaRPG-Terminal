package personagens;

import inimigos.Inimigo;

public class Necromante extends Personagem {
    public Necromante(String nome) {
        super(nome, 85);  // HP médio-baixo
    }

    @Override
    public int calcularDano() {
        return 8 + (int)(Math.random() * 6);  // 8-13 de dano básico
    }

    @Override
    public void usarHabilidade(Inimigo inimigo) {
        System.out.println(getNome() + " invoca ESQUELETO SOMBRIO!");
        int dano = 18 + (int)(Math.random() * 8);  // 18-25 de dano
        int cura = 10;
        
        inimigo.receberDano(dano);
        this.recuperarHp(cura);
        
        System.out.println("💀 O esqueleto causou " + dano + " de dano!");
        System.out.println("🩸 " + getNome() + " drenou " + cura + " de HP do inimigo!");
    }
}
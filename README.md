# 🎮 JavaRPG-Terminal 
*Um RPG baseado em terminal desenvolvido em Java com princípios de POO*

![Java](https://img.shields.io/badge/Java-17%2B-orange)
![POO](https://img.shields.io/badge/POO-Encapsulamento%2FHerança%2FPolimorfismo-blue)
![Licença](https://img.shields.io/badge/Licença-MIT-green)

<p align="center">
  <img src="screenshots/gameplay.gif" width="600" alt="Demonstração do Jogo">
</p>

## 📜 Sumário
- [Funcionalidades](#-funcionalidades)
- [Arquitetura do Jogo](#-arquitetura-do-jogo)
- [Instalação](#-instalação)
- [Como Jogar](#%EF%B8%8F-como-jogar)
- [Sistema de Classes](#-sistema-de-classes)
- [Documentação Técnica](#-documentação-técnica)
- [Contribuição](#-contribuição)
- [Licença](#-licença)

## 🎯 Funcionalidades
- **7 classes jogáveis** com habilidades únicas
- **3 tipos de inimigos** com dificuldade progressiva
- **Sistema de progressão**:
  - Level up com crescimento de atributos
  - XP baseado na dificuldade do inimigo
- **Gerenciamento de inventário**:
  - Poções (restauração de HP)
  - Equipamentos (armas/armaduras)
- **Persistência de dados**: Salvar/Carregar progresso

## 🏗️ Arquitetura do Jogo
```bash
src/
├── jogo/            # Loop principal e menus
├── personagens/     # Personagens jogáveis (herança POO)
│   ├── Guerreiro.java
│   ├── Mago.java
│   └── ...
├── inimigos/        # Sistema de inimigos
│   ├── Dragao.java
│   └── ...
├── itens/           # Sistema de inventário
│   ├── Pocao.java
│   ├── Arma.java
│   └── ...
└── persistencia/    # Salvamento
    └── GerenciadorSalvamento.java

📥 Instalação
Requisitos:

Java JDK 17+

Git (opcional)

Executar a partir do código-fonte:

git clone https://github.com/seu-usuario/JavaRPG-Terminal.git
cd JavaRPG-Terminal
javac -d bin src/jogo/Jogo.java
java -cp bin jogo.Jogo

🧙 Sistema de Classes
Classe	HP	Habilidade Especial	Tipo de Dano
Guerreiro	120	Golpe Poderoso (25 dmg)	Físico
Mago	80	Bola de Fogo (30-39 dmg)	Mágico
Necromante	85	Drenar Vida (18 dmg + cura)	Híbrido
📚 Documentação Técnica
Diagrama de Classes

Documento de Design do Jogo

Princípios POO Aplicados

🤝 Contribuição
Faça um fork do projeto

Crie sua branch (git checkout -b feature/sua-feature)

Commit suas mudanças (git commit -m 'Adiciona nova feature')

Push para a branch (git push origin feature/sua-feature)

Abra um Pull Request

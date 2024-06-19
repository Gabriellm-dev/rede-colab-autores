### Explicação do Programa

Este programa simula uma rede de colaboração entre autores usando conceitos de grafos. Em um grafo, temos vértices (nós) que representam os autores e arestas (conexões) que representam colaborações entre eles.

#### Componentes do Programa

1. **Autor**: Representa um autor com um nome.
2. **Grafo**: Representa a rede de colaboração, onde cada autor pode colaborar com outros autores.
3. **Centralidade**: Calcula três tipos de centralidade (Degree, Betweenness e Closeness) para os autores na rede.
4. **Menu**: Interface do usuário para interagir com o programa, permitindo adicionar autores, colaborações e calcular centralidades.

#### Medidas de Centralidade

1. **Centralidade de Grau (Degree Centrality)**: Mede o número de conexões diretas que um autor tem. 
   - **Exemplo**: Se Fulano colabora com Ciclano e Beltrado, Fulano tem uma centralidade de grau de 2.

2. **Centralidade de Intermediação (Betweenness Centrality)**: Mede a frequência com que um autor aparece nos caminhos mais curtos entre outros autores.
   - **Exemplo**: Se Fulano é frequentemente um intermediário nas colaborações entre outros autores, ele terá uma alta centralidade de intermediação.

3. **Centralidade de Proximidade (Closeness Centrality)**: Mede o quão perto um autor está de todos os outros autores na rede. É a inversa da soma das distâncias mais curtas de um autor para todos os outros.
   - **Exemplo**: Se Fulano pode alcançar todos os outros autores rapidamente através de poucas colaborações, ele terá uma alta centralidade de proximidade.

### Exemplos

Vamos usar um exemplo com cinco autores: Fulano, Ciclano, Beltrado, Tala e Zala.

- **Fulano**: Colabora com Ciclano e Beltrado
- **Ciclano**: Colabora com Fulano e Zala
- **Beltrado**: Colabora com Fulano
- **Tala**: Colabora com Zala
- **Zala**: Colabora com Tala e Ciclano

#### Centralidade de Grau
- **Fulano**: 2 (Ciclano e Beltrado)
- **Ciclano**: 2 (Fulano e Zala)
- **Beltrado**: 1 (Fulano)
- **Tala**: 1 (Zala)
- **Zala**: 2 (Tala e Ciclano)

#### Centralidade de Intermediação
- **Fulano**: Alto (Como intermediário entre Ciclano e Beltrado)
- **Ciclano**: Alto (Como intermediário entre Fulano e Zala)
- **Beltrado**: Baixo (Poucas colaborações)
- **Tala**: Baixo (Poucas colaborações)
- **Zala**: Médio (Como intermediário entre Tala e Ciclano)

#### Centralidade de Proximidade
- **Fulano**: Alto (Pode alcançar todos rapidamente)
- **Ciclano**: Alto (Pode alcançar todos rapidamente)
- **Beltrado**: Médio (Menos colaborações diretas)
- **Tala**: Baixo (Apenas uma colaboração)
- **Zala**: Médio (Pode alcançar outros mas não tão diretamente)

### Visualização Textual

Se você selecionar a opção de visualizar a rede de colaboração, verá algo assim:

```
Rede de Colaboração:
- Fulano: Colabora com Ciclano, Beltrado
- Ciclano: Colabora com Fulano, Zala
- Beltrado: Colabora com Fulano
- Tala: Colabora com Zala
- Zala: Colabora com Tala, Ciclano
```

---

Para rodar o programa a partir de um repositório no GitHub, você precisa seguir alguns passos. Aqui está um guia passo a passo:

### Passo 1: Clonar o Repositório

1. **Obter o Link do Repositório**:
   - Vá para a página do repositório no GitHub.
   - Clique no botão "Code" e copie o link do repositório (geralmente termina em `.git`).

2. **Clonar o Repositório**:
   - Abra o terminal (ou prompt de comando) no seu computador.
   - Navegue até o diretório onde você deseja clonar o repositório.
   - Execute o comando:
     ```
     git clone https://github.com/Gabriellm-dev/rede-colab-autores.git
     ```
   

### Passo 2: Navegar até o Diretório do Projeto

- Após clonar o repositório, navegue até o diretório do projeto:
  ```
  cd repository
  ```

### Passo 3: Compilar e Executar o Programa

Assumindo que o projeto é um projeto simples de Java sem ferramentas de build complexas como Maven ou Gradle, você pode compilar e executar o programa diretamente do terminal.

1. **Compilar o Programa**:
   - Certifique-se de que você está no diretório onde os arquivos `.java` estão localizados.
   - Compile os arquivos `.java`:
     ```
     javac *.java
     ```
   - Isso compilará todos os arquivos `.java` no diretório atual.

2. **Executar o Programa**:
   - Depois de compilar, você pode executar a classe principal. Assumindo que `Main` é a classe principal:
     ```
     java Main
     ```

### Passo 4: Interagir com o Programa

- Agora, você deve ver o menu do programa no console, e pode começar a interagir com ele conforme as opções disponíveis.


### Considerações Adicionais

- **Pré-requisitos**: Certifique-se de que o JDK (Java Development Kit) está instalado e configurado no seu sistema. Você pode verificar isso executando `javac -version` e `java -version` no terminal.

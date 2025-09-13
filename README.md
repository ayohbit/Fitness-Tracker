# Fitness Tracker

Aplicativo Android desenvolvido em Kotlin, projetado para auxiliar os usuários no acompanhamento de métricas de saúde essenciais: o Índice de Massa Corporal (IMC) e a Taxa Metabólica Basal (TMB).

## Funcionalidades

### Cálculo de IMC (Índice de Massa Corporal)

A funcionalidade de IMC permite que os usuários insiram seu peso e altura para calcular seu Índice de Massa Corporal. Após o cálculo, o aplicativo fornece uma classificação do resultado (por exemplo, 'Peso Normal', 'Sobrepeso', 'Obesidade'), ajudando o usuário a entender sua condição de saúde em relação ao peso. Os resultados podem ser salvos no histórico para acompanhamento.

### Cálculo de TMB (Taxa Metabólica Basal)

O cálculo de TMB estima a quantidade de calorias que o corpo queima em repouso para manter as funções vitais. Além de peso, altura e idade, o aplicativo incorpora o nível de atividade física do usuário para fornecer uma estimativa mais precisa das necessidades calóricas diárias. Assim como o IMC, os resultados da TMB podem ser registrados e revisados posteriormente.

### Banco de Dados Offline com Room

Para garantir a persistência e a acessibilidade dos dados, o aplicativo utiliza a biblioteca Room Persistence Library do Android. O Room é uma camada de abstração sobre o SQLite que facilita o trabalho com bancos de dados no Android, oferecendo uma forma robusta e eficiente de armazenar dados localmente. Isso significa que todos os cálculos de IMC e TMB, juntamente com suas datas, são salvos no dispositivo do usuário e podem ser consultados a qualquer momento, mesmo sem conexão com a internet. A funcionalidade de histórico permite visualizar, editar e excluir registros anteriores.

## Tecnologias Utilizadas

*   **Kotlin**: Linguagem de programação principal para o desenvolvimento Android.
*   **Android SDK**: Conjunto de ferramentas de desenvolvimento para a plataforma Android.
*   **Room Persistence Library**: Para gerenciamento de banco de dados SQLite offline.
*   **Material Design**: Para uma interface de usuário moderna e responsiva.
*   **RecyclerView**: Para exibir listas de histórico de cálculos de forma eficiente.

## Estrutura do Projeto

O projeto segue uma arquitetura modular, com as seguintes classes principais:

*   `MainActivity.kt`: Ponto de entrada do aplicativo, responsável por navegar entre as funcionalidades de IMC e TMB.
*   `ImcActivity.kt`: Lida com a lógica de cálculo e exibição do IMC, além de salvar os resultados.
*   `TmbActivity.kt`: Gerencia o cálculo e a exibição da TMB, incluindo a seleção do nível de atividade física e a persistência dos dados.
*   `ListCalcActivity.kt`: Exibe o histórico de cálculos de IMC e TMB, permitindo a edição e exclusão de registros.
*   `model/`: Contém as classes de modelo de dados (`Calc.kt`), a interface DAO (`CalcDao.kt`) e a classe do banco de dados (`AppDatabase.kt`) para o Room.

Contribuições são bem-vindas!

# AVL_AND_Normal_Trees
Implementation of a Binary Tree and AVL Tree using a linked list in Java.

Relatório de Desempenho de Árvores Binárias

Curso: Bacharelado em Ciência da Computação

Aluno: Marcelo Wzorek Filho

Introdução:

Este relatório tem como objetivo analisar o desempenho em termos de tempo e espaço de duas árvores binárias implementadas 
com o uso de listas encadeadas. Uma delas segue o modelo conceitual básico de uma árvore binária, enquanto a outra utiliza 
o conceito de AVL (Árvore Binária de Busca Balanceada), capaz de se auto-rebalancear.

Implementação das Árvores Binárias:

Ambas as árvores utilizam a mesma lógica, criando uma classe Node para criar e manipular as ramificações e folhas da árvore 
de maneira mais segura e clara. Os métodos básicos implementados também seguem um padrão, sendo eles a inserção, remoção e 
busca na árvore. A árvore AVL, por sua vez, possui métodos para seu rebalanceamento (rotação para a direita e para a esquerda).

Testes e Resultados:

Para realizar essa análise de desempenho de processos, foi utilizado o VisualVM (um ambiente para monitoramento). A principal 
vantagem de se utilizar esta ferramenta visual em vez de bibliotecas próprias, como o Hyperic SIGAR, ou outros ambientes, como o JMeter, 
foi a grande facilidade de uso para fins acadêmicos.

As tabelas a seguir representam os resultados em porcentagem (% do uso de CPU) para a realização das respectivas funções básicas implementadas:

Inserir um valor na árvore:                          Remover um valor na árvore:

╔════════════╦═══════════════╦════════════╗          ╔═══════════════╦════════════╗

║ Quantidade ║ Árvore Normal ║ Árvore AVL ║          ║ Árvore Normal ║ Árvore AVL ║

╠════════════╬═══════════════╬════════════╣          ╠═══════════════╬════════════╣

║ 100        ║ 0.520 %       ║ 0.610 %    ║          ║ 0.530 %       ║ 0.720 %    ║

╠════════════╬═══════════════╬════════════╣          ╠═══════════════╬════════════╣

║ 500        ║ 0.640 %       ║ 0.750 %    ║          ║ 0.610 %       ║ 0.790 %    ║

╠════════════╬═══════════════╬════════════╣          ╠═══════════════╬════════════╣

║ 1000       ║ 0.780 %       ║ 0.870 %    ║          ║ 0.840 %       ║ 0.910 %    ║

╠════════════╬═══════════════╬════════════╣          ╠═══════════════╬════════════╣

║ 10000      ║ 1.100 %       ║ 2.300 %    ║          ║ 1.110 %       ║ 1.220 %    ║

╠════════════╬═══════════════╬════════════╣          ╠═══════════════╬════════════╣

║ 20000      ║ 1.500 %       ║ 3.600 %    ║          ║ 1.360 %       ║ 1.570 %    ║

╚════════════╩═══════════════╩════════════╝          ╚═══════════════╩════════════╝

Buscar um valor na árvore:

╔═══════════════╦════════════╗

║ Árvore Normal ║ Árvore AVL ║

╠═══════════════╬════════════╣

║ 0.730 %       ║ 0.720 %    ║

╠═══════════════╬════════════╣

║ 0.850 %       ║ 0.770 %    ║

╠═══════════════╬════════════╣

║ 1.010 %       ║ 0.930 %    ║

╠═══════════════╬════════════╣

║ 1.530 %       ║ 1.000 %    ║

╠═══════════════╬════════════╣

║ 1.960 %       ║ 1.170 %    ║

╚═══════════════╩════════════╝


Análise de Desempenho:

A análise apresenta uma discrepância significativa no desempenho das tarefas. Podemos notar claramente nos métodos de inserção 
e remoção um consumo mais elevado na Árvore AVL em comparação com a implementação padrão. Por outro lado, no método de busca, 
observamos uma vantagem nítida de desempenho na Árvore AVL em comparação com a implementação padrão.

Conclusão:

Modelo Básico de Árvore:
Conclui-se que o modelo básico de árvore binária é preferível em cenários onde o número de folhas e de ramificações 
é suficientemente pequeno, de forma que não haja necessidade de rebalanceamento. Essa abordagem simplificada oferece a vantagem 
da eficiência nas operações com elementos, tornando-a uma boa escolha quando o espaço e o desempenho são primordiais.

Modelo AVL de Árvore:
Por outro lado, a árvore AVL é melhor em cenários onde o número de folhas e ramificações é substancialmente grande. 
O mecanismo de rebalanceamento permite manter a árvore em um estado altamente balanceado, garantindo que operações 
tenham uma complexidade previsível e controlada (O(log n)). Isso se traduz em uma vantagem quando se trabalha com conjuntos de 
dados volumosos, pois podemos determinar, com base nos índices de nível da árvore, qual é o pior cenário possível para percorrê-la, 
garantindo que o desempenho permaneça consistente. No entanto, deve-se observar que a complexidade no rebalanceamento pode aumentar 
o consumo de recursos em comparação com a árvore binária básica. Portanto, a escolha entre os modelos deve ser feita com base nas 
necessidades específicas do problema e nos recursos disponíveis para a implementação.



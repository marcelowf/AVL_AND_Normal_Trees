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

Inserir um valor na árvore:                                                            

╔════════╦══════════╦═══════╗                                     
║ Quantidade ║ Árvore Normal ║ Árvore AVL║                                    
╠════════╬══════════╬═══════╣                                   
║_100________║_0.520 %_______║_0.610 %____║                                    
╠════════╬══════════╬═══════╣                                   
║_500________║_0.640 %_______║_0.750 %____║                                     
╠════════╬══════════╬═══════╣                                   
║_1000_______║_0.780 %_______║_0.870 %____║                                     
╠════════╬══════════╬═══════╣                                   
║_10000______║_1.100 %_______║_2.300 %____║                                     
╠════════╬══════════╬═══════╣                                   
║_20000______║_1.500 %_______║_3.600 %____║                                     
╚════════╩══════════╩═══════╝                      

Remover um valor na árvore:

╔══════════╦═══════╗                                                                                  
║ Árvore Normal ║ Árvore AVL║                                                                                  
╠══════════╬═══════╣                                                                                   
║_0.530 %________║_0.720 %__║                                                                                  
╠══════════╬═══════╣                                                                                  
║_0.610 %________║_0.790 %__║                                                                                 
╠══════════╬═══════╣                                                                                  
║_0.840 %________║_0.910 %__║                                                                                 
╠══════════╬═══════╣                                                                                  
║_1.110 %________║_1.220 %__║                                                                                 
╠══════════╬═══════╣                                                                                  
║_1.360 %________║_1.570 %__║                                                                                 
╚══════════╩═══════╝                                                                                 

Buscar um valor na árvore:

╔══════════╦═══════╗                                                                                 
║ Árvore Normal ║ Árvore AVL║                                                                                 
╠══════════╬═══════╣                                                                                 
║_0.730 %________║_0.720 %__║                                                                                 
╠══════════╬═══════╣                                                                                 
║_0.850 %________║_0.770 %__║                                                                                 
╠══════════╬═══════╣                                                                                 
║_1.010 %________║_0.930 %__║                                                                                 
╠══════════╬═══════╣                                                                                 
║_1.530 %________║_1.000 %__║                                                                                 
╠══════════╬═══════╣                                                                                 
║_1.960 %________║_1.170 %__║                                                                                 
╚══════════╩═══════╝                                                                                 

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



# ContaMagica
Implementa uma conta de banco e casos de teste com base em análise de grafos. Todos os testes foram criados visando cobrir todas as
transições (arestas) necessárias, incluindo lançamentos de exceções.

## Testes

* Deposito Negativo: Este teste verifica o lançamento de um erro gerado ao executar a "transição" ocasionada pela ação 
deposito usando um valor menor ou igual a zero. Este teste foi executado em apenas um estado (Silver) pois a verificação de deposito 
é a mesma para qualquer estado. 

* Retirada Negativa: Este teste verifica o lançamento de um erro gerado ao executar a "transição" ocasionada pela ação retirada 
usando um valor menor ou igual a zero. Este teste foi executado em apenas um estado (Silver) pois a verificação de retirada 
é a mesma para qualquer estado.

* Retirada Maior que Saldo: Este teste verifica o lançamento de um erro que pode ser gerado ao executar a "transição" gerada pela 
ação de retirada usando um valor maior que o saldo existente. Este teste foi executado em apenas um estado (Silver) pois a 
verificação de retirada é a mesma para qualquer estado.

* Transição Silver Deposito: Executa três testes parametrizados de deposito, para verificar qual será o próximo estado, um com valor
baixo para manter-se em Silver, outro saldo suficiente para ir para Gold e um grande o suficiente para ir para Platinum, porem deve
ir apenas para Gold pois transição dupla não é permitida, verificando se as transições ocorreram como esperado.

* Transição Gold Deposito: Executa dois testes parametrizados de deposito, para verificar qual será o próximo estado, um com valor
baixo para manter-se em Gold, outro saldo suficiente para ir para Platinum, verificando se as transições ocorreram como esperado.

* Transição Platinum Retirada: Executa três testes parametrizados de retirada, para verificar qual será o próximo estado, um com valor
baixo para manter-se em Platinum, outro saldo suficiente para cair para Gold e um grande o suficiente para ir para Silver, porem 
deve ir apenas para Gold pois transição dupla não é permitida, verificando se as transições ocorreram como esperado.

* Transição Gold Retirada: Executa dois testes parametrizados de retirada, para verificar qual será o próximo estado, um com valor
baixo para manter-se em Gold, outro saldo suficiente para cair para Silver, verificando se as transições ocorreram como esperado.

* Bônus Deposito Gold: Verifica se na "transição" gerada por deposito em Gold o bonus de 10% está sendo aplicado ao deposito 
efetuado.

* Bônus Deposito Platinum: Verifica se na "transição" gerada por deposito em Platinum o bônus de 25% está sendo aplicado ao deposito 
efetuado.

## Code Coverage e Casos Testes Extras

No Code Coverage consta que 92% das instruções foram cobertas, não sendo considerado necessário o acréscimo de casos de teste 
como, a transição de retirada em Silver que apenas subtrai o valor de saldo já que o caso de exceção já foi coberto e o caso de
transição de deposito em Platinum já que não altera a o estado e seu caso de bônus já foi coberto.

Outro motivo para não adicionar outros casos de teste foi que parte da porcentagem não coberta é da classe INVALID_OPER_EXCEPTION
que possui dois construtores, mas apenas um é utilizado (o com a mensagem de erro).

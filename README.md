# api-relatorio-jasper

*** PEQUENO EXEMPLO DE GERAÇÃO DE RELATÓRIO JASPER (CONVERTIDO EM BINARIO64), APÓS RECEBER AS INFORMAÇÕES DO RELATÓRIO NO CORPO DA REQUISIÇÃO.

1 - APÓS BAIXAR O PROJETO E EXECUTÁ-LO, ENVIE UMA REQUISIÇÃO DO TIPO GET COM O SEGUINTE CORPO -> {"id": "1","email": "teste.@teste.com","senha": "123456","perfil": "admin"}

2 - CRIAR UMA VARIAVEL DE NOME "response" NO PRÓPRIO CONSOLE DO NAVEGADOR E ATRIBUIR A ELA O VALOR DA RESPOSTA DA REQUISIÇÃO FEITA ACIMA

3 - EXECUTAR ESTE COMANDO PARA VISUALIZAR O LAYOUT DO RELATÓRIO -> window.open('data:application/pdf;base64,' + response, '', 'width=700px,height=900px');

***OBS.: A SEGUINTE API PODE SER FACILMENTE MODIFICADA PARA RECEBER UMA LISTA E IMPRIMI-LA NO LAYOUT DO RELATÓRIO...

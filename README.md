# ibge
Projeto web cujo objetivo e consumir o Web Service do IBGE para retornar as Unidades Federativas com seus respectivos municípios. 
O WebService e composto por duas URL:
<ul>
<li>Dados UF: http://ibge.herokuapp.com/estado/UF</li>
<li>Nomes Municipios: http://ibge.herokuapp.com/municipio/?val=<SiglaUf> </li>
</ul>

Para maiores informações sobre o serviço consulte o link: http://ibge.herokuapp.com/

<h2>Requisitos </h2>

O projeto foi construido usando a IDE Eclipse e as seguintes tecnologias e bibliotecas abaixo:
<ul>
<li>Maven</li>
<li>JSF</li>
<li>Primefaces</li>
<li>Jboss as 7.1.1.Final</li>
<li>Java 7</li>
<li>Lib Gson</li>
<li>Lib CDI-API</li>
</ul>

<h2> Executando a aplicação</h2>

Após clonar ou fazer o download do projeto importe o projeto no ecplise através do maven. Depois disso pelas propriedades do projeto ou 
pelo buildPath inclua o servidor de aplicação.
Faça o build da aplicação no servidor e chame o projeto pela seguinte URL: http://localhost:8080/ibge

Você vera uma página com dois selectItens um listará as siglas das UFs e a outra carregara o nome dos municipios da respectiva UF. A lista
de nomes dos municipios e atualizada a cada vez que e escolhida uma nova UF.

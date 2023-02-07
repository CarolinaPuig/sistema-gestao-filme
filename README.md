# Sistema de gestão de filmes da Locadora X

> Para ultilizar este sistema é necessário cria a tabela Filmes em sua conexão oracle conforme indicado abaixo:
  
```  
create table filmes (
   codigo varchar(5) not null primary key,
   titulo varchar(35),
   genero varchar(8),
   produtora varchar(15)
  )
```

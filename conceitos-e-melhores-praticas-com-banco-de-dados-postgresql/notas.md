# Notas de Aula

## Arquivo postgresql.conf
- Armazenas todas as configs do servidor PostgreSQL.
- A view pg_settings acessada dentro do banco de dados guarda todas as configurações atuais.
```sql
select NAME, SETTING FROM pg_settings;

ou

SHOW [parametro]
```

- Configs principais (# significa que está comentado)
    - #listen_addresses = 'localhost' - endereços que podem acessar o postgresql.
    - #port = 5432 - porta padrão, mas pode ser alterada.
    - max_connections = 100.
    - #superuser_reserved_connections = 3 - conexões específicas para o super usuário do banco de dados.
    - #authentication_timeout = 1min - tempo máximo para conseguir conexão no banco.
    - #password_encryption = md5 - algoritmo de criptografia para senhas dos novos usuários criados no banco de dados.
    - #ssl = off - habilita conexão criptografada por SSL.
    - shared_buffers = 128MB - tamanho da memória compartilhada para cache/buffer de tabelas índices e demais relações.
    - #work_mem = 4MB - tamanho da memória para operações de agrupamento e ordenação (order by, distinct, merge joins).
    - #maintenance_work_mem = 64MB - tamaho da memória para operações como vacuum, index, alter table.

## Arquivo pg_hba.conf

- Controle de autenticação de usuários no servidor PostgreSQL.
- Métodos de autenticação:
  - TRUST (sem senha)
  - REJECT (rejeita conexões)
  - MD5
  - PASSWORD (senha sem criptografia)
  - GSS (generic security service application program interface)
  - SSPI (security support provider interface - somente para Windows)
  - KRB5 (Kerberos V5)
  - IDENT (utiliza o usuário do SO via ident server)
  - PEER (usuário do SO cliente)
  - LDAP (ldap server)
  - RADIUS (radius server)
  - CERT (autenticação via certificado ssl do cliente)
  - PAM (pluggable authentication modules)

## Arquivo pg_ident.conf

- Mapear dos usuários no SO com os usuários do banco de dados.
- A opção `ident` deve estar mapeada no arquivo `pg_hba.conf`.

## Arquitetura/Hierarquia

- Cluster
  - Coleção de banco de dados que compartilham as mesmas configurações (arquivos de config) do PostegreSQL e do sistema operacional (porta, Address, etc).
- Banco de dados
  - Conjunto de schemas com seus objetos/relações (tabelas, funções, views, etc).
- Schemas
  - Conjunto de objetos e relações (tabelas, funções, views, types, triggers, etc).
  - MySQL -> create schema é o mesmo que create database, por exemplo, mas nem todos os SGBDs são assim.

# PGAdmin

Importante para Conexão

1. Liberar acesso ao cluster em postgresql.conf.
2. Liberar acesso ao cluster para o usuário do banco de dados em pg_hba.conf.
3. Criar/Editar usuários.

# Fundamentos de SQL

- A query abaixo lista todas as colunas de todas as tabelas do banco de dados:

```sql
SELECT * FROM information_schema.columns;
```

## Funções de Agregação

Exemplos:

- AVG - Average - Média

```sql
SELECT AVG(valor) FROM cliente_transacoes;
```

- COUNT (having)

```sql
SELECT COUNT(numero) FROM cliente;

// group by
SELECT COUNT(numero), email FROM cliente WHERE email ILIKE '%gmail.com' GROUP BY email;
// `group by` porque a função é de agregação, então precisa agrupar o e-mail

// group by e having
SELECT COUNT(id), tipo_transacao_id FROM cliente_transacoes GROUP BY tipo_transacao_id HAVING COUNT(id) > 150; 
```

- MAX

```sql
SELECT MAX(valor) FROM cliente_transacoes;
```

- MIN

```sql
SELECT MIN (valor) FROM cliente_transacoes;
```

- SUM

```sql
SELECT SUM(valor), tipo_transacao_id FROM cliente_trancacoes GROUP BY tipo_transacao_id;
```

# Joins

- JOIN (INNER): busca dados que estão nas 2 tabelas (intersecção de conjuntos).
- LEFT JOIN (OUTER): busca dados da tabela da esquerda e se houver relacionamento na tabela da direita, traz, se não, traz nulo.
- RIGHT JOIN (OUTER): busca dados da tabela da direita e se houver relacionamento na tabela da esquerda, traz, se não, traz nulo.
- FULL JOIN (OUTER): todas as relações possíveis, de ambos os lados.
- CROSS JOIN: todos os dados de uma tabela serão cruzados com todos os dados de outra tabela referenciada no CROSS JOIN criando uma matriz.

```sql
SELECT tabela_1.campos, tabela_2.campos FROM tabela_1 CROSS JOIN tabela_2;
```

# CTE

Commom Table Expression

CRUDs usando cláusula WITH, melhor que SUBQUERIES.

# Views

Views são camadas das tabelas.

São um alias para uma ou mais queries.

Aceitam comandos de CRUD, porém, INSERT, UPDATE e DELETE só é permitido em views de uma única tabela. Se tiver JOIN, não será permitido.


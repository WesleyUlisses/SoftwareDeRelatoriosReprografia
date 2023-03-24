# Controle de Reprografia 

Este projeto foi desenvolvido utilizando Java e JavaFX para fornecer uma solução de controle de reprografia para o Instituto Federal Baiano de Educação, Ciência e Tecnologia - Campus Itapetinga. 

![image](https://user-images.githubusercontent.com/90068576/227588719-69c131a7-5872-4f8a-82ca-2799607761d5.png)

# Funcionalidades
  * Cadastro de Usuarios
  * Cadastro de Pessoas
  * Relatórios de Serviços Realizados
  * Configuração de Impressões

# Banco de Dados
  O banco de dados utilizado neste projeto é o MySQL. Você pode importar o arquivo controle_reprografia.sql, localizado na pasta database, para criar a estrutura do    banco de dados e suas tabelas.

# Configuração do Banco de Dados
Antes de executar a aplicação, você precisará configurar o acesso ao banco de dados. Edite o arquivo application.properties localizado em src/conection/Conexao.java/ e altere as seguintes linhas com suas informações de conexão ao banco de dados:

            String url = "jdbc:mysql://localhost:3306/datacenter";
            String usuario = "root"; // Insira seu usuario local
            String senha ="2002"; // Insira sua senha local
            conn =  DriverManager.getConnection(url, usuario, senha);

Certifique-se de ter o MySQL instalado e rodando na porta padrão (3306). Além disso, você precisará criar um usuário com acesso ao banco de dados e configurar suas permissões de acesso.

# Utilizando o MySQL Workbench
Você também pode utilizar o MySQL Workbench para gerenciar o banco de dados do projeto. Após importar o arquivo controle_reprografia.sql, abra o MySQL Workbench e crie uma nova conexão. Informe o nome da conexão, o host (geralmente localhost), a porta (3306), o nome do banco de dados (controle_reprografia), o nome do usuário e a senha. Em seguida, clique em "Test Connection" para testar a conexão e, se estiver tudo correto, clique em "OK" para salvar a conexão. Você pode utilizar o MySQL Workbench para visualizar e editar os dados do banco de dados do projeto.

# Como Executar
Para executar o projeto, basta clonar o repositório e importá-lo em sua IDE Java preferida. Certifique-se de ter as versões mais recentes do Java e JavaFX instaladas. Em seguida, execute o arquivo Main.java localizado na pasta src/main/java/ como um aplicativo Java.

# Contribuições
Contribuições são sempre bem-vindas! Sinta-se à vontade para abrir um pull request com suas alterações ou sugerir melhorias através das issues.

# Licença
Este projeto está licenciado sob a licença MIT - consulte o arquivo LICENSE.md para obter mais detalhes.

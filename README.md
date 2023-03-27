# Explicação de auxilio para uso da branch dev

A branch "dev" é uma ramificação do código fonte de um projeto de software, que é utilizada para desenvolvimento de novas funcionalidades ou correções de bugs. É importante seguir algumas orientações e cuidados ao utilizar essa branch, para garantir a estabilidade e qualidade do código e evitar conflitos com outros desenvolvedores que também estão trabalhando na mesma branch. Aqui estão algumas dicas:

1. Atualize a branch "dev" antes de começar a trabalhar: Sempre execute o comando "git pull" na branch "dev" antes de começar a desenvolver novas funcionalidades ou correções de bugs. Isso garante que você esteja trabalhando na versão mais atualizada da branch.

2. Crie uma nova branch para sua funcionalidade ou correção de bug: Evite fazer alterações diretamente na branch "dev". Em vez disso, crie uma nova branch a partir da branch "dev" com um nome descritivo da funcionalidade ou correção de bug que está sendo desenvolvida. Isso ajuda a manter o histórico do projeto mais organizado e facilita a revisão de código.

3. Faça commits frequentes: É importante fazer commits frequentes na sua branch de trabalho para que as alterações sejam salvas e o código esteja sempre atualizado. Isso também ajuda na revisão de código e na identificação de possíveis conflitos.

4. Faça testes antes de fazer push: Antes de fazer push das suas alterações para a branch "dev", faça testes locais para verificar se as funcionalidades ou correções de bugs estão funcionando corretamente. Certifique-se de que todas as funcionalidades estão implementadas e funcionando corretamente, e que o código está seguindo as boas práticas e padrões definidos pelo projeto.

5. Faça revisão de código: Após finalizar as alterações na sua branch de trabalho, faça uma revisão de código antes de fazer o merge com a branch "dev". Isso ajuda a garantir a qualidade do código e a identificar possíveis conflitos.

6. Evite conflitos com outras branches: Ao fazer o merge da sua branch de trabalho com a branch "dev", verifique se há conflitos com outras branches que foram desenvolvidas simultaneamente. Certifique-se de que as alterações da sua branch não interferem no trabalho de outros desenvolvedores que estão trabalhando em outras branches.

Seguindo essas orientações e cuidados, é possível trabalhar de forma colaborativa e organizada na branch "dev" de um projeto de software, garantindo a qualidade e estabilidade do código.

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
Antes de executar a aplicação, você precisará configurar o acesso ao banco de dados. Edite o arquivo Conexao.java localizado em src/conection/Conexao.java/ e altere as seguintes linhas com suas informações de conexão ao banco de dados:

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

# Créditos
Este projeto foi desenvolvido como um trabalho acadêmico pelos seguintes autores:

* Maria Fernanda Fernandes | Desgner e FrontEnd ([LinkedIn](https://www.linkedin.com/in/maria-fernanda-fernandes-0a8aa6250/) | [GitHub](https://github.com/mafxrnandxs))
* Raquel Ribeiro | Desgner e FrontEnd ([LinkedIn](https://www.linkedin.com/in/raquel-ribeiro-553b25260/) | [GitHub](https://github.com/ribeiroraquel))
* Lucas de Oliveira | Full Stack Developer ([LinkedIn](https://www.linkedin.com/in/lucas-de-oliveira-b39b41206/) | [GitHub](https://github.com/kollhall))
* Ayrthon Lopes | BackEnd Developer ([LinkedIn](https://www.linkedin.com/in/ayrton-lopes/) | [GitHub](https://github.com/Ayrton54))
* Wesley Ulisses | Engenheiro de Software ([LinkedIn](https://www.linkedin.com/in/wesley-ulisses/) | [GitHub](https://github.com/WesleyUlisses))

Agradecimentos especiais ao professor Francisco Hélio pela orientação e suporte durante o desenvolvimento do projeto.


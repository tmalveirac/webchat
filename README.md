webchat
=======

Engenharia de Computação
Disciplina: Programação Paralela e Distribuída
Professor: Cidcley Teixeira
Projeto: Chat com WebService, Corba e JMS
Autor: Tiago Malveira Cavalcante


COMO INICIAR A APLICAÇÃO:

PASSO 1: Iniciar o servidor de Nomes (sudo tnameserv);

PASSO 2: Iniciar o OpenJMS (arquivos startup.sh e admin.sh no Diretório do OPENJMS);

PASSO 3: Iniciar Servidor Corba (executar "sh run.sh ServidorCorba" no Diretório WebChat/CORBAJMS)
OBS. o script run.sh deve ser modificado conforme diretório do OpenJMS)

PASSO 4: Iniciar o Publicador WebService (Executar no Netbeans a classe Publicador.java no pacote br.ifce.ppd.com)

PASSO 5: Executar a aplicação cliente (Arquivo Login.java ou a partir do projeto).


COMO UTILIZAR A APLICAÇÃO:

Para fazer o LOGIN, o usuário deve primeiro se CADASTRAR e depois clicar em ENTRAR;

A janela Principal exibe a lista de usuários cadastrados no lado esquerdo e conforme as conversas são iniciadas, as abas correspondentes são geradas.


OBSERVAÇÕES:

Em caso de tentativa de login com um usuário já logado, o sistema exbirá uma mensagem de alerta;


DÚVIDAS:

Entrar em contato pelo e-mail tmalveirac@gmail.com

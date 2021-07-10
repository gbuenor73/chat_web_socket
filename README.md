## Obs. Este sistema está fora do ar no momento, caso queira testar, favor entrar em contao comigo para a liberação do mesmo

# Projeto de exemplo de chat global + APi para acesso as informações do chat

Nas ultimas atualizações:
* Mudanças visuais como, backgroud e cores da aplicação.
* Implementação do HATEOAS.

Para o correto funcionamento da aplicação é necessario informar as seguinte variaveis de ambiente.

* AMB_DPL= ambiente de deploy (lcl, dev ou pdr)
* BD_PASS= senha do banco de dados

## Links para acesso:
### Ambiente de desenvolvimento e teste:
<br>https://gbuenor-chat-dev.herokuapp.com/chat
<br>https://gbuenor-chat-dev.herokuapp.com/chat/more/getAllUsers
<br>https://gbuenor-chat-dev.herokuapp.com/chat/more/getUser/{Id}
<br>https://gbuenor-chat-dev.herokuapp.com/chat/more/getAllMessages
<br>https://gbuenor-chat-dev.herokuapp.com/chat/more/getMessages/{Nick}
<br> Id -> Id referente ao usuario, caso não possua procurar em getAllUsers
<br> Nick -> Usuario informado antes de enviar a mensagem no chat 

### Ambiente de produção:

<br>https://gbuenor-chat.herokuapp.com/chat
<br>https://gbuenor-chat.herokuapp.com/chat/more/getAllUsers
<br>https://gbuenor-chat.herokuapp.com/chat/more/getUser/{Id}
<br>https://gbuenor-chat.herokuapp.com/chat/more/getAllMessages
<br>https://gbuenor-chat.herokuapp.com/chat/more/getMessages/(Nick)
<br> Id -> Id referente ao usuario, caso não possua procurar em getAllUsers
<br> Nick -> Usuario informado antes de enviar a mensagem no chat


## Change Log
### Version's
* 1.2.0
    * Implementação do <a href=https://flywaydb.org/>flyway</a> para migração do banco de dados
    * Alteração do apontamento do banco de dados para AWS.

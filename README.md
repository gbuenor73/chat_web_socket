# Projeto de teste para entrevista da empresa Tupinambá Energia

Nas ultimas atualizações:
* Mudanças visuais como, backgroud e cores da aplicação.
* Implementação do HATEOAS.

Para o correto funcionamento da aplicação é necessario informar as seguinte variaveis de ambiente.

* AMB_DPL= ambiente de deploy (lcl, dev ou pdr)
* BD_PASS= senha do banco de dados

## Links para acesso:
### Ambiente de desenvolvimento e teste:
<br>https://desafio-chat-tupinamba-hml.herokuapp.com/chat
<br>https://desafio-chat-tupinamba-hml.herokuapp.com/chat/more/getAllUsers
<br>https://desafio-chat-tupinamba-hml.herokuapp.com/chat/more/getUser/{Id}
<br>https://desafio-chat-tupinamba-hml.herokuapp.com/chat/more/getAllMessages
<br>https://desafio-chat-tupinamba-hml.herokuapp.com/chat/more/getMessages/{Nick}
<br> Id -> Id referente ao usuario, caso não possua procurar em getAllUsers
<br> Nick -> Usuario informado antes de enviar a mensagem no chat 

### Ambiente de produção:

<br>https://desafio-chat-tupinamba.herokuapp.com/chat
<br>https://desafio-chat-tupinamba.herokuapp.com/chat/more/getAllUsers
<br>https://desafio-chat-tupinamba-hml.herokuapp.com/chat/more/getUser/{Id}
<br>https://desafio-chat-tupinamba.herokuapp.com/chat/more/getAllMessages
<br>https://desafio-chat-tupinamba.herokuapp.com/chat/more/getMessages/(Nick)
<br> Id -> Id referente ao usuario, caso não possua procurar em getAllUsers
<br> Nick -> Usuario informado antes de enviar a mensagem no chat

user: tupi;
password: tupi123;

show databases;
use teste_tupi;
show tables;

drop table users;
CREATE TABLE users (
    id INTEGER(30) UNSIGNED AUTO_INCREMENT NOT NULL,
    name VARCHAR(30) NOT NULL,
    nick VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
SELECT
    *
FROM
    users;
insert into users (name,nick)values('Gabriel', 'bueno');

drop table messages;
CREATE TABLE messages (
    id INTEGER(30) UNSIGNED AUTO_INCREMENT NOT NULL,
    id_send INTEGER(30) UNSIGNED NOT NULL,
    id_receiver INTEGER(30) UNSIGNED NOT NULL,
    message VARCHAR(255) NOT NULL,
    date_message DATETIME NOT NULL,
    PRIMARY KEY (id)
)  ENGINE=INNODB;
ALTER table messages ADD constraint foreign key(id_send) references users(id);
ALTER table messages ADD constraint foreign key(id_receiver) references users(id);

SELECT
    *
FROM
    messages;

insert into messages (id_send, id_receiver, message, dateMessage)
values(1,1,'TESTE DE MENSAGEM', current_timestamp());

SELECT
    *
FROM
    messages m
        INNER JOIN
    users u ON id_send = u.id;
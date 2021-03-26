user: websocket;
password: ws123456;

show databases;

use websocket;
show tables;

SELECT
    *
FROM
    users;

SELECT
    *
FROM
    messages;

SELECT
    *
FROM
    messages m
        INNER JOIN
    users u ON id_send = u.id;
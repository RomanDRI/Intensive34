DROP TABLE USERS;
 DROP TABLE ORDERS;
CREATE TABLE if not exists ORDERS (
    id int auto_increment,
    number_of_order integer UNIQUE NOT NULL,
    PRIMARY KEY (id)
);


CREATE TABLE if not exists USERS (
    id int auto_increment,
    full_name VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL,
    order_id bigint NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_USER_ORDER
    FOREIGN KEY (order_id)
    REFERENCES ORDERS(id)
    );

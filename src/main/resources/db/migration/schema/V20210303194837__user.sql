CREATE TABLE tb_user (
    id int8 NOT NULL PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    age INTEGER NOT NULL,
    phone VARCHAR(15) NOT NULL,
    email VARCHAR(50) NOT NULL,
    gender VARCHAR(1) NOT NULL,
    specific_id uuid NOT NULL
);
CREATE SEQUENCE IF NOT EXISTS categoria_id_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE categorias (
                            id BIGINT PRIMARY KEY DEFAULT nextval('categoria_id_seq'),
                            nombre VARCHAR(255) NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS cliente_id_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE clientes (
                          id BIGINT PRIMARY KEY DEFAULT nextval('cliente_id_seq'),
                          nombre VARCHAR(255) NOT NULL,
                          correo VARCHAR(255) NOT NULL
);

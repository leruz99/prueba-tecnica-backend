CREATE SEQUENCE IF NOT EXISTS orden_id_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE orden (
                       id BIGINT PRIMARY KEY DEFAULT nextval('orden_id_seq'),
                       fecha DATE NOT NULL,
                       cliente_id BIGINT NOT NULL,
                       FOREIGN KEY (cliente_id) REFERENCES clientes (id) ON DELETE CASCADE
);

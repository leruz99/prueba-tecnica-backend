CREATE SEQUENCE IF NOT EXISTS producto_id_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE productos (
                           codigo BIGINT PRIMARY KEY DEFAULT nextval('producto_id_seq'),
                           nombre VARCHAR(255) NOT NULL,
                           caracteristicas TEXT,
                           precio NUMERIC(10, 2) NOT NULL,
                           empresa_nit VARCHAR(20) NOT NULL,
                           FOREIGN KEY (empresa_nit) REFERENCES empresas (nit) ON DELETE CASCADE
);


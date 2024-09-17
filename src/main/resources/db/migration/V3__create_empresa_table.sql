CREATE SEQUENCE IF NOT EXISTS empresa_id_seq
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

CREATE TABLE empresas (
                          nit VARCHAR(20) PRIMARY KEY,
                          nombre VARCHAR(255) NOT NULL,
                          direccion VARCHAR(255),
                          telefono VARCHAR(20)
);

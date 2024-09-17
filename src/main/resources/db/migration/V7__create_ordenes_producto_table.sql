CREATE TABLE orden_productos (
                                orden_id BIGINT NOT NULL,
                                productos_codigo BIGINT NOT NULL,
                                PRIMARY KEY (orden_id, productos_codigo),
                                FOREIGN KEY (orden_id) REFERENCES orden(id) ON DELETE CASCADE,
                                FOREIGN KEY (productos_codigo) REFERENCES productos(codigo) ON DELETE CASCADE
);
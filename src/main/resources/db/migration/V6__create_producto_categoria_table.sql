CREATE TABLE producto_categoria (
                                    producto_id BIGINT NOT NULL,
                                    categoria_id BIGINT NOT NULL,
                                    PRIMARY KEY (producto_id, categoria_id),
                                    FOREIGN KEY (producto_id) REFERENCES productos (codigo) ON DELETE CASCADE,
                                    FOREIGN KEY (categoria_id) REFERENCES categorias (id) ON DELETE CASCADE
);

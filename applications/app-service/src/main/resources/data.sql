-- schema.sql
CREATE TABLE IF NOT EXISTS categories (
                                          id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                          nombre VARCHAR(255),
    fecha_creacion TIMESTAMP,
    fecha_actualizacion TIMESTAMP
    );

CREATE TABLE IF NOT EXISTS comments (
                                        id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                        posts_id BIGINT,
                                        contenido TEXT,
                                        fecha_creacion TIMESTAMP,
                                        fecha_actualizacion TIMESTAMP
);

CREATE TABLE IF NOT EXISTS post (
                                    id BIGINT PRIMARY KEY AUTO_INCREMENT,
                                    categorias_id BIGINT,
                                    titulo VARCHAR(255),
    contenido TEXT,
    fecha_creacion TIMESTAMP,
    fecha_actualizacion TIMESTAMP
    );


-- data.sql
INSERT INTO categories (id, nombre, fecha_creacion, fecha_actualizacion) VALUES (1, 'Hogar', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO categories (id, nombre, fecha_creacion, fecha_actualizacion) VALUES (2, 'Tecnología', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO post (id, categorias_id, titulo, contenido, fecha_creacion, fecha_actualizacion) VALUES (1, 1, 'Gran fiesta en Colombia', 'Lorem imsum', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO post (id, categorias_id, titulo, contenido, fecha_creacion, fecha_actualizacion) VALUES (2, 2, 'Festival de Comida', 'Lorem imsum', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO comments (id, posts_id, contenido, fecha_creacion, fecha_actualizacion) VALUES (1, 1, 'ESTUPENDO!', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO comments (id, posts_id, contenido, fecha_creacion, fecha_actualizacion) VALUES (2, 2, 'ME ENCANTA!!!', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO categories (id, nombre, fecha_creacion, fecha_actualizacion) VALUES (3, 'Deportes', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO categories (id, nombre, fecha_creacion, fecha_actualizacion) VALUES (4, 'Cultura', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO post (id, categorias_id, titulo, contenido, fecha_creacion, fecha_actualizacion) VALUES (3, 3, 'Partido de Fútbol', 'Lorem imsum', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO post (id, categorias_id, titulo, contenido, fecha_creacion, fecha_actualizacion) VALUES (4, 4, 'Concierto de Música', 'Lorem imsum', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO comments (id, posts_id, contenido, fecha_creacion, fecha_actualizacion) VALUES (3, 3, 'VAMOS EQUIPO!', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
INSERT INTO comments (id, posts_id, contenido, fecha_creacion, fecha_actualizacion) VALUES (4, 4, 'EXCELENTE MÚSICA!', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
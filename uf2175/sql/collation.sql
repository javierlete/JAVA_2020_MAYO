CREATE TABLE IF NOT EXISTS spanishCollation (
    name01 VARCHAR(15) CHARSET utf8 COLLATE utf8_spanish_ci,
    name02 VARCHAR(15) CHARSET utf8 COLLATE utf8_spanish2_ci
) ENGINE=MyISAM;

INSERT INTO spanishCollation VALUES ('Baño', 'Baño'),('Carlos', 'Carlos'),('Cruzada', 'Cruzada'),('Chile', 'Chile'),('Llorar', 'Llorar'),('Lámina', 'Lámina'),('Loreto', 'Loreto'),('Dedo', 'Dedo');

SELECT * FROM spanishCollation ORDER BY name01;
SELECT * FROM spanishCollation ORDER BY name02;

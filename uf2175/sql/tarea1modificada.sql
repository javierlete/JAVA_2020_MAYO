-- MySQL Workbench Synchronization
-- Generated: 2020-07-22 13:40
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: javaee

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

ALTER TABLE `tarea1`.`companias` 
ADD PRIMARY KEY (`id`);
;

ALTER TABLE `tarea1`.`videojuegos` 
ADD INDEX `fk_videojuegos_companias_idx` (`compania_id` ASC),
ADD PRIMARY KEY (`id`);
;

ALTER TABLE `tarea1`.`videojuegos` 
ADD CONSTRAINT `fk_videojuegos_companias`
  FOREIGN KEY (`compania_id`)
  REFERENCES `tarea1`.`companias` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

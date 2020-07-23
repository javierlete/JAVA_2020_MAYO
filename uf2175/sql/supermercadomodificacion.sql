-- MySQL Workbench Synchronization
-- Generated: 2020-07-23 09:25
-- Model: Sakila Full
-- Version: 2.0
-- Project: Name of the project
-- Author: Mike

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

ALTER TABLE `supermercado`.`producto` 
ADD COLUMN `producto_detalles_id` INT(11) NOT NULL AFTER `id_usuario`,
ADD INDEX `fk_producto_producto_detalles1_idx` (`producto_detalles_id` ASC);
;

ALTER TABLE `supermercado`.`producto` 
ADD CONSTRAINT `fk_producto_producto_detalles1`
  FOREIGN KEY (`producto_detalles_id`)
  REFERENCES `sakila`.`producto_detalles` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

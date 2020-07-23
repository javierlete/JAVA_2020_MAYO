-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema tiendavirtual
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema tiendavirtual
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tiendavirtual` ;
USE `tiendavirtual` ;

-- -----------------------------------------------------
-- Table `tiendavirtual`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiendavirtual`.`roles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` TEXT(2000) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tiendavirtual`.`clientes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiendavirtual`.`clientes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nif` CHAR(9) NOT NULL,
  `nombre` VARCHAR(45) NULL,
  `apellidos` VARCHAR(90) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tiendavirtual`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiendavirtual`.`usuarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `roles_id` INT NOT NULL,
  `cliente_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC),
  INDEX `fk_usuarios_roles1_idx` (`roles_id` ASC),
  INDEX `fk_usuarios_cliente1_idx` (`cliente_id` ASC),
  CONSTRAINT `fk_usuarios_roles1`
    FOREIGN KEY (`roles_id`)
    REFERENCES `tiendavirtual`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuarios_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `tiendavirtual`.`clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tiendavirtual`.`productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiendavirtual`.`productos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `precio` DECIMAL(9,2) NOT NULL,
  `foto` VARCHAR(255) NULL,
  `descuento` INT NULL,
  `unidad_medida` VARCHAR(20) NULL,
  `precio_unidad_medida` DECIMAL(7,2) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tiendavirtual`.`facturas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiendavirtual`.`facturas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `numero` CHAR(6) NOT NULL,
  `fecha` DATE NOT NULL,
  `iva` INT NOT NULL,
  `clientes_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `numero_UNIQUE` (`numero` ASC),
  UNIQUE INDEX `fecha_UNIQUE` (`fecha` ASC),
  INDEX `fk_facturas_clientes1_idx` (`clientes_id` ASC),
  CONSTRAINT `fk_facturas_clientes1`
    FOREIGN KEY (`clientes_id`)
    REFERENCES `tiendavirtual`.`clientes` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `tiendavirtual`.`facturas_has_productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `tiendavirtual`.`facturas_has_productos` (
  `facturas_id` INT NOT NULL,
  `productos_id` INT NOT NULL,
  `cantidad` INT NOT NULL,
  `precio` DECIMAL(9,2) NOT NULL,
  `descuento` INT NOT NULL,
  PRIMARY KEY (`facturas_id`, `productos_id`),
  INDEX `fk_facturas_has_productos_productos1_idx` (`productos_id` ASC),
  INDEX `fk_facturas_has_productos_facturas1_idx` (`facturas_id` ASC),
  CONSTRAINT `fk_facturas_has_productos_facturas1`
    FOREIGN KEY (`facturas_id`)
    REFERENCES `tiendavirtual`.`facturas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_facturas_has_productos_productos1`
    FOREIGN KEY (`productos_id`)
    REFERENCES `tiendavirtual`.`productos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

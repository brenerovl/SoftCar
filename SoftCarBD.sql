-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema softcar
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema softcar
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `softcar` DEFAULT CHARACTER SET utf8 ;
USE `softcar` ;

-- -----------------------------------------------------
-- Table `softcar`.`gerente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `softcar`.`gerente` (
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `idGerente` INT(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idGerente`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `softcar`.`vagas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `softcar`.`vagas` (
  `idVagas` INT(11) NOT NULL AUTO_INCREMENT,
  `setor` VARCHAR(45) NOT NULL,
  `estado` INT(11) NOT NULL,
  PRIMARY KEY (`idVagas`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `softcar`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `softcar`.`usuario` (
  `idUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `vagas_idVagas` INT(11) NOT NULL,
  PRIMARY KEY (`idUsuario`, `vagas_idVagas`),
  UNIQUE INDEX `emai_UNIQUE` (`email` ASC) VISIBLE,
  INDEX `fk_usuario_vagas1_idx` (`vagas_idVagas` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_vagas1`
    FOREIGN KEY (`vagas_idVagas`)
    REFERENCES `softcar`.`vagas` (`idVagas`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `softcar`.`veiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `softcar`.`veiculo` (
  `placa` VARCHAR(7) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL,
  `tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`placa`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `softcar`.`usuario_has_veiculo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `softcar`.`usuario_has_veiculo` (
  `usuario_idUsuario` INT(11) NOT NULL,
  `veiculo_placa` VARCHAR(7) NOT NULL,
  PRIMARY KEY (`usuario_idUsuario`, `veiculo_placa`),
  INDEX `fk_usuario_has_veiculo_veiculo1_idx` (`veiculo_placa` ASC) VISIBLE,
  INDEX `fk_usuario_has_veiculo_usuario1_idx` (`usuario_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_usuario_has_veiculo_usuario1`
    FOREIGN KEY (`usuario_idUsuario`)
    REFERENCES `softcar`.`usuario` (`idUsuario`),
  CONSTRAINT `fk_usuario_has_veiculo_veiculo1`
    FOREIGN KEY (`veiculo_placa`)
    REFERENCES `softcar`.`veiculo` (`placa`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
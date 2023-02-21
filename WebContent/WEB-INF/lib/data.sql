-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema doranco-bd
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema doranco-bd
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `doranco-bd` DEFAULT CHARACTER SET utf8 ;
USE `doranco-bd` ;

-- -----------------------------------------------------
-- Table `doranco-bd`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `doranco-bd`.`User` ;

CREATE TABLE IF NOT EXISTS `doranco-bd`.`User` (
  `idUser` INT NOT NULL,
  `nom` VARCHAR(45) NOT NULL,
  `prenom` VARCHAR(45) NOT NULL,
  `sexe` VARCHAR(6) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `date_naissance` DATE NOT NULL,
  `qualite_service` VARCHAR(15) NOT NULL,
  `telephone` VARCHAR(12) NOT NULL,
  `disponible` VARCHAR(45) NOT NULL,
  `fonction_Actuelle` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUser`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `doranco-bd`.`Adresse`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `doranco-bd`.`Adresse` ;

CREATE TABLE IF NOT EXISTS `doranco-bd`.`Adresse` (
  `idAdresse` INT NOT NULL,
  `numero` VARCHAR(2) NOT NULL,
  `rue` VARCHAR(45) NOT NULL,
  `ville` VARCHAR(45) NOT NULL,
  `codePostal` VARCHAR(45) NOT NULL,
  `User_idUser` INT NOT NULL,
  PRIMARY KEY (`idAdresse`),
  INDEX `fk_Adresse_User1_idx` (`User_idUser` ASC) VISIBLE,
  CONSTRAINT `fk_Adresse_User1`
    FOREIGN KEY (`User_idUser`)
    REFERENCES `doranco-bd`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `doranco-bd`.`Langage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `doranco-bd`.`Langage` ;

CREATE TABLE IF NOT EXISTS `doranco-bd`.`Langage` (
  `idLangage` INT NOT NULL,
  `languge` VARCHAR(45) NOT NULL,
  `User_idUser` INT NOT NULL,
  PRIMARY KEY (`idLangage`),
  INDEX `fk_Langage_User1_idx` (`User_idUser` ASC) VISIBLE,
  CONSTRAINT `fk_Langage_User1`
    FOREIGN KEY (`User_idUser`)
    REFERENCES `doranco-bd`.`User` (`idUser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

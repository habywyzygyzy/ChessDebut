-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`MetaData`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`MetaData` ;

CREATE TABLE IF NOT EXISTS `mydb`.`MetaData` (
  `MetaId` INT NOT NULL,
  `Result` VARCHAR(5) NULL,
  PRIMARY KEY (`MetaId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Hit`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Hit` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Hit` (
  `HitId` INT NOT NULL,
  `Hit` VARCHAR(10) NULL,
  `StateBeforeHit` VARCHAR(40) NULL,
  `MetaId` INT NULL,
  PRIMARY KEY (`HitId`),
  INDEX `MetaId_idx` (`MetaId` ASC) VISIBLE,
  CONSTRAINT `MetaId`
    FOREIGN KEY (`MetaId`)
    REFERENCES `mydb`.`MetaData` (`MetaId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

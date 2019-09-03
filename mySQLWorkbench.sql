/*DROP TABLE IF EXISTS MetaData ;*/

CREATE TABLE IF NOT EXISTS MetaData (
  MetaId INT NOT NULL AUTO_INCREMENT,
  Result VARCHAR(10) NULL,
  PRIMARY KEY (MetaId))
ENGINE = InnoDB;

/*DROP TABLE IF EXISTS Hit ;*/

CREATE TABLE IF NOT EXISTS Hit (
  HitId INT NOT NULL AUTO_INCREMENT,
  Hit VARCHAR(10) NULL,
  StateBeforeHit DOUBLE NULL,
  MetaId INT NULL,
  PRIMARY KEY (HitId),
  /*INDEX MetaId_idx (MetaId ASC) VISIBLE,*/
  CONSTRAINT MetaId
    FOREIGN KEY (MetaId)
    REFERENCES MetaData (MetaId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
/*
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;*/
//DROP TABLE IF EXISTS MetaData;

CREATE TABLE IF NOT EXISTS MetaData
(
    MetaId    INT         NOT NULL AUTO_INCREMENT,
    Result    VARCHAR(10) NULL,
    GameYear  SMALLINT    NULL,
    Opening   VARCHAR(70) NULL,
    WhiteName VARCHAR(30) NULL,
    BlackName VARCHAR(30) NULL,
    WhiteELO  SMALLINT    NULL,
    BlackELO  SMALLINT    NULL,
    PRIMARY KEY (MetaId)
)
    ENGINE = InnoDB;

//DROP TABLE IF EXISTS Hit;

CREATE TABLE IF NOT EXISTS Hit
(
    HitId           INT        NOT NULL AUTO_INCREMENT,
    Hit             VARCHAR(7) NULL,
    StateBeforeHit  BIGINT     NULL,
    StateBeforeHit2 BIGINT     NULL,
    StateBeforeHit3 BIGINT     NULL,
    StateBeforeHit4 BIGINT     NULL,
    MetaId          INT        NULL,
    PRIMARY KEY (HitId),
    /*INDEX MetaId_idx (MetaId ASC) VISIBLE,*/
    /*CONSTRAINT MetaId
        FOREIGN KEY (MetaId)
            REFERENCES MetaData (MetaId)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION*/
)
    ENGINE = InnoDB;
CREATE INDEX IF NOT EXISTS index_name
    on Hit (StateBeforeHit, StateBeforeHit2, StateBeforeHit3, StateBeforeHit4, Hit);
/*
SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;*/
DROP TABLE IF EXISTS MetaData;
CREATE TABLE IF NOT EXISTS MetaData
(
    MetaId    INT         AUTO_INCREMENT NOT NULL,
    Result    VARCHAR(10) NULL,
    GameYear  SMALLINT    NULL,
    Opening   VARCHAR(70) NULL,
    WhiteName VARCHAR(50) NULL,
    BlackName VARCHAR(50) NULL,
    WhiteELO  SMALLINT    NULL,
    BlackELO  SMALLINT    NULL,
    PRIMARY KEY (MetaId)
);
//ENGINE = InnoDB;

DROP TABLE IF EXISTS Hit;
CREATE TABLE IF NOT EXISTS Hit
(
    HitId           INT        AUTO_INCREMENT NOT NULL,
    Hit             VARCHAR(7) NULL,
    StateBeforeHit  BIGINT     NULL,
    StateBeforeHit2 BIGINT     NULL,
    StateBeforeHit3 BIGINT     NULL,
    StateBeforeHit4 BIGINT     NULL,
    MetaId          INT        NULL,
    PRIMARY KEY (HitId),
    CONSTRAINT MetaId
    FOREIGN KEY (MetaId)
    REFERENCES MetaData (MetaId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
//ENGINE = InnoDB;

DROP INDEX IF EXISTS index_name;
//CREATE INDEX IF NOT EXISTS index_name
//ON Hit (Hit, StateBeforeHit ASC, StateBeforeHit2 ASC, StateBeforeHit3 ASC, StateBeforeHit4 ASC);
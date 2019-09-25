//DROP TABLE IF EXISTS `MetaData`;
CREATE TABLE IF NOT EXISTS `MetaData`
(
    `MetaId`    INT         AUTO_INCREMENT NOT NULL,
    `Result`    VARCHAR(10) NULL,
    `GameYear`  SMALLINT    NULL,
    `Opening`   VARCHAR(70) NULL,
    `WhiteName` VARCHAR(50) NULL,
    `BlackName` VARCHAR(50) NULL,
    `WhiteELO`  SMALLINT    NULL,
    `BlackELO`  SMALLINT    NULL,
    PRIMARY KEY (`MetaId`)
);

//DROP TABLE IF EXISTS `Hit`;
CREATE TABLE IF NOT EXISTS `Hit`
(
    `HitId`           INT        AUTO_INCREMENT NOT NULL,
    `Hit`             VARCHAR(7) NULL,
    `StateBeforeHit`  BIGINT     NULL,
    `StateBeforeHit2` BIGINT     NULL,
    `StateBeforeHit3` BIGINT     NULL,
    `StateBeforeHit4` BIGINT     NULL,
    `MetaId`          INT        NULL,
    PRIMARY KEY (`HitId`)
);
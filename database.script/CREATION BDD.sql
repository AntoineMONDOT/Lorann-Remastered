DELIMITER |
CREATE PROCEDURE getLevelCompById (IN LevelChoice INT)
SELECT x, y, sprite
FROM LevelStruct
WHERE IdLevel = LevelChoice 
ORDER BY x, y;
DELIMITER ;

#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------
CREATE DATABASE `Lorann` ;

USE `Lorann` ;

#------------------------------------------------------------
# Table: That contain all the levels and there ID
#------------------------------------------------------------

CREATE TABLE LevelList(
        IdLevel   int(3) Auto_increment  NOT NULL ,
        LevelName Varchar(50) ,
        PRIMARY KEY (IdLevel)
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: That contain all the structure off all level
#------------------------------------------------------------

CREATE TABLE LevelStruct(
        x         Int ,
        y         Int ,
        sprite	  char(1) NOT NULL ,
        IdLevel     Int NOT NULL ,
        PRIMARY KEY (IdLevel, x, y),
        CONSTRAINT FK_elementMap_IDlevel FOREIGN KEY (IdLevel) REFERENCES LevelList(IdLevel)
)ENGINE=InnoDB;
create database assignment01

use assignment01

CREATE TABLE IF NOT EXISTS `assignment01`.`customer` (
  `customerId` INT(11) NOT NULL AUTO_INCREMENT,
  `customerName` VARCHAR(255) NULL DEFAULT NULL,
  `customerAddress` VARCHAR(255) NULL DEFAULT NULL,
  `customerAge` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`customerId`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `assignment01`.`product` (
  `productNumber` INT(11) NOT NULL AUTO_INCREMENT,
  `productName` VARCHAR(255) NULL DEFAULT NULL,
   `dateOfPayment` DATE NULL DEFAULT NULL,
   `price`  FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`productNumber`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `assignment01`.`invoice` (
  `` INT(11) NOT NULL AUTO_INCREMENT,
  `productName` VARCHAR(255) NULL DEFAULT NULL,
   `dateOfPayment` DATE NULL DEFAULT NULL,
   `price`  FLOAT NULL DEFAULT NULL,
  PRIMARY KEY (`productNumber`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;



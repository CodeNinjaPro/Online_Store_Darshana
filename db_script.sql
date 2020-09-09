-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema online_store_darshana
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema online_store_darshana
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `online_store_darshana` DEFAULT CHARACTER SET utf8 ;
USE `online_store_darshana` ;

-- -----------------------------------------------------
-- Table `online_store_darshana`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store_darshana`.`employee` (
  `employee_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `designation` VARCHAR(45) NULL,
  `contact` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `basic_salary` DOUBLE NULL,
  `ot_rate` DOUBLE NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`employee_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `online_store_darshana`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store_darshana`.`customer` (
  `customer_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `contact` VARCHAR(45) NULL,
  `loyality` INT NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`customer_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `online_store_darshana`.`attedance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store_darshana`.`attedance` (
  `attendance_id` INT NOT NULL AUTO_INCREMENT,
  `month` VARCHAR(45) NULL,
  `no_of_days` DOUBLE NULL,
  `no_of_ot` DOUBLE NULL,
  `bonus` DOUBLE NULL,
  `advance` DOUBLE NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`attendance_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `online_store_darshana`.`stock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store_darshana`.`stock` (
  `stock_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `category` VARCHAR(45) NULL,
  `qty` INT NULL,
  `unit_price` DOUBLE NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`stock_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `online_store_darshana`.`invoice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store_darshana`.`invoice` (
  `invoice_id` INT NOT NULL AUTO_INCREMENT,
  `customer_id` INT NULL,
  `loyalty_points` INT NULL,
  `total` DOUBLE NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`invoice_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `online_store_darshana`.`supplier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store_darshana`.`supplier` (
  `supplier_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `contact` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`supplier_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `online_store_darshana`.`delivery`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store_darshana`.`delivery` (
  `delivery_id` INT NOT NULL AUTO_INCREMENT,
  `invoice_id` INT NULL,
  `address` VARCHAR(45) NULL,
  `status` VARCHAR(45) NULL,
  `driver_contact` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`delivery_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `online_store_darshana`.`grn`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store_darshana`.`grn` (
  `grn_id` INT NOT NULL AUTO_INCREMENT,
  `stock_id` INT NULL,
  `supplier_id` INT NULL,
  `qty` DOUBLE NULL,
  `total` DOUBLE NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`grn_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `online_store_darshana`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store_darshana`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(45) NULL,
  `user_type` VARCHAR(45) NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `online_store_darshana`.`invoice_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store_darshana`.`invoice_details` (
  `invoice_details_id` INT NOT NULL AUTO_INCREMENT,
  `invoice_id` INT NULL,
  `stock_id` INT NULL,
  `qty` INT NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`invoice_details_id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

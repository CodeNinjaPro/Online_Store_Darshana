-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema online_store_isp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema online_store_isp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `online_store_isp` DEFAULT CHARACTER SET utf8 ;
USE `online_store_isp` ;

-- -----------------------------------------------------
-- Table `online_store_isp`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store_isp`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `emp_id` INT NULL,
  `user_type` VARCHAR(45) NULL,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `online_store_isp`.`employee`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store_isp`.`employee` (
  `emp_id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `contact_number` VARCHAR(45) NULL,
  `designation` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`emp_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `online_store_isp`.`salary_shedule`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store_isp`.`salary_shedule` (
  `salary_shedule_id` INT NOT NULL AUTO_INCREMENT,
  `emp_id` INT NULL,
  `basic_salary` DOUBLE NULL,
  `ot_rate` DOUBLE NULL,
  `bonus` DOUBLE NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`salary_shedule_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `online_store_isp`.`attendance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store_isp`.`attendance` (
  `attendance_id` INT NOT NULL AUTO_INCREMENT,
  `emp_id` INT NULL,
  `month` VARCHAR(45) NULL,
  `no_of_days` DOUBLE NULL,
  `no_of_ot` DOUBLE NULL,
  `advance` DOUBLE NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`attendance_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `online_store_isp`.`item_registration`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store_isp`.`item_registration` (
  `item_registration_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `category` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  `unit_price` DOUBLE NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`item_registration_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `online_store_isp`.`stock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store_isp`.`stock` (
  `stock_id` INT NOT NULL AUTO_INCREMENT,
  `item_registration_id` INT NULL,
  `qty` DOUBLE NULL,
  `offer_presentage` DOUBLE NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`stock_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `online_store_isp`.`grn`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store_isp`.`grn` (
  `grn_id` INT NOT NULL AUTO_INCREMENT,
  `supplier_id` INT NULL,
  `total` DOUBLE NULL,
  `status` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`grn_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `online_store_isp`.`grn_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store_isp`.`grn_details` (
  `grn_details` INT NOT NULL AUTO_INCREMENT,
  `grn_id` INT NULL,
  `item_registration_id` INT NULL,
  `qty` DOUBLE NULL,
  `unit_price` DOUBLE NULL,
  `status` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`grn_details`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `online_store_isp`.`supplier`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store_isp`.`supplier` (
  `supplier_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `status` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`supplier_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `online_store_isp`.`invoice`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store_isp`.`invoice` (
  `invoice_id` INT NOT NULL AUTO_INCREMENT,
  `customer_id` INT NULL,
  `total` DOUBLE NULL,
  `offer_amount` DOUBLE NULL,
  `status` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`invoice_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `online_store_isp`.`invoice_details`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store_isp`.`invoice_details` (
  `invoice_details_id` INT NOT NULL AUTO_INCREMENT,
  `invoice_id` INT NULL,
  `item_registration_id` INT NULL,
  `qty` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`invoice_details_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `online_store_isp`.`delivary`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `online_store_isp`.`delivary` (
  `delivary_id` INT NOT NULL AUTO_INCREMENT,
  `invoice_id` INT NULL,
  `emp_id` INT NULL,
  `address` VARCHAR(45) NULL,
  `cus_contact` VARCHAR(45) NULL,
  `status` VARCHAR(45) NULL,
  `date_time` VARCHAR(45) NULL,
  PRIMARY KEY (`delivary_id`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


DROP SCHEMA IF EXISTS `cwadb` ;

CREATE SCHEMA IF NOT EXISTS `cwadb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `cwadb` ;

-- -----------------------------------------------------
-- Table `cwadb`.`clients`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cwadb`.`users` ;

CREATE TABLE IF NOT EXISTS `cwadb`.`users` (
	`user_id` BIGINT NOT NULL AUTO_INCREMENT,
    `email` VARCHAR(50) NOT NULL UNIQUE,
    `password` VARCHAR(255) NOT NULL,
    `first_name` VARCHAR(50) NOT NULL,
	`last_name` VARCHAR(50) NOT NULL,
    `phone` VARCHAR(15) NULL DEFAULT NULL,
    `role` VARCHAR(10) NOT NULL,
    `disabled` BOOLEAN NOT NULL default 1,
    
    PRIMARY KEY (`user_id`))
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Table `cwadb`.`bookings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cwadb`.`bookings` ;

CREATE TABLE IF NOT EXISTS `cwadb`.`bookings` (
	`booking_id` BIGINT NOT NULL AUTO_INCREMENT,
    `session_start` DATETIME NOT NULL,
    `status` VARCHAR(10) NOT NULL,
    `user_email` VARCHAR(50) NULL,
    `emp_id` BIGINT NULL DEFAULT NULL,
    
    PRIMARY KEY (`booking_id`))
AUTO_INCREMENT = 1;

-- -----------------------------------------------------
-- Table `cwadb`.`employees`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cwadb`.`employees` ;

CREATE TABLE IF NOT EXISTS `cwadb`.`employees` (
	`emp_id` BIGINT NOT NULL AUTO_INCREMENT,
    `email` VARCHAR(50) NOT NULL,
    `first_name` VARCHAR(50) NOT NULL,
	`last_name` VARCHAR(50) NOT NULL,

    PRIMARY KEY (`emp_id`))
AUTO_INCREMENT = 1;


-- -----------------------------------------------------
-- Adding constraints
-- -----------------------------------------------------
ALTER TABLE `cwadb`.`bookings` ADD CONSTRAINT `fk_book_to_cli` FOREIGN KEY (`user_email`) REFERENCES `cwadb`.`users` (`email`);
ALTER TABLE `cwadb`.`bookings` ADD CONSTRAINT `fk_book_to_emp` FOREIGN KEY (`emp_id`) REFERENCES `cwadb`.`employees` (`emp_id`);


-- -----------------------------------------------------
-- Inserting employees
-- -----------------------------------------------------

INSERT INTO employees (email, first_name, last_name)
VALUES ('jane.doe@clinic.ca', 'Jane', 'Doe');

INSERT INTO employees (email, first_name, last_name)
VALUES ('brie.gibson@clinic.ca', 'Brie', 'Gibson');

INSERT INTO employees (email, first_name, last_name)
VALUES ('paul.onile@clinic.ca', 'Paul', 'Onile');

INSERT INTO employees (email, first_name, last_name)
VALUES ('zola.bronson@clinic.ca', 'Zola', 'Bronson');

INSERT INTO employees (email, first_name, last_name)
VALUES ('david.mcdevitt@clinic.ca', 'David', 'McDevitt');

INSERT INTO employees (email, first_name, last_name)
VALUES ('christine.belle@clinic.ca', 'Christine', 'Belle');

-- -----------------------------------------------------
-- Inserting bookings
-- -----------------------------------------------------
#
# INSERT INTO bookings (session_start, session_end, status, user_email, emp_id)
# VALUES (NOW()+ INTERVAL 1 day, NOW()+ INTERVAL 1 day + INTERVAL 1 hour , 'scheduled', 'john@test.com', 1);
#
# INSERT INTO bookings (session_start, session_end, status, user_email, emp_id)
# VALUES (NOW()+ INTERVAL 1 day, NOW()+ INTERVAL 1 day + INTERVAL 1 hour , 'scheduled', 'john@test.com', 1);
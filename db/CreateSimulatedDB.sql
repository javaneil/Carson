##
## Enterprise Java Spring 2017
## Individual Project "Carson the Coffee Butler"
## Neil Fortney
##
## NOTE: For a deployed web application .WAR to connect to the MySQL server
##       the connector .jar must be copied to the Tomcat /lib directory
##       SSH into your ASW instance and install libmysql-java to get the .jar
##       $ sudo apt-get install libmysql-java
##       $ cd /usr/share/java
##       $ sudo cp mysql-connector-java-5.1.38.jar /opt/tomee/lib
##       $ sudo /opt/tomee/bin/shutdown.sh
##       $ sudo /opt/tomee/bin/startup.sh
##
DROP DATABASE IF EXISTS carson ;
CREATE DATABASE carson ;
USE carson ;

##
## Create empty tables
##
CREATE TABLE coffee (
  coffee_id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(25),
  description VARCHAR(100),
  vendor_name VARCHAR(25),
  vendor_address VARCHAR(25),
  vendor_city VARCHAR(25),
  vendor_st_prov VARCHAR(2),
  vendor_mail_code VARCHAR(25),
  vendor_phone VARCHAR(25),
  
  PRIMARY KEY ( coffee_id ) 
) ;
ALTER TABLE coffee AUTO_INCREMENT = 22001 ;


CREATE TABLE urns (
  urn_id INT NOT NULL AUTO_INCREMENT,
  inventory_number INT,
  brand VARCHAR(25),
  model VARCHAR(25),
  commission_date DATE,
  
  PRIMARY KEY ( urn_id ) 
) ;
ALTER TABLE urns AUTO_INCREMENT = 21001 ;


CREATE TABLE `records` (
  `record_id` INT NOT NULL AUTO_INCREMENT,
  `urn_id` INT,
  `coffee_id` INT,
  `current_location` VARCHAR(25),
  `start_date_time` DATETIME,
  PRIMARY KEY ( `record_id` ),
  
  KEY `fk_urn_id` ( `urn_id` ),
  CONSTRAINT `fk_urn_id` FOREIGN KEY ( `urn_id` )
    REFERENCES `urns` ( `urn_id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,

  KEY `fk_coffee_id` ( `coffee_id` ),
  CONSTRAINT `fk_coffee_id` FOREIGN KEY ( `coffee_id` )
    REFERENCES `coffee` ( `coffee_id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE
    
) ;
ALTER TABLE records AUTO_INCREMENT = 25001 ;


CREATE TABLE `samples` (
  `sample_id` INT NOT NULL AUTO_INCREMENT,
  `record_id` INT, 
  `elapse_time` INT,
  `liquid_level` INT,
  `temperature` INT,
  
  KEY `record_fk` ( `record_id` ),
  CONSTRAINT `fk_record_id` FOREIGN KEY ( `record_id` )
    REFERENCES `records` ( `record_id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    
  PRIMARY KEY ( `sample_id` )
) ;


### TODO: Add Authenication and Authorization tables ###
CREATE TABLE users (
user_name VARCHAR(15) NOT NULL PRIMARY KEY,
user_pass VARCHAR(15) NOT NULL
) ;

CREATE TABLE user_roles (
user_name VARCHAR(15) NOT NULL,
role_name VARCHAR(15) NOT NULL,
PRIMARY KEY (user_name, role_name)
) ;


USE mysql ;
DROP USER IF EXISTS 'tomcat'@'localhost' ;
CREATE USER 'tomcat'@'localhost' IDENTIFIED BY 'tomcat' ;
GRANT SELECT ON carson.* TO 'tomcat'@'localhost' ;
FLUSH PRIVILEGES ;
USE carson ;

##
## Fill tables with simulated data
##

# Default Authentication and Authorization values
INSERT INTO users VALUES
	('admin', 'admin'),
    ('emp',   'emp')
;
INSERT INTO user_roles VALUES
	('admin', 'administrator'),
    ('emp',   'employee')
;

## TODO: Read .csv files from other than the MySQL default data file location?
## If the MySQL server (not Workbench) cannot find/open the .csv files, you'll get an error like what follows:
## ERROR 1290: The MySQL server is running with the --secure-file-priv option so it cannot execute this statement
## You may use the following to find the path being used to look for the .csv file:
## SHOW VARIABLES LIKE 'secure_file_priv' ;

## Use following path when running local on Windows
#LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 5.7/Uploads/FakeCoffees.csv'
## Use this path when running remote on Ubuntu over SSH (you must copy the .csv file to Ubuntu environment first!)
LOAD DATA INFILE '/var/lib/mysql-files/FakeCoffees.csv'
  INTO TABLE coffee
  FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\r\n'
  IGNORE 1 ROWS
  (name, description, vendor_name, vendor_address, vendor_city, vendor_st_prov, vendor_mail_code, vendor_phone)
;
#SELECT * FROM coffee ;

#TODO: Load from csv file?
INSERT INTO urns ( inventory_number, brand, model, commission_date ) VALUES
  ( '1234', 'Bunn', 'Digital ThermoFresh', '2016-06-24' ),
  ( '1235', 'Bunn', 'Digital ThermoFresh', '2016-06-24' ),
  ( '1236', 'Bunn', 'Digital ThermoFresh', '2016-06-24' ),
  ( '5678', 'Fetco', 'L3D-15', '2016-07-14' ),
  ( '5679', 'Fetco', 'L3D-15', '2016-07-14' ),
  ( '5680', 'Fetco', 'L3D-15', '2016-07-14' )
;  
#SELECT * FROM urns ;


SET foreign_key_checks = 0 ;
#LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 5.7/Uploads/FakeRecords.csv'
LOAD DATA INFILE '/var/lib/mysql-files/FakeRecords.csv'
  INTO TABLE records
  FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\r\n'
  IGNORE 1 ROWS
  (urn_id, coffee_id, current_location, start_date_time)
;
SET foreign_key_checks = 1 ;
#SELECT * FROM records ;


SET foreign_key_checks = 0 ;
#LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 5.7/Uploads/FakeSamples.csv'
LOAD DATA INFILE '/var/lib/mysql-files/FakeSamples.csv'
  INTO TABLE samples
  FIELDS TERMINATED BY ',' ENCLOSED BY '"' LINES TERMINATED BY '\r\n'
  IGNORE 1 ROWS
  (record_id, elapse_time, liquid_level, temperature)
;
SET foreign_key_checks = 1 ;
#SELECT * FROM samples ;


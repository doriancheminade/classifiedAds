CREATE DATABASE IF NOT EXISTS ClassifiedAdsDB;
USE ClassifiedAdsDB;
CREATE TABLE IF NOT EXISTS Ad (
  id int(11) NOT NULL AUTO_INCREMENT,
  description varchar(200) NOT NULL,
  submissionDate timestamp NOT NULL,
  surfaceArea float NOT NULL,
  price float NOT NULL,
  currency varchar(5) NOT NULL,
  country varchar(25) NOT NULL,
  area varchar(25) NOT NULL,
  street varchar(25) NOT NULL,
  misc varchar(25) NOT NULL,
  PUBLISHER_ID varchar(25) NOT NULL,
  
  PRIMARY KEY (id)
) engine=innodb;

CREATE TABLE IF NOT EXISTS Country (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(25) NOT NULL,
  
  PRIMARY KEY (id)
) engine=innodb;

CREATE TABLE IF NOT EXISTS Area (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(25) NOT NULL,
  
  PRIMARY KEY (id)
) engine=innodb;

CREATE TABLE IF NOT EXISTS User (
  id int(11) NOT NULL AUTO_INCREMENT,
  mail varchar(25) NOT NULL,
  password varchar(25) NOT NULL,
  username varchar(25) NOT NULL,
  telephone varchar(25) NOT NULL,
  country varchar(25) NOT NULL,
  area varchar(25) NOT NULL,
  street varchar(25) NOT NULL,
  misc varchar(25) NOT NULL,
  
  PRIMARY KEY (id)
) engine=innodb;

INSERT INTO User (id, mail, password)
VALUES (1, 'dilbert@evilcompany.com', 'dilbert');
INSERT INTO User (id, mail, password)
VALUES (2, 'a', 'a');

INSERT INTO Ad (description, submissionDate, surfaceArea, price, currency, PUBLISHER_ID)
VALUES ('petite maison dans une prairie', '2015-01-01 10:30:00', 140, 150000, 'USD', 1);
INSERT INTO Ad (description, submissionDate, surfaceArea, price, currency, PUBLISHER_ID)
VALUES ('chateau en espagne', '2015-02-02 11:30:00', 245000, 13000000, 'EUR', 1);

INSERT INTO Ad (description, submissionDate, surfaceArea, price, currency, PUBLISHER_ID)
VALUES ('grande maison', '2015-01-01 10:30:00', 500, 15000000, 'USD', 1);
INSERT INTO Ad (description, submissionDate, surfaceArea, price, currency, PUBLISHER_ID)
VALUES ('cabanon', '2015-02-02 11:30:00', 10, 12000, 'EUR', 1);

INSERT INTO Country (name)
VALUES ('france');
INSERT INTO Country (name)
VALUES ('germany');
INSERT INTO Country (name)
VALUES ('england');
INSERT INTO Country (name)
VALUES ('belgium');

INSERT INTO Area (name)
VALUES ('bordeaux');
INSERT INTO Area (name)
VALUES ('francfort');
INSERT INTO Area (name)
VALUES ('hampshire');
INSERT INTO Area (name)
VALUES ('flanders');

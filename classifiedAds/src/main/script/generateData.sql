CREATE DATABASE IF NOT EXISTS ClassifiedAdsDB;
USE ClassifiedAdsDB;
CREATE TABLE IF NOT EXISTS Ad (
  id int(11) NOT NULL AUTO_INCREMENT,
  description varchar(200) NOT NULL,
  submitionDate timestamp NOT NULL,
  surfaceArea float NOT NULL,
  price float NOT NULL,
  currency varchar(5) NOT NULL,
  
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

INSERT INTO Ad (description, submitionDate, surfaceArea, price, currency)
VALUES ('petite maison dans une prairie', '2015-01-01 10:30:00', 140, 150000, 'USD');
INSERT INTO Ad (description, submitionDate, surfaceArea, price, currency)
VALUES ('chateau en espagne', '2015-02-02 11:30:00', 245000, 13000000, 'EUR')

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
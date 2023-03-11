DROP DATABASE tariffs;
CREATE DATABASE tariffs;

USE tariffs;

DROP TABLE tariff;
CREATE TABLE tariff
(
id int auto_increment primary key,
tariffName varchar(100),
price double,
phoneTime int,
internet int,
sms int
);

DROP TABLE consumer;
CREATE TABLE consumer
(
id int auto_increment primary key,
consumerName varchar(100),
phoneNumber varchar(12)
);


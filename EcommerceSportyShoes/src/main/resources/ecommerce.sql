DROP DATABASE  IF EXISTS `ecommercesportyshoes`;

CREATE DATABASE  IF NOT EXISTS `ecommercesportyshoes`;
USE `ecommercesportyshoes`;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  `role` varchar(45) NOT NULL,
  `enabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
);

INSERT INTO `users` (`username`,`password`,`role`,`enabled`)
VALUES ('ramesh',
'$2a$10$XptfskLsT1l/bRTLRiiCgejHqOpgXFreUnNUa35gJdCr2v2QbVFzu',
'ROLE_USER', 1);
 
INSERT INTO `users` (`username`,`password`,`role`,`enabled`)
VALUES ('admin',
'$2a$10$zxvEq8XzYEYtNjbkRsJEbukHeRx3XS6MDXHMu8cNuNsRfZJWwswDy',
'ROLE_ADMIN', 1);


DROP TABLE IF EXISTS `product`;
create table product
(
  productId int(11) NOT NULL AUTO_INCREMENT,
  product_name VARCHAR(255) NOT NULL,
  product_category VARCHAR(255) NOT NULL,
  PRIMARY KEY (productId)
) ;


DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(64) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO `customer` (`first_name`,`last_name`)
VALUES ('Ramesh Singh',
'Kharai');

INSERT INTO `customer` (`first_name`,`last_name`)
VALUES ('Ashu',
'Pokhariya');

INSERT INTO `customer` (`first_name`,`last_name`)
VALUES ('Deepak',
'Pokhariya');

INSERT INTO `customer` (`first_name`,`last_name`)
VALUES ('Deepika',
'Pokhariya');

INSERT INTO `customer` (`first_name`,`last_name`)
VALUES ('Keshar',
'Pokhariya');

INSERT INTO `customer` (`first_name`,`last_name`)
VALUES ('Trilok',
'Kharai');

INSERT INTO `customer` (`first_name`,`last_name`)
VALUES ('Hira',
'Kharai');

INSERT INTO `customer` (`first_name`,`last_name`)
VALUES ('Ganesh',
'Kharai');

INSERT INTO `customer` (`first_name`,`last_name`)
VALUES ('Rajender',
'Kharai');

INSERT INTO `customer` (`first_name`,`last_name`)
VALUES ('Dhan',
'Kharai');


DROP TABLE IF EXISTS `order_details`;

CREATE TABLE `order_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `category` varchar(45) NOT NULL,
  `purchase_date` date NOT NULL,
  `user_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
);


INSERT INTO `order_details` (`product_name`,`quantity`,`price`,`category`,`purchase_date`,`user_name`)
VALUES ('Shiseido',5,156,'skincare','2018-11-19','Ramesh');

INSERT INTO `order_details` (`product_name`,`quantity`,`price`,`category`,`purchase_date`,`user_name`)
VALUES ('Nivea',5,156,'FaceCare','2021-04-18','Harish');


INSERT INTO `order_details` (`product_name`,`quantity`,`price`,`category`,`purchase_date`,`user_name`)
VALUES ('Face Pack',5,156,'Face Care','2021-04-10','Suresh');
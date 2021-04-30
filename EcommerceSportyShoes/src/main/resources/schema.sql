

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  `role` varchar(45) NOT NULL,
  `enabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
);

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

DROP TABLE IF EXISTS `order_details`;

CREATE TABLE `order_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) NOT NULL,
  `category` varchar(45) NOT NULL,
  `purchase_date` date NOT NULL,
  `user_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
);
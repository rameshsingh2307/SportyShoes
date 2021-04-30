INSERT INTO `users` (`username`,`password`,`role`,`enabled`)
VALUES ('singh',
'$2a$10$XptfskLsT1l/bRTLRiiCgejHqOpgXFreUnNUa35gJdCr2v2QbVFzu',
'ROLE_USER', 1);
 
INSERT INTO `users` (`username`,`password`,`role`,`enabled`)
VALUES ('admin',
'$2a$10$zxvEq8XzYEYtNjbkRsJEbukHeRx3XS6MDXHMu8cNuNsRfZJWwswDy',
'ROLE_ADMIN', 1);


INSERT INTO `product` (`product_name`,`product_category`)
VALUES ('Knee high boots',
'Boots');

INSERT INTO `product` (`product_name`,`product_category`)
VALUES ('Insulated boots',
'Boots');

INSERT INTO `product` (`product_name`,`product_category`)
VALUES ('Laced booties',
'Heels');

INSERT INTO `product` (`product_name`,`product_category`)
VALUES ('Kitten heels',
'Heels');

INSERT INTO `product` (`product_name`,`product_category`)
VALUES ('Chuck Taylor',
'Athletic Shoes');

INSERT INTO `product` (`product_name`,`product_category`)
VALUES ('Golf shoes',
'Athletic Shoes');

INSERT INTO `product` (`product_name`,`product_category`)
VALUES ('Ice-skates',
'Athletic Shoes');

INSERT INTO `order_details` (`product_name`,`category`,`purchase_date`,`user_name`)
VALUES ('Ice-skates','Athletic Shoes','2018-11-19','Ramesh');

INSERT INTO `order_details` (`product_name`,`category`,`purchase_date`,`user_name`)
VALUES ('Kitten heels','Heels','2021-04-18','Harish');


INSERT INTO `order_details` (`product_name`,`category`,`purchase_date`,`user_name`)
VALUES ('Insulated boots','Boots','2021-04-10','Suresh');

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


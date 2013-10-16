 DROP SCHEMA spring_transaction;
 CREATE SCHEMA IF NOT EXISTS spring_transaction;
 USE spring_transaction;
 CREATE TABLE IF NOT EXISTS `account` (
 `id` int auto_increment,
 `name` varchar(12) DEFAULT NULL,
 `password` varchar(12) DEFAULT NULL,
 `balance` double DEFAULT NULL,
 PRIMARY KEY(id))
 ENGINE=InnoDB DEFAULT CHARSET=utf8;

 GRANT ALL ON spring_transaction.* TO 'transaction'@'127.0.0.1' IDENTIFIED BY 'transaction';

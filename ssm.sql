DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie`(
`Id` INT UNSIGNED AUTO_INCREMENT NOT NULL,
`Title` VARCHAR(30) NOT NULL,
`Director` VARCHAR(30) NOT NULL,
`Genre` VARCHAR(20) NOT NULL,
`Language` VARCHAR(20) NOT NULL,
PRIMARY KEY(`Id`)
)ENGINE=INNODB DEFAULT CHARSET=UTF8;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `email` varchar(50) NOT NULL,
  `password` char(32) NOT NULL,
  `username` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table ssm_book
# ------------------------------------------------------------
DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(200) NOT NULL DEFAULT '' COMMENT '书名',
  `market_price` varchar(10) NOT NULL DEFAULT '' COMMENT '市场价',
  `author` varchar(200) NOT NULL DEFAULT '' COMMENT '书籍作者',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

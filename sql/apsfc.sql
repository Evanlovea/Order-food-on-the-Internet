/*
Navicat MySQL Data Transfer

Source Server         : evan
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : apsfc

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-01-12 10:04:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `authority` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'sa', 'sa', '0');
INSERT INTO `admin` VALUES ('2', 'admin', 'admin', '0');
INSERT INTO `admin` VALUES ('3', '张三', '3', '0');
INSERT INTO `admin` VALUES ('4', 'sas', '1', '0');

-- ----------------------------
-- Table structure for `menus`
-- ----------------------------
DROP TABLE IF EXISTS `menus`;
CREATE TABLE `menus` (
  `id` int(4) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `typeid` int(4) unsigned NOT NULL,
  `burden` varchar(50) NOT NULL,
  `brief` varchar(500) NOT NULL,
  `price` decimal(10,2) unsigned NOT NULL,
  `sums` int(4) unsigned NOT NULL DEFAULT '0',
  `price1` decimal(10,2) unsigned NOT NULL,
  `sums1` int(4) unsigned NOT NULL DEFAULT '0',
  `imgpath` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menus
-- ----------------------------
INSERT INTO `menus` VALUES ('12', '粉蒸肉', '10', '米粉、五花肉', '暂无', '26.00', '0', '23.00', '0', 'img/m_fenzhengrou.gif');
INSERT INTO `menus` VALUES ('14', '糖醋排骨', '2', '排骨、糖、醋', '暂无', '26.00', '0', '24.00', '4', 'img/m_tangcupaigu.gif');
INSERT INTO `menus` VALUES ('15', '咸肉菜饭', '1', '咸肉、米饭', '暂无', '15.00', '0', '12.00', '4', 'img/m_xianroucaifan.gif');
INSERT INTO `menus` VALUES ('17', '五香驴肉', '1', '驴肉', '暂无', '25.00', '0', '21.00', '1', 'img/m_wuxianglvrou.gif');
INSERT INTO `menus` VALUES ('18', '黄瓜拉皮', '1', '黄瓜、拉皮', '暂无', '8.00', '0', '6.00', '1', 'img/m_huanggualapi.gif');
INSERT INTO `menus` VALUES ('19', '水煮鱼', '11', '鱼，辣椒', '暂无', '38.00', '0', '32.00', '1', 'img/m_shuizhuyu.gif');

-- ----------------------------
-- Table structure for `notice`
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `times` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('8', '大家好，向大家介绍一下', '自我介绍一下，我是软件工程1503班的赵志国，学号是201516920210', '2018-01-08 18:23:44');
INSERT INTO `notice` VALUES ('13', '本店特色《咸肉饭》', ' 记得小时候每每妈妈做咸肉菜饭，我都要吃上二大碗，那个香啊那个好吃啊，真的不知道怎样来形容。吃过的朋友，大家都懂的，呵呵!11 ', '2018-01-08 18:39:52');
INSERT INTO `notice` VALUES ('14', '本店上新《糖醋排骨》', '糖醋排骨超级好吃。', '2018-01-08 18:40:57');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `userid` int(4) unsigned NOT NULL,
  `menuid` int(4) unsigned NOT NULL,
  `menusum` int(4) unsigned NOT NULL,
  `times` varchar(20) NOT NULL,
  `delivery` int(4) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `index_orders` (`id`,`userid`,`menuid`,`menusum`,`times`,`delivery`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('16', '2', '12', '2', '2018-01-07 13:16:28', '1');
INSERT INTO `orders` VALUES ('17', '1', '14', '1', '2018-01-07 13:23:30', '1');
INSERT INTO `orders` VALUES ('19', '4', '15', '2', '2018-01-07 23:26:20', '1');
INSERT INTO `orders` VALUES ('23', '4', '14', '1', '2015-01-07 00:35:09', '1');
INSERT INTO `orders` VALUES ('24', '4', '17', '1', '2018-01-07 00:35:09', '1');
INSERT INTO `orders` VALUES ('25', '2', '15', '1', '2018-01-07 20:14:23', '1');
INSERT INTO `orders` VALUES ('27', '2', '18', '1', '2018-01-07 20:31:56', '1');
INSERT INTO `orders` VALUES ('28', '2', '19', '1', '2018-01-07 20:31:56', '0');
INSERT INTO `orders` VALUES ('29', '4', '15', '1', '2018-01-05 19:16:00', '0');
INSERT INTO `orders` VALUES ('30', '4', '14', '1', '2018-01-08 17:38:50', '0');
INSERT INTO `orders` VALUES ('31', '4', '15', '1', '2018-01-09 10:35:36', '0');

-- ----------------------------
-- Table structure for `types`
-- ----------------------------
DROP TABLE IF EXISTS `types`;
CREATE TABLE `types` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of types
-- ----------------------------
INSERT INTO `types` VALUES ('1', '凉拌菜');
INSERT INTO `types` VALUES ('2', '炒菜');
INSERT INTO `types` VALUES ('6', '炒饭');
INSERT INTO `types` VALUES ('10', '蒸菜');
INSERT INTO `types` VALUES ('11', '川菜');
INSERT INTO `types` VALUES ('12', '鲁菜');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `realname` varchar(20) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `age` int(4) unsigned NOT NULL,
  `card` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL DEFAULT '' COMMENT 'address',
  `phone` varchar(20) NOT NULL,
  `email` varchar(20) DEFAULT NULL,
  `code` varchar(10) DEFAULT NULL,
  `type` int(4) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('2', '222', '222', '2221', '女', '241', '211111111111111111', '郑州市高新区', '13988888888', '123@163.com', '110044', '0');
INSERT INTO `users` VALUES ('3', 'sunday', '123', '张三', '男', '26', '4222222222222222', '郑州市高新区', '13901001111', '13901001111@139.com', '101000', '0');
INSERT INTO `users` VALUES ('4', '1', '1', '李二狗', '男', '1', '1', '郑州市高新区', '1', '1', '1', '0');
INSERT INTO `users` VALUES ('8', '炸支付', '4565', '赵志国', '男', '45', '410621199709284517', '郑州市高新区', '13253312194', '456250@111.com', '45445', '0');
INSERT INTO `users` VALUES ('9', 'evan', '888333', '王权', '男', '56', '456464546545654', '郑州市高新区', '2343434', '45654545@qq.com', '456250', '0');
INSERT INTO `users` VALUES ('10', 'fas', 'fa', 'fasd', '男', '12', '324254345345', '郑州市高新区dfadf', '13121555', '32433@adsfs', '4533', '0');

-- ----------------------------
-- View structure for `v_orders`
-- ----------------------------
DROP VIEW IF EXISTS `v_orders`;
CREATE ALGORITHM=UNDEFINED DEFINER=`skip-grants user`@`skip-grants host` SQL SECURITY DEFINER VIEW `v_orders` AS select `c`.`id` AS `id`,`a`.`id` AS `userid`,`b`.`id` AS `menuid`,`c`.`id` AS `orderid`,`a`.`realname` AS `realname`,`a`.`phone` AS `phone`,`a`.`address` AS `address`,`b`.`name` AS `menuname`,`c`.`menusum` AS `menusum`,`b`.`price1` AS `price1`,`c`.`times` AS `times`,`c`.`delivery` AS `delivery` from ((`users` `a` join `menus` `b`) join `orders` `c`) where ((`a`.`id` = `c`.`userid`) and (`b`.`id` = `c`.`menuid`) and (`c`.`times` like '%"+ date + "%')) group by `c`.`id` ;

-- ----------------------------
-- View structure for `v_orders1`
-- ----------------------------
DROP VIEW IF EXISTS `v_orders1`;
CREATE ALGORITHM=UNDEFINED DEFINER=`skip-grants user`@`skip-grants host` SQL SECURITY DEFINER VIEW `v_orders1` AS select `c`.`id` AS `id`,`a`.`id` AS `userid`,`b`.`id` AS `menuid`,`c`.`id` AS `orderid`,`a`.`realname` AS `realname`,`a`.`phone` AS `phone`,`a`.`address` AS `address`,`b`.`name` AS `menuname`,`c`.`menusum` AS `menusum`,`b`.`price1` AS `price1`,`c`.`times` AS `times`,`c`.`delivery` AS `delivery` from ((`users` `a` join `menus` `b`) join `orders` `c`) where ((`a`.`id` = `c`.`userid`) and (`b`.`id` = `c`.`menuid`) and (`b`.`name` like '%"\r\n					+ menuname + "%')) group by `c`.`id` ;

-- ----------------------------
-- Procedure structure for `EXECUTE_sql_proc`
-- ----------------------------
DROP PROCEDURE IF EXISTS `EXECUTE_sql_proc`;
DELIMITER ;;
CREATE DEFINER=`skip-grants user`@`skip-grants host` PROCEDURE `EXECUTE_sql_proc`(IN executeSql varchar(1000))
BEGIN 
set @needExcSql:=executeSql;
PREPARE stmt from @needExcSql;
EXECUTE stmt;
DEALLOCATE PREPARE stmt;
END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `get_orders_id`
-- ----------------------------
DROP PROCEDURE IF EXISTS `get_orders_id`;
DELIMITER ;;
CREATE DEFINER=`skip-grants user`@`skip-grants host` PROCEDURE `get_orders_id`(
  in $tableName varchar(25),
 in $times varchar(20)
)
set @sql=CONCAT('select id into @mainID from',$tableName,'where times like',$times,'%','order by times limit 1' )
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `tg_orders_before_create`;
DELIMITER ;;
CREATE TRIGGER `tg_orders_before_create` BEFORE INSERT ON `orders` FOR EACH ROW BEGIN     
  
    set @count = (SELECT menusum FROM orders WHERE NEW.menusum=menusum );  
    if @count > 100 then  
        SIGNAL SQLSTATE 'TX000' SET MESSAGE_TEXT = 'beyond the max num';    
    end if;  
END
;;
DELIMITER ;

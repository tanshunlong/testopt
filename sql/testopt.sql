SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for databasechangelog
-- ----------------------------
DROP TABLE IF EXISTS `databasechangelog`;
CREATE TABLE `databasechangelog`  (
  `ID` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `AUTHOR` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `FILENAME` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `DATEEXECUTED` datetime(0) NOT NULL,
  `ORDEREXECUTED` int(11) NOT NULL,
  `EXECTYPE` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `MD5SUM` varchar(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `DESCRIPTION` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `COMMENTS` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `TAG` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `LIQUIBASE` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CONTEXTS` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `LABELS` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `DEPLOYMENT_ID` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of databasechangelog
-- ----------------------------
INSERT INTO `databasechangelog` VALUES ('00000000000001', 'jhipster', 'config/liquibase/changelog/00000000000000_initial_schema.xml', '2020-02-14 05:42:56', 1, 'EXECUTED', '8:9bf75aca02e1c4157cc1268a96e34b65', 'createTable tableName=jhi_persistent_audit_event; createTable tableName=jhi_persistent_audit_evt_data; addPrimaryKey tableName=jhi_persistent_audit_evt_data; createIndex indexName=idx_persistent_audit_event, tableName=jhi_persistent_audit_event; c...', '', NULL, '3.6.3', NULL, NULL, '1658976141');

-- ----------------------------
-- Table structure for databasechangeloglock
-- ----------------------------
DROP TABLE IF EXISTS `databasechangeloglock`;
CREATE TABLE `databasechangeloglock`  (
  `ID` int(11) NOT NULL,
  `LOCKED` bit(1) NOT NULL,
  `LOCKGRANTED` datetime(0) DEFAULT NULL,
  `LOCKEDBY` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of databasechangeloglock
-- ----------------------------
INSERT INTO `databasechangeloglock` VALUES (1, b'0', NULL, NULL);

-- ----------------------------
-- Table structure for jhi_persistent_audit_event
-- ----------------------------
DROP TABLE IF EXISTS `jhi_persistent_audit_event`;
CREATE TABLE `jhi_persistent_audit_event`  (
  `event_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `principal` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `event_date` timestamp(0) DEFAULT NULL,
  `event_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`event_id`) USING BTREE,
  INDEX `idx_persistent_audit_event`(`principal`, `event_date`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for jhi_persistent_audit_evt_data
-- ----------------------------
DROP TABLE IF EXISTS `jhi_persistent_audit_evt_data`;
CREATE TABLE `jhi_persistent_audit_evt_data`  (
  `event_id` bigint(20) NOT NULL,
  `name` varchar(150) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`event_id`, `name`) USING BTREE,
  INDEX `idx_persistent_audit_evt_data`(`event_id`) USING BTREE,
  CONSTRAINT `fk_evt_pers_audit_evt_data` FOREIGN KEY (`event_id`) REFERENCES `jhi_persistent_audit_event` (`event_id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;


-- ----------------------------
-- Table structure for shipment
-- ----------------------------
DROP TABLE IF EXISTS `shipment`;
CREATE TABLE `shipment`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `batch` int(4) DEFAULT NULL COMMENT '批次',
  `total_weight` double DEFAULT NULL COMMENT '总重量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '装运\n\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shipment
-- ----------------------------
INSERT INTO `shipment` VALUES ('31f966faa44544cb05be306f03a2493e', 2, 60);
INSERT INTO `shipment` VALUES ('3e51f601b87b1327c56e6bafa0840ca1', 4, 300);
INSERT INTO `shipment` VALUES ('405f67ee0a52a8bbc8c16cc36a52f683', 4, 400);
INSERT INTO `shipment` VALUES ('4e82825f127b6eb211100f889b610902', 5, 100);
INSERT INTO `shipment` VALUES ('9fcb833a50bac8e37a9c1538fda48a9e', 4, 90);

-- ----------------------------
-- Table structure for shipment_children
-- ----------------------------
DROP TABLE IF EXISTS `shipment_children`;
CREATE TABLE `shipment_children`  (
  `id` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `parent_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '父ID',
  `weight` double DEFAULT NULL COMMENT '重量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '装运\n\n子表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shipment_children
-- ----------------------------
INSERT INTO `shipment_children` VALUES ('02109339e81d297fb6fbdcf1a9465e14', '9fcb833a50bac8e37a9c1538fda48a9e', 22.5);
INSERT INTO `shipment_children` VALUES ('02a26d1d7db4dec2d057c1299852bcba', '3e51f601b87b1327c56e6bafa0840ca1', 75);
INSERT INTO `shipment_children` VALUES ('05ef3fa5a48b4070ca93b8083297a8c3', '4e82825f127b6eb211100f889b610902', 20);
INSERT INTO `shipment_children` VALUES ('0b6b95770c17cd10cd55fc8428f37544', '9fcb833a50bac8e37a9c1538fda48a9e', 22.5);
INSERT INTO `shipment_children` VALUES ('298b969e9e3b2e9d4cd78e032a28f138', '405f67ee0a52a8bbc8c16cc36a52f683', 100);
INSERT INTO `shipment_children` VALUES ('31f29e93fdbff3a477a1969d29b642ea', '4e82825f127b6eb211100f889b610902', 20);
INSERT INTO `shipment_children` VALUES ('38a1df20b6c0ed3e81ee6bca9c10f8fe', '405f67ee0a52a8bbc8c16cc36a52f683', 100);
INSERT INTO `shipment_children` VALUES ('3d66867d81cbcc6f34d99525458c10eb', '4e82825f127b6eb211100f889b610902', 20);
INSERT INTO `shipment_children` VALUES ('5f9f6e35fec57c9ba1c38ef5a3947e32', '3e51f601b87b1327c56e6bafa0840ca1', 75);
INSERT INTO `shipment_children` VALUES ('89984beb4541d320401e3d6aa18c6c50', '4e82825f127b6eb211100f889b610902', 20);
INSERT INTO `shipment_children` VALUES ('8ddcd05f4941e61285283e6a2e229a4b', '405f67ee0a52a8bbc8c16cc36a52f683', 100);
INSERT INTO `shipment_children` VALUES ('9463587e9e51b8424c95b351041bd81a', '9fcb833a50bac8e37a9c1538fda48a9e', 22.5);
INSERT INTO `shipment_children` VALUES ('a47e630abd40bb7acb8e1614ddae0145', '31f966faa44544cb05be306f03a2493e', 30);
INSERT INTO `shipment_children` VALUES ('ccc75204f7efab25d226278f9e4826bf', '3e51f601b87b1327c56e6bafa0840ca1', 75);
INSERT INTO `shipment_children` VALUES ('cd9f2a721a4adb4aa714af5d0004c6d0', '31f966faa44544cb05be306f03a2493e', 30);
INSERT INTO `shipment_children` VALUES ('d0628d42964a2c5994178cb02e29189c', '9fcb833a50bac8e37a9c1538fda48a9e', 22.5);
INSERT INTO `shipment_children` VALUES ('e1d39cc030824171db45a94f248cec0f', '405f67ee0a52a8bbc8c16cc36a52f683', 100);
INSERT INTO `shipment_children` VALUES ('f11909a78db57ffe4b8714c4b0457db0', '3e51f601b87b1327c56e6bafa0840ca1', 75);
INSERT INTO `shipment_children` VALUES ('f4d1114f5cea723eb0cd4aaa89750e8c', '4e82825f127b6eb211100f889b610902', 20);



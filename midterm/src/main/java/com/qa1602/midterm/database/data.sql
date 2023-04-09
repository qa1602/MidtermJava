-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: OnlineStore
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `status` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Bánh quy',1),(2,'Snack',1),(3,'Thức uống',1),(4,'Kẹo',1);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `amount` int DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `status` int DEFAULT NULL,
  `thumbnail` varchar(255) DEFAULT NULL,
  `category_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`),
  CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,99,'Bánh xốp nhân Sôcôla Biggie, với cuộn bánh to hơn, bổ sung vitamin A, C và Canxi, thơm ngon và tiếp thêm năng lượng mỗi ngày','Chocolate Biggie',12000,4,1,'https://oishi.cdn.vccloud.vn/storage/products/October2021/FsQ4WVPQdS1ZbaSQBA4o.png',1),(2,99,'Theo bạn tới bất kì đâu, Akiko Snack Que giòn tan với lớp moka ngọt lịm ngon ngon được đóng gói tiện lợi, dễ dàng mang đi cho bạn thỏa mãn cơn thèm ngọt mọi lúc, mọi nơi. ','Moka Akiko',22000,4,1,'https://oishi.cdn.vccloud.vn/storage/products/March2021/WPwDtHmq7zUTc1TdSSU1.png',1),(3,99,'Gia vị thơm cay đặc trưng kết hợp với vị ngon của tôm - Từng miếng bánh được chế biến bằng công nghệ rang không chiên, cho bạn trải nghiệm vô tư ăn liền với Oishi Snack Tôm Cay.','Snack Tôm Cay',10000,4,1,'https://oishi.cdn.vccloud.vn/storage/products/October2021/xIOpzoFj0JJXUFLXvaNI.png',2),(4,99,'Snack bí đỏ kết hợp đồng điệu giữa bí đỏ và bò nướng chính là bạn đồng hành tuyệt vời cho những khoảnh khắc của riêng bạn.','Snack Bí Đỏ',10000,4,1,'https://oishi.cdn.vccloud.vn/storage/products/October2021/Io18PkcSq88iUjKUD8zF.png',2),(5,99,'Oishi Sundays nước bưởi là nước trái cây tươi mát giàu Vitamin C, dạng túi tiện lợi theo bạn mọi lúc, cùng bạn mọi nơi. Hãy sảng khoái mỗi ngày cùng Oishi Sundays nhé!','Nước Bưởi Sundays',4500,4,1,'https://oishi.cdn.vccloud.vn/storage/products/July2021/8oNx0BeRU6WgwLd5imv9.png',3),(6,99,'Oishi Tea Go giúp bạn sảng khoái với trà xanh tự nhiên và giải tỏa căng thẳng với hương chanh thơm mát.','Trà Xanh Vị Chanh Tea Go',4500,4,1,'https://oishi.cdn.vccloud.vn/storage/products/October2021/j3I0DTFr2t41AnS8I1BD.png',3),(7,99,'Ẩn sau lớp kẹo mềm xốp như bông là nhân socola ngọt bùi hấp dẫn. Cùng đắm chìm vào hương vị ngọt ngào trong từng viên kẹo Opuff nhé!','Kẹo Xốp Socola O-Puff',19000,4,1,'https://oishi.cdn.vccloud.vn/storage/products/June2022/DpvmS9CqmMtxxxZXqdAc.png',4),(8,99,'Được rang cực kì cẩn thận mà không sử dụng dầu. ','Đậu Phộng Pinattsu',11000,4,1,'https://oishi.cdn.vccloud.vn/storage/products/February2019/UlBGAW1QHDPpZITmjsEp.png',4);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'OnlineStore'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-09 20:49:48

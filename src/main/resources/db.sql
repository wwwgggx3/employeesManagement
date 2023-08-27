-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        10.11.2-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- 테이블 test.t_employees 구조 내보내기
CREATE TABLE IF NOT EXISTS `t_employees` (
    `employee_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `title_id` bigint(20) unsigned DEFAULT NULL,
    `nm` varchar(30) NOT NULL,
    `tel` varchar(13) NOT NULL,
    `email` varchar(30) NOT NULL,
    `del_yn` int(11) NOT NULL DEFAULT 0 CHECK (`del_yn` in (0,1)),
    `created_at` datetime NOT NULL DEFAULT current_timestamp(),
    `updated_at` datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
    PRIMARY KEY (`employee_id`),
    KEY `title_id` (`title_id`),
    CONSTRAINT `t_employees_ibfk_1` FOREIGN KEY (`title_id`) REFERENCES `t_title` (`title_id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 test.t_employees:~17 rows (대략적) 내보내기
/*!40000 ALTER TABLE `t_employees` DISABLE KEYS */;
INSERT INTO `t_employees` (`employee_id`, `title_id`, `nm`, `tel`, `email`, `del_yn`, `created_at`, `updated_at`) VALUES
(1, 5, '손흥민', '010-4562-4384', '000@naver.com', 0, '2023-08-26 15:40:17', '2023-08-26 17:10:12'),
(2, 1, '정우영', '010-9073-1234', 'wooyoung@daum.net', 0, '2023-08-26 15:40:18', '2023-08-26 16:53:46'),
(3, 1, '김현수', '010-8221-1232', 'kimhs@daum.net', 0, '2023-08-26 15:40:19', '2023-08-26 16:53:58'),
(4, 1, '장민철', '010-6653-7899', 'jangmc@daum.net', 0, '2023-08-26 15:40:20', '2023-08-26 16:54:05'),
(5, 1, '홍진호', '010-2234-4422', 'hongjh@google.com', 0, '2023-08-26 15:40:20', '2023-08-26 16:54:12'),
(6, 2, '김강우', '010-9988-7788', 'kimkw@naver.com', 0, '2023-08-26 15:40:20', '2023-08-26 16:55:45'),
(7, 1, '이강인', '010-3355-2462', 'leeki@naver.com', 0, '2023-08-26 15:40:20', '2023-08-26 16:54:25'),
(8, 3, '강호', '010-3267-0987', 'kangh@google.com', 0, '2023-08-26 15:40:20', '2023-08-26 16:55:46'),
(9, 4, '구자철', '010-2323-2323', 'koojc@daum.net', 0, '2023-08-26 15:40:20', '2023-08-26 16:55:47'),
(10, 5, '뉴진스', '010-1365-6546', 'newjs@google.com', 0, '2023-08-26 15:40:20', '2023-08-26 16:55:48'),
(11, 6, '김희민', '010-2344-9900', 'kimhm@naver.com', 0, '2023-08-26 15:40:21', '2023-08-26 16:55:52'),
(12, 7, '김진영', '010-9654-4165', 'kimjy@daum.net', 0, '2023-08-26 15:40:21', '2023-08-26 16:55:54'),
(13, 8, '주호민', '010-8812-3142', 'joohm@daum.net', 0, '2023-08-26 15:40:21', '2023-08-26 16:55:57'),
(14, 1, '침착맨', '010-9554-0012', 'chimcm@daum.net', 0, '2023-08-26 15:40:21', '2023-08-26 16:55:21'),
(15, 1, '권지용', '010-4457-0453', 'kwonjy@daum.net', 0, '2023-08-26 15:40:21', '2023-08-26 16:55:28'),
(16, 1, '김지수', '010-3673-8987', 'kimjs@daum.net', 1, '2023-08-26 15:40:27', '2023-08-26 16:55:33'),
(17, 1, '하지원', '010-7732-0077', 'hajw@daum.net', 0, '2023-08-26 15:40:33', '2023-08-26 16:55:42');
/*!40000 ALTER TABLE `t_employees` ENABLE KEYS */;

-- 테이블 test.t_title 구조 내보내기
CREATE TABLE IF NOT EXISTS `t_title` (
    `title_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `nm` varchar(10) DEFAULT NULL,
    PRIMARY KEY (`title_id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 테이블 데이터 test.t_title:~8 rows (대략적) 내보내기
/*!40000 ALTER TABLE `t_title` DISABLE KEYS */;
INSERT INTO `t_title` (`title_id`, `nm`) VALUES
                                             (1, '사원'),
                                             (2, '주임'),
                                             (3, '대리'),
                                             (4, '과장'),
                                             (5, '차장'),
                                             (6, '부장'),
                                             (7, '이사'),
                                             (8, '사장');
/*!40000 ALTER TABLE `t_title` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

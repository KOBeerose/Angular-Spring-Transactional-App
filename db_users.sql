-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 07, 2022 at 04:54 AM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_users`
--
CREATE DATABASE IF NOT EXISTS `db_users` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `db_users`;

-- --------------------------------------------------------

--
-- Table structure for table `app_role`
--

CREATE TABLE `app_role` (
  `id` bigint(20) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `app_role`
--

INSERT INTO `app_role` (`id`, `role_name`) VALUES
(1, 'USER'),
(2, 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `app_user`
--

CREATE TABLE `app_user` (
  `id` bigint(20) NOT NULL,
  `actived` bit(1) NOT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `app_user`
--

INSERT INTO `app_user` (`id`, `actived`, `adress`, `password`, `username`, `address`) VALUES
(42, b'1', NULL, '$2a$10$k1aiPC44AqjyWbVIP/MrleBOYLV3FWphuwmRo0pPfJSFeeLxh6zwO', 'new_test', 'test'),
(49, b'1', NULL, '$2a$10$UGdPWBDLufB9iSZbB6ugA.Hd.KzMVs39RryFhS2jdA3fyeHjl9oRm', 'sdfadsffsa', '0xdesdaffdsafsd3897dFdbd4Fa1032F92CFEf86a9215108FEc6e'),
(50, b'1', NULL, '$2a$10$oa5zOOa/1nCMfySGjZ/19OAdCyaLWgy5JLWGouy65clhENg6KARgO', 'user2', 'sdafdsafdsafasdf'),
(51, b'1', NULL, '$2a$10$XqeFgDzzHhbUMD3o13smb.TGbQ3rJsZBz8KW4a/oyue7zwQ6PETmu', 'test', 'teasdfasdf');

-- --------------------------------------------------------

--
-- Table structure for table `app_user_roles`
--

CREATE TABLE `app_user_roles` (
  `app_user_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `app_user_roles`
--

INSERT INTO `app_user_roles` (`app_user_id`, `roles_id`) VALUES
(42, 2),
(43, 2),
(44, 1),
(45, 1),
(46, 1),
(47, 1),
(48, 1),
(49, 1),
(50, 1),
(51, 1),
(52, 1),
(53, 1),
(54, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `app_role`
--
ALTER TABLE `app_role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `app_user`
--
ALTER TABLE `app_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_3k4cplvh82srueuttfkwnylq0` (`username`);

--
-- Indexes for table `app_user_roles`
--
ALTER TABLE `app_user_roles`
  ADD KEY `FK1pfb2loa8so5oi6ak7rh6enva` (`roles_id`),
  ADD KEY `FKkwxexnudtp5gmt82j0qtytnoe` (`app_user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `app_role`
--
ALTER TABLE `app_role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `app_user`
--
ALTER TABLE `app_user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `app_user_roles`
--
ALTER TABLE `app_user_roles`
  ADD CONSTRAINT `FK1pfb2loa8so5oi6ak7rh6enva` FOREIGN KEY (`roles_id`) REFERENCES `app_role` (`id`),
  ADD CONSTRAINT `FKkwxexnudtp5gmt82j0qtytnoe` FOREIGN KEY (`app_user_id`) REFERENCES `app_user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

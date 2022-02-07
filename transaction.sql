-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 07, 2022 at 05:24 AM
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
-- Database: `gestionservice`
--

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `id` bigint(20) NOT NULL,
  `addressrecipent` varchar(255) DEFAULT NULL,
  `immobilier_id` bigint(20) DEFAULT NULL,
  `address_owner` varchar(255) DEFAULT NULL,
  `price` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`id`, `addressrecipent`, `immobilier_id`, `address_owner`, `price`) VALUES
(1, '0xCbD39678ebA8ebD0B2FC99a578B77e5Cceb0AaE6', 1, '0x7A22A15f3d436b7B39EF4ea8286A2C629a8E87e6', 12),
(2, '0xCbD39678ebA8ebD0B2FC99a578B77e5Cceb0AaE6', 2, '0x78fF7925EEFCA6464B38bc5d1f657ABa50e24212', 13),
(3, '0xCbD39678ebA8ebD0B2FC99a578B77e5Cceb0AaE6', 3, '0x9B87eB25005AE08FA35EAb2903570e74fDC08609', 14),
(4, '0x7A22A15f3d436b7B39EF4ea8286A2C629a8E87e6', 7, '0x764AABe679B970E9fcaB03027d14f57196a09496', 17),
(5, '0x7A22A15f3d436b7B39EF4ea8286A2C629a8E87e6', 6, '0x7A22A15f3d436b7B39EF4ea8286A2C629a8E87e6', 18),
(6, '0xCbD39678ebA8ebD0B2FC99a578B77e5Cceb0AaE6', 6, '0x7A22A15f3d436b7B39EF4ea8286A2C629a8E87e6', 21);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKb78ch8xc3926ny4snffljqx7l` (`immobilier_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `FKb78ch8xc3926ny4snffljqx7l` FOREIGN KEY (`immobilier_id`) REFERENCES `immobilier` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

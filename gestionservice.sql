-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 08, 2022 at 01:27 AM
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
CREATE DATABASE IF NOT EXISTS `gestionservice` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `gestionservice`;
--

-- --------------------------------------------------------

--
-- Table structure for table `immobilier`
--

CREATE TABLE `immobilier` (
  `id` bigint(20) NOT NULL,
  `ville` varchar(255) DEFAULT NULL,
  `address_owner` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `is_announced` bit(1) NOT NULL,
  `price` double NOT NULL,
  `surface` double NOT NULL,
  `titre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `immobilier`
--

INSERT INTO `immobilier` (`id`, `ville`, `address_owner`, `image`, `is_announced`, `price`, `surface`, `titre`) VALUES
(1, 'Tanger', '0xeD46803F719b4EB04B49592ef16b3E77D7809928', './assets/img/immobilier/image1.jpg', b'1', 34, 50, '2fsdf3345'),
(2, 'Rabat', '0xB18591C82Ae07EFfa3ef776737e4afCca6132C33', './assets/img/immobilier/image2.jpg', b'1', 45, 60,'3452' ),
(3, 'Fes', '0xB18591C82Ae07EFfa3ef776737e4afCca6132C33', './assets/img/immobilier/image3.jpg', b'1', 45, 60, '25678'),
(4, 'Tanger', '0xB18591C82Ae07EFfa3ef776737e4afCca6132C33', './assets/img/immobilier/image4.jfif', b'1', 12, 10, '256767'),
(5, 'Tanger', '0xeD46803F719b4EB04B49592ef16b3E77D7809928', './assets/img/immobilier/image5.jfif', b'1', 56, 40,'256324658' ),
(6, 'Agadir', '0xeD46803F719b4EB04B49592ef16b3E77D7809928', './assets/img/immobilier/image6.jfif', b'1', 34, 56, '57867757'),
(7, 'Rabat', '0xde3897dFdbd4Fa1032F92CFEf86a9215108FEc6e', './assets/img/immobilier/image7.jfif', b'1', 50, 6, '53768476'),
(8, 'Tanger', '0xde3897dFdbd4Fa1032F92CFEf86a9215108FEc6e', './assets/img/immobilier/image8.jfif', b'1', 45, 76, 'h4567657'),
(9, 'Sale', '0xde3897dFdbd4Fa1032F92CFEf86a9215108FEc6e', './assets/img/immobilier/image9.jfif', b'0', 60, 5, 'nbgf563'),
(10, 'Paris', '0xEA0422587D8Ed6f14aC22244f891213C76Bb3E56', './assets/img/immobilier/image10.jfif', b'1', 10, 60, 'bfcxvbnhg436'),
(11, 'Tanger', '0xEA0422587D8Ed6f14aC22244f891213C76Bb3E56', './assets/img/immobilier/image11.jfif', b'1', 67, 22,  'dvzs35w4'),
(12, 'Newyork', '0xEA0422587D8Ed6f14aC22244f891213C76Bb3E56', './assets/img/immobilier/image12.jfif', b'1', 50, 20, 'dfv4t4'),
(13, 'California', '0xD1605Cf0aD012Cb563205B0a27A74ABc788c5e87', './assets/img/immobilier/image13.jfif', b'0', 40, 50, 'dsgsr4534'),
(14, 'Ohao', '0xD1605Cf0aD012Cb563205B0a27A74ABc788c5e87', './assets/img/immobilier/image14.jfif', b'1', 30, 48, 'sfgsfg323'),
(15, 'Casablanca', '0xD1605Cf0aD012Cb563205B0a27A74ABc788c5e87', './assets/img/immobilier/image15.jfif', b'1', 50, 23, 'sgs3523vgf'),
(16, 'Tokyo', '0x14fd5DA9B1FE5308b7D7a29b0d503f286cC4DAD7', './assets/img/immobilier/image16.jfif', b'1', 50, 30, 'sdf345');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `id` bigint(20) NOT NULL,
  `addressrecipent` varchar(255) DEFAULT NULL,
  `immobilier_id` bigint(20) DEFAULT NULL,
  `address_owner` varchar(255) DEFAULT NULL,
  `price_tran` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`id`, `addressrecipent`, `immobilier_id`, `address_owner`, `price_tran`) VALUES
(1, '0xB18591C82Ae07EFfa3ef776737e4afCca6132C33', 1, '0x2E3EfC9737AB91451Cf0755A2201591898286F87', 45),
(2, '0xB18591C82Ae07EFfa3ef776737e4afCca6132C33', 2, '0x2E3EfC9737AB91451Cf0755A2201591898286F87', 34),
(3, '0x2E3EfC9737AB91451Cf0755A2201591898286F87', 3, '0xB18591C82Ae07EFfa3ef776737e4afCca6132C33', 20),
(4, '0x2E3EfC9737AB91451Cf0755A2201591898286F87', 4, '0xB18591C82Ae07EFfa3ef776737e4afCca6132C33', 10),
(5, '0x7A22A15f3d436b7B39EF4ea8286A2C629a8E87e6', 5, '0xeD46803F719b4EB04B49592ef16b3E77D7809928', 60),
(6, '0x7A22A15f3d436b7B39EF4ea8286A2C629a8E87e6', 6, '0xeD46803F719b4EB04B49592ef16b3E77D7809928', 22),
(7, '0x2E3EfC9737AB91451Cf0755A2201591898286F87', 7, '0xB18591C82Ae07EFfa3ef776737e4afCca6132C33', 10),
(8, '0x7A22A15f3d436b7B39EF4ea8286A2C629a8E87e6', 8, '0xeD46803F719b4EB04B49592ef16b3E77D7809928', 60),
(9, '0x7A22A15f3d436b7B39EF4ea8286A2C629a8E87e6', 9, '0xeD46803F719b4EB04B49592ef16b3E77D7809928', 22),
(10, '0x2E3EfC9737AB91451Cf0755A2201591898286F87', 10, '0xB18591C82Ae07EFfa3ef776737e4afCca6132C33', 10),
(11, '0x7A22A15f3d436b7B39EF4ea8286A2C629a8E87e6', 11, '0xeD46803F719b4EB04B49592ef16b3E77D7809928', 60),
(12, '0x7A22A15f3d436b7B39EF4ea8286A2C629a8E87e6', 12, '0xeD46803F719b4EB04B49592ef16b3E77D7809928', 22),
(13, '0x2E3EfC9737AB91451Cf0755A2201591898286F87', 13, '0xB18591C82Ae07EFfa3ef776737e4afCca6132C33', 10),
(14, '0x7A22A15f3d436b7B39EF4ea8286A2C629a8E87e6', 14, '0xeD46803F719b4EB04B49592ef16b3E77D7809928', 60),
(15, '0x7A22A15f3d436b7B39EF4ea8286A2C629a8E87e6', 15, '0xeD46803F719b4EB04B49592ef16b3E77D7809928', 22);


--
-- Indexes for dumped tables
--

--
-- Indexes for table `immobilier`
--
ALTER TABLE `immobilier`
  ADD PRIMARY KEY (`id`);

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
-- AUTO_INCREMENT for table `immobilier`
--
ALTER TABLE `immobilier`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

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

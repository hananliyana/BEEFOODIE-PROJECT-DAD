-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 28, 2024 at 03:12 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `groupprojectdad`
--

-- --------------------------------------------------------

--
-- Table structure for table `itemorder`
--

CREATE TABLE `itemorder` (
  `Order_ID` varchar(100) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Quantity` int(11) NOT NULL,
  `Price` int(11) NOT NULL,
  `Status` varchar(100) NOT NULL DEFAULT 'incomplete'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `itemorder`
--

INSERT INTO `itemorder` (`Order_ID`, `Name`, `Quantity`, `Price`, `Status`) VALUES
('11174', 'Kirby', 3, 21, 'complete'),
('42401', 'Sabrina', 3, 9, 'incomplete'),
('43109', 'Hana', 2, 11, 'incomplete'),
('58091', 'Memei', 4, 6, 'complete'),
('78782', 'Boo', 2, 6, 'complete'),
('95838', 'Maomi', 2, 11, 'complete');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `itemorder`
--
ALTER TABLE `itemorder`
  ADD PRIMARY KEY (`Order_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 15, 2018 at 12:07 PM
-- Server version: 10.1.22-MariaDB
-- PHP Version: 7.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java`
--

-- --------------------------------------------------------

--
-- Table structure for table `house`
--

CREATE TABLE `house` (
  `type` varchar(7) NOT NULL,
  `balcony` int(11) NOT NULL,
  `sq_feet` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `swimming` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `house`
--

INSERT INTO `house` (`type`, `balcony`, `sq_feet`, `price`, `swimming`) VALUES
('1BHK', 1, 1200, 1200, 0),
('2BHK', 0, 2200, 2200, 0),
('2BHK', 1, 1400, 200, 0),
('H', 1, 300, 4500, 0),
('1BHK', 0, 1300, 4000, 1),
('1BHK', 1, 1234, 765, 1),
('1BHK', 1, 134, 165, 1),
('1BHK', 1, 1000, 1500, 1),
('1BHK', 1, 2000, 1500, 1),
('2BHK', 1, 3500, 5000, 1),
('3BHK', 1, 1600, 6400, 1),
('2BHK', 1, 2300, 6600, 1),
('3BHK', 1, 12345, 2200, 1),
('H', 1, 2500, 1500, 1),
('H', 1, 1900, 1600, 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 04, 2023 at 12:20 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbbook`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `book_code` varchar(255) DEFAULT NULL,
  `images` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `name`, `book_code`, `images`, `price`) VALUES
(1, 'Toi di code dao', 'JUWISJA22002', 'https://th.bing.com/th/id/OIP.VvYd74xJf-55NBR6EcOzyQHaE8?pid=ImgDet&rs=1', 123123),
(2, 'Tôi là ai', 'JUWISJA2200', 'https://th.bing.com/th/id/R.98efbc9a9297927471789fa8b07be74e?rik=IO%2fetPE6LwqMJw&pid=ImgRaw&r=0', 20000000),
(3, 'Tôi là Hacker', 'ABC123', 'https://i.pinimg.com/originals/00/b4/8e/00b48e631956d41b43435b4b110ef195.jpg', 15000000),
(4, 'Hacker ', 'XYZ789', 'https://th.bing.com/th/id/R.abc87b4ce32c097a939f7b8ae5cc3aed?rik=Z7jSokNHYd%2frnw&pid=ImgRaw&r=0', 18000000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

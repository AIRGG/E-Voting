-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 03, 2021 at 03:51 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_evoting`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_kalkulasi`
--

CREATE TABLE `tbl_kalkulasi` (
  `idkalkulasi` int(11) NOT NULL,
  `docalculate` varchar(1) NOT NULL,
  `datecalculate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_kalkulasi`
--

INSERT INTO `tbl_kalkulasi` (`idkalkulasi`, `docalculate`, `datecalculate`) VALUES
(1, '0', '2021-10-03 20:19:27');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_pemilih`
--

CREATE TABLE `tbl_pemilih` (
  `userid` varchar(50) NOT NULL,
  `passwd` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `hasvote` varchar(1) NOT NULL,
  `role` varchar(5) NOT NULL,
  `unqiduser` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_pemilih`
--

INSERT INTO `tbl_pemilih` (`userid`, `passwd`, `nama`, `hasvote`, `role`, `unqiduser`) VALUES
('admin', '123', 'Administrator', '1', 'admin', 'asdtfgh2y675r'),
('budi', '123', 'Budiantoro', '0', 'user', 'asd76tyghjb2dasd'),
('orang', '123', 'Orang', '0', 'user', 'f4c26f2bf6ba4d548921cbcfc32587ab'),
('orang2', '123', 'orang2', '0', 'user', '014b06652eda4074b131c8cce374afac'),
('qq', '123', 'aaaa', '0', 'user', '9beea48c99a14e288aab5905ed5a250e'),
('siapa', 'Z6X9UMMB', 'siapa kamu', '0', 'user', '3450150ea8604936a3928951fbcceb54');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_vote`
--

CREATE TABLE `tbl_vote` (
  `idvote` int(11) NOT NULL,
  `kdvote` varchar(5) NOT NULL,
  `unqiduser` varchar(32) NOT NULL,
  `tgljam` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_vote`
--

INSERT INTO `tbl_vote` (`idvote`, `kdvote`, `unqiduser`, `tgljam`) VALUES
(1, '1', '1', '2021-10-03 13:50:18');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_kalkulasi`
--
ALTER TABLE `tbl_kalkulasi`
  ADD PRIMARY KEY (`idkalkulasi`);

--
-- Indexes for table `tbl_pemilih`
--
ALTER TABLE `tbl_pemilih`
  ADD PRIMARY KEY (`userid`);

--
-- Indexes for table `tbl_vote`
--
ALTER TABLE `tbl_vote`
  ADD PRIMARY KEY (`idvote`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_kalkulasi`
--
ALTER TABLE `tbl_kalkulasi`
  MODIFY `idkalkulasi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `tbl_vote`
--
ALTER TABLE `tbl_vote`
  MODIFY `idvote` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

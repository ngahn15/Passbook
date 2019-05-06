-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2019 at 02:42 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bank`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `ID` varchar(255) NOT NULL,
  `Fullname` varchar(255) DEFAULT NULL,
  `Birthday` date DEFAULT NULL,
  `Address` text,
  `Email` varchar(255) DEFAULT NULL,
  `Phone` varchar(255) DEFAULT NULL,
  `Gender` tinyint(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`ID`, `Fullname`, `Birthday`, `Address`, `Email`, `Phone`, `Gender`) VALUES
('013423479', 'Lê Hải Đăng', '1996-03-14', 'Hà Nội	', 'lehaidang@gmail.com', '01234567890', 0),
('038197005151', 'Hoàng Ngọc Nga', '1997-05-05', 'Thanh Hóa	', 'ngocnga.hnn@gmail.com', '0946555997', 1),
('1112365987', 'Nguyễn Thị Định', '1993-05-20', 'Hà Nội', 'ntdinh@gmail.com', '0359862660', 1),
('174595178', 'Hoàng Ngọc Nga', '1997-05-05', 'Hà Nội', 'ngocnga.hnn@gmail.com', '0948655597', 1),
('225978639', 'Nguyen Van An', '1960-05-16', 'Ha Tinh	', 'akho@gmail.com', '0563987269', 0),
('256987991', 'Pham Thi Mai', '1997-01-26', 'Hung yen', 'phammai@gmai.com', '0369875266', 1),
('999666586', 'Bao An', '1998-05-07', 'Hà Nội', 'hahah@gmail.com', '01223456789', 1);

-- --------------------------------------------------------

--
-- Table structure for table `deal`
--

CREATE TABLE `deal` (
  `ID` int(10) NOT NULL,
  `InterestMethodID` int(10) NOT NULL,
  `PassBookID` int(10) NOT NULL,
  `CustomerID` varchar(255) NOT NULL,
  `TypeDealID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `interestmethod`
--

CREATE TABLE `interestmethod` (
  `ID` int(10) NOT NULL,
  `NameMethod` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `interestmethod`
--

INSERT INTO `interestmethod` (`ID`, `NameMethod`) VALUES
(1, 'Rút tháng'),
(2, 'Nhập gốc');

-- --------------------------------------------------------

--
-- Table structure for table `interestrate`
--

CREATE TABLE `interestrate` (
  `ID` int(10) NOT NULL,
  `TypeID` int(10) NOT NULL,
  `Period` int(255) DEFAULT NULL,
  `Rate` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `interestrate`
--

INSERT INTO `interestrate` (`ID`, `TypeID`, `Period`, `Rate`) VALUES
(1, 1, 0, 0.2),
(2, 2, 1, 4.1),
(3, 2, 2, 4.1),
(4, 2, 3, 4.6),
(5, 2, 6, 5.1),
(6, 2, 9, 5.5),
(7, 2, 12, 6.6),
(8, 2, 18, 6.7),
(9, 2, 24, 6.7);

-- --------------------------------------------------------

--
-- Table structure for table `passbook`
--

CREATE TABLE `passbook` (
  `ID` int(10) NOT NULL,
  `InterestRateID` int(10) NOT NULL,
  `TypeID` int(10) NOT NULL,
  `CustomerID` varchar(255) NOT NULL,
  `TypePeriod` int(10) NOT NULL,
  `InterestMethodID` int(11) DEFAULT NULL,
  `DepositsOriginal` double DEFAULT NULL,
  `OpenDate` date DEFAULT NULL,
  `expDate` date DEFAULT NULL,
  `status` tinyint(10) DEFAULT NULL,
  `closeDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `passbook`
--

INSERT INTO `passbook` (`ID`, `InterestRateID`, `TypeID`, `CustomerID`, `TypePeriod`, `InterestMethodID`, `DepositsOriginal`, `OpenDate`, `expDate`, `status`, `closeDate`) VALUES
(103393184, 1, 1, '174595178', 1, 2, 3000000, '2019-04-17', '0000-00-00', 0, NULL),
(203894093, 4, 2, '174595178', 4, 1, 500000000, '2019-05-04', '2019-08-04', 0, '0000-00-00'),
(895359605, 3, 2, '225978639', 3, 1, 5000000, '2019-05-04', '2019-07-04', 0, NULL),
(1010735640, 4, 2, '174595178', 4, 1, 50000000, '2019-05-03', '2019-08-03', 0, '0000-00-00');

-- --------------------------------------------------------

--
-- Table structure for table `savemoney`
--

CREATE TABLE `savemoney` (
  `DealID` int(10) NOT NULL,
  `Deposits` double DEFAULT NULL,
  `DateSend` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `typepassbook`
--

CREATE TABLE `typepassbook` (
  `ID` int(10) NOT NULL,
  `NameType` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `typepassbook`
--

INSERT INTO `typepassbook` (`ID`, `NameType`) VALUES
(1, 'Không kỳ hạn'),
(2, 'Có kỳ hạn'),
(3, 'An sinh');

-- --------------------------------------------------------

--
-- Table structure for table `withdraw`
--

CREATE TABLE `withdraw` (
  `DealID` int(10) NOT NULL,
  `DateWithdraw` date DEFAULT NULL,
  `InterestReceived` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `deal`
--
ALTER TABLE `deal`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKDeal228923` (`CustomerID`),
  ADD KEY `FKDeal543782` (`PassBookID`),
  ADD KEY `FKDeal574823` (`InterestMethodID`);

--
-- Indexes for table `interestmethod`
--
ALTER TABLE `interestmethod`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `interestrate`
--
ALTER TABLE `interestrate`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKInterestRa806854` (`TypeID`);

--
-- Indexes for table `passbook`
--
ALTER TABLE `passbook`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FKPassBook450493` (`TypeID`),
  ADD KEY `FKPassBook747485` (`InterestRateID`),
  ADD KEY `FKPassBook816479` (`CustomerID`),
  ADD KEY `FKPassBook816480` (`InterestMethodID`);

--
-- Indexes for table `savemoney`
--
ALTER TABLE `savemoney`
  ADD PRIMARY KEY (`DealID`);

--
-- Indexes for table `typepassbook`
--
ALTER TABLE `typepassbook`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `withdraw`
--
ALTER TABLE `withdraw`
  ADD PRIMARY KEY (`DealID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `deal`
--
ALTER TABLE `deal`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `interestmethod`
--
ALTER TABLE `interestmethod`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `interestrate`
--
ALTER TABLE `interestrate`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `passbook`
--
ALTER TABLE `passbook`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1010735641;

--
-- AUTO_INCREMENT for table `typepassbook`
--
ALTER TABLE `typepassbook`
  MODIFY `ID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `deal`
--
ALTER TABLE `deal`
  ADD CONSTRAINT `FKDeal228923` FOREIGN KEY (`CustomerID`) REFERENCES `customer` (`ID`),
  ADD CONSTRAINT `FKDeal543782` FOREIGN KEY (`PassBookID`) REFERENCES `passbook` (`ID`);

--
-- Constraints for table `interestrate`
--
ALTER TABLE `interestrate`
  ADD CONSTRAINT `FKInterestRa806854` FOREIGN KEY (`TypeID`) REFERENCES `typepassbook` (`ID`);

--
-- Constraints for table `savemoney`
--
ALTER TABLE `savemoney`
  ADD CONSTRAINT `FKSaveMoney449373` FOREIGN KEY (`DealID`) REFERENCES `deal` (`ID`);

--
-- Constraints for table `withdraw`
--
ALTER TABLE `withdraw`
  ADD CONSTRAINT `FKWithdraw585161` FOREIGN KEY (`DealID`) REFERENCES `deal` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

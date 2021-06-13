-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 30 May 2021, 14:23:39
-- Sunucu sürümü: 10.4.17-MariaDB
-- PHP Sürümü: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `rentacar`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `brands`
--

CREATE TABLE `brands` (
  `Id` int(11) NOT NULL,
  `Name` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `brands`
--

INSERT INTO `brands` (`Id`, `Name`) VALUES
(1, 'Citroen'),
(2, 'BMW'),
(6, 'Toyota'),
(9, 'Ferrari');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `cars`
--

CREATE TABLE `cars` (
  `Id` int(11) NOT NULL,
  `ModelId` int(11) NOT NULL,
  `BrandId` int(11) NOT NULL,
  `ColorId` int(11) NOT NULL,
  `DailyPrice` decimal(18,0) NOT NULL,
  `ModelYear` smallint(6) NOT NULL,
  `Description` varchar(50) DEFAULT NULL,
  `FindeksScore` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `cars`
--

INSERT INTO `cars` (`Id`, `ModelId`, `BrandId`, `ColorId`, `DailyPrice`, `ModelYear`, `Description`, `FindeksScore`) VALUES
(2, 2, 6, 2, '250', 2018, 'Az yakar çok kaçmaz', 90),
(18, 10, 9, 11, '500', 1967, 'Sport', 100),
(19, 9, 9, 11, '600', 2013, 'Sport', 100),
(20, 8, 2, 6, '400', 2020, 'Sport Classic', 90),
(21, 7, 2, 10, '350', 2021, 'Sport Classic', 95),
(22, 6, 2, 9, '300', 2009, 'Sport Classic', 80),
(23, 5, 1, 7, '150', 2016, 'C Segment', 50);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `colors`
--

CREATE TABLE `colors` (
  `Id` int(11) NOT NULL,
  `Name` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `colors`
--

INSERT INTO `colors` (`Id`, `Name`) VALUES
(2, 'Mavi'),
(5, 'Mor'),
(6, 'Yeşil'),
(7, 'Gri'),
(8, 'Pembe'),
(9, 'Sarı'),
(10, 'Beyaz'),
(11, 'Kırmızı');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `customers`
--

CREATE TABLE `customers` (
  `Id` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `CompanyName` varchar(50) DEFAULT NULL,
  `FindeksScore` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `customers`
--

INSERT INTO `customers` (`Id`, `UserId`, `CompanyName`, `FindeksScore`) VALUES
(8, 14, 'Tass LTD Şti', 80),
(9, 15, 'Softech', 90);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `models`
--

CREATE TABLE `models` (
  `Id` int(11) NOT NULL,
  `BrandId` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `models`
--

INSERT INTO `models` (`Id`, `BrandId`, `Name`) VALUES
(1, 1, 'C-5'),
(2, 2, 'C180'),
(5, 1, 'C3'),
(6, 1, 'DS7'),
(7, 2, 'M550d'),
(8, 2, 'Gran Turismo'),
(9, 9, 'F12 Berlinetta'),
(10, 9, '275 GTB');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `operationclaims`
--

CREATE TABLE `operationclaims` (
  `Id` int(11) NOT NULL,
  `Name` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `operationclaims`
--

INSERT INTO `operationclaims` (`Id`, `Name`) VALUES
(1, 'admin'),
(2, 'member');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `rentals`
--

CREATE TABLE `rentals` (
  `Id` int(11) NOT NULL,
  `CarId` int(11) NOT NULL,
  `CustomerId` int(11) NOT NULL,
  `RentDate` datetime DEFAULT NULL,
  `ReturnDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `rentals`
--

INSERT INTO `rentals` (`Id`, `CarId`, `CustomerId`, `RentDate`, `ReturnDate`) VALUES
(4, 23, 8, '2021-05-30 00:00:00', '2021-06-01 00:00:00'),
(5, 22, 9, '2021-05-30 00:00:00', '2021-06-06 00:00:00'),
(6, 23, 8, '2021-05-30 00:00:00', '2021-06-02 00:00:00');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `useroperationclaims`
--

CREATE TABLE `useroperationclaims` (
  `Id` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  `OperationClaimId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `useroperationclaims`
--

INSERT INTO `useroperationclaims` (`Id`, `UserId`, `OperationClaimId`) VALUES
(7, 13, 1),
(8, 14, 2),
(9, 15, 2),
(10, 16, 2);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `users`
--

CREATE TABLE `users` (
  `Id` int(11) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `PasswordHash` varchar(500) NOT NULL,
  `Status` bit(1) NOT NULL DEFAULT b'1',
  `Age` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `users`
--

INSERT INTO `users` (`Id`, `FirstName`, `LastName`, `Email`, `PasswordHash`, `Status`, `Age`) VALUES
(13, 'Admin', '', 'Admin', '0192023a7bbd73250516f069df18b500', b'1', '1994-06-03 00:00:00'),
(14, 'Semih', 'Şahan', 's.semih.sahan@hotmail.com', '202cb962ac59075b964b07152d234b70', b'1', '1999-08-22 00:00:00'),
(15, 'Mehmet', 'Bozdağ', 'mehmet123@gmail.com', '202cb962ac59075b964b07152d234b70', b'1', '2021-05-14 00:00:00'),
(16, 'Ahmet', 'Arık', 'arik46@hotmail.com', '202cb962ac59075b964b07152d234b70', b'1', '2021-05-28 00:00:00');

--
-- Tetikleyiciler `users`
--
DELIMITER $$
CREATE TRIGGER `user_ai` AFTER INSERT ON `users` FOR EACH ROW INSERT INTO useroperationclaims (UserId,OperationClaimId) VALUES (NEW.Id,2)
$$
DELIMITER ;

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `brands`
--
ALTER TABLE `brands`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FK_Cars_Brands` (`BrandId`),
  ADD KEY `FK_Cars_Colors` (`ColorId`),
  ADD KEY `FK_Cars_Models` (`ModelId`);

--
-- Tablo için indeksler `colors`
--
ALTER TABLE `colors`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FK_Customers_Users` (`UserId`);

--
-- Tablo için indeksler `models`
--
ALTER TABLE `models`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FK_Colors_Brands` (`BrandId`);

--
-- Tablo için indeksler `operationclaims`
--
ALTER TABLE `operationclaims`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `rentals`
--
ALTER TABLE `rentals`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FK_Rentals_Cars` (`CarId`),
  ADD KEY `FK_Rentals_Customers` (`CustomerId`);

--
-- Tablo için indeksler `useroperationclaims`
--
ALTER TABLE `useroperationclaims`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `FK_UserOperationClaims_Users` (`UserId`),
  ADD KEY `FK_UserOperationClaims_OperationClaims` (`OperationClaimId`);

--
-- Tablo için indeksler `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`Id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `brands`
--
ALTER TABLE `brands`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Tablo için AUTO_INCREMENT değeri `cars`
--
ALTER TABLE `cars`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Tablo için AUTO_INCREMENT değeri `colors`
--
ALTER TABLE `colors`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Tablo için AUTO_INCREMENT değeri `customers`
--
ALTER TABLE `customers`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Tablo için AUTO_INCREMENT değeri `models`
--
ALTER TABLE `models`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Tablo için AUTO_INCREMENT değeri `operationclaims`
--
ALTER TABLE `operationclaims`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `rentals`
--
ALTER TABLE `rentals`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Tablo için AUTO_INCREMENT değeri `useroperationclaims`
--
ALTER TABLE `useroperationclaims`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Tablo için AUTO_INCREMENT değeri `users`
--
ALTER TABLE `users`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `cars`
--
ALTER TABLE `cars`
  ADD CONSTRAINT `FK_Cars_Brands` FOREIGN KEY (`BrandId`) REFERENCES `brands` (`Id`),
  ADD CONSTRAINT `FK_Cars_Colors` FOREIGN KEY (`ColorId`) REFERENCES `colors` (`Id`),
  ADD CONSTRAINT `FK_Cars_Models` FOREIGN KEY (`ModelId`) REFERENCES `models` (`Id`);

--
-- Tablo kısıtlamaları `customers`
--
ALTER TABLE `customers`
  ADD CONSTRAINT `FK_Customers_Users` FOREIGN KEY (`UserId`) REFERENCES `users` (`Id`);

--
-- Tablo kısıtlamaları `models`
--
ALTER TABLE `models`
  ADD CONSTRAINT `FK_Colors_Brands` FOREIGN KEY (`BrandId`) REFERENCES `brands` (`Id`);

--
-- Tablo kısıtlamaları `rentals`
--
ALTER TABLE `rentals`
  ADD CONSTRAINT `FK_Rentals_Cars` FOREIGN KEY (`CarId`) REFERENCES `cars` (`Id`),
  ADD CONSTRAINT `FK_Rentals_Customers` FOREIGN KEY (`CustomerId`) REFERENCES `customers` (`Id`);

--
-- Tablo kısıtlamaları `useroperationclaims`
--
ALTER TABLE `useroperationclaims`
  ADD CONSTRAINT `FK_UserOperationClaims_OperationClaims` FOREIGN KEY (`OperationClaimId`) REFERENCES `operationclaims` (`Id`),
  ADD CONSTRAINT `FK_UserOperationClaims_Users` FOREIGN KEY (`UserId`) REFERENCES `users` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

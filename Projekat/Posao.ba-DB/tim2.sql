-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 24, 2017 at 06:04 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tim2`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `idKorisnika` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`idKorisnika`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `kantoni`
--

CREATE TABLE `kantoni` (
  `idKantona` int(11) NOT NULL,
  `naziv` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `kantoni`
--

INSERT INTO `kantoni` (`idKantona`, `naziv`) VALUES
(1, 'Unsko-sanski kanton'),
(2, 'Posavski kanton'),
(3, 'Tuzlanski kanton'),
(4, 'Zeničko-dobojski kanton'),
(5, 'Bosansko-podrinjski kanton'),
(6, 'Srednjobosanski kanton'),
(7, 'Hercegovačko-neretvanski kanton'),
(8, 'Zapadnohercegovački kanton'),
(9, 'Kanton Sarajevo'),
(10, 'Kanton 10');

-- --------------------------------------------------------

--
-- Table structure for table `kategorije`
--

CREATE TABLE `kategorije` (
  `idKategorije` int(11) NOT NULL,
  `naziv` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `kategorije`
--

INSERT INTO `kategorije` (`idKategorije`, `naziv`) VALUES
(1, 'IT'),
(2, 'Ekonomija'),
(3, 'Uslužne djelatnosti');

-- --------------------------------------------------------

--
-- Table structure for table `korisnici`
--

CREATE TABLE `korisnici` (
  `idKorisnika` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password_hash` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `korisnici`
--

INSERT INTO `korisnici` (`idKorisnika`, `username`, `password_hash`, `email`) VALUES
(1, 'admin', '098f6bcd4621d373cade4e832627b4f6', 'admin@posao.ba'),
(2, 'firma1', '098f6bcd4621d373cade4e832627b4f6', 'firma1@firma1.com'),
(5, 'korisnik2', '098f6bcd4621d373cade4e832627b4f6', 'korisnik2@domena.com'),
(6, 'ekalac1', 'test', 'no');

-- --------------------------------------------------------

--
-- Table structure for table `lokacije`
--

CREATE TABLE `lokacije` (
  `idLokacije` int(11) NOT NULL,
  `idKantona` int(11) NOT NULL,
  `naziv` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `lokacije`
--

INSERT INTO `lokacije` (`idLokacije`, `idKantona`, `naziv`) VALUES
(1, 9, 'Sarajevo'),
(2, 4, 'Zenica'),
(3, 3, 'Tuzla'),
(4, 7, 'Mostar');

-- --------------------------------------------------------

--
-- Table structure for table `nezaposleni`
--

CREATE TABLE `nezaposleni` (
  `idKorisnika` int(11) NOT NULL,
  `ime` varchar(60) NOT NULL,
  `prezime` varchar(60) NOT NULL,
  `cv` varchar(1000) DEFAULT NULL,
  `privatanProfil` tinyint(4) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `nezaposleni`
--

INSERT INTO `nezaposleni` (`idKorisnika`, `ime`, `prezime`, `cv`, `privatanProfil`) VALUES
(5, 'Drugi', 'Nezaposleni', 'CV Tekst 2', 0),
(6, 'Elza', '', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `notifikacija`
--

CREATE TABLE `notifikacija` (
  `idNotifikacije` int(11) NOT NULL,
  `idKorisnika` int(11) NOT NULL,
  `tekst` varchar(255) NOT NULL,
  `pregledana` tinyint(4) NOT NULL DEFAULT '0',
  `vrijemeGenerisanja` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `notifikacija`
--

INSERT INTO `notifikacija` (`idNotifikacije`, `idKorisnika`, `tekst`, `pregledana`, `vrijemeGenerisanja`) VALUES
(1, 2, 'Notifikacija broj jedan', 1, '2017-08-05 17:12:33'),
(4, 2, 'Notifikacija broj cetiri', 0, '2017-10-05 16:13:09');

-- --------------------------------------------------------

--
-- Table structure for table `notifikacijapozivnica`
--

CREATE TABLE `notifikacijapozivnica` (
  `idNotifikacije` int(11) NOT NULL,
  `idPozivnice` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `notifikacijaprijava`
--

CREATE TABLE `notifikacijaprijava` (
  `idNotifikacije` int(11) NOT NULL,
  `idPrijave` int(11) NOT NULL,
  `idPrijavljenog` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `oglas`
--

CREATE TABLE `oglas` (
  `idOglasa` int(11) NOT NULL,
  `idPoslodavca` int(11) NOT NULL,
  `idLokacije` int(11) NOT NULL,
  `idKategorije` int(11) NOT NULL,
  `datumObjave` datetime NOT NULL,
  `datumIsteka` datetime NOT NULL,
  `sakriven` tinyint(4) NOT NULL,
  `zatvoren` tinyint(4) NOT NULL DEFAULT '0',
  `uspjesan` tinyint(4) DEFAULT NULL,
  `prioritet` int(11) NOT NULL DEFAULT '5',
  `naziv` varchar(256) NOT NULL,
  `opis` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `oglas`
--

INSERT INTO `oglas` (`idOglasa`, `idPoslodavca`, `idLokacije`, `idKategorije`, `datumObjave`, `datumIsteka`, `sakriven`, `zatvoren`, `uspjesan`, `prioritet`, `naziv`, `opis`) VALUES
(1, 2, 1, 1, '2017-05-05 00:00:00', '2017-07-01 23:59:59', 0, 0, 0, 1, 'Oglas 1', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis quis vulputate mi. Nullam interdum nulla risus, vitae varius metus volutpat ut. Aliquam sem mauris, vulputate vitae neque a, dapibus feugiat elit. In dignissim ornare urna, ultrices dapibus metus semper id. Ut eget ex a felis finibus facilisis a ac massa. Aenean condimentum quam eu odio imperdiet, a maximus odio accumsan. In at fermentum arcu, in laoreet tortor. Vivamus ultrices aliquet velit, non aliquam leo. Quisque sit amet commodo sem. Donec pretium ut orci a fermentum. Morbi purus lectus, molestie non nisi ut, suscipit ullamcorper justo. Ut consequat egestas varius. Nullam magna enim, viverra id eros quis, pulvinar aliquet libero.'),
(2, 2, 2, 2, '2017-05-10 00:00:00', '2017-06-01 23:59:59', 0, 0, 0, 2, 'Oglas 2', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis quis vulputate mi. Nullam interdum nulla risus, vitae varius metus volutpat ut. Aliquam sem mauris, vulputate vitae neque a, dapibus feugiat elit. In dignissim ornare urna, ultrices dapibus metus semper id. Ut eget ex a felis finibus facilisis a ac massa. Aenean condimentum quam eu odio imperdiet, a maximus odio accumsan. In at fermentum arcu, in laoreet tortor. Vivamus ultrices aliquet velit, non aliquam leo. Quisque sit amet commodo sem. Donec pretium ut orci a fermentum. Morbi purus lectus, molestie non nisi ut, suscipit ullamcorper justo. Ut consequat egestas varius. Nullam magna enim, viverra id eros quis, pulvinar aliquet libero.'),
(3, 2, 3, 2, '2017-05-08 00:00:00', '2017-05-19 00:00:00', 0, 0, 0, 2, 'Oglas 3', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis quis vulputate mi. Nullam interdum nulla risus, vitae varius metus volutpat ut. Aliquam sem mauris, vulputate vitae neque a, dapibus feugiat elit. In dignissim ornare urna, ultrices dapibus metus semper id. Ut eget ex a felis finibus facilisis a ac massa. Aenean condimentum quam eu odio imperdiet, a maximus odio accumsan. In at fermentum arcu, in laoreet tortor. Vivamus ultrices aliquet velit, non aliquam leo. Quisque sit amet commodo sem. Donec pretium ut orci a fermentum. Morbi purus lectus, molestie non nisi ut, suscipit ullamcorper justo. Ut consequat egestas varius. Nullam magna enim, viverra id eros quis, pulvinar aliquet libero.'),
(4, 2, 3, 1, '2017-05-07 00:00:00', '2017-06-07 00:00:00', 0, 1, 0, 1, 'Oglas 4', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis quis vulputate mi. Nullam interdum nulla risus, vitae varius metus volutpat ut. Aliquam sem mauris, vulputate vitae neque a, dapibus feugiat elit. In dignissim ornare urna, ultrices dapibus metus semper id. Ut eget ex a felis finibus facilisis a ac massa. Aenean condimentum quam eu odio imperdiet, a maximus odio accumsan. In at fermentum arcu, in laoreet tortor. Vivamus ultrices aliquet velit, non aliquam leo. Quisque sit amet commodo sem. Donec pretium ut orci a fermentum. Morbi purus lectus, molestie non nisi ut, suscipit ullamcorper justo. Ut consequat egestas varius. Nullam magna enim, viverra id eros quis, pulvinar aliquet libero.'),
(6, 2, 1, 1, '2017-05-05 00:00:00', '2017-07-01 23:59:59', 0, 0, 0, 1, 'Oglas X', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis quis vulputate mi. Nullam interdum nulla risus, vitae varius metus volutpat ut. Aliquam sem mauris, vulputate vitae neque a, dapibus feugiat elit. In dignissim ornare urna, ultrices dapibus metus semper id. Ut eget ex a felis finibus facilisis a ac massa. Aenean condimentum quam eu odio imperdiet, a maximus odio accumsan. In at fermentum arcu, in laoreet tortor. Vivamus ultrices aliquet velit, non aliquam leo. Quisque sit amet commodo sem. Donec pretium ut orci a fermentum. Morbi purus lectus, molestie non nisi ut, suscipit ullamcorper justo. Ut consequat egestas varius. Nullam magna enim, viverra id eros quis, pulvinar aliquet libero.');

-- --------------------------------------------------------

--
-- Table structure for table `oglaspodaci`
--

CREATE TABLE `oglaspodaci` (
  `id` int(11) NOT NULL,
  `idOglasa` int(11) NOT NULL,
  `vrijednost` varchar(1000) NOT NULL,
  `staje` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `oglaspodaci`
--

INSERT INTO `oglaspodaci` (`id`, `idOglasa`, `vrijednost`, `staje`) VALUES
(8, 2, 'Trgovac', 'Zanimanje'),
(9, 2, 'Kratak opis', 'Opis'),
(10, 2, 'Opis posla ....', 'Opis'),
(11, 2, 'SSS', 'SSS'),
(12, 2, '2017-05-10 00:00:00', 'Datum i vrijeme'),
(13, 2, 'Mostar', 'Lokacija'),
(14, 2, 'Zenica', 'Lokacija'),
(15, 2, 'Napomena', 'Napomena');

-- --------------------------------------------------------

--
-- Table structure for table `oglasprijave`
--

CREATE TABLE `oglasprijave` (
  `idPrijave` int(11) NOT NULL,
  `idOglasa` int(11) NOT NULL,
  `idKorisnika` int(11) NOT NULL,
  `dodatneInformacije` varchar(1000) DEFAULT NULL,
  `vrijemePrijave` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `oglasprijave`
--

INSERT INTO `oglasprijave` (`idPrijave`, `idOglasa`, `idKorisnika`, `dodatneInformacije`, `vrijemePrijave`) VALUES
(1, 1, 5, NULL, '2017-05-23 00:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `poljatemplatea`
--

CREATE TABLE `poljatemplatea` (
  `id` int(11) NOT NULL,
  `idTemplate` int(11) NOT NULL,
  `nazivPolja` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `poljatemplatea`
--

INSERT INTO `poljatemplatea` (`id`, `idTemplate`, `nazivPolja`) VALUES
(1, 1, 'Naslov'),
(2, 1, 'Kratak opis'),
(3, 1, 'Opis'),
(4, 1, 'Vještine'),
(5, 1, 'Datum objave'),
(6, 1, 'Datum isteka'),
(7, 1, 'Lokacija'),
(8, 2, 'Naslov'),
(9, 2, 'Kratak opis'),
(10, 2, 'Opis'),
(11, 2, 'Stručna sprema'),
(12, 2, 'Datum objave'),
(13, 2, 'Datum isteka'),
(14, 2, 'Lokacija'),
(15, 2, 'Napomene');

-- --------------------------------------------------------

--
-- Table structure for table `poruke`
--

CREATE TABLE `poruke` (
  `idPoruke` int(11) NOT NULL,
  `idPosiljaoca` int(11) NOT NULL,
  `idPrimaoca` int(11) NOT NULL,
  `tekst` varchar(1000) NOT NULL,
  `vrijeme` datetime NOT NULL,
  `procitano` tinyint(4) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `poruke`
--

INSERT INTO `poruke` (`idPoruke`, `idPosiljaoca`, `idPrimaoca`, `tekst`, `vrijeme`, `procitano`) VALUES
(1, 2, 5, 'Do?i da me ljubis', '2017-05-23 00:00:00', 0),
(2, 2, 5, 'Do?i da me ljubis', '2017-05-23 00:00:00', 0),
(3, 2, 5, 'Do?i da me ljubis', '2017-05-23 00:00:00', 0),
(4, 2, 5, 'Korisnik Drugi Nezaposlenise prijavio na oglas Oglas 1', '2017-05-23 00:00:00', 0);

-- --------------------------------------------------------

--
-- Table structure for table `poslodavci`
--

CREATE TABLE `poslodavci` (
  `idKorisnika` int(11) NOT NULL,
  `ime` varchar(60) NOT NULL,
  `prezime` varchar(60) NOT NULL,
  `nazivFirme` varchar(100) NOT NULL,
  `telefon` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `poslodavci`
--

INSERT INTO `poslodavci` (`idKorisnika`, `ime`, `prezime`, `nazivFirme`, `telefon`) VALUES
(2, 'VlasnikUpdated', 'Firme', 'Firma1', '123-456');

-- --------------------------------------------------------

--
-- Table structure for table `pozivnice`
--

CREATE TABLE `pozivnice` (
  `idPozivnice` int(11) NOT NULL,
  `idOglasa` int(11) NOT NULL,
  `idKorisnika` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `sakrivenipodaci`
--

CREATE TABLE `sakrivenipodaci` (
  `idPoslodavca` int(11) NOT NULL,
  `privatnoIme` tinyint(4) NOT NULL DEFAULT '0',
  `privatnoPrezime` tinyint(4) NOT NULL DEFAULT '0',
  `privatnanTelefon` tinyint(4) NOT NULL DEFAULT '0',
  `privatanEmail` tinyint(4) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sakrivenipodaci`
--

INSERT INTO `sakrivenipodaci` (`idPoslodavca`, `privatnoIme`, `privatnoPrezime`, `privatnanTelefon`, `privatanEmail`) VALUES
(2, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `template`
--

CREATE TABLE `template` (
  `idTemplate` int(11) NOT NULL,
  `naziv` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `template`
--

INSERT INTO `template` (`idTemplate`, `naziv`) VALUES
(1, 'IT Posao'),
(2, 'Trgovac'),
(3, 'Menadzer'),
(4, 'Pravnik');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`idKorisnika`);

--
-- Indexes for table `kantoni`
--
ALTER TABLE `kantoni`
  ADD PRIMARY KEY (`idKantona`);

--
-- Indexes for table `kategorije`
--
ALTER TABLE `kategorije`
  ADD PRIMARY KEY (`idKategorije`);

--
-- Indexes for table `korisnici`
--
ALTER TABLE `korisnici`
  ADD PRIMARY KEY (`idKorisnika`);

--
-- Indexes for table `lokacije`
--
ALTER TABLE `lokacije`
  ADD PRIMARY KEY (`idLokacije`),
  ADD KEY `fk_Lokacije_Kantoni1_idx` (`idKantona`);

--
-- Indexes for table `nezaposleni`
--
ALTER TABLE `nezaposleni`
  ADD PRIMARY KEY (`idKorisnika`);

--
-- Indexes for table `notifikacija`
--
ALTER TABLE `notifikacija`
  ADD PRIMARY KEY (`idNotifikacije`),
  ADD KEY `fk_Notifikacija_Korisnici1_idx` (`idKorisnika`);

--
-- Indexes for table `notifikacijapozivnica`
--
ALTER TABLE `notifikacijapozivnica`
  ADD PRIMARY KEY (`idNotifikacije`),
  ADD KEY `fk_NotifikacijaPozivnica_Pozivnice1_idx` (`idPozivnice`);

--
-- Indexes for table `notifikacijaprijava`
--
ALTER TABLE `notifikacijaprijava`
  ADD PRIMARY KEY (`idNotifikacije`),
  ADD KEY `fk_NotifikacijaPrijava_OglasPrijave1_idx` (`idPrijave`),
  ADD KEY `fk_NotifikacijaPrijava_Nezaposleni1_idx` (`idPrijavljenog`);

--
-- Indexes for table `oglas`
--
ALTER TABLE `oglas`
  ADD PRIMARY KEY (`idOglasa`),
  ADD KEY `fk_Oglas_Poslodavci1_idx` (`idPoslodavca`),
  ADD KEY `fk_Oglas_Lokacije1_idx` (`idLokacije`),
  ADD KEY `fk_Oglas_Kategorije1_idx` (`idKategorije`);

--
-- Indexes for table `oglaspodaci`
--
ALTER TABLE `oglaspodaci`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_OglasPodaci_Oglas1_idx` (`idOglasa`);

--
-- Indexes for table `oglasprijave`
--
ALTER TABLE `oglasprijave`
  ADD PRIMARY KEY (`idPrijave`),
  ADD KEY `fk_OglasPrijave_Oglas1_idx` (`idOglasa`),
  ADD KEY `fk_OglasPrijave_Nezaposleni1_idx` (`idKorisnika`);

--
-- Indexes for table `poljatemplatea`
--
ALTER TABLE `poljatemplatea`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_PoljaTemplatea_Template1_idx` (`idTemplate`);

--
-- Indexes for table `poruke`
--
ALTER TABLE `poruke`
  ADD PRIMARY KEY (`idPoruke`),
  ADD KEY `fk_Poruke_Nezaposleni1_idx` (`idPosiljaoca`),
  ADD KEY `fk_Poruke_Poslodavci1_idx` (`idPrimaoca`);

--
-- Indexes for table `poslodavci`
--
ALTER TABLE `poslodavci`
  ADD PRIMARY KEY (`idKorisnika`);

--
-- Indexes for table `pozivnice`
--
ALTER TABLE `pozivnice`
  ADD PRIMARY KEY (`idPozivnice`),
  ADD KEY `fk_Pozivnice_Oglas1_idx` (`idOglasa`),
  ADD KEY `fk_Pozivnice_Nezaposleni1_idx` (`idKorisnika`);

--
-- Indexes for table `sakrivenipodaci`
--
ALTER TABLE `sakrivenipodaci`
  ADD PRIMARY KEY (`idPoslodavca`);

--
-- Indexes for table `template`
--
ALTER TABLE `template`
  ADD PRIMARY KEY (`idTemplate`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kantoni`
--
ALTER TABLE `kantoni`
  MODIFY `idKantona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `kategorije`
--
ALTER TABLE `kategorije`
  MODIFY `idKategorije` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `korisnici`
--
ALTER TABLE `korisnici`
  MODIFY `idKorisnika` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `lokacije`
--
ALTER TABLE `lokacije`
  MODIFY `idLokacije` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `notifikacija`
--
ALTER TABLE `notifikacija`
  MODIFY `idNotifikacije` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `oglas`
--
ALTER TABLE `oglas`
  MODIFY `idOglasa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `oglaspodaci`
--
ALTER TABLE `oglaspodaci`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `oglasprijave`
--
ALTER TABLE `oglasprijave`
  MODIFY `idPrijave` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `poljatemplatea`
--
ALTER TABLE `poljatemplatea`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `poruke`
--
ALTER TABLE `poruke`
  MODIFY `idPoruke` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `pozivnice`
--
ALTER TABLE `pozivnice`
  MODIFY `idPozivnice` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `template`
--
ALTER TABLE `template`
  MODIFY `idTemplate` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `fk_Admin_Korisnici1` FOREIGN KEY (`idKorisnika`) REFERENCES `korisnici` (`idKorisnika`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `lokacije`
--
ALTER TABLE `lokacije`
  ADD CONSTRAINT `fk_Lokacije_Kantoni1` FOREIGN KEY (`idKantona`) REFERENCES `kantoni` (`idKantona`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `nezaposleni`
--
ALTER TABLE `nezaposleni`
  ADD CONSTRAINT `fk_Nezaposleni_Korisnici` FOREIGN KEY (`idKorisnika`) REFERENCES `korisnici` (`idKorisnika`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `notifikacija`
--
ALTER TABLE `notifikacija`
  ADD CONSTRAINT `fk_Notifikacija_Korisnici1` FOREIGN KEY (`idKorisnika`) REFERENCES `korisnici` (`idKorisnika`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `notifikacijapozivnica`
--
ALTER TABLE `notifikacijapozivnica`
  ADD CONSTRAINT `fk_NotifikacijaPozivnica_Notifikacija1` FOREIGN KEY (`idNotifikacije`) REFERENCES `notifikacija` (`idNotifikacije`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_NotifikacijaPozivnica_Pozivnice1` FOREIGN KEY (`idPozivnice`) REFERENCES `pozivnice` (`idPozivnice`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `notifikacijaprijava`
--
ALTER TABLE `notifikacijaprijava`
  ADD CONSTRAINT `fk_NotifikacijaPrijava_Nezaposleni1` FOREIGN KEY (`idPrijavljenog`) REFERENCES `nezaposleni` (`idKorisnika`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_NotifikacijaPrijava_Notifikacija1` FOREIGN KEY (`idNotifikacije`) REFERENCES `notifikacija` (`idNotifikacije`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_NotifikacijaPrijava_OglasPrijave1` FOREIGN KEY (`idPrijave`) REFERENCES `oglasprijave` (`idPrijave`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `oglas`
--
ALTER TABLE `oglas`
  ADD CONSTRAINT `fk_Oglas_Kategorije1` FOREIGN KEY (`idKategorije`) REFERENCES `kategorije` (`idKategorije`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Oglas_Lokacije1` FOREIGN KEY (`idLokacije`) REFERENCES `lokacije` (`idLokacije`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Oglas_Poslodavci1` FOREIGN KEY (`idPoslodavca`) REFERENCES `poslodavci` (`idKorisnika`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `oglaspodaci`
--
ALTER TABLE `oglaspodaci`
  ADD CONSTRAINT `fk_OglasPodaci_Oglas1` FOREIGN KEY (`idOglasa`) REFERENCES `oglas` (`idOglasa`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `oglasprijave`
--
ALTER TABLE `oglasprijave`
  ADD CONSTRAINT `fk_OglasPrijave_Nezaposleni1` FOREIGN KEY (`idKorisnika`) REFERENCES `nezaposleni` (`idKorisnika`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_OglasPrijave_Oglas1` FOREIGN KEY (`idOglasa`) REFERENCES `oglas` (`idOglasa`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `poljatemplatea`
--
ALTER TABLE `poljatemplatea`
  ADD CONSTRAINT `fk_PoljaTemplatea_Template1` FOREIGN KEY (`idTemplate`) REFERENCES `template` (`idTemplate`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `poruke`
--
ALTER TABLE `poruke`
  ADD CONSTRAINT `fk_Poruke_Nezaposleni1` FOREIGN KEY (`idPosiljaoca`) REFERENCES `korisnici` (`idKorisnika`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Poruke_Poslodavci1` FOREIGN KEY (`idPrimaoca`) REFERENCES `korisnici` (`idKorisnika`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `poslodavci`
--
ALTER TABLE `poslodavci`
  ADD CONSTRAINT `fk_Poslodavci_Korisnici1` FOREIGN KEY (`idKorisnika`) REFERENCES `korisnici` (`idKorisnika`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `pozivnice`
--
ALTER TABLE `pozivnice`
  ADD CONSTRAINT `fk_Pozivnice_Nezaposleni1` FOREIGN KEY (`idKorisnika`) REFERENCES `nezaposleni` (`idKorisnika`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Pozivnice_Oglas1` FOREIGN KEY (`idOglasa`) REFERENCES `oglas` (`idOglasa`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Constraints for table `sakrivenipodaci`
--
ALTER TABLE `sakrivenipodaci`
  ADD CONSTRAINT `fk_SakriveniPodaci_Poslodavci1` FOREIGN KEY (`idPoslodavca`) REFERENCES `poslodavci` (`idKorisnika`) ON DELETE CASCADE ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 18, 2017 at 09:22 PM
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
(3, 'firma2', '098f6bcd4621d373cade4e832627b4f6', 'forma2@firma2.com'),
(4, 'korisnik1', '098f6bcd4621d373cade4e832627b4f6', 'korisnik1@domena.com'),
(5, 'korisnik2', '098f6bcd4621d373cade4e832627b4f6', 'korisnik2@domena.com');

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
(4, 'Prvi', 'Nezaposleni', 'CV Tekst 1', 0),
(5, 'Drugi', 'Nezaposleni', 'CV Tekst 2', 0);

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
(2, 3, 'Notifikacija broj dva', 0, '2017-09-05 04:22:13'),
(3, 4, 'Notifikacija broj tri', 1, '2017-09-05 11:48:23'),
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
  `prioritet` int(11) NOT NULL DEFAULT '5'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `oglas`
--

INSERT INTO `oglas` (`idOglasa`, `idPoslodavca`, `idLokacije`, `idKategorije`, `datumObjave`, `datumIsteka`, `sakriven`, `zatvoren`, `uspjesan`, `prioritet`) VALUES
(1, 2, 1, 1, '2017-05-05 00:00:00', '2017-07-01 23:59:59', 0, 0, 0, 1),
(2, 2, 2, 2, '2017-05-10 00:00:00', '2017-06-01 23:59:59', 0, 0, 0, 2),
(3, 2, 3, 2, '2017-05-08 00:00:00', '2017-06-05 23:59:59', 0, 0, 0, 2),
(4, 2, 3, 1, '2017-05-07 00:00:00', '2017-06-07 23:59:59', 0, 0, 0, 1),
(5, 2, 4, 1, '2017-05-10 00:00:00', '2017-06-10 23:59:59', 0, 0, 0, 1);

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
(1, 1, 'Junior developer', ''),
(2, 1, 'Tražimo junior developera', ''),
(3, 1, 'Junior developer sa dvogodišnjim iskustvom sa različitim tehnologijama, želja za učenjem, entuzijazam bla bla', ''),
(4, 1, 'Java, Spring, Ember, Angular js', ''),
(5, 1, '2017-05-05 00:00:00', ''),
(6, 1, '2017-07-01 23:59:59', ''),
(7, 1, 'Sarajevo', ''),
(8, 2, 'Trgovac', ''),
(9, 2, 'Kratak opis', ''),
(10, 2, 'Opis posla ....', ''),
(11, 2, 'SSS', ''),
(12, 2, '2017-05-10 00:00:00', ''),
(13, 2, '', ''),
(14, 2, 'Zenica', ''),
(15, 2, 'Napomena', '');

-- --------------------------------------------------------

--
-- Table structure for table `oglasprijave`
--

CREATE TABLE `oglasprijave` (
  `idPrijave` int(11) NOT NULL,
  `idOglasa` int(11) NOT NULL,
  `idKorisnika` int(11) NOT NULL,
  `dodatneInformacije` varchar(1000) DEFAULT NULL,
  `vrijemePrijave` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  `idNezaposlenog` int(11) NOT NULL,
  `idPoslodavca` int(11) NOT NULL,
  `tekst` varchar(1000) NOT NULL,
  `vrijeme` datetime NOT NULL,
  `procitano` tinyint(4) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
(2, 'Vlasnik', 'Firme', 'Firma1', '123-456'),
(3, 'Vlasnik 2', 'Firme', 'Firma2', '123-456');

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
(2, 0, 0, 0, 0),
(3, 1, 1, 0, 0);

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
  ADD KEY `fk_Poruke_Nezaposleni1_idx` (`idNezaposlenog`),
  ADD KEY `fk_Poruke_Poslodavci1_idx` (`idPoslodavca`);

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
  MODIFY `idKorisnika` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
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
  MODIFY `idOglasa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `oglaspodaci`
--
ALTER TABLE `oglaspodaci`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `oglasprijave`
--
ALTER TABLE `oglasprijave`
  MODIFY `idPrijave` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `poljatemplatea`
--
ALTER TABLE `poljatemplatea`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `poruke`
--
ALTER TABLE `poruke`
  MODIFY `idPoruke` int(11) NOT NULL AUTO_INCREMENT;
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
  ADD CONSTRAINT `fk_Lokacije_Kantoni1` FOREIGN KEY (`idKantona`) REFERENCES `kantoni` (`idKantona`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `nezaposleni`
--
ALTER TABLE `nezaposleni`
  ADD CONSTRAINT `fk_Nezaposleni_Korisnici` FOREIGN KEY (`idKorisnika`) REFERENCES `korisnici` (`idKorisnika`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `notifikacija`
--
ALTER TABLE `notifikacija`
  ADD CONSTRAINT `fk_Notifikacija_Korisnici1` FOREIGN KEY (`idKorisnika`) REFERENCES `korisnici` (`idKorisnika`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `notifikacijapozivnica`
--
ALTER TABLE `notifikacijapozivnica`
  ADD CONSTRAINT `fk_NotifikacijaPozivnica_Notifikacija1` FOREIGN KEY (`idNotifikacije`) REFERENCES `notifikacija` (`idNotifikacije`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_NotifikacijaPozivnica_Pozivnice1` FOREIGN KEY (`idPozivnice`) REFERENCES `pozivnice` (`idPozivnice`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `notifikacijaprijava`
--
ALTER TABLE `notifikacijaprijava`
  ADD CONSTRAINT `fk_NotifikacijaPrijava_Nezaposleni1` FOREIGN KEY (`idPrijavljenog`) REFERENCES `nezaposleni` (`idKorisnika`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_NotifikacijaPrijava_Notifikacija1` FOREIGN KEY (`idNotifikacije`) REFERENCES `notifikacija` (`idNotifikacije`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_NotifikacijaPrijava_OglasPrijave1` FOREIGN KEY (`idPrijave`) REFERENCES `oglasprijave` (`idPrijave`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `oglas`
--
ALTER TABLE `oglas`
  ADD CONSTRAINT `fk_Oglas_Kategorije1` FOREIGN KEY (`idKategorije`) REFERENCES `kategorije` (`idKategorije`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Oglas_Lokacije1` FOREIGN KEY (`idLokacije`) REFERENCES `lokacije` (`idLokacije`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Oglas_Poslodavci1` FOREIGN KEY (`idPoslodavca`) REFERENCES `poslodavci` (`idKorisnika`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `oglaspodaci`
--
ALTER TABLE `oglaspodaci`
  ADD CONSTRAINT `fk_OglasPodaci_Oglas1` FOREIGN KEY (`idOglasa`) REFERENCES `oglas` (`idOglasa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `oglasprijave`
--
ALTER TABLE `oglasprijave`
  ADD CONSTRAINT `fk_OglasPrijave_Nezaposleni1` FOREIGN KEY (`idKorisnika`) REFERENCES `nezaposleni` (`idKorisnika`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_OglasPrijave_Oglas1` FOREIGN KEY (`idOglasa`) REFERENCES `oglas` (`idOglasa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `poljatemplatea`
--
ALTER TABLE `poljatemplatea`
  ADD CONSTRAINT `fk_PoljaTemplatea_Template1` FOREIGN KEY (`idTemplate`) REFERENCES `template` (`idTemplate`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `poruke`
--
ALTER TABLE `poruke`
  ADD CONSTRAINT `fk_Poruke_Nezaposleni1` FOREIGN KEY (`idNezaposlenog`) REFERENCES `nezaposleni` (`idKorisnika`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Poruke_Poslodavci1` FOREIGN KEY (`idPoslodavca`) REFERENCES `poslodavci` (`idKorisnika`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `poslodavci`
--
ALTER TABLE `poslodavci`
  ADD CONSTRAINT `fk_Poslodavci_Korisnici1` FOREIGN KEY (`idKorisnika`) REFERENCES `korisnici` (`idKorisnika`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `pozivnice`
--
ALTER TABLE `pozivnice`
  ADD CONSTRAINT `fk_Pozivnice_Nezaposleni1` FOREIGN KEY (`idKorisnika`) REFERENCES `nezaposleni` (`idKorisnika`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Pozivnice_Oglas1` FOREIGN KEY (`idOglasa`) REFERENCES `oglas` (`idOglasa`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `sakrivenipodaci`
--
ALTER TABLE `sakrivenipodaci`
  ADD CONSTRAINT `fk_SakriveniPodaci_Poslodavci1` FOREIGN KEY (`idPoslodavca`) REFERENCES `poslodavci` (`idKorisnika`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

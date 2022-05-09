-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Dec 30, 2021 at 03:15 PM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestionnaire_du_personnel`
--

-- --------------------------------------------------------

--
-- Table structure for table `absences_nj`
--

DROP TABLE IF EXISTS `absences_nj`;
CREATE TABLE IF NOT EXISTS `absences_nj` (
  `PPR` varchar(255) NOT NULL,
  `date_debut` varchar(255) NOT NULL,
  `duree` int(10) NOT NULL,
  `date_fin` varchar(255) NOT NULL,
  KEY `emp` (`PPR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `absences_nj`
--

INSERT INTO `absences_nj` (`PPR`, `date_debut`, `duree`, `date_fin`) VALUES
('12', '20/02/2020', 2, '23/02/2020');

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(15) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `mot_de_passe` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `nom`, `mot_de_passe`) VALUES
(1, 'alia', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `conges`
--

DROP TABLE IF EXISTS `conges`;
CREATE TABLE IF NOT EXISTS `conges` (
  `PPR` varchar(255) NOT NULL,
  `date_demande` varchar(255) NOT NULL,
  `date_debut` varchar(255) NOT NULL,
  `date_fin` varchar(255) NOT NULL,
  `duree` varchar(255) NOT NULL,
  `solde_a_diminuer` int(10) NOT NULL,
  KEY `emp_id_fk` (`PPR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `conges`
--

INSERT INTO `conges` (`PPR`, `date_demande`, `date_debut`, `date_fin`, `duree`, `solde_a_diminuer`) VALUES
('12', '02/03/2000', '02/03/2000', '02/03/2000', '2', 2),
('12', '02/03/2019', '02/03/2019', '02/03/2019', '2', 2),
('11', '02/03/2019', '02/03/2019', '02/03/2019', '1', 1),
('12', '11/11/2012', '11/11/2012', '11/11/2012', '3', 3),
('12', '02/03/2021', '02/03/2021', '02/03/2021', '1', 1),
('14', '20/03/2021', '20/04/2021', '20/05/2021', '2', 2),
('14', '02/05/2021', '02/05/2021', '02/05/2021', '2', 2),
('14', '01/05/2021', '02/05/2021', '02/05/2021', '2', 2),
('15', '20/03/2021', '21/03/2021', '22/03/2021', '2', 2),
('12', '12/03/2021', '12/03/2021', '12/03/2021', '2', 2),
('14', '03/04/2020', '03/04/2020', '03/06/2020', '2', 2),
('12', '18/02/2020', '20/02/2020', '24/02/2020', '2', 2),
('13', '20/11/2020', '21/11/2020', '27/11/2020', '2', 2);

-- --------------------------------------------------------

--
-- Table structure for table `diplomes`
--

DROP TABLE IF EXISTS `diplomes`;
CREATE TABLE IF NOT EXISTS `diplomes` (
  `PPR` varchar(255) NOT NULL,
  `diplome` varchar(255) NOT NULL,
  `filiere` varchar(255) NOT NULL,
  `mention` varchar(255) NOT NULL,
  KEY `emp_id_fk` (`PPR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `diplomes`
--

INSERT INTO `diplomes` (`PPR`, `diplome`, `filiere`, `mention`) VALUES
('11', 'ingenieur', 'info', 'good'),
('12', 'ing', 'civil', 'bien'),
('15', 'master', 'big data', 'honorable'),
('12', 'ing', 'web', 'bien'),
('13', 'ing', 'web dev', 'bien');

-- --------------------------------------------------------

--
-- Table structure for table `licence_ex`
--

DROP TABLE IF EXISTS `licence_ex`;
CREATE TABLE IF NOT EXISTS `licence_ex` (
  `PPR` varchar(255) NOT NULL,
  `date_debut` varchar(255) NOT NULL,
  `duree` varchar(255) NOT NULL,
  `solde_diminuer` int(10) NOT NULL,
  `date_fin` varchar(255) NOT NULL,
  `raison` varchar(255) NOT NULL,
  KEY `emp` (`PPR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `licence_ex`
--

INSERT INTO `licence_ex` (`PPR`, `date_debut`, `duree`, `solde_diminuer`, `date_fin`, `raison`) VALUES
('12', '12/13/2021', '2', 2, '12/17/2021', 'jkljkjkljl  njkjkjnkjnkjnk bjkbjkjnkjnkjnk\r\nknlmmkl jijlijkljk jikjkj'),
('11', '19/12/2020', '1', 1, '21/12/2020', ''),
('15', '03/05/2021', '03/05/2021', 2, '03/05/2021', 'sdfdfs sdfsdf'),
('12', '20/03/2021', '20/03/2021', 2, '20/03/2021', 'jhjhjhjnhk'),
('12', '04/04/2021', '2', 2, '04/04/2021', 'jnkjnkjnknj emklmklemk klklklklklcv'),
('12', '20/03/2020', '2', 2, '24/03/2020', 'qwwew wreret eetrt');

-- --------------------------------------------------------

--
-- Table structure for table `ordre_de_mission`
--

DROP TABLE IF EXISTS `ordre_de_mission`;
CREATE TABLE IF NOT EXISTS `ordre_de_mission` (
  `PPR` varchar(255) NOT NULL,
  `date_debut` varchar(255) NOT NULL,
  `duree` int(255) NOT NULL,
  `date_demande` varchar(255) NOT NULL,
  `date_fin` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  KEY `emp` (`PPR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ordre_de_mission`
--

INSERT INTO `ordre_de_mission` (`PPR`, `date_debut`, `duree`, `date_demande`, `date_fin`, `description`) VALUES
('12', '12/11/2019', 3, '10/11/2019', '14/11/2019', 'ghhhhhhh jhhhhhhhhh jhkkkkkkk'),
('11', '20/03/2020', 6, '01/03/2020', '01/04/2020', 'AHLAN BIKOM '),
('15', '20/04/2020', 2, '20/03/2020', '20/05/2020', '\\sdjhsdjhaw  dakjhadjhK asdjhkwdjhk'),
('13', '22/11/2020', 2, '20/11/2020', '24/11/2020', 'sdcdcdcdsdsds jklcdjjkl ksdkjn');

-- --------------------------------------------------------

--
-- Table structure for table `personnel`
--

DROP TABLE IF EXISTS `personnel`;
CREATE TABLE IF NOT EXISTS `personnel` (
  `PPR` varchar(22) NOT NULL,
  `CIN` varchar(255) DEFAULT NULL,
  `Adresse` varchar(255) DEFAULT NULL,
  `Date_de_naissance` varchar(255) DEFAULT NULL,
  `Lieu_de_naissance` varchar(255) DEFAULT NULL,
  `Nationalite` varchar(255) DEFAULT NULL,
  `Nom_Complet_Fr` varchar(255) DEFAULT NULL,
  `Nombre_Des_enfants` int(10) DEFAULT NULL,
  `Sexe` varchar(255) DEFAULT NULL,
  `Situation_familial` varchar(255) DEFAULT NULL,
  `recrutement_ensa` varchar(255) DEFAULT NULL,
  `recrutement` varchar(255) DEFAULT NULL,
  `grade_mise` varchar(255) DEFAULT NULL,
  `Echelle` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Grade` varchar(255) DEFAULT NULL,
  `N_telephone` varchar(255) DEFAULT NULL,
  `Nombre_absence` int(10) DEFAULT NULL,
  `Solde_du_conge` int(10) DEFAULT NULL,
  `Solde_licence_exceptionnel` int(10) DEFAULT NULL,
  `Status_de_travail` varchar(255) DEFAULT NULL,
  `Type_employe` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`PPR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `personnel`
--

INSERT INTO `personnel` (`PPR`, `CIN`, `Adresse`, `Date_de_naissance`, `Lieu_de_naissance`, `Nationalite`, `Nom_Complet_Fr`, `Nombre_Des_enfants`, `Sexe`, `Situation_familial`, `recrutement_ensa`, `recrutement`, `grade_mise`, `Echelle`, `Email`, `Grade`, `N_telephone`, `Nombre_absence`, `Solde_du_conge`, `Solde_licence_exceptionnel`, `Status_de_travail`, `Type_employe`) VALUES
('11', 'fer', 'efef', '02/03/2000', 'maroc', 'marocain', 'yassin', 2, 'dcd', 'cdds', '02/03/2000', '02/03/2000', '02/03/2000', 'dfvdf', 'vffvddf', 'feef', 'fvfve', 22, 23, 23, 'scsd', 'cddccd'),
('12', 'fer', 'efef', '02/03/2000', 'cfdcdf', 'marocain', 'rachid', 2, 'dcd', 'marocain', '02/03/2000', '02/03/2000', '02/03/2000', 'dfvdf', 'vffvddf', 'feef', '0644564', 22, 14, 18, 'scsd', 'cddccd'),
('13', 'fer', 'efef', '02/03/2000', 'maroc', 'camerone', 'ayman', 2, 'dcd', 'cdds', '02/03/2010', '02/03/2009', '02/03/2014', 'dfvdf', 'vffvddf', 'lllll', 'fvfve', 22, 21, 23, 'scsd', 'cddccd'),
('14', 'fer', 'efef', '02/03/2000', 'maroc', 'marocain', 'ismail', 2, 'dcd', 'cdds', '02/03/2010', '02/03/2009', '02/03/2014', 'kkkkk', 'vffvddf', 'llll', 'fvfve', 22, 15, 23, 'scsd', 'jjjj'),
('15', 'fer', 'efef', '02/03/2000', 'maroc', 'marocain', 'amed', 2, 'dcd', 'cdds', '02/03/2010', '02/03/2009', '02/03/2014', 'kkkkk', 'vffvddf', 'llll', 'fvfve', 22, 21, 21, 'scsd', 'jjjj'),
('16', 'fer', 'efef', '02/03/2000', 'cfdcdf', 'marocain', 'rachid', 2, 'dcd', 'marocain', '02/03/2000', '02/03/2000', '02/03/2000', 'dfvdf', 'vffvddf', 'feef', '0644564', 22, 14, 18, 'scsd', 'cddccd');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `absences_nj`
--
ALTER TABLE `absences_nj`
  ADD CONSTRAINT `absences_nj_ibfk_1` FOREIGN KEY (`PPR`) REFERENCES `personnel` (`PPR`);

--
-- Constraints for table `conges`
--
ALTER TABLE `conges`
  ADD CONSTRAINT `conges_ibfk_1` FOREIGN KEY (`PPR`) REFERENCES `personnel` (`PPR`);

--
-- Constraints for table `diplomes`
--
ALTER TABLE `diplomes`
  ADD CONSTRAINT `diplomes_ibfk_1` FOREIGN KEY (`PPR`) REFERENCES `personnel` (`PPR`);

--
-- Constraints for table `licence_ex`
--
ALTER TABLE `licence_ex`
  ADD CONSTRAINT `licence_ex_ibfk_1` FOREIGN KEY (`PPR`) REFERENCES `personnel` (`PPR`);

--
-- Constraints for table `ordre_de_mission`
--
ALTER TABLE `ordre_de_mission`
  ADD CONSTRAINT `ordre_de_mission_ibfk_1` FOREIGN KEY (`PPR`) REFERENCES `personnel` (`PPR`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

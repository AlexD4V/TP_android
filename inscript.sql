-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : ven. 01 avr. 2022 à 13:18
-- Version du serveur :  5.7.31
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `assos`
--

-- --------------------------------------------------------

--
-- Structure de la table `inscript`
--

DROP TABLE IF EXISTS `inscript`;
CREATE TABLE IF NOT EXISTS `inscript` (
  `Pseudo` varchar(30) NOT NULL,
  `Motdepasse` varchar(35) NOT NULL,
  `Association` varchar(35) NOT NULL,
  `Disposemaine` varchar(30) NOT NULL,
  `Niveau` varchar(25) NOT NULL,
  `Commentaire` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `inscript`
--

INSERT INTO `inscript` (`Pseudo`, `Motdepasse`, `Association`, `Disposemaine`, `Niveau`, `Commentaire`) VALUES
('', '', 'Association 1', '', '', ''),
('', '', 'association 2', '', '', ''),
('', '', 'association 3', '', '', '');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

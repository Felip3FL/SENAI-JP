CREATE TABLE `contrato` (
  `idcontrato` int(11) NOT NULL AUTO_INCREMENT,
  `numero` varchar(45) NOT NULL,
  `descricao` varchar(450) NOT NULL,
  `dataAbertura` date NOT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY (`idcontrato`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP DATABASE IF EXISTS DOCTORSIS;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Estrutura da tabela `consulta`
--
CREATE DATABASE IF NOT EXISTS `doctorsis`;
USE `doctorsis`;


CREATE TABLE IF NOT EXISTS `consulta` (
`idconsulta` int(11) NOT NULL,
  `data_consulta` date DEFAULT NULL,
  `sintomas` text,
  `exames` text,
  `idtipo_consulta` int(11) NOT NULL,
  `idpaciente` int(11) NOT NULL,
  `hora_consulta` time DEFAULT NULL,
  `compareceu` tinyint(1) DEFAULT NULL,
  `receita` text,
  `medicacao` text,
  `atestado` text,
  `laudo` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `convenio`
--

CREATE TABLE IF NOT EXISTS `convenio` (
`idconvenio` int(11) NOT NULL,
  `descricao` varchar(45) DEFAULT NULL,
  `observacoes` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `paciente`
--

CREATE TABLE IF NOT EXISTS `paciente` (
`idpaciente` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `telefone1` varchar(10) DEFAULT NULL,
  `telefone2` varchar(10) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `data_nasc` date DEFAULT NULL,
  `idconvenio` int(11) NOT NULL,
  `observacoes` text,
  `cpf` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_consulta`
--

CREATE TABLE IF NOT EXISTS `tipo_consulta` (
`idtipo_consulta` int(11) NOT NULL,
  `descricao` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_usuario`
--

CREATE TABLE IF NOT EXISTS `tipo_usuario` (
`idtipo_usuario` int(11) NOT NULL,
  `descricao` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
`idusuario` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `telefone` varchar(10) DEFAULT NULL,
  `celular` varchar(10) DEFAULT NULL,
  `senha` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `idtipousuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `consulta`
--
ALTER TABLE `consulta`
 ADD PRIMARY KEY (`idconsulta`), ADD KEY `fk_consulta_tipo_consulta1_idx` (`idtipo_consulta`), ADD KEY `fk_consulta_paciente1_idx` (`idpaciente`);

--
-- Indexes for table `convenio`
--
ALTER TABLE `convenio`
 ADD PRIMARY KEY (`idconvenio`);

--
-- Indexes for table `paciente`
--
ALTER TABLE `paciente`
 ADD PRIMARY KEY (`idpaciente`), ADD KEY `fk_paciente_convenio_idx` (`idconvenio`);

--
-- Indexes for table `tipo_consulta`
--
ALTER TABLE `tipo_consulta`
 ADD PRIMARY KEY (`idtipo_consulta`);

--
-- Indexes for table `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
 ADD PRIMARY KEY (`idtipo_usuario`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
 ADD PRIMARY KEY (`idusuario`), ADD KEY `fk_usuario_tipousuario1_idx` (`idtipousuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `consulta`
--
ALTER TABLE `consulta`
MODIFY `idconsulta` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `convenio`
--
ALTER TABLE `convenio`
MODIFY `idconvenio` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `paciente`
--
ALTER TABLE `paciente`
MODIFY `idpaciente` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tipo_consulta`
--
ALTER TABLE `tipo_consulta`
MODIFY `idtipo_consulta` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
MODIFY `idtipo_usuario` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT;


INSERT INTO `convenio` VALUES (1,'UNIMED',''),(2,'IPE','');
INSERT INTO `tipo_consulta` VALUES (1,'consulta'),(2,'reconsulta');
INSERT INTO `tipo_usuario` VALUES (1,'secretaria'),(2,'medico'),(3, 'administrador');
INSERT INTO `usuario` VALUES (1,'usuario','','','e10adc3949ba59abbe56e057f20f883e','usuario',2);

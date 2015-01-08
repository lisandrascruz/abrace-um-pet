-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 08-Jan-2015 às 02:41
-- Versão do servidor: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `abrace_um_pet`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `adocao`
--

CREATE TABLE IF NOT EXISTS `adocao` (
`id` int(11) NOT NULL,
  `idAnimal` int(11) DEFAULT NULL,
  `idAdotante` int(11) DEFAULT NULL,
  `dataAdocao` timestamp NULL DEFAULT NULL,
  `dataDevolucao` timestamp NULL DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0 - Inativo 1 - Ativo'
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `adocao`
--

INSERT INTO `adocao` (`id`, `idAnimal`, `idAdotante`, `dataAdocao`, `dataDevolucao`, `idUsuario`, `status`) VALUES
(9, 1, 18, '2014-12-17 15:00:50', '2014-12-17 15:02:21', 9, 1),
(14, 7, 23, '2014-12-17 15:43:35', '2014-12-17 15:44:09', 9, 1),
(15, 7, 18, '2014-12-17 15:51:18', '2014-12-17 15:51:32', 9, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `adotante`
--

CREATE TABLE IF NOT EXISTS `adotante` (
`id` int(11) NOT NULL,
  `impedimento` tinyint(1) DEFAULT NULL,
  `motivoImpedimeto` text,
  `idPessoa` int(11) DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0 - Inativo 1 - Ativo'
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `adotante`
--

INSERT INTO `adotante` (`id`, `impedimento`, `motivoImpedimeto`, `idPessoa`, `status`) VALUES
(18, NULL, NULL, 3, 0),
(19, NULL, NULL, 4, 1),
(20, NULL, NULL, 5, 1),
(21, NULL, NULL, 6, 1),
(22, NULL, NULL, 7, 1),
(23, NULL, NULL, 8, 0),
(24, NULL, NULL, 11, 1),
(25, NULL, NULL, 12, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `animal`
--

CREATE TABLE IF NOT EXISTS `animal` (
`id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `tipo` varchar(120) DEFAULT NULL,
  `rga` varchar(45) DEFAULT NULL,
  `dataNascimento` varchar(45) DEFAULT NULL,
  `idRaca` int(11) DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `deficiencia` text,
  `vacinado` varchar(45) DEFAULT NULL,
  `castrado` varchar(45) DEFAULT NULL,
  `tamanho` double DEFAULT NULL,
  `peso` double DEFAULT NULL,
  `temperamento` text,
  `observacao` text,
  `dataResgate` varchar(45) DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0 - Inativo 1 - Ativo'
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `animal`
--

INSERT INTO `animal` (`id`, `nome`, `tipo`, `rga`, `dataNascimento`, `idRaca`, `genero`, `deficiencia`, `vacinado`, `castrado`, `tamanho`, `peso`, `temperamento`, `observacao`, `dataResgate`, `status`) VALUES
(1, 'Cat', 'gato', '7921', NULL, 1, 'M', NULL, '1', '1', 1, 20, NULL, NULL, NULL, 1),
(2, 'rwtretr', 'gato', 'rrrrr', '11/1111', NULL, '', '', '1', '1', 11.11, 1.22, 'javax.swing.JTextPane[,403,244,216x30,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@4d15aaeb,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@bb54828,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@bb54828}]', 'javax.swing.JTextPane[,106,292,513x84,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@4d15aaeb,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@668aca93,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@668aca93}]', '11/11/1111', 1),
(3, 'dsfsdf', 'Gato', 'dsfsdf', '22/2222', NULL, '', '', '1', '1', 22.22, 1.22, 'javax.swing.JTextPane[,403,244,216x30,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@6c6c80f1,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@1a4764e,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@1a4764e}]', 'javax.swing.JTextPane[,106,292,513x84,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@6c6c80f1,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@5eb4ee36,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@5eb4ee36}]', '22/22/2222', 1),
(4, 'adsff', 'Gato', '222222222222222', '22/2222', NULL, 'Macho', 'Auditiva', 'Sim', 'Sim', 22.22, 1.22, 'javax.swing.JTextPane[,403,244,216x30,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@3692c09,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@2669822f,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@2669822f}]', 'javax.swing.JTextPane[,106,292,513x84,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@3692c09,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@42963634,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@42963634}]', '22/22/2222', 1),
(5, 'asdsa', 'Gato', 'sadsadsa', '11/1111', NULL, 'Macho', 'Auditiva', 'Não', 'Sim', 11.11, 11.11, 'javax.swing.JTextPane[,403,244,216x30,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@4b3356a6,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@14738413,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@14738413}]', 'javax.swing.JTextPane[,106,292,513x84,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@4b3356a6,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@6e938623,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@6e938623}]', '11/11/1111', 1),
(6, 'wewqe', 'Cachorro', 'errrrrrrrrrrrr', '22/2222', NULL, 'Macho', 'Fisica', 'Não', 'Sim', 22.22, 22.22, NULL, 'javax.swing.JTextPane[,106,292,513x84,layout=javax.swing.plaf.basic.BasicTextUI$UpdateHandler,alignmentX=0.0,alignmentY=0.0,border=javax.swing.plaf.basic.BasicBorders$MarginBorder@bd10581,flags=296,maximumSize=,minimumSize=,preferredSize=,caretColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],disabledTextColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],editable=true,margin=javax.swing.plaf.InsetsUIResource[top=3,left=3,bottom=3,right=3],selectedTextColor=sun.swing.PrintColorUIResource[r=51,g=51,b=51],selectionColor=javax.swing.plaf.ColorUIResource[r=184,g=207,b=229],kit=javax.swing.text.StyledEditorKit@33ab9440,typeHandlers={text/plain=javax.swing.text.StyledEditorKit@33ab9440}]', '22/22/2222', 1),
(7, 'Sr. Gato', 'Gato', '111', '11/1111', NULL, 'Fêmea', 'Auditiva', 'Não', 'Sim', 11.11, 11.11, '1111111111111', '1111', '11/11/1111', 1),
(8, 'Gatinho', 'Gato', '4443', '11/1111', NULL, 'Macho', 'Auditiva', 'Sim', 'Sim', 11.11, 11.11, 'ruim', 'nenhuma', '11/11/1111', 1),
(9, 'miau', 'Gato', '123', '33/3333', 1, 'Macho', 'Auditiva', 'Sim', 'Sim', 3.33, 33.33, '3333', '333', '33/33/3333', 1),
(10, 'miau', 'Gato', '213', '22/2222', 1, 'Macho', 'Nenhuma', 'Sim', 'Sim', 2.22, 22.22, '22222', '2222', '22/22/2222', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE IF NOT EXISTS `endereco` (
`id` int(11) NOT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `cidade` varchar(45) DEFAULT NULL,
  `bairro` varchar(45) DEFAULT NULL,
  `rua` varchar(45) DEFAULT NULL,
  `numero` varchar(45) DEFAULT NULL,
  `complemento` varchar(45) DEFAULT NULL,
  `cep` varchar(45) DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0 - Inativo 1 - Ativo'
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`id`, `estado`, `cidade`, `bairro`, `rua`, `numero`, `complemento`, `cep`, `status`) VALUES
(3, 'PERNAMBUCO', 'RECIFE', 'VARZEA', 'RUA DEPUTADO ADALBERTO GUERRA', '83', 'CASA A', '50980615', 1),
(4, 'PERNAMBUCO', 'RECIFE', 'CAXANGA', 'RUA 00', '2', '', '50987651', 1),
(24, 'Kanto', 'Tokyo', 'Shibuya', 'chigachi', '87', 'BA', '52030100', 0),
(25, 'Kanto', 'Tokyo', 'Shinjuku', 'choujichi', '63', 'B2', '52030100', 1),
(26, 'PE', 'Recife', 'Arruda', 'Rua 3', '45', 'A33', '52030100', 1),
(27, 'fsdf', 'sdfsdf', 'fsd', 'sfsdfsdf', 'sdfsd', 'sdf', '52030100', 1),
(28, 'erw', 'wer', 'wer', 'rw', 'wer', 'ewr', '52030100', 1),
(29, 'London', 'London', 'Hammersmith', 'London street', '458', 'A34', '52030100', 0),
(30, '3223', '33333333333333', '3232', 'erewrrewewrewr', '3232', '', '33.333-333', 1),
(31, '2222', '2222', '2222', '2222222222', '222', '', '22.222-222', 1),
(32, '222', '22222222', '22', '22222222222222222222', '222', '', '22.222-222', 1),
(33, '3', '3', '33', '3333333333333', '33', '', '33.333-333', 1),
(34, '222', '222', '222', '222', '222', '', '22.222-222', 1),
(35, 'dsdssd', 'dsds', 'dsds', 'sddssd', 'sdds', '', '22.222-222', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `imagem`
--

CREATE TABLE IF NOT EXISTS `imagem` (
`id(11)` int(11) NOT NULL,
  `path` varchar(255) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0 - Inativo 1 - Ativo'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `imagemanimal`
--

CREATE TABLE IF NOT EXISTS `imagemanimal` (
  `id` int(11) NOT NULL,
  `idimagem` int(11) NOT NULL,
  `idanimal` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0 - Inativo 1 - Ativo'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE IF NOT EXISTS `pessoa` (
`id` int(11) NOT NULL,
  `nome` varchar(90) DEFAULT NULL,
  `idEndereco` int(11) DEFAULT NULL,
  `telefoneFixo` varchar(45) DEFAULT NULL,
  `telefoneCelular` varchar(45) DEFAULT NULL,
  `email` varchar(90) DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0 - Inativo 1 - Ativo'
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`id`, `nome`, `idEndereco`, `telefoneFixo`, `telefoneCelular`, `email`, `status`) VALUES
(3, 'Yukito Ayatsuji', 24, '08199652341', '08134445678', 'ayatsuji@mail.com', 0),
(4, 'JBC', 25, '08134445896', '08134445896', 'contato@jbc.com', 1),
(5, 'Prorenc', 26, '08134446471', '08134446471', 'pro@mail.com', 1),
(6, 'dfafsd', 27, '08134446471', '08134446471', 'dfs@h.com', 1),
(7, 'qewqewreqw', 28, '08134446471', '08134446471', 'asd@dw.com', 1),
(8, 'Oxford', 29, '08134446471', '08134446471', 'oxford@oxford.com', 0),
(9, 'wqewqe', 32, '(22)2222-2222', '(22)2222-2222', '222222222222222222222222', 1),
(10, 'ewe', 33, '(33)3333-3333', '(33)3333-3333', 'e@f.vo', 1),
(11, 'sdxdxd', 34, '(55)5555-5555', '(22)2222-2222', '222222222222222', 1),
(12, 'dsdsadsasda', 35, '(22)2222-2222', '(22)2222-2222', 'k@k.com', 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoafisica`
--

CREATE TABLE IF NOT EXISTS `pessoafisica` (
`id` int(11) NOT NULL,
  `rg` varchar(45) DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  `genero` varchar(45) DEFAULT NULL,
  `idPessoa` int(11) DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0 - Inativo 1 - Ativo'
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pessoafisica`
--

INSERT INTO `pessoafisica` (`id`, `rg`, `cpf`, `genero`, `idPessoa`, `status`) VALUES
(10, '7852413', '082.323.444-40', 'M', 3, 0),
(11, '1234567', '222.222.222-22', 'F', 12, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoajuridica`
--

CREATE TABLE IF NOT EXISTS `pessoajuridica` (
`id` int(11) NOT NULL,
  `cnpj` varchar(45) DEFAULT NULL,
  `idPessoa` int(11) DEFAULT NULL,
  `idPessoaFisica` int(11) DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0 - Inativo 1 - Ativo'
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `pessoajuridica`
--

INSERT INTO `pessoajuridica` (`id`, `cnpj`, `idPessoa`, `idPessoaFisica`, `status`) VALUES
(2, '01.234.567/8998-74', 4, NULL, 1),
(3, '01.234.567/8912-34', 8, 10, 0),
(4, '22.222.222/2222-22', 11, 10, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `raca`
--

CREATE TABLE IF NOT EXISTS `raca` (
`id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `origem` varchar(45) DEFAULT NULL,
  `tamanhoMax` double DEFAULT NULL,
  `tamanhoMin` double DEFAULT NULL,
  `expectativaVida` int(11) DEFAULT NULL,
  `temperamento` text,
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0 - Inativo 1 - Ativo',
  `tipo` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `raca`
--

INSERT INTO `raca` (`id`, `nome`, `origem`, `tamanhoMax`, `tamanhoMin`, `expectativaVida`, `temperamento`, `status`, `tipo`) VALUES
(1, 'Persa', 'Oriente', 45, 30, 5, NULL, 1, ''),
(2, 'Mingau', 'Leitolândia', 1, 0.5, 10, 'normal', 1, 'Gato');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
`id` int(11) NOT NULL,
  `login` varchar(45) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `email` varchar(90) DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '0 - Inativo 1 - Ativo'
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id`, `login`, `senha`, `email`, `status`) VALUES
(1, 'mushi', '202cb962ac59075b964b07152d234b70', NULL, 1),
(2, 'mikaru', '123', NULL, 1),
(3, 'paulo', '202cb962ac59075b964b07152d234b70', 'paulo@d.com', 1),
(4, 'paulo', '202cb962ac59075b964b07152d234b70', 'paulo@d.com', 1),
(5, 'cristoforetti', 'a85d63d01bd61ccd5d2798bcb6bc4c99', 'cristoforetti@nasa.com', 1),
(6, 'marcos', 'a85d63d01bd61ccd5d2798bcb6bc4c99', 'marcos@hotmail.com', 1),
(7, 'joel', 'a85d63d01bd61ccd5d2798bcb6bc4c99', 'joel@mail.com', 1),
(8, 'Charles', 'a85d63d01bd61ccd5d2798bcb6bc4c99', 'charles@mail.com', 1),
(9, 'paulof', 'a85d63d01bd61ccd5d2798bcb6bc4c99', 'paulao@mail.com', 1),
(10, 'jorginho', 'a85d63d01bd61ccd5d2798bcb6bc4c99', 'jorginho@mail.com', 1),
(11, 'jorge', 'a85d63d01bd61ccd5d2798bcb6bc4c99', 'jorge@mail.com', 1),
(12, 'paulor', 'a85d63d01bd61ccd5d2798bcb6bc4c99', 'paulor@mail.com', 1),
(13, 'isabella ', 'a85d63d01bd61ccd5d2798bcb6bc4c99', 'isabella@mail.com', 1),
(14, 'paulorf', 'a85d63d01bd61ccd5d2798bcb6bc4c99', 'p@hotmail.com', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adocao`
--
ALTER TABLE `adocao`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `adotante`
--
ALTER TABLE `adotante`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `animal`
--
ALTER TABLE `animal`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `endereco`
--
ALTER TABLE `endereco`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `imagem`
--
ALTER TABLE `imagem`
 ADD PRIMARY KEY (`id(11)`);

--
-- Indexes for table `imagemanimal`
--
ALTER TABLE `imagemanimal`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pessoa`
--
ALTER TABLE `pessoa`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pessoafisica`
--
ALTER TABLE `pessoafisica`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pessoajuridica`
--
ALTER TABLE `pessoajuridica`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `raca`
--
ALTER TABLE `raca`
 ADD PRIMARY KEY (`id`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adocao`
--
ALTER TABLE `adocao`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `adotante`
--
ALTER TABLE `adotante`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=26;
--
-- AUTO_INCREMENT for table `animal`
--
ALTER TABLE `animal`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `endereco`
--
ALTER TABLE `endereco`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=36;
--
-- AUTO_INCREMENT for table `imagem`
--
ALTER TABLE `imagem`
MODIFY `id(11)` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `pessoa`
--
ALTER TABLE `pessoa`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `pessoafisica`
--
ALTER TABLE `pessoafisica`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `pessoajuridica`
--
ALTER TABLE `pessoajuridica`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `raca`
--
ALTER TABLE `raca`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=15;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

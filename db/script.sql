-- phpMyAdmin SQL Dump
-- version 2.7.0-pl1
-- http://www.phpmyadmin.net
-- 
-- Servidor: localhost
-- Tempo de Geração: Mai 30, 2007 as 05:27 PM
-- Versão do Servidor: 5.0.18
-- Versão do PHP: 5.1.1
-- 
-- Banco de Dados: `Biblioteca`
-- 

-- --------------------------------------------------------

-- 
-- Estrutura da tabela `emprestados`
-- 

CREATE TABLE `emprestados` (
  `id` int(11) NOT NULL auto_increment,
  `id_exemplar` int(11) NOT NULL,
  `id_emprestimo` int(11) NOT NULL,
  `data_devolucao` date NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `id_exemplar` (`id_exemplar`),
  KEY `id_emprestimo` (`id_emprestimo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Extraindo dados da tabela `emprestados`
-- 


-- --------------------------------------------------------

-- 
-- Estrutura da tabela `emprestimos`
-- 

CREATE TABLE `emprestimos` (
  `id` int(11) NOT NULL auto_increment,
  `id_usuario` int(11) NOT NULL,
  `data_emprestimo` date NOT NULL,
  `data_prevista` date NOT NULL,
  `multa` float NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `id_usuario` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Extraindo dados da tabela `emprestimos`
-- 


-- --------------------------------------------------------

-- 
-- Estrutura da tabela `enderecos`
-- 

CREATE TABLE `enderecos` (
  `id` int(11) NOT NULL auto_increment,
  `cidade` varchar(25) NOT NULL,
  `bairro` varchar(25) NOT NULL,
  `logradouro` varchar(60) NOT NULL,
  `numero` varchar(6) NOT NULL,
  `complemento` varchar(60) default NULL,
  `cep` varchar(8) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Extraindo dados da tabela `enderecos`
-- 


-- --------------------------------------------------------

-- 
-- Estrutura da tabela `exemplares`
-- 

CREATE TABLE `exemplares` (
  `id` int(11) NOT NULL auto_increment,
  `id_livro` int(11) NOT NULL,
  `obs` varchar(255) default NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `id_livro` (`id_livro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Extraindo dados da tabela `exemplares`
-- 


-- --------------------------------------------------------

-- 
-- Estrutura da tabela `livros`
-- 

CREATE TABLE `livros` (
  `id` int(11) NOT NULL auto_increment,
  `id_tipo` int(11) NOT NULL,
  `titulo` varchar(30) NOT NULL,
  `autor` varchar(30) NOT NULL,
  `editora` varchar(20) NOT NULL,
  `edicao` int(11) NOT NULL,
  `ISBN` varchar(30) NOT NULL,
  `idioma` varchar(20) NOT NULL,
  `ano` int(11) default NULL,
  `sinopse` text collate latin1_general_ci,
  PRIMARY KEY  (`id`),
  KEY `id_tipo` (`id_tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Extraindo dados da tabela `livros`
-- 


-- --------------------------------------------------------

-- 
-- Estrutura da tabela `reservas`
-- 

CREATE TABLE `reservas` (
  `id` int(11) NOT NULL auto_increment,
  `id_usuario` int(11) NOT NULL,
  `id_livro` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_livro` (`id_livro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Extraindo dados da tabela `reservas`
-- 


-- --------------------------------------------------------

-- 
-- Estrutura da tabela `tipos`
-- 

CREATE TABLE `tipos` (
  `id` int(11) NOT NULL auto_increment,
  `titulo` varchar(20) NOT NULL,
  `id_tipo` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `id_tipo` (`id_tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Extraindo dados da tabela `tipos`
-- 

-- --------------------------------------------------------

-- 
-- Estrutura da tabela `usuarios`
-- 

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL auto_increment,
  `nome` varchar(30) NOT NULL,
  `rg` varchar(15) NOT NULL,
  `cpf` varchar(11) default NULL,
  `telefone` varchar(10) NOT NULL,
  `celular` varchar(10) default NULL,
  `email` varchar(30) default NULL,
  `sexo` char(1) NOT NULL,
  `id_endereco` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `id_endereco` (`id_endereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Extraindo dados da tabela `usuarios`
-- 

-- 
-- Restrições para as tabelas dumpadas
-- 

-- 
-- Restrições para a tabela `emprestados`
-- 
ALTER TABLE `emprestados`
  ADD CONSTRAINT `emprestados_ibfk_1` FOREIGN KEY (`id_exemplar`) REFERENCES `exemplares` (`id`),
  ADD CONSTRAINT `emprestados_ibfk_2` FOREIGN KEY (`id_emprestimo`) REFERENCES `emprestimos` (`id`);

-- 
-- Restrições para a tabela `emprestimos`
-- 
ALTER TABLE `emprestimos`
  ADD CONSTRAINT `emprestimos_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`);

-- 
-- Restrições para a tabela `exemplares`
-- 
ALTER TABLE `exemplares`
  ADD CONSTRAINT `exemplares_ibfk_1` FOREIGN KEY (`id_livro`) REFERENCES `livros` (`id`);

-- 
-- Restrições para a tabela `livros`
-- 
ALTER TABLE `livros`
  ADD CONSTRAINT `livros_ibfk_1` FOREIGN KEY (`id_tipo`) REFERENCES `tipos` (`id`);

-- 
-- Restrições para a tabela `reservas`
-- 
ALTER TABLE `reservas`
  ADD CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`),
  ADD CONSTRAINT `reservas_ibfk_2` FOREIGN KEY (`id_livro`) REFERENCES `livros` (`id`);

-- 
-- Restrições para a tabela `tipos`
-- 
ALTER TABLE `tipos`
  ADD CONSTRAINT `tipos_ibfk_1` FOREIGN KEY (`id_tipo`) REFERENCES `tipos` (`id`);
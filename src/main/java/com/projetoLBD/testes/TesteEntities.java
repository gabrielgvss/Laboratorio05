package com.projetoLBD.testes;

import com.projetoLBD.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TesteEntities {
   public static void main(String[] args) {
      // Cria uma fábrica de EntityManager usando a configuração definida em persistence.xml
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab05_pu");
      EntityManager em = emf.createEntityManager();

      // Cria uma transação
      em.getTransaction().begin();

      // Criação de filiais
      Filial f1 = new Filial();
      Filial f2 = new Filial();
      Filial f3 = new Filial();
      f1.setNome("São Luís");
      f1.setTelefone("9128391293");
      f2.setNome("São Paulo");
      f2.setTelefone("9218392131");
      f3.setNome("São Bento");
      f3.setTelefone("9218392139");

      // Criação de funcionários
      Funcionario func1 = new Funcionario();
      Funcionario func2 = new Funcionario();
      Funcionario func3 = new Funcionario();
      func1.setCpf("2983174194");
      func1.setNome("Joberson");
      func1.setMatricula("ADE123");
      func1.setEmail("joberson@gmail.com");
      func1.setFilial(f1);
      func2.setCpf("210491283");
      func2.setNome("Jose");
      func2.setMatricula("ADE981");
      func2.setEmail("jose@gmail.com");
      func2.setFilial(f2);
      func3.setCpf("2123120312");
      func3.setNome("Cleiton");
      func3.setMatricula("ADR112");
      func3.setEmail("cleiton@gmail.com");
      func3.setFilial(f3);

      // Criação de clientes
      Cliente c1 = new Cliente();
      Cliente c2 = new Cliente();
      Cliente c3 = new Cliente();
      c1.setNome("Joao");
      c1.setCpf("213821384");
      c1.setEmail("joao@gmail.com");
      c2.setNome("Gabriel");
      c2.setCpf("921382183");
      c2.setEmail("gabriel@gmail.com");
      c3.setNome("Maria");
      c3.setCpf("7718218918");
      c3.setEmail("maria@gmail.com");

      // Criação de dependentes
      Dependente d1 = new Dependente();
      Dependente d2 = new Dependente();
      Dependente d3 = new Dependente();
      d1.setNome("Pedro");
      d1.setDataNascimento(LocalDate.of(2004, 05, 01));
      d1.setFuncionario(func1);
      d2.setNome("Juliana");
      d2.setDataNascimento(LocalDate.of(2009, 10, 11));
      d2.setFuncionario(func2);
      d3.setNome("Carla");
      d3.setDataNascimento(LocalDate.of(1989, 12, 27));
      d3.setFuncionario(func2);

      // Criação de Tipos de Veículos
      TipoVeiculo t1 = new TipoVeiculo();
      TipoVeiculo t2 = new TipoVeiculo();
      TipoVeiculo t3 = new TipoVeiculo();
      t1.setDescricao("Caminhão Leve");
      t1.setPesoMaximo(BigDecimal.valueOf(8000.00));  // Peso máximo em kg
      t2.setDescricao("Van de Passageiros");
      t2.setPesoMaximo(BigDecimal.valueOf(2000.00));  // Peso máximo em kg
      t3.setDescricao("Caminhão Pesado");
      t3.setPesoMaximo(BigDecimal.valueOf(20000.00));  // Peso máximo em kg

      // Relacionando funcionários com filiais
      f1.getFuncionarios().add(func1);
      f2.getFuncionarios().add(func2);
      f3.getFuncionarios().add(func3);

      // Persistindo os objetos no banco de dados
      em.persist(f1);
      em.persist(f2);
      em.persist(f3);
      em.persist(func1);
      em.persist(func2);
      em.persist(func3);
      em.persist(c1);
      em.persist(c2);
      em.persist(c3);
      em.persist(d1);
      em.persist(d2);
      em.persist(d3);

      // Commit da transação
      em.getTransaction().commit();

      // Fechando EntityManager
      em.close();
      emf.close();

   }
}

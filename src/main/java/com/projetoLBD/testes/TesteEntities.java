package com.projetoLBD.testes;

import com.projetoLBD.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TesteEntities {
   public static void main(String[] args) {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab05_pu");
      EntityManager em = emf.createEntityManager();

      try {
         em.getTransaction().begin();

         // Criação de filiais
         Filial f1 = new Filial();
         Filial f2 = new Filial();
         Filial f3 = new Filial();
         f1.setNome("São Luís");
         f1.setTelefone("9128391293");
         f1.setEndereco("Rua do Arame");
         f2.setNome("São Paulo");
         f2.setTelefone("9218392131");
         f2.setEndereco("Rua Belamar");
         f3.setNome("Rio de Janeiro");
         f3.setTelefone("9218392139");
         f3.setEndereco("Estrada do Ipiranga");

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

         // Relacionando funcionários com filiais
         f1.getFuncionarios().add(func1);
         f2.getFuncionarios().add(func2);
         f3.getFuncionarios().add(func3);

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
         d1.setDataNascimento(LocalDate.of(2004, 5, 1));
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
         t2.setDescricao("Van de Entregas");
         t2.setPesoMaximo(BigDecimal.valueOf(2000.00));  // Peso máximo em kg
         t3.setDescricao("Caminhão Pesado");
         t3.setPesoMaximo(BigDecimal.valueOf(20000.00));  // Peso máximo em kg

         // Criação de Veículos
         Veiculo v1 = new Veiculo();
         Veiculo v2 = new Veiculo();
         Veiculo v3 = new Veiculo();
         v1.setNumeroPlaca("ABC1241");
         v1.setFilial(f1);
         v1.setTipoVeiculo(t1);
         v2.setNumeroPlaca("ABC1242");
         v2.setFilial(f2);
         v2.setTipoVeiculo(t2);
         v3.setNumeroPlaca("ABC1234");
         v3.setFilial(f3);
         v3.setTipoVeiculo(t3);

         // Criação de Cidades
         Cidade ci1 = new Cidade();
         Cidade ci2 = new Cidade();
         Cidade ci3 = new Cidade();
         ci1.setUf("MA");
         ci1.setEstado("Maranhão");
         ci1.setNome("São Luís");
         ci2.setUf("SP");
         ci2.setEstado("São Paulo");
         ci2.setNome("São Paulo");
         ci3.setUf("RJ");
         ci3.setEstado("Rio de Janeiro");
         ci3.setNome("Rio de Janeiro");

         // Criação de Distâncias entre as cidades
         Distancia di1 = new Distancia();
         Distancia di2 = new Distancia();
         Distancia di3 = new Distancia();
         di1.setCidadeOrigem(ci1);
         di1.setCidadeDestino(ci2);
         di1.setQuilometros(200);
         di2.setCidadeOrigem(ci1);
         di2.setCidadeDestino(ci3);
         di2.setQuilometros(600);
         di3.setCidadeOrigem(ci2);
         di3.setCidadeDestino(ci3);
         di3.setQuilometros(500);

         // Criação de categorias de frete
         CategoriaFrete cat1 = new CategoriaFrete();
         CategoriaFrete cat2 = new CategoriaFrete();
         CategoriaFrete cat3 = new CategoriaFrete();
         cat1.setNome("Normal");
         cat1.setDescricao("Entrega normal, sem acréscimo.");
         cat1.setPercentualAdicional(0.0F);
         cat2.setNome("Rápida");
         cat2.setDescricao("Entrega rápida, com acréscimo de 10%.");
         cat2.setPercentualAdicional(10.0F);
         cat3.setNome("Super-rápida");
         cat3.setDescricao("Entrega super-rápida, com acréscimo de 30%.");
         cat3.setPercentualAdicional(30.0F);

         // Criação de itens de frete
         ItemFrete item1 = new ItemFrete();
         ItemFrete item2 = new ItemFrete();
         ItemFrete item3 = new ItemFrete();
         item1.setDescricao("Produto A");
         item1.setPeso(10.0f);
         item2.setDescricao("Produto B");
         item2.setPeso(20.0f);
         item3.setDescricao("Produto C");
         item3.setPeso(30.0f);

         // Criação de fretes
         Frete fr1 = new Frete();
         Frete fr2 = new Frete();
         Frete fr3 = new Frete();
         fr1.setCategoriaFrete(cat1);
         fr1.setCidadeOrigem(ci1);
         fr1.setCidadeDestino(ci2);
         fr1.setVeiculo(v1);
         fr1.setCliente(c1);
         fr1.setNumeroNotaFiscal(1001);
         fr1.setValorKmRodado(BigDecimal.valueOf(1.00));
         fr2.setCategoriaFrete(cat2);
         fr2.setCidadeOrigem(ci2);
         fr2.setCidadeDestino(ci3);
         fr2.setVeiculo(v2);
         fr2.setCliente(c2);
         fr2.setNumeroNotaFiscal(1002);
         fr2.setValorKmRodado(BigDecimal.valueOf(1.50));
         fr3.setCategoriaFrete(cat3);
         fr3.setCidadeOrigem(ci1);
         fr3.setCidadeDestino(ci3);
         fr3.setVeiculo(v3);
         fr3.setCliente(c3);
         fr3.setNumeroNotaFiscal(1003);
         fr3.setValorKmRodado(BigDecimal.valueOf(2.00));

         // Associando itens frete com frete
         item1.setFrete(fr1);
         item2.setFrete(fr2);
         item3.setFrete(fr3);

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
         em.persist(t1);
         em.persist(t2);
         em.persist(t3);
         em.persist(v1);
         em.persist(v2);
         em.persist(v3);
         em.persist(ci1);
         em.persist(ci2);
         em.persist(ci3);
         em.persist(di1);
         em.persist(di2);
         em.persist(di3);
         em.persist(cat1);
         em.persist(cat2);
         em.persist(cat3);
         em.persist(item1);
         em.persist(item2);
         em.persist(item3);
         em.persist(fr1);
         em.persist(fr2);
         em.persist(fr3);

         // Commit da transação
         em.getTransaction().commit();

      } catch (Exception e) {
         // Log da exceção
         e.printStackTrace();
         if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
         }
      } finally {
         // Fechando EntityManager
         em.close();
         emf.close();
      }
   }
}
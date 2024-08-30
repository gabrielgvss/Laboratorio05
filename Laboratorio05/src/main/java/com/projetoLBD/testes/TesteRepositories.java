package com.projetoLBD.testes;

import com.projetoLBD.entity.Cliente;
import com.projetoLBD.entity.PessoaFisica; // Certifique-se de importar a classe PessoaFisica
import com.projetoLBD.repository.ClienteRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class TesteRepositories {
   public static void main(String[] args) {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab05_pu");
      EntityManager em = emf.createEntityManager();
      ClienteRepository clienteRepository = new ClienteRepository(em);

      try {
         // Iniciar transação
         em.getTransaction().begin();

         // Criando cliente
         Cliente cliente = new Cliente();
         cliente.setCpf("2813781");
         cliente.setEmail("teste_cliente_insert@gmail.com");
         cliente.setAtivo(true);
         cliente.setTelefone("291921");
         cliente.setContato(cliente.getTelefone());
         cliente.setNome("teste");

         clienteRepository.salvarOuAtualizar(cliente);

         // Confirmar transação
         em.getTransaction().commit();

         // Listar clientes
         List<Object[]> clientes = clienteRepository.listarClientes();
         for (Object[] result : clientes) {
            PessoaFisica pf = (PessoaFisica) result[0];
            Cliente c = (Cliente) result[1];

            // Exibindo os detalhes do cliente e da pessoa física
            System.out.println("Cliente:");
            System.out.println("ID: " + pf.getId());
            System.out.println("Nome: " + pf.getNome());
            System.out.println("CPF: " + pf.getCpf());

            System.out.println("Cliente:");
            System.out.println("ID: " + c.getId());
            System.out.println("Email: " + c.getEmail());
            System.out.println("Telefone: " + c.getTelefone());
            System.out.println("Contato: " + c.getContato());
            System.out.println("Ativo: " + c.getAtivo());
            System.out.println();
         }
      } catch (Exception e) {
         // Em caso de erro, reverter transação
         if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
         }
         e.printStackTrace();
      } finally {
         // Fechar o EntityManager
         em.close();
         emf.close();
      }
   }
}

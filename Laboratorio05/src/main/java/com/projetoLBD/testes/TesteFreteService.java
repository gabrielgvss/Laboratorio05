package com.projetoLBD.testes;

import com.projetoLBD.entity.*;
import com.projetoLBD.repository.FreteRepository;
import com.projetoLBD.service.FreteService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class TesteFreteService {

    public static void main(String[] args) {
        // manager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab05_pu");
        EntityManager em = emf.createEntityManager();
        // service
        FreteService service = new FreteService(new FreteRepository(em));

        // Transação para persistir as entidades relacionadas
        em.getTransaction().begin();
        try {
            // Objetos
            Cliente c1 = new Cliente();
            c1.setNome("pedro");
            c1.setCpf("213821384");
            c1.setEmail("joao@gmail.com");
            c1.setAtivo(true);

            Filial filial = new Filial();
            filial.setNome("Entregas Maranhão");
            filial.setEndereco("Rua da Saudade");
            filial.setTelefone("98940028922");

            Funcionario f1 = new Funcionario();
            f1.setNome("Joaquim");
            f1.setCpf("98745632154");
            f1.setTelefone("98978945612");
            f1.setEmail("joaquim@gmail.com");
            f1.setMatricula("1234");
            f1.setFilial(filial);

            ItemFrete itemFrete1 = new ItemFrete();
            itemFrete1.setDescricao("Abacate");
            itemFrete1.setPeso(500);
            ItemFrete itemFrete2 = new ItemFrete();
            itemFrete2.setDescricao("Banana");
            itemFrete2.setPeso(100);
            ItemFrete itemFrete3 = new ItemFrete();
            itemFrete3.setDescricao("Limão");
            itemFrete3.setPeso(250);

            CategoriaFrete categoriaFrete1 = new CategoriaFrete();
            categoriaFrete1.setNome("Normal");
            categoriaFrete1.setDescricao("muitos");
            categoriaFrete1.setPercentualAdicional(0);

            CategoriaFrete categoriaFrete2 = new CategoriaFrete();
            categoriaFrete2.setNome("Master Blastes Rápido");
            categoriaFrete2.setDescricao("poucos");
            categoriaFrete2.setPercentualAdicional(30);

            Cidade cidadeOrigem1 = new Cidade();
            cidadeOrigem1.setNome("Miranda");
            cidadeOrigem1.setUf("Ma");
            cidadeOrigem1.setEstado("Maranhão");
            Cidade cidadeDestino1 = new Cidade();
            cidadeDestino1.setNome("São Luís");
            cidadeDestino1.setUf("Ma");
            cidadeDestino1.setEstado("Maranhão");
            Cidade cidadeOrigem2 = new Cidade();
            cidadeOrigem2.setNome("Bacabera");
            cidadeOrigem2.setUf("Ma");
            cidadeOrigem2.setEstado("Maranhão");

            Distancia distancia1 = new Distancia();
            distancia1.setQuilometros(400);
            distancia1.setCidadeOrigem(cidadeOrigem1);
            distancia1.setCidadeDestino(cidadeDestino1);
            Distancia distancia2 = new Distancia();
            distancia2.setQuilometros(300);
            distancia2.setCidadeOrigem(cidadeOrigem2);
            distancia2.setCidadeDestino(cidadeDestino1);

            TipoVeiculo tipoVeiculo = new TipoVeiculo();
            tipoVeiculo.setDescricao("Opala");
            tipoVeiculo.setPesoMaximo(new BigDecimal(700));

            Veiculo veiculo = new Veiculo();
            veiculo.setNumeroPlaca("NHO-1234");
            veiculo.setTipoVeiculo(tipoVeiculo);
            veiculo.setFilial(filial);

            em.persist(c1);
            em.persist(filial);
            em.persist(f1);
            em.persist(categoriaFrete1);
            em.persist(categoriaFrete2);
            em.persist(cidadeOrigem1);
            em.persist(cidadeDestino1);
            em.persist(cidadeOrigem2);
            em.persist(distancia1);
            em.persist(distancia2);
            em.persist(tipoVeiculo);
            em.persist(veiculo);

            // Persistindo o frete sem itens inicialmente
            Frete frete1 = new Frete();
            frete1.setItemFretes(new LinkedList<>());
            frete1.setCategoriaFrete(categoriaFrete1);
            frete1.setCidadeOrigem(cidadeOrigem1);
            frete1.setCidadeDestino(cidadeDestino1);
            frete1.setCliente(c1);
            frete1.setFuncionario(f1);
            frete1.setNumeroNotaFiscal(1);
            frete1.setValorKmRodado(new BigDecimal(400));
            frete1.setVeiculo(veiculo);

            Frete frete2 = new Frete();
            frete2.setItemFretes(new LinkedList<>());
            frete2.setCategoriaFrete(categoriaFrete2);
            frete2.setCidadeOrigem(cidadeOrigem2);
            frete2.setCidadeDestino(cidadeDestino1);
            frete2.setCliente(c1);
            frete2.setFuncionario(f1);
            frete2.setNumeroNotaFiscal(2);
            frete2.setValorKmRodado(new BigDecimal(400));
            frete2.setVeiculo(veiculo);

            em.persist(frete1);
            em.persist(frete2);

            // Atualizando os ItemFrete com o frete correspondente
            itemFrete1.setFrete(frete1);
            itemFrete2.setFrete(frete1);
            itemFrete3.setFrete(frete2);

            em.persist(itemFrete1);
            em.persist(itemFrete2);
            em.persist(itemFrete3);

            // Atualizar o frete com os itens
            frete1.getItemFretes().add(itemFrete1);
            frete1.getItemFretes().add(itemFrete2);
            frete2.getItemFretes().add(itemFrete2);  // Assumindo que o mesmo itemFrete2 pode ser adicionado a frete2
            frete2.getItemFretes().add(itemFrete3);

            // Sincronizar o estado atualizado no banco
            em.merge(frete1);
            em.merge(frete2);

            em.getTransaction().commit();

            System.out.println("Cadastrando o frete: " + service.cadastrarFrete(frete1).getCodigo() + "\n");
            System.out.println("Cadastrando o frete: " + service.cadastrarFrete(frete2).getId() + "\n");
            System.out.println("Valor do frete 1: R$ " + service.calcularValorFrete(frete1) + "\n");

            System.out.println("Detalhes do Frete1: " + service.buscarPorCodigo(1).toString() + "\n");
            List<Object[]> resultados = service.listarFretes();
            for (Object[] resultado : resultados) {
                // Verifique o tamanho do array para evitar ArrayIndexOutOfBoundsException
                if (resultado.length > 0) {
                    Frete frete = (Frete) resultado[0];
                    System.out.println("Frete ID: " + frete.toString() + "\n");
                } else {
                    System.out.println("Nenhum dado disponível para o índice 0.");
                }
            }

        } catch (Exception e) {
            //em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

    }

}

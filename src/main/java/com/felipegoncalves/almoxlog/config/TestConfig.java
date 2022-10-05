package com.felipegoncalves.almoxlog.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.felipegoncalves.almoxlog.entities.CategoriaSaida;
import com.felipegoncalves.almoxlog.entities.Cliente;
import com.felipegoncalves.almoxlog.entities.Empresa;
import com.felipegoncalves.almoxlog.entities.Entrada;
import com.felipegoncalves.almoxlog.entities.EntradaItem;
import com.felipegoncalves.almoxlog.entities.Fornecedor;
import com.felipegoncalves.almoxlog.entities.Lote;
import com.felipegoncalves.almoxlog.entities.Pessoa;
import com.felipegoncalves.almoxlog.entities.Produto;
import com.felipegoncalves.almoxlog.entities.Saida;
import com.felipegoncalves.almoxlog.entities.SaidaItem;
import com.felipegoncalves.almoxlog.entities.Transportadora;
import com.felipegoncalves.almoxlog.entities.Usuario;
import com.felipegoncalves.almoxlog.repositories.CategoriaSaidaRepository;
import com.felipegoncalves.almoxlog.repositories.ClienteRepository;
import com.felipegoncalves.almoxlog.repositories.EntradaItemRepository;
import com.felipegoncalves.almoxlog.repositories.EntradaRepository;
import com.felipegoncalves.almoxlog.repositories.FornecedorRepository;
import com.felipegoncalves.almoxlog.repositories.LoteRepository;
import com.felipegoncalves.almoxlog.repositories.ProdutoRepository;
import com.felipegoncalves.almoxlog.repositories.SaidaItemRepository;
import com.felipegoncalves.almoxlog.repositories.SaidaRepository;
import com.felipegoncalves.almoxlog.repositories.TransportadoraRepository;
import com.felipegoncalves.almoxlog.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private LoteRepository loteRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Autowired
	private TransportadoraRepository transportadoraRepository;

	@Autowired
	private EntradaRepository entradaRepository;

	@Autowired
	private EntradaItemRepository entradaItemRepository;

	@Autowired
	private SaidaRepository saidaRepository;

	@Autowired
	private SaidaItemRepository saidaItemRepository;

	@Autowired
	private CategoriaSaidaRepository categoriaSaidaRepository;

	@Override
	public void run(String... args) throws Exception {

		Pessoa p1 = new Pessoa(null, "Maria", "Silva");
		Pessoa p2 = new Pessoa(null, "José", "Silva");

		Usuario u1 = new Usuario(null, p1.getNome(), "1234", p1);
		Usuario u2 = new Usuario(null, p2.getNome(), "1234", p2);

		usuarioRepository.saveAll(Arrays.asList(u1, u2));

		Produto pr1 = new Produto(null, "DEXAMETASONA");
		Produto pr2 = new Produto(null, "MICONAZOL POMADA");
		Produto pr3 = new Produto(null, "NEOMICINA + BACITRACINA");

		produtoRepository.saveAll(Arrays.asList(pr1, pr2, pr3));

		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy/MM/dd");

		Lote l1 = new Lote(null, "2103005", LocalDate.parse("2021/10/01", format),
				LocalDate.parse("2023/10/01", format), pr1);
		Lote l2 = new Lote(null, "2110363", LocalDate.parse("2021/10/01", format),
				LocalDate.parse("2023/10/01", format), pr2);
		Lote l3 = new Lote(null, "2111640", LocalDate.parse("2021/11/01", format),
				LocalDate.parse("2023/10/01", format), pr3);

		loteRepository.saveAll(Arrays.asList(l1, l2, l3));

		Empresa e2 = new Empresa(null, "Fornecedor1", "Fr1");
		Fornecedor fr1 = new Fornecedor(null, e2);

		fornecedorRepository.save(fr1);

		Entrada ent1 = new Entrada(null, "Df01", LocalDate.now().minusDays(1), fr1);

		entradaRepository.save(ent1);

		EntradaItem ei1 = new EntradaItem(l1, ent1, 500, 2.50);
		EntradaItem ei2 = new EntradaItem(l2, ent1, 300, 3.25);
		EntradaItem ei3 = new EntradaItem(l3, ent1, 200, 3.23);

		entradaItemRepository.saveAll(Arrays.asList(ei1, ei2, ei3));

		Empresa e1 = new Empresa(null, "Cliente1", "Cl1");
		Cliente c1 = new Cliente(null, e1);

		clienteRepository.save(c1);

		Empresa e3 = new Empresa(null, "Transportadora1", "Tr1");
		Transportadora t1 = new Transportadora(null, e3);

		transportadoraRepository.save(t1);

		CategoriaSaida cs1 = new CategoriaSaida(null, "Categoria1");
		CategoriaSaida cs2 = new CategoriaSaida(null, "Categoria2");

		categoriaSaidaRepository.saveAll(Arrays.asList(cs1, cs2));

		Saida saida1 = new Saida(null, "111/22", LocalDate.now(), 1, 0.13, 15.10, c1, t1);
		saida1.getCategorias().add(cs1);
		saida1.getCategorias().add(cs2);
		saidaRepository.save(saida1);

		SaidaItem si1 = new SaidaItem(l1, saida1, 200, 2.50);
		SaidaItem si2 = new SaidaItem(l2, saida1, 195, 3.25);
		SaidaItem si3 = new SaidaItem(l3, saida1, 194, 3.23);

		saidaItemRepository.saveAll(Arrays.asList(si1, si2, si3));

	}

}

package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.UnidadeTrabalho;
import br.com.alura.spring.data.repository.UnidadeTrabalhoRepository;

@Service
public class CrudUnidadeTrabalhoService {
	private Boolean system = true;

	private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;

	public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository) {
		this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual ação de Unidade de trabalho deseja executar? ");
			System.out.println("0 - Sair ");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");

			int action = scanner.nextInt();
			switch (action) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(scanner);
				break;

			default:
				system = false;
				break;
			}

		}
		salvar(scanner);
	}

	private void salvar(Scanner scanner) {
		System.out.println("Unidade do trabalho: ");
		String descricao = scanner.next();
		System.out.println("Descrição do endereço: ");
		String endereco = scanner.next();
		UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
		unidadeTrabalho.setDescricao(descricao);
		unidadeTrabalho.setEndereco(endereco);
		unidadeTrabalhoRepository.save(unidadeTrabalho);
		System.out.println("Foi Salvo!!");
	}

	private void atualizar(Scanner scanner) {
		System.out.println("Informar ID: ");
		int id = scanner.nextInt();
		System.out.println("Descricao da Unidade: ");
		String descricao = scanner.next();
		System.out.println("Descricao do Endereço: ");
		String endereco = scanner.next();

		UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
		unidadeTrabalho.setId(id);
		unidadeTrabalho.setDescricao(descricao);
		unidadeTrabalho.setDescricao(endereco);
		unidadeTrabalhoRepository.save(unidadeTrabalho);
		System.out.println("Salvo!!");

	}

	private void visualizar() {
		Iterable<UnidadeTrabalho> Unidades = unidadeTrabalhoRepository.findAll();
		Unidades.forEach(unidade -> System.out.println(unidade));
	}

	private void deletar(Scanner scanner) {
		System.out.println("Informar ID: ");
		int id = scanner.nextInt();
		unidadeTrabalhoRepository.deleteById(id);
		System.out.println("Deletado!!");
	}

	
}

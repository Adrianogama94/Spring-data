package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.Funcionario;

import br.com.alura.spring.data.repository.FuncionarioRepository;

@Service
public class CrudFuncionarioService {

	private Boolean system = true;

	private final FuncionarioRepository funcionarioRepository;

	public CrudFuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual ação de Funcionario deseja executar? ");
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
		System.out.println("Descrição do Funcionario: ");
		String nome = scanner.next();
		Funcionario funcionario = new Funcionario();
		funcionario.setNome(nome);
		funcionarioRepository.save(funcionario);
		System.out.println("Foi Salvo!!");
	}

	private void atualizar(Scanner scanner) {
		System.out.println("Informar ID: ");
		int id = scanner.nextInt();
		System.out.println("Descricao do Cargo: ");
		String nome = scanner.next();

		Funcionario funcionario = new Funcionario();
		funcionario.setId(id);
		funcionario.setNome(nome);
		funcionarioRepository.save(funcionario);
		System.out.println("Salvo!!");

	}

	private void visualizar() {
		Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
		funcionarios.forEach(funcionario -> System.out.println(funcionario));
	}

	private void deletar(Scanner scanner) {
		System.out.println("Informar ID: ");
		int cpf = scanner.nextInt();
		funcionarioRepository.deleteById(cpf);
		System.out.println("Deletado!!");
	}

}

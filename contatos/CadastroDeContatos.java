package me.daniel.cadastro;

import java.util.ArrayList;
import java.util.Scanner;

public class CadastroDeContatos {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		ArrayList<Contato> contatos = new ArrayList<Contato>();
		int opcao;

		do {

			System.out.println("Escolha uma opção:");
			System.out.println("1. Adicionar contato");
			System.out.println("2. Listar contatos");
			System.out.println("3. Buscar contato");
			System.out.println("4. Remover contato");
			System.out.println("0. Sair");

			opcao = scan.nextInt();

			switch (opcao) {
			case 1:
				adicionarContato(contatos, scan);
				break;
			case 2:
				listarContatos(contatos, scan);
				break;
			case 3:
				buscarContato(contatos, scan);
				break;
			case 4:
				removerContato(contatos, scan);
				break;
			case 0:
				System.out.println("Finalizando...");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}

		} while (opcao != 0);

	}

	public static void adicionarContato(ArrayList<Contato> contatos, Scanner scan) {

		System.out.println("-> Informações do contato");
		System.out.println("Nome:");
		scan.nextLine();
		String nome = scan.nextLine();
		System.out.println("Email:");
		String email = scan.nextLine();
		System.out.println("Telefone:");
		String telefone = scan.nextLine();
		contatos.add(new Contato(nome, email, telefone));

	}

	public static void listarContatos(ArrayList<Contato> contatos, Scanner scan) {

		if (contatos.isEmpty()) {
			System.out.println("Não há contatos!");
		} else {
			System.out.println("-> Lista de contatos");
			for (Contato c : contatos) {
				System.out.println(c);
			}

		}

	}

	public static void buscarContato(ArrayList<Contato> contatos, Scanner scan) {

		if (contatos.isEmpty()) {
			System.out.println("Não há contatos!");
		} else {

			System.out.println("Digite o nome do contato");
			scan.nextLine();
			String nomeContato = scan.nextLine();
			Contato contatoEncontrado = null;

			for (Contato c : contatos) {

				if (c.getNome().equalsIgnoreCase(nomeContato)) {
					contatoEncontrado = c;
				}

			}

			if (contatoEncontrado != null) {
				System.out.println("Contato encontrado: " + contatoEncontrado);
			} else {
				System.out.println("Contato não encontrado!");
			}

		}

	}

	public static void removerContato(ArrayList<Contato> contatos, Scanner scan) {

		if (contatos.isEmpty()) {
			System.out.println("Não há contatos!");
		} else {

			System.out.println("Digite o nome do contato que deseja remover");
			scan.nextLine();
			String nomeRemove = scan.nextLine();
			Contato contatoRemove = null;

			for (Contato c : contatos) {
				if (c.getNome().equalsIgnoreCase(nomeRemove)) {
					contatoRemove = c;
				}
			}

			if (contatoRemove != null) {
				System.out.println("Contato removido: " + contatoRemove);
				contatos.remove(contatoRemove);
			} else {
				System.out.println("Contato não encontrado.");
			}

		}

	}

}

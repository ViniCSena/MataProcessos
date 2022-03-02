package view;

import java.io.IOException;
import java.util.Scanner;

import controller.KillController;

public class Main {
	
	static KillController killController = new KillController();
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Bem vindo ao MATADOR DE PROCESSOS!");
		int op;
		String param;
		do {
			System.out.println("\nDigite:"
					+ "\n0 Para sair."
					+ "\n1 Para ver a lista de processos."
					+ "\n2 Para matar processo pelo PID. "
					+ "\n3 Para matar processo pelo nome. \n");
			op = input.nextInt();
			try {
				switch (op) {
					case 1:
						killController.taskList();
						break;
					case 2:
						System.out.println("Digite o PID da task que deseja matar.");
						param = input.next();
						killController.killByPid(param);
						break;
					case 3:
						System.out.println("Digite o nome da task que deseja matar.");
						param = input.next();
						killController.killByName(param);
						break;
					case 0:
						System.out.println("Obrigado por utilizar este programa.");
						break;
					default:
						System.out.println("Opção desconhecida. Escolha novamente");
						break;
				}
			}catch (IOException e) {
				System.err.println("Erro. não foi possível executar o processo. Mensagem:" + e.getMessage() );
			}
		}while(op!=0);
	}

}

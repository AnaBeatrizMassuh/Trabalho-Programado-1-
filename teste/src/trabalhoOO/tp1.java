// Aluna: Ana Beatriz Wanderley Massuh
// Matrícula: 200060783
// Trabalho programado 1
// Intuito trabalho:um programa em Java que automatize o controle de clientes e produtos

package trabalhoOO;

import java.util.Scanner; 

public class tp1 {

public static void main(String[] args) {
		
		Scanner ler = new Scanner (System.in);
		
		int opcao = 0;
		int clientesCadastrados = 10; // contador para total clientes cadastrados 
		int produtosCadastrados = 10; // contador para total produtos cadastrados 
		
		
		//Vetores clientes
		String[] clienteNome = new String[50];
		String[] clienteEndereco = new String[50];
		String[] clienteTelefone = new String[50];
		
		prCadastrarCliente(clienteNome, clienteEndereco, clienteTelefone);
		
		//Vetores produtos
		String[] produtoNome = new String[50];
		String[] produtoDescricao = new String[50];
		double[] produtoValor = new double[50];
		double[] produtoLucro = new double[50];
		int[] produtoQuantidade = new int[50];
		
		preCadastrarProduto(produtoNome, produtoDescricao, produtoValor,  produtoLucro, produtoQuantidade);

		
		while(opcao != 7) {
				
			menu();
			opcao = ler.nextInt();
				
			if(opcao>=1 && opcao<=6) {
					switch(opcao) {
				
					case 1:
						
						System.out.println("Quantos clientes gostaria de cadastrar?");
						int qtdClientes = ler.nextInt();
						ler.nextLine();//esvazia o buffer do teclado

						cadastrarCliente(clienteNome, clienteEndereco, clienteTelefone, clientesCadastrados, qtdClientes);
					
						clientesCadastrados = clientesCadastrados + qtdClientes;
	
						break;
					case 2:
						
						procurarCliente(clienteNome, clienteEndereco, clienteTelefone, clientesCadastrados);
						
						break;
					case 3:
						
						System.out.println("Quantos produtos gostaria de cadastrar?");
						int qtdProdutos = ler.nextInt();
						
						ler.nextLine();//esvazia o buffer do teclado
						
						cadastrarProduto(produtoNome, produtoDescricao, produtoValor, produtoLucro, produtoQuantidade, produtosCadastrados, qtdProdutos); 
						
						produtosCadastrados = produtosCadastrados + qtdProdutos;
						
						break;
					case 4:
						
						procurarProduto(produtoNome, produtoDescricao, produtoValor, produtoLucro, produtoQuantidade, produtosCadastrados); 
						
						
						break;
					case 5:
					
						cadastrarVenda(clientesCadastrados, clienteNome, produtosCadastrados, produtoNome, produtoQuantidade); 
						
						break;
					case 6:
						
						listarProdutos(produtoNome, produtoQuantidade, produtosCadastrados);
						
						break;
					
					}
					
				}else if(opcao != 7) {
					
					System.out.println("Número inválido!");
				}
				
			}
			
			ler.close();
			
			System.out.println("Até mais!");
			
			
		}
	static void menu(){
		System.out.println(" ");
		System.out.println("----------------Menu----------------");
		System.out.println("-  1. Cadastro de novo cliente.    -");
		System.out.println("-  2. Busca por cliente.           -");
		System.out.println("-  3. Cadastro de novo produto.    -");
		System.out.println("-  4. Busca por produto.           -");
		System.out.println("-  5. Cadastro de venda.           -");
		System.out.println("-  6. Mostrar produtos em estoque. -");
		System.out.println("-  7. Sair.                        -");
		System.out.println("------------------------------------");
		System.out.println(" ");
		
	}
	
	static void cadastrarCliente(String clienteNome[], String clienteEndereco[], String clienteTelefone[], int clientesCadastrados, int qtdClientes) {
		 
					//             O programa deverá pedir a quantidade de clientes a serem cadastrados. Depois disso, deve pedir o nome, endereço, 
					//             telefone de cada novo cliente cadastrado.
					

		Scanner ler = new Scanner (System.in);
		
		
		for (int i = clientesCadastrados; i < (qtdClientes + clientesCadastrados); i++) {
			
			System.out.println(" ");
			System.out.println("------------------------------------");
			System.out.println("           Cliente " + (i+1));
			System.out.println("Digite o nome do cliente. ");
			clienteNome[i] = ler.nextLine();
			System.out.println("Digite o endereço do cliente. ");
			clienteEndereco[i] = ler.nextLine();
			System.out.println("Digite o telefone do cliente sem nenhum caracter. ");
			clienteTelefone[i] = ler.nextLine();
			while(clienteTelefone[i].length() != 9 && clienteTelefone[i].length() != 8) {
				System.out.println("Digite um telefone válido");
				clienteTelefone[i] = ler.nextLine();
			}
			System.out.println("------------------------------------");
			System.out.println(" ");

		}
		
		
	}
	
	static void procurarCliente(String clienteNome[], String clienteEndereco[], String clienteTelefone[], int clientesCadastrados) {

				//				O programa deverá pedir o nome do cliente e verificar se o cliente em questão
				//				está cadastrado. Caso esteja, o programa deverá mostrar os dados do cliente e oferecer a opção
				//				de alterar os dados cadastrados do cliente em questão. Caso o cliente não esteja cadastrado, o
				//				programa deverá mostrar a mensagem: “Cliente não encontrado!”
				
		int seEncontrouC = 0;
		char mudar;
		int alterar;
		String procuraCliente;
		
		Scanner ler = new Scanner (System.in);
		
		System.out.println(" ");
		System.out.println("Digite o nome do cliente que está buscando.");
		procuraCliente = ler.nextLine();
		
		for (int j = 0; j < clientesCadastrados; j++) {
			
			if(procuraCliente.equalsIgnoreCase(clienteNome[j])){
				System.out.println(" ");
				System.out.println("------------------------------------");
				System.out.println("               Dados");
				System.out.println("Nome: " + clienteNome[j]);
				System.out.println("Endereço: " + clienteEndereco[j]);
				System.out.println("Telefone: " + clienteTelefone[j]);
				System.out.println("------------------------------------");
				System.out.println(" ");
				
				seEncontrouC++;
				
				System.out.println("Gostaria de alterar os dados cadastrados do cliente? Se sim digite 'S', se não digite qualquer outro caracter. ");
				mudar = ler.next().charAt(0);
				
				if(mudar == 'S' || mudar =='s') {
					System.out.println(" ");
					System.out.println("------------------------------------");
					System.out.println("       O que deseja alterar?");
					System.out.println("         1- Mudar o nome");
					System.out.println("        2- Mudar o endereço");
					System.out.println("        3- Mudar o telefone");
					System.out.println("------------------------------------");
					System.out.println(" ");
					
					alterar = ler.nextInt();
					
					ler.nextLine();//esvazia o buffer do teclado
					
					switch(alterar) {
					
					case 1:
						
						System.out.println("Digite o novo nome.");
						clienteNome[j] = ler.nextLine();
						
						break;
					
					case 2:
						
						System.out.println("Digite o novo endereço.");
						clienteEndereco[j] = ler.nextLine();
						
						break;
						
					case 3:
						
						System.out.println("Digite o novo telefone.");
						clienteTelefone[j] = ler.nextLine();
						while(clienteTelefone[j].length() != 9 && clienteTelefone[j].length() != 8) {
							System.out.println("Digite um telefone válido");
							clienteTelefone[j] = ler.nextLine();
						}
						
						break;
					
					default:
						System.out.println("Opção inválida!");
					}
					
					
				}
				
				
			}
		}
		
		if(seEncontrouC == 0) {
			
			System.out.println(" ");
			System.out.println("Cliente não encontrado!");
			System.out.println(" ");
		}

	}
	
	static void cadastrarProduto(String produtoNome[], String produtoDescricao[], double produtoValor[], double produtoLucro[], int produtoQuantidade[], int produtosCadastrados, int qtdProdutos) {

				//				O programa deverá pedir a quantidade de produtos a serem cadastrados. Depois disso, deve pedir o nome do produto,
				//				descrição, valor de compra, porcentagem
				//				de lucro e quantidade em estoque.
		
		Scanner ler = new Scanner (System.in);
		
		for (int k = produtosCadastrados; k < (qtdProdutos + produtosCadastrados); k++) {
			
			System.out.println(" ");
			System.out.println("------------------------------------");
			System.out.println("           Produto " + (k+1));
			System.out.println("Digite o nome do produto. ");
			produtoNome[k] = ler.nextLine();
			System.out.println("Digite a descrição do produto. ");
			produtoDescricao[k] = ler.nextLine();
			System.out.println("Digite o valor de compra do produto. ");
			produtoValor[k] = ler.nextDouble();
			while(produtoValor[k] <0){
				System.out.println("Digite um valor válido!");
				produtoValor[k] = ler.nextDouble();
			}
			System.out.println("Digite a porcentagem de lucro do produto. (só usar números sem o simbolo %) ");
			produtoLucro[k] = ler.nextDouble();
			while(produtoLucro[k] <0) {
				System.out.println("Digite um valor válido!");
				produtoLucro[k] = ler.nextDouble();
			}
			System.out.println("Digite a quantidade em estoque do produto. ");
			produtoQuantidade[k] = ler.nextInt();
			while(produtoQuantidade[k] <0) {
				System.out.println("Digite um valor válido!");
				produtoQuantidade[k] = ler.nextInt();
			}
			System.out.println("------------------------------------");
			System.out.println(" ");
			
			ler.nextLine();//esvazia o buffer do teclado
		
		}

	}
	
	static void procurarProduto(String produtoNome[], String produtoDescricao[], double produtoValor[], double produtoLucro[], int produtoQuantidade[], int produtosCadastrados) {
		
				//				O programa deverá pedir o nome do produto e verificar se o produto em
				//				questão está cadastrado. Caso esteja, o programa deverá mostrar os dados do produto e oferecer
				//				a opção de alterar os dados cadastrados do produto em questão. Caso o produto não esteja
				//				cadastrado, o programa deverá mostrar a mensagem: “Produto não encontrado!”
								
		int seEncontrouP = 0;
		char mudar1;
		int alterar1;
		String procuraProduto;
		
		Scanner ler = new Scanner (System.in);
		
		System.out.println(" ");
		System.out.println("Digite o nome do produto que está buscando.");
		procuraProduto = ler.nextLine();
		
		for (int l = 0; l < produtosCadastrados; l++) {
			
			if(procuraProduto.equalsIgnoreCase(produtoNome[l])){
				System.out.println(" ");
				System.out.println("------------------------------------");
				System.out.println("               Dados");
				System.out.println("Produto: " + produtoNome[l]);
				System.out.println("Descrição: " + produtoDescricao[l]);
				System.out.println("Valor de compra do produto: " + produtoValor[l]);
				System.out.println("Porcentagem de lucro do produto: " + produtoLucro[l]);
				System.out.println("Quantidade em estoque do produto: " + produtoQuantidade[l]);
				System.out.println("------------------------------------");
				System.out.println(" ");
				
				seEncontrouP++;
				
				System.out.println("Gostaria de alterar os dados cadastrados do produto? Se sim digite 'S', se não digite qualquer outro caracter. ");
				mudar1 = ler.next().charAt(0);
				
				if(mudar1 == 'S' || mudar1 =='s') {
					System.out.println(" ");
					System.out.println("------------------------------------");
					System.out.println("       O que deseja alterar?");
					System.out.println("     1- Mudar o nome do produto");
					System.out.println("        2- Mudar a descriçao");
					System.out.println("     3- Mudar o valor de compra");
					System.out.println("  4- Mudar a porcentagem de lucro");
					System.out.println("  5- Mudar a quantidade em estoque");
					System.out.println("------------------------------------");
					System.out.println(" ");
					
					alterar1 = ler.nextInt();
					
					ler.nextLine();//esvazia o buffer do teclado
					
					switch(alterar1) {
					
					case 1:
						
						System.out.println("Digite o novo nome.");
						produtoNome[l] = ler.nextLine();
						
						break;
					
					case 2:
						
						System.out.println("Digite a nova a descriçao.");
						produtoDescricao[l] = ler.nextLine();
						
						break;
						
					case 3:
						
						System.out.println("Digite o novo valor de compra.");
						produtoValor[l] = ler.nextDouble();
						ler.nextLine();//esvazia o buffer do teclado
						
						break;
						
					case 4:
						
						System.out.println("Digite a nova porcentagem de lucro.");
						produtoLucro[l] = ler.nextDouble();
						ler.nextLine();//esvazia o buffer do teclado
						
						break;
						
					case 5:
						
						System.out.println("Digite a nova quantidade em estoque.");
						produtoQuantidade[l] = ler.nextInt();
						ler.nextLine();//esvazia o buffer do teclado
						
						break;
					
					default:
						System.out.println("Opção inválida!");
					}
					
					
				}
				
				
			}
		}
		
		if(seEncontrouP == 0) {
			
			System.out.println(" ");
			System.out.println("Produto não encontrado!");
			System.out.println(" ");
		}

	
	}
	
	static void cadastrarVenda(int clientesCadastrados, String clienteNome[], int produtosCadastrados, String produtoNome[], int produtoQuantidade[]) {
		
				//				O programa deverá mostrar a lista de clientes e pedir que o usuário
				//				selecione um deles. Depois, deverá mostrar a lista de produtos e pedir que o usuário selecione um
				//				deles. Depois disso, o programa deverá perguntar a quantidade daquele produto que foi vendida
				//				para o cliente em questão. A lista de produtos deverá ser mostrada para o usuário até que este
				//				indique que não deseja mais cadastrar vendas para o cliente em questão.
				

		int cliente = 0;
		int produto = 1;
		int vendas = 0;
		
		Scanner ler = new Scanner (System.in);
		
		System.out.println("------------------------------------");
		System.out.println("          Lista de clientes         ");
		
		for (int m = 0; m < clientesCadastrados; m++) {
			
			System.out.println((m+1) + ". " + clienteNome[m]);
			
		}
		System.out.println("------------------------------------");
		System.out.println(" ");
		
		System.out.println("Digite o número correspondente ao do cliente que deseja selecionar.");
		cliente = ler.nextInt();
		ler.nextLine();//esvazia o buffer do teclado
		
		System.out.println("O cliente selecionado foi: " + clienteNome[(cliente-1)]);
		System.out.println(" ");
		System.out.println("Digite '0' quando quiser parar de cadastra vendas!");
		System.out.println(" ");
		while(produto != 0) {
			System.out.println("------------------------------------");
			System.out.println("          Lista de produtos         ");
		
			for (int n = 0; n < produtosCadastrados; n++) {
				
				System.out.println((n+1) + ". " + produtoNome[n]);
				
			}
			
			System.out.println("------------------------------------");
			System.out.println(" ");
			
			System.out.println("Digite o número correspondente ao do produto que deseja selecionar.");
			produto = ler.nextInt();
			ler.nextLine();//esvazia o buffer do teclado
			
			while(produto < 0 || produto>produtosCadastrados) {
				
				System.out.println("Digite um número válido!");
				produto = ler.nextInt();
				ler.nextLine();//esvazia o buffer do teclado
				
				while(produtoQuantidade[(produto-1)] == 0) {
					System.out.println("Não há mais desse produto em nosso estoque, digite o número de outro.");
					produto = ler.nextInt();
					ler.nextLine();//esvazia o buffer do teclado
				}
				
			}
			
			if (produto != 0) {
				System.out.println("O produto selecionado foi: " + produtoNome[(produto-1)]);
				System.out.println(" ");
				System.out.println("Possui " + produtoQuantidade[(produto-1)] + " unidades." );
				System.out.println(" ");
				System.out.println("Gostaria de cadastrar a venda de quantas unidades desse produto?");
				vendas = ler.nextInt();
				ler.nextLine();//esvazia o buffer do teclado
				
				while((produtoQuantidade[(produto-1)] - vendas) < 0) {
					System.out.println("Digite um número válido!");
					vendas = ler.nextInt();
					ler.nextLine();//esvazia o buffer do teclado
				}
				
				if((produtoQuantidade[(produto-1)] - vendas) == 0) {
					produtoQuantidade[(produto-1)] = 0;
				}else {
					produtoQuantidade[(produto-1)] = produtoQuantidade[(produto-1)] - vendas;
				}
			}
		}
		
		
	}
	
	static void listarProdutos(String produtoNome[], int produtoQuantidade[], int produtosCadastrados) {
		
				//				O programa deverá mostrar a lista de todos os produtos
				//				cadastrados com a quantidade em estoque de cada um deles.
				
				
		System.out.println("------------------------------------");
		System.out.println("          Lista de produtos         ");
	
		for (int p = 0; p < produtosCadastrados; p++) {
			
			System.out.println((p+1) + ". " + "Nome produto: " + produtoNome[p] + " -  Quantidade em estoque: " + produtoQuantidade[p]);
			
		}
		
		System.out.println("------------------------------------");
		System.out.println(" ");
			
		
	}
	
	static void prCadastrarCliente(String clienteNome[], String clienteEndereco[], String clienteTelefone[]) {
		
		//              pré cadastrar 10 clientes 
		
		// ---------------- Cliente 1 -----------------
		clienteNome[0] = "Maria";
		clienteEndereco[0] = "Rua Angelo Romano, 186 - Presidente Dutra";
		clienteTelefone[0] = "999999999";
		
		// ---------------- Cliente 2 -----------------
		clienteNome[1] = "Jose";
		clienteEndereco[1] = "Rua Itu, 1.120 - Vila Carvalho";
		clienteTelefone[1] = "989999999";
		
		// ---------------- Cliente 3 -----------------
		clienteNome[2] = "Carlos";
		clienteEndereco[2] = "Rua Pedro Colino, nº 271 - Res. Leo Gomes de Moraes";
		clienteTelefone[2] = "988999999";
		
		// ---------------- Cliente 4 -----------------
		clienteNome[3] = "Paulo";
		clienteEndereco[3] = "Rua Cruz e Souza, 3.100 - Parque Ribeirao Preto";
		clienteTelefone[3] = "988899999";
		
		// ---------------- Cliente 5 -----------------
		clienteNome[4] = "Pedro";
		clienteEndereco[4] = "Rua Roberto Michellin, 95 - Antônio Marincek";
		clienteTelefone[4] = "988889999";
		
		// ---------------- Cliente 6 -----------------
		clienteNome[5] = "Lucas";
		clienteEndereco[5] = "Rua Genoveva Onofre Barban, 851 - casa 1";
		clienteTelefone[5] = "988888999";
		
		// ---------------- Cliente 7 -----------------
		clienteNome[6] = "Luiz";
		clienteEndereco[6] = "Av. Cavalheiro Paschoal Innecchi, 500, Jardim Independência";
		clienteTelefone[6] = "988888899";
		
		// ---------------- Cliente 8 -----------------
		clienteNome[7] = "Marcos";
		clienteEndereco[7] = "Rua 1 Cond.22 casa 1";
		clienteTelefone[7] = "988888889";
		
		// ---------------- Cliente 9 -----------------
		clienteNome[8] = "Gabriel";
		clienteEndereco[8] = "Rua 10 Cond.21 casa 15";
		clienteTelefone[8] = "988888888";
		
		// ---------------- Cliente 10 -----------------
		clienteNome[9] = "Rafael";
		clienteEndereco[9] = "Rua 5 Cond.10 casa 2";
		clienteTelefone[9] = "989888888";
		
	}
	
	static void preCadastrarProduto(String produtoNome[], String produtoDescricao[], double produtoValor[], double produtoLucro[], int produtoQuantidade[]) {
		
		//				pré cadastrar 10 produtos 
		
		// ---------------- Produto 1 -----------------
		produtoNome[0] = "Creme";
		produtoDescricao[0] = "Branco";
		produtoValor[0] = 20;
		produtoLucro[0] = 50;
		produtoQuantidade[0] = 100;
		
		// ---------------- Produto 2 -----------------
		produtoNome[1] = "Lapis";
		produtoDescricao[1] = "Preto";
		produtoValor[1] = 1;
		produtoLucro[1] = 10;
		produtoQuantidade[1] = 1000;
		
		// ---------------- Produto 3 -----------------
		produtoNome[2] = "Caneta";
		produtoDescricao[2] = "Azul";
		produtoValor[2] = 2;
		produtoLucro[2] = 25;
		produtoQuantidade[2] = 500;
		
		// ---------------- Produto 4 -----------------
		produtoNome[3] = "Pincel";
		produtoDescricao[3] = "Ponta fina";
		produtoValor[3] = 25;
		produtoLucro[3] = 50;
		produtoQuantidade[3] = 150;
		
		// ---------------- Produto 5 -----------------
		produtoNome[4] = "Bloco de papel";
		produtoDescricao[4] = "A4";
		produtoValor[4] = 10;
		produtoLucro[4] = 50;
		produtoQuantidade[4] = 200;
		
		// ---------------- Produto 6 -----------------
		produtoNome[5] = "Caixa";
		produtoDescricao[5] = "Vermelha";
		produtoValor[5] = 30;
		produtoLucro[5] = 50;
		produtoQuantidade[5] = 200;
		
		// ---------------- Produto 7 -----------------
		produtoNome[6] = "Apontador";
		produtoDescricao[6] = "Rosa";
		produtoValor[6] = 3.50;
		produtoLucro[6] = 25;
		produtoQuantidade[6] = 100;
		
		// ---------------- Produto 8 -----------------
		produtoNome[7] = "Borracha";
		produtoDescricao[7] = "Capa vermelha";
		produtoValor[7] = 2;
		produtoLucro[7] = 25;
		produtoQuantidade[7] = 100;
		
		// ---------------- Produto 9 -----------------
		produtoNome[8] = "Marca texto";
		produtoDescricao[8] = "Amarelo";
		produtoValor[8] = 1.5;
		produtoLucro[8] = 25;
		produtoQuantidade[8] = 150;
		
		// ---------------- Produto 10 -----------------
		produtoNome[9] = "Pote de tinta";
		produtoDescricao[9] = "250 mL";
		produtoValor[9] = 7.9;
		produtoLucro[9] = 50;
		produtoQuantidade[9] = 150;
		
	}
	
}	
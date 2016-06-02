import java.util.Locale;
import java.util.Scanner;


public class Trabalho2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en", "US"));
		
		String Cliente[], tel[];
		double conta[], preco[][], receita, media, soma, percent;
		int tipo[], min[], i, j, cli, menor, cont1, cont2, cont3;
		
		System.out.println("Quantos clientes deseja conferir?");
		cli = sc.nextInt();
		
		Cliente = new String [cli];
		tel = new String [cli];
		tipo = new int [cli];
		min = new int [cli];
		conta = new double[cli];
		preco = new double [3][2];
		
		
		System.out.println("Digite os valores das assinaturas e os valores dos acréscimos: ");
		for (i = 0; i < 3; i++) {
			for (j = 0; j < 2; j++){
				preco[i][j] = sc.nextDouble();
			}
		}
				
		System.out.println("Digite os dados dos clientes conforme se pede.");		
		for (i = 0; i < cli; i++ ) {
			System.out.println("Qual nome do Ciente: ");
			Cliente[i] = sc.next();
			System.out.println("Telefone do cliente: ");
			tel[i] = sc.next();
			System.out.println("Qual o tipo de assinatura: ");
			tipo[i] = sc.nextInt();
			System.out.println("Quantos minutos foram usados: ");
			min[i]= sc.nextInt();
		}
		receita = 0;
		for (i = 0; i < cli; i++ ) {
			if (min[i] <= 90){
				conta[i] = preco[tipo[i]][0];
				
			}else{
				conta[i] = preco[tipo[i]][0] + ((min[i] - 90) * preco[tipo[i]][1]);
			}
			receita = receita + conta[i];
		}
		
		System.out.println("\n\n");
		System.out.println("Nome\t | Telefone\t | Tipo\t | Minutos\t | Valor da conta");
		System.out.println("----\t |---------\t |-----\t |--------\t |---------------");

		for(i = 0;i < cli;i++) {
			 System.out.println(Cliente[i]+"\t | "+tel[i]+"\t | "+tipo[i]+"\t | "+min[i]+" min.\t | R$ "+conta[i]);
		 }
		System.out.println("\nA receita total produzida pela empresa foi de: ");
		System.out.printf("R$ %.2f", receita);
		
		menor = 0;
		cont1 = 0;
		cont3 = 0;
		soma = 0;
		for (i = 1; i < cli; i++ ) {
			if (conta[i] < conta[menor]){
				menor = i;
			}
		}
		for (i = 0; i < cli; i++ ) {
			if (tipo[i] == 1){
				cont1++;
				soma = soma + min[i];
			}
			if (tipo[i] == 2){
				cont3++;
			}
		}
		
		media = soma / cont1;
		
		
		
		
		System.out.println("\n\nO cliente que pagou a menor conta foi: ");
		System.out.println(Cliente[menor] + ", assinante do número " + tel[menor]);
		
		System.out.println("\nA média de minutos consumidos por clientes de conta tipo 1 foi de: ");
		System.out.println(media + " Minutos.");
			
		System.out.println("\nClientes que não consumiram minutos excedentes: ");
		for (i = 0; i < cli; i++ ) {
			if (min[i] <= 90){
				System.out.print(Cliente[i] + " " + tel[i] + "\n");
			}
		}
		
		cont2 = 0;
		for (i = 0; i < cli; i++ ) {
			if (min[i] > 120){
				cont2++;
			}
		}
		System.out.println("\n" + cont2 + " clientes consumiram mais de 120 minutos.");

		percent = cont3 * 100 / (double) cli;
		System.out.println("\n" + percent + "% dos clientes são assinantes da conta tipo 2.");
		
		
		sc.close();

	}

}

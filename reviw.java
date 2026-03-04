import java.util.Scanner;

public class reviw {
    
    public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);

    
        int[] onibus = new int[4];
        int[] assentos = new int[20]; 
        String[] passageiros = new String[20];

        int totalReservas = 0;
        int qtd = 0; 
        int opcao1;
   

        while (true) {
            System.out.println("\n=== CADASTRO DE ÔNIBUS ===");
            System.out.println("1 - Cadastrar numero do onibus");
            System.out.println("2 - Reservar Onibus");
            System.out.println("3 - Pesquisar");
            System.out.println("4 - Sair");
            System.out.print ("Opção: ");
            opcao1 = ler.nextInt();
            ler.nextLine(); 

            if (opcao1 == 4) { 
                System.out.println("Saindo...");
                break;
            }

            switch (opcao1) {
              
                case 1: 
                    if (qtd == onibus.length) {
                        System.out.println("Lista cheia! Não é possível cadastrar mais ônibus.");
                        break;
                    }

                    System.out.print("Digite o numero do onibus: ");
                    onibus[qtd] = ler.nextInt();

                    System.out.print("Digite a quantidade de assentos (máximo 20): ");
                    int assentosDigitados = ler.nextInt();
                    
             
                    if (assentosDigitados > 20 || assentosDigitados <= 0) {
                        System.out.println("Erro: Limite de assentos excedido ou inválido!");
                        break; 
                    }
                    
                    assentos[qtd] = assentosDigitados; 
                    qtd++;
                    
                    System.out.println("Ônibus registrado com sucesso!");
                    break;

               
                case 2: 
                    if (qtd == 0) {
                        System.out.println("Nenhum ônibus cadastrado.");
                        break;
                    }
                    if (totalReservas >= 20) {
                        System.out.println("Limite máximo de 20 reservas do sistema atingido!");
                        break;
                    }

                    System.out.println("\n--- Ônibus Disponíveis ---");
                    for (int i = 0; i < qtd; i++) {
                        System.out.println("Ônibus: " + onibus[i] + " | Vagas: " + assentos[i]);
                    }

                    System.out.print("\nDigite o numero do onibus para reservar: ");
                    int reserva = ler.nextInt();
                    ler.nextLine();
                    
                    boolean encontrado = false; 
                    for (int i = 0; i < qtd; i++) {
                       if (onibus[i] == reserva) {
                            encontrado = true;
                            if (assentos[i] > 0) {
                                
                                System.out.print("Informe o nome do passageiro: ");
                                String nome = ler.nextLine();
                                
                                
                                passageiros[totalReservas] = nome; 
                                
                                assentos[i]--; 
                                totalReservas++;
                                
                                System.out.println("Reserva realizada com sucesso para o passageiro(a): " + nome);
                            } else {
                                System.out.println("Não há assentos disponíveis para este ônibus!");
                            }
                            break; 
                        }
                    }
                    
                    if (!encontrado) {
                        System.out.println("Este ônibus não existe!");
                    }
                    break;

                case 3: 
                    if (qtd == 0) {
                        System.out.println("Nenhum ônibus cadastrado.");
                        break;
                    }
                    System.out.println("\n=== CADASTRO DE ÔNIBUS ===");
                    System.out.println("1 - Consultar onibus");
                    System.out.println("2 - Consultar passageiros");
                    int opcao2 = ler.nextInt();
                    ler.nextLine();
                    
                    switch (opcao2) {
                        case 1:
                            System.out.println("--- Ônibus Cadastrados ---");
                            System.out.print("Digite o numero do onibus para pesquisar: ");
                            int busca = ler.nextInt();

                            int posBusca = -1;
                            for (int i = 0; i < qtd; i++) {
                                if (onibus[i] == busca) { 
                                    posBusca = i;
                                    break;
                                }
                            }
                            if (posBusca == -1) {
                                System.out.println("Ônibus não encontrado.");
                            } else {
                                System.out.println("Encontrado: Ônibus " + onibus[posBusca] + " com " + assentos[posBusca] + " assentos disponíveis.");
                            }
                            break;
                            
                        case 2:
                            System.out.println("--- Passageiros Cadastrados ---");
                            for (int j = 0; j < totalReservas; j++) {
                                System.out.println("Passageiro(a): " + passageiros[j]);
                            }
                            break;
                            
                        default:
                            System.out.println("Opção inválida! Tente novamente.");
                            break;
                    }
                    break;
            }
        }
        
        ler.close();
    }
}
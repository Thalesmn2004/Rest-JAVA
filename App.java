import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leitor = new Scanner(System.in);
        Restaurante unico = new Restaurante("TM FOODS", "Av. Desinformados, 222", 5);
        int escolha = 0, numMesa = 0;
        double valor;
        String data, nome, email;
        Mesa mesaAtual;

        do
        {
            System.out.println("> Seja bem vindo ao " + unico.getNome() + "! O que deseja fazer? ");
            System.out.println(" [1] Reservar Mesa        | [2] Liberar Mesa ");
            System.out.println(" [3] Ver Mesa             | [4] Configurar Mesa ");
            System.out.println(" [5] Adicionar Cliente    | [6] Remover Cliente ");
            System.out.println(" [7] Adicionar Na Comanda | [8] Listar Comanda");
            System.out.println(" [9] Zerar Comanda        | [0] Sair Do Restaurante");
            System.out.printf(" >> ");
            escolha = leitor.nextInt();

            switch (escolha) {
                case 1:
                    for(Mesa X : unico.getMesas()){
                        System.out.println("> Reservas para a mesa " + X.getID() + ": ");
                        for (String Y : X.getReservas()) {
                            System.out.println(" - " + Y);
                        }
                    }
                    System.out.println("> Escolha a mesa a reservar: ");
                    numMesa = leitor.nextInt();
                    System.out.println("> Escolha a data para reservar: ");
                    data = leitor.next();
                    leitor.nextLine();
                    unico.ReservarMesa(numMesa, data);
                    break;
                case 2:
                    for(Mesa X : unico.getMesas()){
                        System.out.println("> Reservas para a mesa " + X.getID() + ": ");
                        for (String Y : X.getReservas()) {
                            System.out.println(" - " + Y);
                        }
                    }
                    System.out.println("> Escolha a mesa para desreservar: ");
                    numMesa = leitor.nextInt();
                    System.out.println("> Escolha a data para desreservar: ");
                    data = leitor.next();
                    leitor.nextLine();
                    unico.LiberarMesa(numMesa, data);
                    break;
                case 3:
                    System.out.println("> Escolha a mesa para ver: ");
                    numMesa = leitor.nextInt();
                    mesaAtual = unico.getMesa(numMesa);
                    if(mesaAtual != null){
                        System.out.println("> Estado atual da mesa: " + (mesaAtual.isOperacional() ? "Aberta" : "Fechada"));
                        
                        System.out.println("> Reservas para a mesa " + mesaAtual.getID() + ": ");
                        for (String Y : mesaAtual.getReservas()) {
                            System.out.println(" - " + Y);
                        }

                        System.out.println("> Clientes na mesa " + mesaAtual.getID() + ": ");
                        for (Cliente Y : mesaAtual.getusuarios()) {
                            System.out.println(" - " + Y.getNome() + " (" + Y.getEmail() + ")");
                        }

                        System.out.printf("> Comanda da mesa %d: ", mesaAtual.getID());
                        mesaAtual.mostrarComanda();
                    }
                    break;
                case 4:
                    System.out.println("> Escolha a mesa para configurar: ");
                    numMesa = leitor.nextInt();
                    mesaAtual = unico.getMesa(numMesa);
                    if(mesaAtual != null){
                        System.out.println("> Estado atual da mesa: " + (mesaAtual.isOperacional() ? "Aberta" : "Fechada"));
                        System.out.println("> Qual deve ser o novo estado? [1] Aberto | [0] Fechado ");
                        escolha = leitor.nextInt();
                        if(escolha == 1){
                            mesaAtual.setOperacional(true);
                            System.out.println("> A mesa " + numMesa + " foi aberta ");
                        }
                        else if (escolha == 0){
                            mesaAtual.setOperacional(false);
                            System.out.println("> A mesa " + numMesa + " foi fechada ");
                        }
                    }
                    break;
                case 5:
                    System.out.println("> Escolha a mesa para adicionar cliente: ");
                    numMesa = leitor.nextInt();
                    mesaAtual = unico.getMesa(numMesa);
                    if(mesaAtual != null){
                        System.out.println("> Nome do cliente: ");
                        nome = leitor.next();
                        leitor.nextLine();
                        System.out.println("> Email do cliente: ");
                        email = leitor.next();
                        leitor.nextLine();
                        mesaAtual.AdicionarCliente(new Cliente(nome, email));
                    }
                    break;
                case 6:
                    System.out.println("> Escolha a mesa para remover cliente: ");
                    numMesa = leitor.nextInt();
                    mesaAtual = unico.getMesa(numMesa);
                    if(mesaAtual != null){
                        System.out.println("> Clientes na mesa " + mesaAtual.getID() + ": ");
                        for (Cliente Y : mesaAtual.getusuarios()) {
                            System.out.println(" - " + Y.getNome() + " (" + Y.getEmail() + ")");
                        }
                        System.out.println("> Email do cliente: ");
                        email = leitor.next();
                        leitor.nextLine();
                        mesaAtual.RemoverCliente(email);
                    }
                    break;
                case 7:
                    System.out.println("> Escolha a mesa para adicionar item: ");
                    numMesa = leitor.nextInt();
                    mesaAtual = unico.getMesa(numMesa);
                    if(mesaAtual != null){
                        System.out.println("> Nome do item: ");
                        nome = leitor.next();
                        leitor.nextLine();
                        System.out.println("> Valor do item: ");
                        valor = leitor.nextDouble();
                        System.out.println("> Quantidade do item: ");
                        escolha = leitor.nextInt();
                        mesaAtual.AdicionarNaComanda(nome, valor, escolha);;
                    }
                    break;
                case 8:
                    System.out.println("> Escolha a mesa para ver: ");
                    numMesa = leitor.nextInt();
                    mesaAtual = unico.getMesa(numMesa);
                    if(mesaAtual != null){
                        System.out.printf("> Comanda da mesa %d: ", mesaAtual.getID());
                        mesaAtual.mostrarComanda();
                    }
                    break;
                case 9:
                    System.out.println("> Escolha a mesa para zerar: ");
                    numMesa = leitor.nextInt();
                    mesaAtual = unico.getMesa(numMesa);
                    if(mesaAtual != null){
                        mesaAtual.ZerarComanda();
                    }
                    break;
                case 0:
                    System.out.println("> Volte Sempre!");
                    leitor.close();
                    return;
                default:
                    break;
                }
        } while(true);
        

        
    }
}

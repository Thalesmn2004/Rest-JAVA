public class Mesa {
    private int ID;
    public int getID() {
        return ID;
    }
    public void setID(int iD) {
        ID = iD;
    }
    private String[] reservas;
    public String[] getReservas() {
        return reservas;
    }
    private boolean operacional;
    public boolean isOperacional() {
        return operacional;
    }
    public void setOperacional(boolean operacional) {
        this.operacional = operacional;
    }
    private Cliente[] usuarios;
    public Cliente[] getusuarios() {
        return usuarios;
    }
    private Comanda conta;
    public Mesa(int iD, boolean operacional) {
        ID = iD;
        this.operacional = operacional;
        this.usuarios = new Cliente[0];
        this.reservas = new String[0];
        this.conta = new Comanda();
    }

    public boolean Reservar(String data){
        if(this.operacional == false){
            System.out.println("> Esta mesa nao esta aberta para reservas... ");
            return false;
        }
        for(String x : reservas) {
            if(x.equals(data) == true){
                System.out.println("> Esta mesa ja foi reservada para " + data + "! ");
                return false;
            }
        }
        
        String[] novasDatas = new String[reservas.length+1];
        for(int i = 0; i < reservas.length; i++){
            novasDatas[i] = reservas[i];
        }
        novasDatas[novasDatas.length-1] = data;
        reservas = novasDatas;
        
        System.out.println("> Mesa reservada com sucesso! ");
        return true;
    }

    public void LiberarReserva(String data)
    {
        for(int i = 0; i < this.reservas.length; i++){
            if(this.reservas[i].equals(data)){
                String[] novasDatas = new String[reservas.length-1];
                for(int j = 0; j < i; j++){
                    novasDatas[j] = reservas[j];
                }
                for(int j = i; j < novasDatas.length; j++){
                    novasDatas[j] = reservas[j+1];
                }
            }
        }
        System.out.println("> Data " + data + "removida! ");
        return;
    }

    public void AdicionarNaComanda(String item, double valor, int quantidade)
    {
        this.conta.setConsumo(this.conta.getConsumo() + "\n \t - ");
        this.conta.setConsumo(this.conta.getConsumo() + quantidade);
        this.conta.setConsumo(this.conta.getConsumo() + " " + item);
        this.conta.setConsumo(this.conta.getConsumo() + " (R$" + valor + ")");
        this.conta.setValorTotal(this.conta.getValorTotal() + valor * quantidade);
        System.out.println("> Item adicionado! ");
        return;
    }
    public void ZerarComanda()
    {
        this.conta.setConsumo("");
        this.conta.setValorTotal(0.0);
        System.out.println("> Comanda " + this.ID + " zerada! ");
        return;
    }

    public void AdicionarCliente(Cliente adicionado)
    {
        for(Cliente X : this.usuarios){
            if(X.getEmail().equals(adicionado.getEmail())){
                System.out.println("> Este email ja foi usado no restaurante! ");
                return;
            }
        }
        
        Cliente[] novosClientes = new Cliente[this.usuarios.length+1];  
        for(int i = 0; i < this.usuarios.length; i++){                       
            novosClientes[i] = usuarios[i];
        }                        
        novosClientes[novosClientes.length-1] = adicionado;             
        usuarios = novosClientes;                                       
        System.out.println("> Cliente \"" + adicionado.getNome() + "\" adicionado! ");
        return;
    }

    public void RemoverCliente(String email)
    {
        for(int i = 0; i < this.usuarios.length; i++){
            if(this.usuarios[i].getEmail().equals(email)){
                Cliente[] novosClientes = new Cliente[this.usuarios.length-1]; 
                for(int j = 0; j < i; j++)                                 
                    novosClientes[j] = usuarios[j];
                for(int j = i; j < novosClientes.length; j++)                                 
                    novosClientes[j] = usuarios[j+1];
                usuarios = novosClientes;                                       
                System.out.println("> Cliente removido! ");
                return;
            }
        }
        System.out.println("> Este cliente nao existe! ");
        return;
    }

    public void mostrarComanda(){
        System.out.println(this.conta.getConsumo());
        System.out.printf("> Valor final (com taxa de 10%%): R$%2.2f \n", this.conta.getValorTotal());
        System.out.printf("> Dividindo entre usuarios:  R$%2.2f \n", this.conta.dividirConta(this.usuarios.length));
        return;
    }
}

public class Restaurante {
    private String nome;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    private String endereço;
    public String getEndereço() {
        return endereço;
    }
    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }
    private Mesa[] mesas;
    public Mesa[] getMesas() {
        return mesas;
    }

    public Restaurante(String nome, String endereço, int numMesas) {
        this.nome = nome;
        this.endereço = endereço;
        this.mesas = new Mesa[numMesas];
        for(int i = 0; i < numMesas; i++){
            this.mesas[i] = new Mesa(i, true);
        }
    }

    public boolean ReservarMesa(int nMesa, String data)
    {
        if(nMesa < 0 || nMesa >= mesas.length)
        {
            System.out.println("# NUMERO DA MESA INEXISTENTE #");
            return false;
        }
        return this.mesas[nMesa].Reservar(data);
    }

    public void LiberarMesa(int nMesa, String data)
    {
        if(nMesa < 0 || nMesa >= mesas.length)
        {
            System.out.println("# NUMERO DA MESA INEXISTENTE #");
            return;
        }
        this.mesas[nMesa].LiberarReserva(data);
        return;
    }

    public Mesa getMesa(int pos)
    {
        if(pos < 0 || pos > this.mesas.length){
            System.out.println("> ESSA MESA NAO EXISTE! ");
            return null;
        }
        return this.mesas[pos];    
    }
}

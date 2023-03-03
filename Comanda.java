public class Comanda
{
    private String consumo;
    public String getConsumo() {
        return consumo;
    }
    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }
    
    private double valorTotal;
    public double getValorTotal() {
        return valorTotal + this.calc10Pc();
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public Comanda() {
        this.consumo = "";
        this.valorTotal = 0.0;
    }
    
    public void listarConsumo() {
        System.out.printf(consumo);
    }

    public double calc10Pc(){
        return this.valorTotal * 0.1;
    }

    public double dividirConta(int pessoas){
        if(pessoas > 0){
            return this.getValorTotal() / pessoas;
        }
        else{
            return 0.0;
        }
    }
}
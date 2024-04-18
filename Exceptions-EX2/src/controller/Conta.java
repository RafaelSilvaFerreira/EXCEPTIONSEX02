package controller;

public class Conta {
    private int agencia;
    private int codigo;
    private int saldo;
    private float limite;

    
    public Conta() {
        this.agencia = 0;
        this.codigo = 0;
        this.saldo = 0;
        this.limite = 0.0f;
    }

    public int getAgencia() {return agencia;}
    public int getCodigo() {return codigo;}
    public int getSaldo() {return saldo;}
    public float getLimite() {return limite;}


    

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    public void setLimite(float limite) {
        this.limite = limite;
    }

    public void deposita(float valor) {
        this.saldo += valor;
    }

    public void saca(float valor) throws Exception {
        if (valor > this.saldo + this.limite) {
            throw new Exception("Saldo insuficiente. Limite total para saque: " + (this.saldo + this.limite));
        }
        this.saldo = (int) (this.saldo - valor);
    }

    public static void main(String[] args) {
        Conta c = new Conta();
        c.setSaldo(1000);
        c.setLimite(500);

        try {
            c.saca(92);
            System.out.println("Saque feito, novo saldo:"+c.saldo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
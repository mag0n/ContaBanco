package javapoo.contabanco;

import java.util.Random;

public class ContaBanco {
    
    public int numConta;
    protected String tipo;  // CC: conta corrente / CP: conta poupanca
    private String dono;    // nome do dono
    private float saldo;    // CC -> R$ 50 / CP -> R$ 150
    private boolean status;

    
    // metodo construtor
    public ContaBanco() {
        this.saldo = 0;
        this.status = false;
        
    }

    
    // metodos getters e setters
    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    
    // metodos: 
    public void abrirConta(String dono,String tipo) {
        //System.out.println("Criando conta...");
        Random g = new Random();
        setStatus(true);
        setDono(dono);
        setNumConta(g.nextInt(100));
        setTipo(tipo);
        if (getTipo().equals("CC")) {
            setSaldo(50);
        } else {
            setSaldo(150);
        }
    } 
    
    public void fecharConta() {
        //System.out.println("Encerrando conta...");
        if (getSaldo() == 0f) {
            setStatus(false);
        } else if (getSaldo() < 0f) {
            System.out.println("O seu saldo esta negativo. Negocie as suas dividas antes de cancelar a conta.");
        } 
        else {
            System.out.println("A sua conta ainda possui saldo, nao foi possivel realizar essa operacao.");
        }
    } 
    
    public void depositar(float valor) {
        
        if (getStatus() == true) {
            System.out.println("Saldo inicial: R$ " + getSaldo());
            this.saldo += valor; // usando set ficaria: setSaldo(getSaldo() + valor);
            System.out.println("Saldo final: R$ " + getSaldo());
        } else {
            System.out.println("Nao foi possivel depositar, status da conta: " + this.status);
        }
        
        
    }
    
    public void sacar(float valor) {
        
        if ((getStatus() == true) && (getSaldo() > 0f) && (valor < getSaldo())) {
            System.out.println("Saldo inicial: R$ " + getSaldo());
            setSaldo(getSaldo() - valor);
            System.out.println("Saldo final: R$ " + getSaldo());
        } else {
            System.out.println("Nao foi possivel realizar essa operacao. Verifique o status da conta, o saldo ou o valor requisitado de saque.");
        }
        
    }
    
    public void pagarMensal() {
        //System.out.println("Descontando a mensalidade...");
        if (getStatus() == true) {
            if ((getTipo().equals("CC")) && (getSaldo() > 12)) {
                System.out.println("Descontando R$ 12,00 reais da conta corrente...");
                setSaldo(getSaldo() - 12);
            } else if ((getTipo().equals("CP")) && (getSaldo() > 20)){
                System.out.println("Descontando R$ 20,00 reais da conta poupanca...");
                setSaldo(getSaldo() - 20);
            }
        } else {
            System.out.println("A conta esta inativa!");
        }
    }
    
    public void consultarSaldo() {
        if (getStatus() == true) {
            System.out.println("Consultando saldo...");
            System.out.println("Saldo atual: R$ " + getSaldo());
        } else {
            System.out.println("A conta esta inativa! Nao foi possivel consultar o saldo.");
        }  
    }
    
    
    // metodo de teste
    public void status() {
        System.out.println("Numero da conta: " + getNumConta());
        System.out.println("Tipo: " + getTipo());
        System.out.println("Nome do dono: " + getDono());
        System.out.println("Saldo: R$ " + getSaldo());
        System.out.println("Status: " + getStatus());
    }
}
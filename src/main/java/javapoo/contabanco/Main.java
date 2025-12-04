package javapoo.contabanco;

public class Main {

    public static void main(String[] args) {
        
        ContaBanco contaJoao = new ContaBanco();
        ContaBanco c1 = new ContaBanco();
        
//        contaJoao.abrirConta("Joao", "CP");
//        contaJoao.depositar(1000);
//        contaJoao.sacar(200);
//        contaJoao.pagarMensal();
//        System.out.println("=========================================");
//        contaJoao.status();
        
        c1.abrirConta("Juca", "CC");
//        c1.depositar(1000.50f);
//        c1.sacar(200.70f);
//        c1.pagarMensal();
//        System.out.println("=========================================");
//        c1.status();
        c1.setSaldo(0);
        c1.fecharConta();
        c1.depositar(100);
        c1.sacar(100);
        c1.pagarMensal();
        c1.consultarSaldo();
    }
}

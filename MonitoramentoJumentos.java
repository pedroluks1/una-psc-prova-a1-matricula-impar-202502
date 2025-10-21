import java.util.Scanner;

public class MonitoramentoJumentos {

    public static double calcularTaxaReducao(int popInicial, int popAtual) {
        return (1 - (double) popAtual / popInicial) * 100;
    }

    public static boolean estaEmRiscoCritico(double taxa) {
        return taxa >= 90;
    }


    public static int simularImpactoAbate(int popAtual, int abatesAno, int anos) {
        return popAtual - (abatesAno * anos);
    }

    public static void exibirDeclaracaoFinal(int popRestante, int anos) {
        System.out.println("\nRESULTADO");
        System.out.println("População restante após " + anos + " anos: " + popRestante);

        if (popRestante <= 0) {
            System.out.println("A espécie seria extinta nesse ritmo");
        } else {
            System.out.println("Ainda há esperança, mas é preciso agir");
        }

        System.out.println("\nPrograma finalizado");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int popInicial = 1400000;
        int popAtual = 84000;
        int abatesAno = 50000;

        System.out.println("S.O.S. JUMENTO NORDESTINO");
        System.out.println("População inicial: " + popInicial);
        System.out.println("População atual: " + popAtual);
        System.out.println("Abates anuais: " + abatesAno);

        double taxa = calcularTaxaReducao(popInicial, popAtual);
        System.out.printf("\nTaxa de redução: %.2f%%\n", taxa);

        if (estaEmRiscoCritico(taxa)) {
            System.out.println("Status: RISCO CRÍTICO");
        } else {
            System.out.println("Status: Situação controlada");
        }

        System.out.print("\nQuantos anos deseja simular? ");
        int anos = sc.nextInt();

        int popRestante = simularImpactoAbate(popAtual, abatesAno, anos);

        exibirDeclaracaoFinal(popRestante, anos);

        sc.close();
    }
}

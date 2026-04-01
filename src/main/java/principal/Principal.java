/**
 * b)
 */
package principal;

import java.util.Scanner;
import modelo.Data;

public class Principal {

    /**
     * u)
     */
    public static void main(String args[]) {
        Data data = new Data();
        int op = -2;
        Scanner in = new Scanner(System.in);
        while (op != 99) {
            System.out.println(
                    "\n1  - Mudar Data\n"
                    + "2  - Incrementar dia\n"
                    + "3  - Incrementar mes\n"
                    + "4  - Incrementar ano\n"
                    + "5  - Decrementar dia\n"
                    + "6  - Decrementar mes\n"
                    + "7  - Decrementar ano\n"
                    + "8  - Mostrar Data\n"
                    + "9  - Adicionar 2 Datas\n"
                    + "10 - Dias entre Datas\n"
                    + "11 - Bissexto?(passa ano)\n"
                    + "12 - Bissexto?(ano atual)\n"
                    + "99 - Sair\n"
                    + "Digite uma opção:");
            op = in.nextInt();
            switch (op) {
                case 1:
                    data.leitura();
                    break;
                case 2:
                    data.incrementaDia();
                    break;
                case 3:
                    data.incrementaMes();
                    break;
                case 4:
                    data.incrementaAno();
                    break;
                case 5:
                    data.decrementaDia();
                    break;
                case 6:
                    data.decrementaMes();
                    break;
                case 7:
                    data.decrementaAno();
                    break;
                case 8:
                    data.imprimir();
                    break;
                case 9: {
                    Data d1 = new Data();
                    d1.leitura();
                    Data d2 = new Data();
                    d2.leitura();
                    data = data.adicionaDatas(d1, d2);
                    data.imprimir();
                    break;
                }
                case 10: {
                    Data d1 = new Data();
                    d1.leitura();
                    Data d2 = new Data();
                    d2.leitura();
                    int saida = data.diasEntre(d1, d2);
                    System.out.println("Segundos: " + saida);
                    break;
                }
                case 11: {
                    System.out.println("Ano:");
                    boolean saida = data.bissexto(in.nextInt());
                    if (saida) {
                        System.out.println("E bissexto!");
                    } else {
                        System.out.println("Nao e bissexto!");
                    }
                    break;
                }
                case 12: {
                    boolean saida = data.bissexto();
                    if (saida) {
                        System.out.println("Bissexto!");
                    } else {
                        System.out.println(data.getAno() + " nao e bissexto!");
                    }
                    break;
                }
                case 99:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção invalida.");
                    op = -1;
                    break;
            }
        }
    }
}

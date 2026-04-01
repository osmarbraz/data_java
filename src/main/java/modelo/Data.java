/**
 * b)
 */
package modelo;

import java.util.Scanner;

/**
 * a)
 */
public class Data {

    private int dia;
    private int mes;
    private int ano;

    /**
     * d)
     */
    //construtores
    public Data() {
        this(1, 1, 1);
    }

    //com inteiros
    public Data(int dia, int mes, int ano) {
        setAno(ano);
        setMes(mes);
        setDia(dia);
    }

    //com strings
    public Data(String dia, String mes, String ano) {
        setAno(ano);
        setMes(mes);
        setDia(dia);
    }

    /**
     * c)
     */
    //sets    
    public void setDia(int dia) {
        this.dia = validaDado(dia, 'd');
    }

    public void setMes(int mes) {
        this.mes = validaDado(mes, 'm');
    }

    public void setAno(int ano) {
        this.ano = validaDado(ano, 'a');
    }

    public void setDia(String dia) {
        if (dia != "") {
            setDia(validaDado(dia, 'd'));
        } else {
            setDia(1);
        }
    }

    public void setMes(String mes) {
        if (mes != "") {
            setMes(validaDado(mes, 'm'));
        } else {
            setMes(1);
        }
    }

    public void setAno(String ano) {
        if (ano != "") {
            setAno(validaDado(ano, 'a'));
        } else {
            setAno(1);
        }
    }

    //gets
    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    /**
     * m)
     */
    public String getData() {
        String saida = "";
        if (dia < 10) {
            saida += "0";
        }
        saida += getDia() + "/";
        if (mes < 10) {
            saida += "0";
        }
        saida += getMes() + "/";
        if (ano < 10) {
            saida += "000";
        } else if (ano < 100) {
            saida += "00";
        } else if (ano < 1000) {
            saida += "0";
        }
        saida += getAno();
        return saida;
    }

    /**
     * e)
     */
    //pede ao usuario os dados
    public void leitura() {
        Scanner in = new Scanner(System.in);
        System.out.println("Data:\nDia:");
        setDia(in.nextInt());
        System.out.println("Data:\nMes:");
        setMes(in.nextInt());
        System.out.println("Data:\nAno:");
        setAno(in.nextInt());
    }

    /**
     * n)
     */
    //imprime na tela a data em dd/mm/aaaa
    public void imprimir() {
        System.out.println(this.getData());
    }

    /**
     * f)
     */
    //operecoes de validacao com inteiros e com strings
    public int validaDado(int dado, char tipo) {
        if (tipo == 'd') {
            if (dado < 1 || dado > diasNoMes(getMes())) {
                dado = 1;
            }
        } else if (tipo == 'm') {
            if (dado < 1 || dado > 12) {
                dado = 1;
            }
        } else if (tipo == 'a') {
            if (dado < 1) {
                dado = 1;
            }
        }
        return dado;
    }

    public int validaDado(String dado, char tipo) {
        if (dado != "") {
            return validaDado(Integer.parseInt(dado), tipo);
        } else {
            return validaDado(0, tipo);
        }
    }

    /**
     * g)
     */
    //operacoes de incremento
    public void incrementaDia() {
        int dia = getDia() + 1;
        if (dia > diasNoMes(getMes())) {
            dia = 1;
            incrementaMes();
        }
        setDia(dia);
    }

    /**
     * h)
     */
    public void incrementaMes() {
        int mes = getMes() + 1;
        if (mes > 12) {
            mes = 1;
            incrementaAno();
        }
        setMes(mes);
    }

    /**
     * i)
     */
    public void incrementaAno() {
        setAno(getAno() + 1);
    }

    /**
     * j)
     */
    //operecoes de decremento
    public void decrementaDia() {
        int dia = getDia() - 1;
        if (dia < 1) {
            decrementaMes();
            dia = diasNoMes(getMes());
        }
        setDia(dia);
    }

    /**
     * k)
     */
    public void decrementaMes() {
        int mes = getMes() - 1;
        if (mes < 1) {
            mes = 12;
            decrementaAno();
        }
        setMes(mes);
    }

    /**
     * l)
     */
    public void decrementaAno() {
        setAno(getAno() - 1);
    }

    //retorna dias no mes passado
    public int diasNoMes(int mes) {
        int dia = 0;
        if (mes == 2) {
            if (bissexto()) {
                if ((dia < 0 || dia > 29)) {
                    dia = 29;
                }
            } else if ((dia < 0 || dia > 28)) {
                dia = 28;
            }
        } else {
            if ((mes <= 7 && mes % 2 != 0) || (mes >= 8 && mes % 2 == 0)) {
                dia = 31;
            } else {
                dia = 30;
            }
        }
        return dia;
    }

    /**
     * o)
     */
    //retorna se e ou nao bissexto
    public boolean bissexto() {
        return bissexto(getAno());
    }

    public boolean bissexto(int ano) {
        if (((ano % 4 == 0) && (ano % 100 != 0)) || (ano % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * p)
     */
    //retorna deas no ano ate o mes passado
    public int diasAteMes(int mes) {
        int dias = 0;
        if (mes > 1) {
            for (int i = 1; i < mes; i++) {
                dias += diasNoMes(i);
            }
        }
        return dias;
    }

    /**
     * q)
     */
    public int diasAteMes(String _mes) {
        String meses[] = {"", "janeiro", "fevereiro", "mar�o",
            "abril", "maio", "junho",
            "julho", "agosto", "setembro",
            "outubro", "novembro", "dezembro"};
        int mes = 0;
        for (int i = 1; i <= 12; i++) {
            if (_mes.equalsIgnoreCase(meses[i])) {
                mes = i;
                break;
            }
        }
        return diasAteMes(mes);
    }

    /**
     * r)
     */
    //retorna uma data apartir da adicao de 2 outras
    public Data adicionaDatas(Data d1, Data d2) {
        Data data = new Data();
        data.setAno(d1.getAno() + d2.getAno());
        int mes = d1.getMes() + d2.getMes();
        if (mes > 12) {
            mes = mes - 12;
            data.incrementaAno();
        }
        data.setMes(mes);
        int dia = d1.getDia() + d2.getDia();
        if (dia > diasNoMes(mes)) {
            dia = dia - diasNoMes(mes);
            incrementaMes();
        }
        data.setDia(dia);
        return data;
    }

    /**
     * s)
     */
    //retorna os dias entre 2 datas
    public int diasEntre(Data d1, Data d2) {
        int dias = 0;
        if (d1.getAno() == d2.getAno()) {
            dias = (d1.diasAteMes(d1.getMes()) + d1.getDia()) - (d2.diasAteMes(d2.getMes()) + d2.getDia());
            if (dias < 0) {
                dias = dias * -1;
            }
        } else if (d1.getAno() < d2.getAno()) {
            for (int i = d1.getAno(); i <= d2.getAno(); i++) {
                if (i == d1.getAno()) {
                    dias = dias - (d1.diasAteMes(d1.getMes()) + d1.getDia());
                    if (bissexto(i)) {
                        dias = dias + 366;
                    } else {
                        dias = dias + 365;
                    }
                } else if (i == d2.getAno()) {
                    dias = dias + (d2.diasAteMes(d2.getMes()) + d2.getDia());
                } else {
                    if (bissexto(i)) {
                        dias = dias + 366;
                    } else {
                        dias = dias + 365;
                    }
                }
            }
        } else if (d2.getAno() < d1.getAno()) {
            for (int i = d2.getAno(); i <= d1.getAno(); i++) {
                if (i == d2.getAno()) {
                    dias = dias - (d2.diasAteMes(d2.getMes()) + d2.getDia());
                    if (bissexto(i)) {
                        dias = dias + 366;
                    } else {
                        dias = dias + 365;
                    }
                } else if (i == d1.getAno()) {
                    dias = dias + (d1.diasAteMes(d1.getMes()) + d1.getDia());
                } else {
                    if (bissexto(i)) {
                        dias = dias + 366;
                    } else {
                        dias = dias + 365;
                    }
                }
            }
        }
        return dias;
    }
}

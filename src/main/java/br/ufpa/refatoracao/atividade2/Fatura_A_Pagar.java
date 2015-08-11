package br.ufpa.refatoracao.atividade2;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by gilson on 11/08/15.
 */
public class Fatura_A_Pagar {
    double _valorConta;
    double _juros;
    Date _dataVencimento;

    public double calcularValorConta (int diaVenc, int mesVenc, int anoVenc,
                                      double juros, double valorConta) {
        this._juros = juros;
        this._valorConta = valorConta;
        this._dataVencimento = new Date(anoVenc, mesVenc - 1, diaVenc);

        // calcula o número de dias do vencimento até a data corrente
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.set(anoVenc, mesVenc - 1, diaVenc);
        c2.setTime(new Date());

        float emAtraso = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);

        // determinar o valor da conta
        int numeroDeDiasEmAtraso = (int) emAtraso;
        double valorAcrescimoPorAtraso = 0;
        if (numeroDeDiasEmAtraso > 10) {
            valorAcrescimoPorAtraso = 10.00;
        } else if (numeroDeDiasEmAtraso >= 5 && numeroDeDiasEmAtraso <= 10) {
            valorAcrescimoPorAtraso = 5.00;
        } else {
            valorAcrescimoPorAtraso = 2.00;
        }
        double valoTotalConta = this._valorConta + (this._valorConta * this._juros)
                + valorAcrescimoPorAtraso;

        // double valoTotalConta = calculaAtraso((int) emAtraso);
        return (valoTotalConta);
    }  // fim do método
} // fim da classe
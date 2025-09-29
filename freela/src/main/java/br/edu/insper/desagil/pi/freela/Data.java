import java.util.HashMap;
import java.util.Map;

public class Data extends Momento {
    private int ano;
    private int mes;
    private int dia;

    private Map<Integer,Integer>limite;

    public Data(){
        this.ano = 1970;
        this.mes = 1;
        this.dia = 1;
        this.limite = new HashMap<>();
        this.InicializarMapasDias();
    }
    @Override
    public int minutos() {

        int diasPorAnosCompletos = (this.ano - 1970) * 365;
        int diasPorMesesCompletos = 0;
        for (int m = 1; m < this.mes; m++) {
            diasPorMesesCompletos += this.getDiasDoMes(m);
        }
        int diasNoMesAtual = this.dia - 1;
        int totalDias = diasPorAnosCompletos + diasPorMesesCompletos + diasNoMesAtual;

        int totalMinutos = totalDias * 24 * 60;

        return totalMinutos;
    }

    public void atualiza(int novoAno, int novoMes, int novoDia){

        int anoAjustado = this.ajusta(novoAno,1970,2070);
        int mesAjustado = this.ajusta(novoMes,1,12);
        int maximoDeDiasNoMes = this.getDiasDoMes(mesAjustado);
        int diaAjustado = this.ajusta(novoDia,1,maximoDeDiasNoMes);

        this.ano = anoAjustado;
        this.mes = mesAjustado;
        this.dia = diaAjustado;

    }

    private void InicializarMapasDias(){
        Map<Integer, Integer> limite = new HashMap<>();
        limite.put(1, 31);
        limite.put(2, 28);
        limite.put(3, 31);
        limite.put(4, 30);
        limite.put(5, 31);
        limite.put(6, 30);
        limite.put(7, 31);
        limite.put(8, 31);
        limite.put(9, 30);
        limite.put(10, 31);
        limite.put(11, 30);
        limite.put(12, 31);

        this.limite = limite;
    }

    public int getDiasDoMes(int NumeroDoMes){
        return this.limite.getOrDefault(NumeroDoMes,0);
    }

    public int GetAno(){
        return this.ano;
    }
    public int GetMes(){
        return this.mes;
    }
    public int GetDia(){
        return this.dia;
    }

}

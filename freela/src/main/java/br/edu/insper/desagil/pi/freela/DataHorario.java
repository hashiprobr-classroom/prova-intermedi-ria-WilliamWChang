import java.util.HashMap;
import java.util.Map;

public class DataHorario extends Momento {
    private int hora;
    private int minuto;
    public Data data;


    public DataHorario(Data,data){
        this.data = data;
        this.hora = 0;
        this.minuto = 0;
    }

    @Override
    public int minutos() {

        int minutosDaParteData = data.minutos();
        int minutosDaParteHorario = this.hora * 60 + this.minuto;

        return minutosDaParteData + minutosDaParteHorario;
    }
    public void atualiza(int novaHora, int novoMinuto){

        int horaAjustado = this.ajusta(novaHora,0,23);
        int minutoAjustado = this.ajusta(novoMinuto,0,59);


        this.hora = horaAjustado;
        this.minuto = minutoAjustado;
    }
}

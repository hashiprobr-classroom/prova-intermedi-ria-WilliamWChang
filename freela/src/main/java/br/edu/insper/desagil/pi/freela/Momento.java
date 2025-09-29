public abstract class Momento {

    public abstract int minutos();

    public int ajusta(int valor, int minimo , int maximo){

        if (valor < minimo) {
            return minimo;
        }
        else if (valor > maximo) {
            return maximo;
        }
        else {
            return valor;
        }
    }

}
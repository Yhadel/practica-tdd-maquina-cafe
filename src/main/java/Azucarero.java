
public class Azucarero {
    private int cantidadDeAzucar;

    public Azucarero(int cantidadDeAzucar) {
        this.cantidadDeAzucar = cantidadDeAzucar;
    }

    public void setCantidadDeAzucar(int cantidadDeAzucar) { this.cantidadDeAzucar = cantidadDeAzucar; }
    public int getCantidadDeAzucar() { return cantidadDeAzucar; }

    public boolean hasAzucar(int cantidad) {
        return this.cantidadDeAzucar >= cantidad;
    }

    public void giveAzucar(int cantidad) {
        if (hasAzucar(cantidad)) {
            this.cantidadDeAzucar -= cantidad;
        }
    }
}
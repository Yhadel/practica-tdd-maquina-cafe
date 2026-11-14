public class Cafetera {
    private int cantidadCafe;

    public Cafetera(int cantidadCafe) {
        this.cantidadCafe = cantidadCafe;
    }

    public void setCantidadDeCafe(int cantidadCafe) { this.cantidadCafe = cantidadCafe; }
    public int getCantidadDeCafe() { return cantidadCafe; }

    public boolean hasCafe(int cantidad) {
        return this.cantidadCafe >= cantidad;
    }

    public void giveCafe(int cantidad) {
        if (hasCafe(cantidad)) {
            this.cantidadCafe -= cantidad;
        }
    }
}
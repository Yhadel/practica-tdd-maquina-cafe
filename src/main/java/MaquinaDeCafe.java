public class MaquinaDeCafe {
    private Cafetera cafe;
    public Vaso vasosPequeno;
    public Vaso vasosMediano;
    public Vaso vasosGrande;
    private Azucarero azucar;

    public void setCafetera(Cafetera cafe) { this.cafe = cafe; }
    public Cafetera getCafetera() { return cafe; }

    public void setVasosPequeno(Vaso vasosPequeño) { this.vasosPequeno = vasosPequeño; }
    public Vaso getVasosPequeno() { return vasosPequeno; }

    public void setVasosMediano(Vaso vasosMediano) { this.vasosMediano = vasosMediano; }
    public Vaso getVasosMediano() { return vasosMediano; }

    public void setVasosGrande(Vaso vasosGrande) { this.vasosGrande = vasosGrande; }
    public Vaso getVasosGrande() { return vasosGrande; }

    public void setAzucarero(Azucarero azucar) { this.azucar = azucar; }
    public Azucarero getAzucarero() { return azucar; }

    public Vaso getTipoVaso(String tipoDeVaso) {
        if (tipoDeVaso != null) {
            String tipo = tipoDeVaso.toLowerCase();
            if (tipo.equals("pequeno") || tipo.equals("pequeño")) return vasosPequeno;
            if (tipo.equals("mediano")) return vasosMediano;
            if (tipo.equals("grande")) return vasosGrande;
        }
        return null;
    }

    public String getVasoDeCafe(Vaso vasoSeleccionado, int cantidadVasos, int cantidadAzucar) {
        if (vasoSeleccionado == null || !vasoSeleccionado.hasVasos(cantidadVasos)) {
            return "No hay Vasos";
        }
        
        int cafeRequerido = vasoSeleccionado.getContenido() * cantidadVasos;
        if (cafe == null || !cafe.hasCafe(cafeRequerido)) {
            return "No hay Cafe";
        }

        if (azucar == null || !azucar.hasAzucar(cantidadAzucar)) {
            return "No hay Azucar";
        }

        vasoSeleccionado.giveVasos(cantidadVasos);
        cafe.giveCafe(cafeRequerido);
        if (cantidadAzucar > 0) {
            azucar.giveAzucar(cantidadAzucar);
        }

        return "Felicitaciones";
    }
}
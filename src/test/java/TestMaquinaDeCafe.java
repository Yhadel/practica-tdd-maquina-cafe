import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestMaquinaDeCafe {
    Cafetera cafetera;
    Vaso vasosPequeno;
    Vaso vasosMediano;
    Vaso vasosGrande;
    Azucarero azucarero;
    MaquinaDeCafe maquinaDeCafe;

    @Before
    public void setUp() {
        cafetera = new Cafetera(50);
        vasosPequeno = new Vaso(5, 10);
        vasosMediano = new Vaso(5, 20);
        vasosGrande = new Vaso(5, 30);
        azucarero = new Azucarero(20);

        maquinaDeCafe = new MaquinaDeCafe();
        maquinaDeCafe.setCafetera(cafetera);
        maquinaDeCafe.setVasosPequeno(vasosPequeno);
        maquinaDeCafe.setVasosMediano(vasosMediano);
        maquinaDeCafe.setVasosGrande(vasosGrande);
        maquinaDeCafe.setAzucarero(azucarero);
    }

    @Test
    public void deberiaDevolverUnVasoPequeno() {
        Vaso vaso = maquinaDeCafe.getTipoVaso("pequeno");
        assertEquals(maquinaDeCafe.vasosPequeno, vaso);
    }

    @Test
    public void deberiaDevolverUnVasoMediano() {
        Vaso vaso = maquinaDeCafe.getTipoVaso("mediano");
        assertEquals(maquinaDeCafe.vasosMediano, vaso);
    }

    @Test
    public void deberiaDevolverUnVasoGrande() {
        Vaso vaso = maquinaDeCafe.getTipoVaso("grande");
        assertEquals(maquinaDeCafe.vasosGrande, vaso);
    }

    @Test
    public void deberiaDevolverNoHayVasos() {
        Vaso vaso = maquinaDeCafe.getTipoVaso("pequeno");
        String resultado = maquinaDeCafe.getVasoDeCafe(vaso, 10, 2);
        assertEquals("No hay Vasos", resultado);
    }

    @Test
    public void deberiaDevolverNoHayCafe() {
        Cafetera cafeteraBaja = new Cafetera(5);
        maquinaDeCafe.setCafetera(cafeteraBaja);
        Vaso vaso = maquinaDeCafe.getTipoVaso("pequeno");
        String resultado = maquinaDeCafe.getVasoDeCafe(vaso, 1, 2);
        assertEquals("No hay Cafe", resultado);
    }

    @Test
    public void deberiaDevolverNoHayAzucar() {
        Azucarero azucareroPoco = new Azucarero(2);
        maquinaDeCafe.setAzucarero(azucareroPoco);
        Vaso vaso = maquinaDeCafe.getTipoVaso("pequeno");
        String resultado = maquinaDeCafe.getVasoDeCafe(vaso, 1, 3);
        assertEquals("No hay Azucar", resultado);
    }

    @Test
    public void deberiaRestarCafe() {
        Vaso vaso = maquinaDeCafe.getTipoVaso("pequeno");
        maquinaDeCafe.getVasoDeCafe(vaso, 1, 3);
        int resultado = maquinaDeCafe.getCafetera().getCantidadDeCafe();
        assertEquals(40, resultado);
    }

    @Test
    public void deberiaRestarVaso() {
        Vaso vaso = maquinaDeCafe.getTipoVaso("pequeno");
        maquinaDeCafe.getVasoDeCafe(vaso, 1, 3);
        int resultado = maquinaDeCafe.getVasosPequeno().getCantidadVasos();
        assertEquals(4, resultado);
    }

    @Test
    public void deberiaRestarAzucar() {
        Vaso vaso = maquinaDeCafe.getTipoVaso("pequeno");
        maquinaDeCafe.getVasoDeCafe(vaso, 1, 3);
        int resultado = maquinaDeCafe.getAzucarero().getCantidadDeAzucar();
        assertEquals(17, resultado);
    }

    @Test
    public void deberiaDevolverFelicitaciones() {
        Vaso vaso = maquinaDeCafe.getTipoVaso("pequeno");
        String resultado = maquinaDeCafe.getVasoDeCafe(vaso, 1, 3);
        assertEquals("Felicitaciones", resultado);
    }
}
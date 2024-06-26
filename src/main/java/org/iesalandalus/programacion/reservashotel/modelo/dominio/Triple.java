package org.iesalandalus.programacion.reservashotel.modelo.dominio;

public class Triple extends Habitacion{
    private static final int NUM_MAXIMO_PERSONAS=3;
    static final int MIN_NUM_BANOS=1;
    static final int MAX_NUM_BANOS=2;
    static final int MIN_NUM_CAMAS_INDIVIDUALES=1;
    static final  int MAX_NUM_CAMAS_INDIVIDUALES=3;
    static final int MIN_NUM_CAMAS_DOBLES=0;
    static final int MAX_NUM_CAMAS_DOBLES=1;
    private int numBanos;
    private int numCamasIndividuales;
    private int numCamasDobles;

    public Triple (int planta, int puerta, double precio, int numBanos, int numCamasIndividuales, int numCamasDobles){
        super (planta, puerta, precio);
        setNumBanos(numBanos);
        setNumCamasIndividuales(numCamasIndividuales);
        setNumCamasDobles(numCamasDobles);
        validaNumCamas();
    }

    public Triple (Triple habitacionTriple){
        //super(habitacionTriple.getPlanta(),habitacionTriple.getPuerta(),habitacionTriple.getPrecio());
        super(habitacionTriple);
        /*if (habitacionTriple == null)
            throw new NullPointerException("ERROR: No es posible copiar una habitaci�n nula.");
        super.setPlanta(habitacionTriple.getPlanta());
        super.setPuerta(habitacionTriple.getPuerta());
        super.setPrecio(habitacionTriple.getPrecio());*/
        setNumCamasIndividuales(habitacionTriple.getNumCamasIndividuales());
        setNumCamasDobles(habitacionTriple.getNumCamasDobles());
        setNumBanos(habitacionTriple.getNumBanos());
    }

    public int getNumBanos() {
        return numBanos;
    }

    public void setNumBanos(int numBanos) {
        if (numBanos<MIN_NUM_BANOS)
            throw new IllegalArgumentException("ERROR: El n�mero de ba�os no puede ser inferior a 1 ni superior a 2");
        if (numBanos>MAX_NUM_BANOS)
            throw new IllegalArgumentException("ERROR: El n�mero de ba�os no puede ser inferior a 1 ni superior a 2");
        this.numBanos = numBanos;
    }

    public int getNumCamasIndividuales() {
        return numCamasIndividuales;
    }

    public void setNumCamasIndividuales(int numCamasIndividuales) {
        this.numCamasIndividuales = numCamasIndividuales;
    }

    public int getNumCamasDobles() {
        return numCamasDobles;
    }

    public void setNumCamasDobles(int numCamasDobles) {
        this.numCamasDobles = numCamasDobles;
    }

    private void validaNumCamas(){
        if (getNumCamasDobles()<MIN_NUM_CAMAS_DOBLES || getNumCamasDobles()>MAX_NUM_CAMAS_DOBLES)
            throw new IllegalArgumentException("ERROR: El n�mero de camas dobles de una habitaci�n triple no puede ser inferior a 0 ni mayor que 1");
        if (getNumCamasIndividuales()<MIN_NUM_CAMAS_INDIVIDUALES || getNumCamasIndividuales()>MAX_NUM_CAMAS_INDIVIDUALES)
            throw new IllegalArgumentException("ERROR: El n�mero de camas individuales de una habitaci�n triple no puede ser inferior a 1 ni mayor que 3");
        if (getNumBanos() == 2 && getNumCamasIndividuales() == 1 && getNumCamasDobles() == 0 || getNumBanos() == 2 && getNumCamasIndividuales() == 2 && getNumCamasDobles() == 0 || getNumBanos() == 2 && getNumCamasIndividuales() == 3 && getNumCamasDobles() == 1)
            throw new IllegalArgumentException("ERROR: La distribuci�n de camas en una habitaci�n triple tiene que ser 3 camas individuales y 0 doble o 1 cama individual y 1 doble");
    }

    @Override
    public int getNumeroMaximoPersonas(){
        return NUM_MAXIMO_PERSONAS;
    }

    @Override
    public String toString() {
        return String.format(super.toString()+", habitaci�n triple, capacidad=%d personas, " +
                        "ba�os=%d, camas individuales=%d, camas dobles=%d",
                getNumeroMaximoPersonas(),getNumBanos(),getNumCamasIndividuales(),getNumCamasDobles());
    }
}

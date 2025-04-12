
public class Persona {

    private String nombre;
    private String cedula;
    private int edad;
    private boolean esDesplazado;
    private int estrato;
    private boolean recibeAuxilio;
    private double auxilio;

    public Persona(String nombre, String cedula, int edad, boolean esDesplazado, int estrato) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.esDesplazado = esDesplazado;
        this.estrato = estrato;
        this.recibeAuxilio = calcularAuxilio();
    }

    private boolean calcularAuxilio() {
        return edad < 18 && (estrato <= 2 || esDesplazado);
    }

    public void setAuxilio(double salarioMinimo) {
        if (recibeAuxilio) {
            this.auxilio = salarioMinimo * 0.8;
        } else {
            this.auxilio = 0;
        }
    }

    public String getNombre(){
         return nombre; }

    public String getCedula(){
         return cedula; }

    public int getEdad() {
         return edad; }

    public boolean getEsDesplazado(){
         return esDesplazado; }

    public int getEstrato(){
        return estrato; }

    public boolean getRecibeAuxilio(){
         return recibeAuxilio; }

    public double getAuxilio() {
         return auxilio; }
         
}



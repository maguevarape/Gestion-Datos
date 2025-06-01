package Modelo;
public class Paciente {
   private String dni;
    private String nombres;
    private String apellidos;
    private String fechaNacimiento;
    private int idLugar;

    public Paciente() {}

    public Paciente(String dni, String nombres, String apellidos, String fechaNacimiento, int idLugar) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.idLugar = idLugar;
    }
    public String getDni() {return dni;  }
    public void setDni(String dni) {this.dni = dni; }
    public String getNombres() {  return nombres;  }
    public void setNombres(String nombres) {   this.nombres = nombres; }
    public String getApellidos() { return apellidos;  }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public String getFechaNacimiento() {  return fechaNacimiento; }
    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public int getIdLugar() {  return idLugar; }
    public void setIdLugar(int idLugar) { this.idLugar = idLugar; }  
}

package Modelo;


public class Constancia {
 private String dniPaciente;
    private String fechaEmision;
    private String observaciones;

    public Constancia() {}

    public Constancia(String dniPaciente, String fechaEmision, String observaciones) {
        this.dniPaciente = dniPaciente;
        this.fechaEmision = fechaEmision;
        this.observaciones = observaciones;
    }

    // Getters y Setters
    public String getDniPaciente() {
        return dniPaciente;
    }
    public void setDniPaciente(String dniPaciente) {
        this.dniPaciente = dniPaciente;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }
    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getObservaciones() {
        return observaciones;
    }
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }   
}

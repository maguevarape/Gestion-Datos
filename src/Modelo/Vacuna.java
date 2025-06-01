package Modelo;

public class Vacuna {
    private String dniPaciente;
    private int idVacuna;
    private String fechaAplicacion;
    private String lote;
    private String personalQueAplico;

    public Vacuna() {}

    public Vacuna(String dniPaciente, int idVacuna, String fechaAplicacion, String lote, String personalQueAplico) {
        this.dniPaciente = dniPaciente;
        this.idVacuna = idVacuna;
        this.fechaAplicacion = fechaAplicacion;
        this.lote = lote;
        this.personalQueAplico = personalQueAplico;
    }

    // Getters y Setters
    public String getDniPaciente() {
        return dniPaciente;
    }
    public void setDniPaciente(String dniPaciente) {
        this.dniPaciente = dniPaciente;
    }

    public int getIdVacuna() {
        return idVacuna;
    }
    public void setIdVacuna(int idVacuna) {
        this.idVacuna = idVacuna;
    }

    public String getFechaAplicacion() {
        return fechaAplicacion;
    }
    public void setFechaAplicacion(String fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public String getLote() {
        return lote;
    }
    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getPersonalQueAplico() {
        return personalQueAplico;
    }
    public void setPersonalQueAplico(String personalQueAplico) {
        this.personalQueAplico = personalQueAplico;
    }  
}


package Controlador;
import Vista.FormaPaci;
import Vista.FormaVacuna;
import Base.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class ControladorFormaPaci {
  private final FormaPaci vista;
    private final Conexion conexion;

    public ControladorFormaPaci(FormaPaci vista) {
        this.vista = vista;
        this.conexion = new Conexion();

        this.vista.btnAceptarp.addActionListener(e -> guardarPaciente());
        this.vista.btnCancelarp.addActionListener(e -> vista.dispose());
    }

   private void guardarPaciente() {
    String dni = vista.txtDni.getText().trim();
    String nombres = vista.txtNombres.getText().trim();
    String apellidos = vista.txtApellidos.getText().trim();
    String fechaNacimiento = vista.txtFechaNacimiento.getText().trim();
    int idLugar = vista.cbxLugar.getSelectedIndex() + 1;

    String sql = "INSERT INTO Pacientes (DNI, Nombres, Apellidos, FechaNacimiento, IdLugar) VALUES (?, ?, ?, ?, ?)";

    try (Connection con = conexion.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, dni);
        ps.setString(2, nombres);
        ps.setString(3, apellidos);
        ps.setString(4, fechaNacimiento);
        ps.setInt(5, idLugar);
        ps.executeUpdate();

        // Mostrar ventana de vacuna y pasarle el controlador
        FormaVacuna formaVacuna = new FormaVacuna();
        new ControladorFormaVacuna(formaVacuna); // ← controlador agregado
        formaVacuna.txtDNIpaci.setText(dni);
        formaVacuna.setVisible(true);

        vista.dispose();

    } catch (Exception ex) {
        System.out.println("Error al guardar paciente: " + ex.getMessage());
    }
}
}  


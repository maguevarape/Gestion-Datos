
package Controlador;
import Vista.FormaCos;
import Base.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class ControladorFormaCos {
    FormaCos vista;
    String dni; 

    public ControladorFormaCos(FormaCos vista, String dni) {
        this.vista = vista;
        this.dni = dni;

        cargarDatosPaciente();

        this.vista.btnAceptarc.addActionListener(e -> guardarConstancia());
        this.vista.btnCancelarc.addActionListener(e -> vista.dispose());
    }

private void cargarDatosPaciente() {
    try (Connection con = new Conexion().conectar()) {
        String sql = "SELECT p.DNI, p.Nombres, p.Apellidos, p.FechaNacimiento, l.Nombre AS Lugar " +
                     "FROM Pacientes p " +
                     "JOIN LugarResidencia l ON p.IdLugar = l.IdLugar " +
                     "WHERE p.DNI = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, dni);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
           
            System.out.println("DNI obtenido: " + rs.getString("DNI"));

          
            vista.txtDNIpa.setText(rs.getString("DNI")); 
            vista.txtNom.setText(rs.getString("Nombres") + " " + rs.getString("Apellidos")); 
            vista.txtFechana.setText(rs.getString("FechaNacimiento")); 
            vista.txtLugar.setText(rs.getString("Lugar")); 

            vista.txtFechaemi.setText(""); 

     
            vista.txtDNIpa.setEditable(false);
            vista.txtNom.setEditable(false);
            vista.txtFechana.setEditable(false);
            vista.txtLugar.setEditable(false);
            vista.txtFechaemi.setEditable(true);

        } else {
            JOptionPane.showMessageDialog(vista, "No se encontró paciente con ese DNI.");
        }

        rs.close();
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(vista, "Error al cargar datos: " + ex.getMessage());
    }
}

  private void guardarConstancia() {
        String observaciones = vista.txaMostrar.getText().trim();
        String fechaEmision = vista.txtFechaemi.getText().trim();

        if (observaciones.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Debe completar las observaciones.");
            return;
        }

        try (Connection con = new Conexion().conectar();
             PreparedStatement ps = con.prepareStatement(
                 "INSERT INTO Constancias (DNIPaciente, FechaEmision, Observaciones) VALUES (?, ?, ?)")) {

            ps.setString(1, dni);
            ps.setString(2, fechaEmision);
            ps.setString(3, observaciones);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(vista, "Constancia registrada con éxito.");
            vista.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al registrar constancia: " + ex.getMessage());
        }
    }
}

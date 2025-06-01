package Controlador;
import Vista.FormaVacuna;
import Vista.FormaCos;
import Base.Conexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class ControladorFormaVacuna {

    FormaVacuna vista;

    public ControladorFormaVacuna(FormaVacuna vista) {
        this.vista = vista;

        this.vista.btnAceptarv.addActionListener(e -> guardarVacuna());

        this.vista.btnCancelarv.addActionListener(e -> {
           
            vista.dispose();
        });

        this.vista.btnRegresarv.addActionListener(e -> {
            // Regresa a FormaPaci
            Vista.FormaPaci formaPaci = new Vista.FormaPaci();
            ControladorFormaPaci controladorPaci = new ControladorFormaPaci(formaPaci);
            formaPaci.setVisible(true);
            vista.dispose();
        });
    }

   private void guardarVacuna() {
    System.out.println(">> Intentando guardar vacuna");

    String dni = vista.txtDNIpaci.getText();
    String fecha = vista.txtAplica.getText();
    String lote = vista.txtLote.getText();
    String personal = vista.txtPersona.getText();

    if (dni.isEmpty() || fecha.isEmpty() || lote.isEmpty() || personal.isEmpty()) {
        JOptionPane.showMessageDialog(vista, "Debe completar todos los campos.");
        return;
    }

    try (Connection con = new Conexion().conectar()) {
        if (con == null) {
            JOptionPane.showMessageDialog(vista, "No se pudo conectar a la base de datos.");
            return;
        }

        int idVacuna = vista.cbxNomvacuna.getSelectedIndex() + 1;
        String sql = "INSERT INTO Vacunas (DNIPaciente, IdVacuna, FechaAplicacion, Lote, PersonalQueAplico) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, dni);
        ps.setInt(2, idVacuna);
        ps.setString(3, fecha);
        ps.setString(4, lote);
        ps.setString(5, personal);

        ps.executeUpdate();

        JOptionPane.showMessageDialog(vista, "Vacuna registrada exitosamente.");

        FormaCos fc = new FormaCos();
        new ControladorFormaCos(fc, dni);
        fc.setVisible(true);
        vista.dispose();

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(vista, "Error al guardar vacuna: " + ex.getMessage());
    }
}
}




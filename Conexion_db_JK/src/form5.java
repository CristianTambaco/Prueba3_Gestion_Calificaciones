import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class form5 extends JFrame {
    public JPanel mainPanel5;
    private JTextField textField1;
    private JButton btnRegistrar;
    private JButton btnMenu;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;

    public form5() {
        // Acción para el botón Menu
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnMenu);
                frame.dispose();  // Cierra la ventana actual
            }
        });

        // Acción para el botón Registrar
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarUsuario();
            }
        });
    }

    // Metodo para registrar el usuario en la base de datos
    private void registrarUsuario() {
        // Obtener los datos del formulario

        String cedula = textField7.getText();
        String nombre = textField1.getText();
        String nota1 = textField2.getText();
        String nota2 = textField3.getText();
        String nota3 = textField4.getText();
        String nota4 = textField5.getText();
        String nota5 = textField6.getText();

        // Validar que los campos no estén vacíos
        if (nombre.isEmpty() || cedula.isEmpty() || nota1.isEmpty() || nota2.isEmpty() || nota3.isEmpty() || nota4.isEmpty() || nota5.isEmpty())  {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Validar que sea un número
        int notaa;
        int notab;
        int notac;
        int notad;
        int notae;



        try {
            notaa = Integer.parseInt(nota1);
            notab = Integer.parseInt(nota2);
            notac = Integer.parseInt(nota3);
            notad = Integer.parseInt(nota4);
            notae = Integer.parseInt(nota5);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese una nota válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Verificar rango
        if (notaa < 0 || notaa > 10) {
            JOptionPane.showMessageDialog(this, "La nota minima es 0 y la nota máxima es 10.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/calificacion";
        String user = "root";
        String password = "123456";
        String query = "INSERT INTO estudiantes (cedula, nombre, estudiante1, estudiante2, estudiante3, estudiante4, estudiante5) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            // Preparar la sentencia SQL
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, cedula);
            statement.setString(2, nombre);
            statement.setInt(3, notaa);
            statement.setInt(4, notab);
            statement.setInt(5, notac);
            statement.setInt(6, notad);
            statement.setInt(7, notae);

            // Ejecutar la inserción
            int rowsAffected = statement.executeUpdate();

            // Verificar si la inserción fue exitosa
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Registro exitoso.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Error al registrar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void iniciarRetiro() {
        JFrame frame = new JFrame("Registro");
        frame.setContentPane(new form5().mainPanel5);
        frame.setSize(800, 600);  // Establecer tamaño de la ventana
        frame.setPreferredSize(new Dimension(800, 600)); // Tamaño preferido
        frame.pack();
        frame.setVisible(true); // Mostrar ventana
        frame.setLocationRelativeTo(null); // Centrar la ventana
    }
}

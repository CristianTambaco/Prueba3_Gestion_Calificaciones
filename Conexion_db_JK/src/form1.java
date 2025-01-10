import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class form1 extends JFrame {
    public JPanel mainPanel;
    private JTextField usuarioTextField;
    private JPasswordField contraseniaPasswordField;
    private JButton loginButton;
    private JLabel mensajeLabel;

    // Metodo para validar el login con la base de datos
    private void validarLogin() {
        // Obtener los valores ingresados
        String usuario = usuarioTextField.getText();
        char[] contrasenia = contraseniaPasswordField.getPassword();
        String contraseniaTexto = new String(contrasenia);

        // Conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/calificacion";
        String user = "root";
        String password = "123456";

        String query = "SELECT * FROM usuarios WHERE username = ? AND pass = ?";

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, usuario);
            statement.setString(2, contraseniaTexto);

            ResultSet resultSet = statement.executeQuery();

            // Si se encuentra un usuario que coincida con los datos ingresados
            if (resultSet.next()) {
                // Acceso correcto
                form2 fords = new form2();
                fords.iniciarMenu();

                mensajeLabel.setText("Acceso Correcto :)");

                // Cerrar el formulario de login
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(loginButton);
                frame.dispose();
            } else {
                // Usuario o contraseña incorrectos
                form7 fords = new form7();
                fords.iniciarUsuarioIncorrecto();

                mensajeLabel.setText("Acceso Incorrecto :(");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            mensajeLabel.setText("Error en la conexión con la base de datos.");
        }
    }

    public void iniciarLogin() {
        JFrame frame = new JFrame("Aplicación Pantalla de Login");
        frame.setContentPane(new form1().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra el formulario
        frame.setSize(800, 600); // Tamaño de la ventana
        frame.setPreferredSize(new Dimension(800, 600)); // Tamaño preferido
        frame.pack();
        frame.setVisible(true); // Muestra la ventana
        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla
    }

    // Funcionalidad para el botón login
    public form1() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarLogin(); // Llama al metodo para validar el login
            }
        });
    }
}

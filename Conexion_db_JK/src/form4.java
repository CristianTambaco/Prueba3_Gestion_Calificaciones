import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class form4 extends JFrame {
    public JPanel mainPanel4;
    private JButton btnMenu;
    private JTextArea textArea1;

    public form4() {
        btnMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Llamar al metodo que obtiene y muestra los registros al presionar el botón
                mostrarRegistros();
            }
        });
    }

    // Metodo para mostrar los registros de la base de datos en el JTextArea
    private void mostrarRegistros() {
        String url = "jdbc:mysql://localhost:3306/calificacion";
        String user = "root";
        String password = "123456";

        String query = "SELECT * FROM estudiantes";
        StringBuilder sb = new StringBuilder();

        try (Connection con = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            // Recorrer los resultados y agregar la información
            while (resultSet.next()) {
                int cod = resultSet.getInt("id");
                String cedula = resultSet.getString("cedula");
                String nombre = resultSet.getString("nombre");

                String estudiante1 = resultSet.getString("estudiante1");
                String estudiante2 = resultSet.getString("estudiante2");
                String estudiante3 = resultSet.getString("estudiante3");
                String estudiante4 = resultSet.getString("estudiante4");
                String estudiante5 = resultSet.getString("estudiante5");


                sb.append("COD: ").append(cod).append("\n")
                        .append("Cedula: ").append(cedula).append("\n")
                        .append("Nombre: ").append(nombre).append("\n")
                        .append("Estudiante1: ").append(estudiante1).append("\n")
                        .append("Estudiante2: ").append(estudiante2).append("\n")
                        .append("Estudiante3: ").append(estudiante3).append("\n")
                        .append("Estudiante4: ").append(estudiante4).append("\n")
                        .append("Estudiante5: ").append(estudiante5).append("\n")


                        .append("----------------------------\n");
            }

            textArea1.setText(sb.toString());

        } catch (SQLException e) {
            e.printStackTrace();
            textArea1.setText("Error al obtener los registros.");
        }
    }

    public void verSaldo() {
        JFrame frame = new JFrame("Ver calificaciones");
        frame.setContentPane(new form4().mainPanel4);
        frame.setSize(800, 600); // Establecer tamaño de la ventana
        frame.setPreferredSize(new Dimension(800, 600)); // Tamaño preferido
        frame.pack();
        frame.setVisible(true); // Mostrar ventana
        frame.setLocationRelativeTo(null); // Centrar la ventana
    }
}

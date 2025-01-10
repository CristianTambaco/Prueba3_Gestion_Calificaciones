import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Main {
    public static void main(String[] args) throws SQLException {

        String url="jdbc:mysql://localhost:3306/calificacion";
        String user="root";
        String password="123456";

        String query="SELECT *FROM usuarios";


        try (Connection cone=DriverManager.getConnection(url,user,password)){


            PreparedStatement statement= cone.prepareStatement(query);
            ResultSet resultSet=statement.executeQuery();

            System.out.println("CONECTADO");

            while(resultSet.next()){
                int id=resultSet.getInt("id");
                String nombre=resultSet.getNString("username");

                String passwordusuario=resultSet.getNString("pass");

                System.out.println(" id: " + id + ", username: " + nombre + ", password: "+passwordusuario);


            }

        }
        catch (Exception e){
            Exception e1 = e;
            e1.printStackTrace();
        }






            JFrame frame = new JFrame("Aplicación Pantalla de Login");
            frame.setContentPane(new form1().mainPanel);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //que es lo que pasa cuando cierro el formulario
            frame.setSize(800,600);                     //seteo del tamaño
            frame.setPreferredSize(new Dimension(800,600));    //seteo del tamaño preferido
            frame.pack();
            frame.setVisible(true);   //para visualizar una nueva ventana
            frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla




    }
}
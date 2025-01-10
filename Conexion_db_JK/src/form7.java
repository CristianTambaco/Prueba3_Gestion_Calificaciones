

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form7 extends JFrame {
    public JPanel mainPanel7;
    private JButton btnOk;


    public form7() {
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnOk);
                frame.dispose();

            }
        });
    }

    public void iniciarUsuarioIncorrecto() {


        JFrame frame = new JFrame("Usuario incorrecto");
        frame.setContentPane(new form7().mainPanel7);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //que es lo que pasa cuando cierro el formulario
        frame.setSize(800,600);                     //seteo del tamaño
        frame.setPreferredSize(new Dimension(800,600));    //seteo del tamaño preferido
        frame.pack();
        frame.setVisible(true);   //para visualizar una nueva ventana
        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla

    }


}

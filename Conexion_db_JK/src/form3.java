

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form3 extends  JFrame{
    public JPanel mainPanel3;
    private JButton OKButton;


    public form3() {
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                form1 fords = new form1();
                fords.iniciarLogin();

                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(OKButton);
                frame.dispose();

                //System.exit(0);  // Finalizar_Todo


            }
        });
    }

    public void iniciarGracias() {


        JFrame frame = new JFrame("Gracias");
        frame.setContentPane(new form3().mainPanel3);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //que es lo que pasa cuando cierro el formulario
        frame.setSize(800,600);                     //seteo del tamaño
        frame.setPreferredSize(new Dimension(800,600));    //seteo del tamaño preferido
        frame.pack();
        frame.setVisible(true);   //para visualizar una nueva ventana
        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla

    }


}

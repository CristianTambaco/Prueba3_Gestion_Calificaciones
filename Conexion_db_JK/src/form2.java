
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form2 extends  JFrame {
    private JButton btnVerSaldo;
    private JButton btnRetiro;
    public JPanel mainPanel2;
    private JButton btnSalir;
    private JLabel lblTransaccion;


    public form2() {
        btnVerSaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                form4 fords = new form4();
                fords.verSaldo();


            }
        });
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                form3 fords = new form3();
                fords.iniciarGracias();

                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnSalir);
                frame.dispose();


                //System.exit(0);  // Finalizar_Todo

                //JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(btnSalir);
                //frame.dispose();

            }
        });
        btnRetiro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                form5 fords = new form5();
                fords.iniciarRetiro();

            }
        });

    }

    public void iniciarMenu() {


        JFrame frame = new JFrame("Menú");
        frame.setContentPane(new form2().mainPanel2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //que es lo que pasa cuando cierro el formulario
        frame.setSize(800,600);                     //seteo del tamaño
        frame.setPreferredSize(new Dimension(800,600));    //seteo del tamaño preferido
        frame.pack();
        frame.setVisible(true);   //para visualizar una nueva ventana
        frame.setLocationRelativeTo(null); // Centra la ventana en la pantalla

    }


}

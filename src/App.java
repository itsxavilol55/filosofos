/**
 * It creates a window with a button and a canvas. When the button is pressed, it creates 5 threads
 * that will try to eat
 */
// Importing all the classes in the `java.awt` package.
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class App extends JFrame implements ActionListener
{
    private Filosofo[] hilos;
    private Semaforo semaforos[];
    private boolean tenedores[], comiendo[];
    private JButton btninicia;
    private canvas mycanva;
    public static void main(String[] args) throws Exception
    {
        new App();
    }
    public App()
    {
        int total = 5;
        hilos = new Filosofo[total];
        semaforos = new Semaforo[total];
        tenedores = new boolean[total];
        comiendo = new boolean[total];
        for (int i = 0; i < hilos.length; i++)
        {
            semaforos[i] = new Semaforo(1);
            tenedores[i] = false;
            comiendo[i] = false;
        }
        interfaz();
        eventos();
    }
    private void interfaz()
    {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        mycanva = new canvas(tenedores, comiendo);
        btninicia = new JButton("Iniciar");
        add(mycanva);
        add(btninicia, BorderLayout.SOUTH);
        setVisible(true);
    }
    private void eventos()
    {
        btninicia.addActionListener(this);
    }
    @Override public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btninicia)
        {
            for (int i = 0; i < hilos.length; i++)
                hilos[i] = new Filosofo((i + 1), semaforos, tenedores, mycanva, comiendo);
            for (int i = 0; i < hilos.length; i++)
                hilos[i].start();
        }
    }
}

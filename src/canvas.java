import java.awt.*;
import javax.swing.*;

// import java.awt.event.*;
public class canvas extends JPanel {
    private int tenedor;
    private boolean tenedores[], comiendo[];

    public canvas(
            boolean[] tenedore,
            boolean[] comiend) {
        tenedores = tenedore;
        comiendo = comiend;
        interfaz();
        tenedor = 0;
    }

    private void interfaz() {
        setSize(500, 500);
        setBackground(new Color(43, 77, 166));
        setVisible(true);
    }

    public void paint(Graphics g) {
        int diametroX = (int) (getWidth() * 0.55);
        int diametroY = (int) (getHeight() * 0.55);
        int diamepeque = (int) (diametroY * 0.265);// diametro de cada plato
        int PosY = diametroY - diamepeque, PosX = (diametroX + PosY) / 2, PosY2 = diametroY + (int) (diamepeque / 1.5),
                PosX2 = diametroX / 2, PosY3 = diametroY / 2, Posy4 = diametroY + diamepeque * 2,
                Posx3 = (diametroX + diametroY) / 2, posx1 = PosX2 + PosY;
        int radiopeque = diamepeque / 2, x1 = PosX2 + diamepeque, y1 = PosY - radiopeque, y21 = y1 + diamepeque,
                terciodiame = diamepeque / 3, y2 = PosY2 - radiopeque, x12 = PosX + radiopeque;
        super.paint(g);
        ImageIcon imgIcon = new ImageIcon("filosofo.jpg");
        ImageIcon imgEscalada = new ImageIcon(imgIcon.getImage().getScaledInstance((int) (diamepeque * 0.8),
                (int) (diamepeque * 1.2), Image.SCALE_SMOOTH));
        g.setFont(new Font("Dialog", 1, 18));
        {
            g.drawImage(imgEscalada.getImage(), PosX2 - diamepeque, PosY, null);
            g.drawImage(imgEscalada.getImage(), PosX, PosY3 - (int) (diamepeque * 1.3), null);
            g.drawImage(imgEscalada.getImage(), PosX2 + diametroY, PosY, null);
            g.drawImage(imgEscalada.getImage(), Posx3 - diamepeque, Posy4, null);
            g.drawImage(imgEscalada.getImage(), Posx3 + diamepeque, Posy4, null);
        }
        g.setColor(new Color(140, 70, 50));
        g.fillOval(PosX2, PosY3, diametroY, diametroY);// dibuja mesa
        // dibuja platos
        {
            if (comiendo[0])
                g.setColor(new Color(110, 157, 255));
            else
                g.setColor(Color.white);
            g.fillOval(PosX2, PosY, diamepeque, diamepeque);
        }
        {
            if (comiendo[2])
                g.setColor(new Color(110, 157, 255));
            else
                g.setColor(Color.white);
            g.fillOval(posx1, PosY, diamepeque, diamepeque);
        }
        {
            if (comiendo[1])
                g.setColor(new Color(110, 157, 255));
            else
                g.setColor(Color.white);
            g.fillOval(PosX, PosY3, diamepeque, diamepeque);
        }
        {
            if (comiendo[4])
                g.setColor(new Color(110, 157, 255));
            else
                g.setColor(Color.white);
            g.fillOval(PosX - diamepeque, PosY2, diamepeque, diamepeque);
        }
        {
            if (comiendo[3])
                g.setColor(new Color(110, 157, 255));
            else
                g.setColor(Color.white);
            g.fillOval(PosX + diamepeque, PosY2, diamepeque, diamepeque);
        }
        {
            if (tenedores[0])
                g.setColor(new Color(15, 157, 16));
            else
                g.setColor(new Color(153, 157, 167));
            for (int i = 0; i < 15; i++)
                g.drawLine(x1, y1, x1 + radiopeque + i, y21);
        } // tenedor 1
        {
            if (tenedores[1])
                g.setColor(new Color(15, 157, 16));
            else
                g.setColor(new Color(153, 157, 167));
            for (int i = 0; i < 14; i++)
                g.drawLine(posx1 + terciodiame, PosY - terciodiame, posx1 - diamepeque + radiopeque + i, y21);
        } // tenedor 2
        {
            if (tenedores[4])
                g.setColor(new Color(15, 157, 16));
            else
                g.setColor(new Color(153, 157, 167));
            for (int i = 0; i < 15; i++)
                g.drawLine(PosX - diamepeque, PosY2, PosX + i, y2);
        } // tenedor 3
        {
            if (tenedores[2])
                g.setColor(new Color(15, 157, 16));
            else
                g.setColor(new Color(153, 157, 167));
            for (int i = 0; i < 14; i++)
                g.drawLine(PosX + diamepeque * 2, PosY2, PosX + diamepeque + i, y2);
        } // tenedor 4
        {
            if (tenedores[3])
                g.setColor(new Color(15, 157, 16));
            else
                g.setColor(new Color(153, 157, 167));
            for (int i = 0; i < 16; i++)
                g.drawLine(x12, PosY3 + (int) (diamepeque * 3.5), x12 + i, PosY3 + (int) (diamepeque * 2.5));
        } // tenedor 5
    }
}

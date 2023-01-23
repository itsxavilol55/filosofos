public class Filosofo extends Thread
{
    private int numero;
    private Semaforo[] semaforos;
    private boolean tenedores[], comiendo[];
    private canvas vista;
    public Filosofo(
        int num,
        Semaforo[] sema,
        boolean[] tene,
        canvas mycanva,
        boolean[] comiend)
    {
        numero = num;
        semaforos = sema;
        tenedores = tene;
        vista = mycanva;
        comiendo = comiend;
        setName("Filosofo" + num);
    }
    public void run()
    {
        while (true)
        {
            System.out.println(getName() + " intenta levantar el tenedor izquierdo");
            semaforos[numero - 1].Espera();// pone en espera para que solo el filosofo que lo puso en espera cheque el if
            if (tenedores[numero - 1])
            {
                System.out.println(getName() + " no pudo levantar el tenedor izquierdo");
                semaforos[numero - 1].Libera();
                continue;
            }
            tenedores[numero - 1] = true;
            System.out.println(getName() + " levanto el tenedor izquierdo");
            semaforos[numero - 1].Libera();
            vista.repaint();
            try
            {
                sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(getName() + " intenta levantar el tenedor derecho");
            int aux = numero - 2 >= 0 ? numero - 2 : tenedores.length - 1;
            semaforos[aux].Espera();
            if (tenedores[aux])
            {
                System.out.println(getName() + " no pudo levantar el tenedor derecho");
                semaforos[aux].Libera();
                tenedores[numero - 1] = false;
                System.out.println(getName() + " solto el tenedor izquierdo");
                vista.repaint();
                // semaforos[numero - 1].Espera();
                try
                {
                    sleep(1000);
                }
                catch (InterruptedException ee)
                {
                    ee.printStackTrace();
                }
                continue;
            }
            System.out.println(getName() + " levanto el tenedor derecho");
            tenedores[aux] = true;
            semaforos[aux].Libera();
            System.out.println(getName() + " esta comiendo");
            comiendo[numero - 1] = true;
            vista.repaint();
            try
            {
                sleep(1000);
            }
            catch (InterruptedException ee)
            {
                ee.printStackTrace();
            }
            semaforos[numero - 1].Espera();
            semaforos[aux].Espera();
            tenedores[aux] = false;
            tenedores[numero - 1] = false;
            comiendo[numero - 1] = false;
            vista.repaint();
            semaforos[numero - 1].Libera();
            semaforos[aux].Libera();
            System.out.println(getName() + " Libero ambos palillos");
            try
            {
                sleep(2000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}

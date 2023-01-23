public class Semaforo
{
    private int recursos;
    public Semaforo(
        int recursos)
    {
        this.recursos = recursos;
    }
    public synchronized void Espera()
    {
        while (recursos < 1)
        {
            try
            {
                wait();
            }
            catch (Exception e)
            {
            }
        }
        recursos--;
    }
    public synchronized void Libera()
    {
        recursos++;
        notifyAll();
    }
}

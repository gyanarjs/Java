package Interfaces;

public class Nicecar{
    private Engine engine;
    private Media player = new CDPlayer();

    public Nicecar()
    {
        engine = new PowerEngine();
    }

    public Nicecar(Engine engine)
    {
        this.engine = engine;
    }

    public void start()
    {
        engine.start();
    }

    public void startMusic()
    {
        player.start();
    }

    public void upgradeEngine()
    {
        this.engine = new ElectricEngine();
    }

}

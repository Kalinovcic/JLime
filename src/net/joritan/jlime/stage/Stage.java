package net.joritan.jlime.stage;

public abstract class Stage
{
    public final StageManager manager;

    public Stage(Stage parentStage)
    {
        manager = parentStage.manager;
    }

    public abstract void onSelection();
    public abstract void onDeselection();

    public abstract void update(float timeDelta);
    public abstract void render();
}

package net.joritan.jlime.world;

import org.jbox2d.dynamics.World;

public abstract class GameObject
{
    protected final Environment environment;
    protected final World world;

    public GameObject(Environment environment)
    {
        this.environment = environment;
        this.world = environment.world;
    }

    public abstract void update(float timeDelta);
    public abstract void render();
}

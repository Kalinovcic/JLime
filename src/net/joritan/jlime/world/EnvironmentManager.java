package net.joritan.jlime.world;

public interface EnvironmentManager
{
    public void load(Environment environment, Object... args);
    public void save(Environment environment, Object... args);
}

package net.joritan.jlime.world.object.entity.segment;

import org.jbox2d.dynamics.Body;

public abstract class Segment
{
    protected Body body;

    public Body getBody()
    {
        return body;
    }

    public void setLinearDamping(float damping)
    {
        body.setLinearDamping(damping);
    }

    public void setFixedRotation(boolean flag)
    {
        body.setFixedRotation(flag);
    }

    public abstract void update(float timeDelta);
    public abstract void render();
}

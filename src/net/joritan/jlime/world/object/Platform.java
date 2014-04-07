package net.joritan.jlime.world.object;

import net.joritan.jlime.world.Environment;
import net.joritan.jlime.world.GameObject;
import net.joritan.jlime.world.object.segment.PhysicsPolygon;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.*;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

public class Platform extends GameBody
{
    private PhysicsPolygon body;

    private float x1, y1;
    private float x2, y2;

    public Platform(Environment environment, float x1, float y1, float x2, float y2)
    {
        super(environment);

        body = new PhysicsPolygon(world, x1, y1, new Vec2[]
                {
                        new Vec2(0, 0),
                        new Vec2(x2 - x1, y2 - y1),
                        new Vec2(x2 - x1, y2 - y1 - 0.000001f),
                        new Vec2(0, -0.000001f)
                }, 1.0f, 0.3f, 0.0f, false);
    }

    @Override
    public void update(float timeDelta)
    {

    }

    @Override
    public void render()
    {
        body.render();
    }
}

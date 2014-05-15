package net.joritan.jlime.world.gameobject.mask;

import net.joritan.jlime.util.Vector2;
import net.joritan.jlime.world.gameobject.segment.Segment;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

import static org.lwjgl.opengl.GL11.*;

public interface MaskBinding
{
    public Vector2 getPosition();
    public float getRotation();
}

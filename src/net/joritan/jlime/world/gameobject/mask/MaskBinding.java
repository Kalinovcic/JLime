package net.joritan.jlime.world.gameobject.mask;

import net.joritan.jlime.util.Vector2;
import net.joritan.jlime.world.gameobject.segment.Segment;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;

import static org.lwjgl.opengl.GL11.*;

public class MaskBinding
{
    private Segment parent;
    private Mask mask;

    private Vector2 posOffset;
    private float angleOffset;

    public MaskBinding(Mask mask, Segment parent, Vector2 posOffset, float angleOffset)
    {
        this.parent = parent;
        this.mask = mask;

        this.posOffset = posOffset;
        this.angleOffset = angleOffset;
    }

    public void render()
    {
        Body body = parent.getBody();
        Vec2 pos = body.getPosition();
        glTranslatef(pos.x + posOffset.x, pos.y + posOffset.y, 0.0f);
        glRotatef((float) Math.toDegrees(body.getAngle()) + angleOffset, 0.0f, 0.0f, 1.0f);
        mask.render();
    }
}

package net.joritan.jlime.world.object.segment;

import net.joritan.jlime.util.RenderUtil;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.*;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glPopMatrix;

public class PhysicsCircle implements PhysicsSegment, BodySegment
{
    public final Body body;
    public final BodyDef bodyDef;
    public final CircleShape shape;
    public final FixtureDef fixture;

    public PhysicsCircle(World world, float x, float y, float r, float density, float friction, float restitution)
    {
        bodyDef = new BodyDef();
        bodyDef.type = BodyType.DYNAMIC;
        bodyDef.position.set(x, y);

        shape = new CircleShape();
        shape.setRadius(r);

        fixture = new FixtureDef();
        fixture.shape = shape;
        fixture.density = density;
        fixture.friction = friction;
        fixture.restitution = restitution;

        body = world.createBody(bodyDef);
        body.createFixture(fixture);
    }

    @Override
    public Body getBody()
    {
        return body;
    }

    @Override
    public void update(float timeDelta)
    {

    }

    @Override
    public void render()
    {
        Vec2 pos = body.getPosition();
        float angle = body.getAngle();

        glPushMatrix();
        glTranslatef(pos.x, pos.y, 0.0f);
        glRotatef((float) Math.toDegrees(angle), 0, 0, 1);

        RenderUtil.drawCircle(0, 0, shape.getRadius(), 10);

        glPopMatrix();
    }
}

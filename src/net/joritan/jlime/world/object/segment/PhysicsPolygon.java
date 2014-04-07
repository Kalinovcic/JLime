package net.joritan.jlime.world.object.segment;

import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.*;

import static org.lwjgl.opengl.GL11.*;

public class PhysicsPolygon implements PhysicsSegment, BodySegment
{
    public final Body body;
    public final BodyDef bodyDef;
    public final PolygonShape shape;
    public final FixtureDef fixture;

    public PhysicsPolygon(World world, float x, float y, Vec2[] vertices,
                          float density, float friction, float restitution, boolean dynamic)
    {
        bodyDef = new BodyDef();
        bodyDef.type = dynamic ? BodyType.DYNAMIC : BodyType.STATIC;
        bodyDef.position.set(x, y);

        shape = new PolygonShape();
        shape.set(vertices, vertices.length);

        fixture = new FixtureDef();
        fixture.shape = shape;
        fixture.density = density;
        fixture.friction = friction;
        fixture.restitution = restitution;

        body = world.createBody(bodyDef);
        body.createFixture(fixture);
    }

    public PhysicsPolygon(World world, float x, float y, Vec2[] vertices, float density, float friction, float restitution)
    {
        this(world, x, y, vertices, density, friction, restitution, true);
    }

    public PhysicsPolygon(World world, float x, float y, float w, float h, float density, float friction, float restitution)
    {
        this(world, x, y, new Vec2[]
                {
                        new Vec2(0, 0),
                        new Vec2(w, 0),
                        new Vec2(w, h),
                        new Vec2(0, h)
                }, density, friction, restitution, true);
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

        glBegin(GL_LINE_LOOP);
        Vec2[] vertices = shape.getVertices();
        for(Vec2 vertex : vertices)
        {
            glVertex2f(vertex.x, vertex.y);
        }
        glEnd();

        glPopMatrix();
    }
}

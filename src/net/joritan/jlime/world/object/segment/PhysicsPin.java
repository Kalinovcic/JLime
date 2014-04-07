package net.joritan.jlime.world.object.segment;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.joints.Joint;
import org.jbox2d.dynamics.joints.RevoluteJoint;
import org.jbox2d.dynamics.joints.RevoluteJointDef;

public class PhysicsPin implements PhysicsSegment, JointSegment
{
    public final RevoluteJointDef def;
    public final RevoluteJoint pin;

    public PhysicsPin(World world, BodySegment bodyA, BodySegment bodyB, Vec2 anchorA, Vec2 anchorB, boolean collide)
    {
        def = new RevoluteJointDef();
        def.bodyA = bodyA.getBody();
        def.bodyB = bodyB.getBody();
        def.collideConnected = collide;
        def.localAnchorA.set(anchorA);
        def.localAnchorB.set(anchorB);
        pin = (RevoluteJoint) world.createJoint(def);
    }

    @Override
    public Joint getJoint()
    {
        return pin;
    }

    @Override
    public void update(float timeDelta)
    {

    }

    @Override
    public void render()
    {

    }
}

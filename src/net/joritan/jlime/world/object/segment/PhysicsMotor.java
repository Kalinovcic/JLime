package net.joritan.jlime.world.object.segment;

import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.World;
import org.jbox2d.dynamics.joints.Joint;
import org.jbox2d.dynamics.joints.RevoluteJoint;
import org.jbox2d.dynamics.joints.RevoluteJointDef;

public class PhysicsMotor implements PhysicsSegment, JointSegment, MotorSegment
{
    public final RevoluteJointDef def;
    public final RevoluteJoint motor;

    public PhysicsMotor(World world, Body bodyA, Body bodyB, Vec2 anchorA, Vec2 anchorB, float maxTorque, boolean collide)
    {
        def = new RevoluteJointDef();
        def.bodyA = bodyA;
        def.bodyB = bodyB;
        def.collideConnected = collide;
        def.localAnchorA.set(anchorA);
        def.localAnchorB.set(anchorB);
        def.enableMotor = true;
        def.maxMotorTorque = maxTorque;
        motor = (RevoluteJoint) world.createJoint(def);
    }

    @Override
    public Joint getJoint()
    {
        return motor;
    }

    @Override
    public RevoluteJoint getMotor()
    {
        return motor;
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

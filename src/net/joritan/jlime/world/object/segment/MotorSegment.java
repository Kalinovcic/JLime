package net.joritan.jlime.world.object.segment;

import org.jbox2d.dynamics.joints.Joint;
import org.jbox2d.dynamics.joints.RevoluteJoint;

public interface MotorSegment
{
    public RevoluteJoint getMotor();
}

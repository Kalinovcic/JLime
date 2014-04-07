package net.joritan.jlime.world.object.entity.segment.joint;

import org.jbox2d.dynamics.joints.Joint;

public class SegmentJoint
{
    private Joint joint;

    public SegmentJoint(Joint joint)
    {
        this.joint = joint;
    }

    public Joint getJoint()
    {
        return joint;
    }
}

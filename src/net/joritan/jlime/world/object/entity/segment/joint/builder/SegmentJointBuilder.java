package net.joritan.jlime.world.object.entity.segment.joint.builder;

import net.joritan.jlime.world.Environment;
import net.joritan.jlime.world.object.entity.segment.Segment;
import net.joritan.jlime.world.object.entity.segment.joint.SegmentJoint;

public interface SegmentJointBuilder
{
    public SegmentJoint buildSegmentJoint(Environment environment, Segment segmentA, Segment segmentB, Object... args);
}

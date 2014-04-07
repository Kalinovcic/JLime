package net.joritan.jlime.world.object.entity;

import net.joritan.jlime.util.Vector2;
import net.joritan.jlime.world.Environment;
import net.joritan.jlime.world.object.entity.attribute.Bullet;
import net.joritan.jlime.world.object.entity.segment.SegmentType;
import net.joritan.jlime.world.object.entity.segment.joint.SegmentJointType;

public class TE1 extends Entity implements Bullet
{
    public TE1(Environment environment)
    {
        super(environment);

        addSegment("polygon", SegmentType.POLYGON, new Vector2[]
                {
                        new Vector2(0, 0),
                        new Vector2(0, 1),
                        new Vector2(1, 1),
                        new Vector2(1, 0)
                }, 1.0f, 0.3f, 0.0f);
        addSegment("circle", SegmentType.CIRCLE, 0.5f, 1.0f, 0.3f, 0.0f);
        addSegmentJoint("joint1", "polygon", "circle", SegmentJointType.REVOLUTE, new Vector2(0.5f, 0.0f), new Vector2(0.0f, 0.0f));
    }
}

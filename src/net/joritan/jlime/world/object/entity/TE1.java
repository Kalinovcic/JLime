package net.joritan.jlime.world.object.entity;

import net.joritan.jlime.util.Vector2;
import net.joritan.jlime.world.Environment;

public class TE1 extends Entity
{
    public TE1(Environment environment)
    {
        super(environment);
        setBullet(true);

        addSegment("polygon", SegmentType.POLYGON, new Vector2[]
                {
                        new Vector2(0, 0),
                        new Vector2(0, 1),
                        new Vector2(1, 1),
                        new Vector2(1, 0)
                });
        addSegment("circle", SegmentType.CIRCLE, 0.5f);

        addJoint("joint1", "polygon", "circle", ConnectionType.REVOLUTE, new Vector2(0.5f, 0.0f), new Vector2(0.0f, 0.0f));
    }
}

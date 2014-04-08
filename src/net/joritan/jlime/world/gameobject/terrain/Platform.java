package net.joritan.jlime.world.gameobject.terrain;

import net.joritan.jlime.util.Vector2;
import net.joritan.jlime.world.Environment;
import net.joritan.jlime.world.gameobject.segment.SegmentType;

public class Platform extends Terrain
{
    public Platform(Environment environment, float x1, float y1, float x2, float y2)
    {
        super(environment);

        addSegment("body", SegmentType.POLYGON, new Vector2[]
                {
                        new Vector2(0, 0),
                        new Vector2(x2 - x1, y2 - y1),
                        new Vector2(x2 - x1, y2 - y1 - 0.00001f),
                        new Vector2(0, -0.00001f)
                }, 1.0f, 0.3f, 0.0f);
        getSegment("body").setPosition(new Vector2(x1, y1));
    }
}

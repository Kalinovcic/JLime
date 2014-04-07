package net.joritan.jlime.world.object.entity;

import net.joritan.jlime.world.Environment;

import java.util.HashMap;
import java.util.Map;

public class Entity
{
    private Environment environment;
    private Map<String, Segment> segments;

    public Entity(Environment environment)
    {
        this.environment = environment;
        segments = new HashMap<String, Segment>();
    }

    protected void setBullet(boolean flag)
    {

    }

    protected void addSegment(String name, SegmentType type, Object... args)
    {
        switch(type)
        {
        case POLYGON:
            segments.put(name, new SegmentPolygon(environment, args));
            break;
        case CIRCLE:
            segments.put(name, new SegmentCircle(environment, args));
            break;
        }
    }

    protected void addJoint(String name, String aName, String bName, ConnectionType type, Object... args)
    {

    }
}

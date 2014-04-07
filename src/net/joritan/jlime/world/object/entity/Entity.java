package net.joritan.jlime.world.object.entity;

import net.joritan.jlime.world.Environment;
import net.joritan.jlime.world.object.entity.attribute.Bullet;
import net.joritan.jlime.world.object.entity.segment.Segment;
import net.joritan.jlime.world.object.entity.segment.SegmentType;
import net.joritan.jlime.world.object.entity.segment.builder.SegmentBuilder;
import net.joritan.jlime.world.object.entity.segment.builder.SegmentBuilderCircle;
import net.joritan.jlime.world.object.entity.segment.builder.SegmentBuilderPolygon;
import net.joritan.jlime.world.object.entity.segment.joint.SegmentJointType;
import net.joritan.jlime.world.object.entity.segment.joint.SegmentJoint;
import net.joritan.jlime.world.object.entity.segment.joint.builder.SegmentJointBuilder;
import net.joritan.jlime.world.object.entity.segment.joint.builder.SegmentJointBuilderRevolute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Entity
{
    private static final SegmentBuilder[] segmentBuilders;
    static
    {
        segmentBuilders = new SegmentBuilder[SegmentType.values().length];
        segmentBuilders[SegmentType.POLYGON.ordinal()] = new SegmentBuilderPolygon();
        segmentBuilders[SegmentType.CIRCLE.ordinal()] = new SegmentBuilderCircle();
    }

    private static final SegmentJointBuilder[] segmentJointBuilders;
    static
    {
        segmentJointBuilders = new SegmentJointBuilder[SegmentJointType.values().length];
        segmentJointBuilders[SegmentJointType.REVOLUTE.ordinal()] = new SegmentJointBuilderRevolute();
    }

    private Environment environment;
    private Map<String, Segment> segments;
    private Map<String, SegmentJoint> joints;

    public Entity(Environment environment)
    {
        this.environment = environment;
        segments = new HashMap<String, Segment>();
        joints = new HashMap<String, SegmentJoint>();
    }

    protected void addSegment(String name, SegmentType type, Object... args)
    {
        segments.put(name, segmentBuilders[type.ordinal()].buildSegment(environment, args));
        segments.get(name).getBody().setUserData(this);
        if (this instanceof Bullet)
            segments.get(name).getBody().setBullet(true);
    }

    protected void addSegmentJoint(String name, String aName, String bName, SegmentJointType type, Object... args)
    {
        joints.put(name, segmentJointBuilders[type.ordinal()].buildSegmentJoint(environment,
                segments.get(aName), segments.get(bName), args));
    }

    public void update(float timeDelta)
    {
        List<Segment> segmentList = new ArrayList<Segment>(segments.values());
        for(Segment segment : segmentList)
            segment.update(timeDelta);
    }

    public void render()
    {
        List<Segment> segmentList = new ArrayList<Segment>(segments.values());
        for(Segment segment : segmentList)
            segment.render();
    }
}

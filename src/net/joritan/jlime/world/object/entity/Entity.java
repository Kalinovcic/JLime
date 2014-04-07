package net.joritan.jlime.world.object.entity;

import net.joritan.jlime.util.Vector2;
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
import org.jbox2d.common.Vec2;

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

    protected final Environment environment;

    private Map<String, Segment> segments;
    private Map<String, SegmentJoint> joints;

    private Segment centerSegment;

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

    public Segment getSegment(String name)
    {
        return segments.get(name);
    }

    public SegmentJoint getSegmentJoint(String name)
    {
        return joints.get(name);
    }

    public void setCenterSegment(String name)
    {
        this.centerSegment = segments.get(name);
    }

    public void setTransform(Vector2 position, float angle)
    {
        centerSegment.getBody().setTransform(new Vec2(position.x, position.y), angle);
    }

    public Vector2 getPosition()
    {
        return new Vector2(centerSegment.getBody().getPosition());
    }

    public void setPosition(Vector2 position)
    {
        setTransform(position, getAngle());
    }

    public float getAngle()
    {
        return centerSegment.getBody().getAngle();
    }

    public void setAngle(float angle)
    {
        setTransform(getPosition(), angle);
    }

    public Vector2 getLinearVelocity()
    {
        return new Vector2(centerSegment.getBody().getLinearVelocity());
    }

    public void setLinearVelocity(Vector2 velocity)
    {
        centerSegment.getBody().setLinearVelocity(new Vec2(velocity.x, velocity.y));
    }

    public float getAngularVelocity()
    {
        return centerSegment.getBody().getAngularVelocity();
    }

    public void setAngularVelocity(float velocity)
    {
        centerSegment.getBody().setAngularVelocity(velocity);
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

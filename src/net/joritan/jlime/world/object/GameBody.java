package net.joritan.jlime.world.object;

import net.joritan.jlime.world.Environment;
import net.joritan.jlime.world.GameObject;
import net.joritan.jlime.world.object.segment.BodySegment;
import net.joritan.jlime.world.object.segment.JointSegment;
import net.joritan.jlime.world.object.segment.MotorSegment;
import net.joritan.jlime.world.object.segment.PhysicsSegment;
import org.jbox2d.dynamics.Body;
import org.jbox2d.dynamics.joints.Joint;
import org.jbox2d.dynamics.joints.RevoluteJoint;

import java.util.*;

public abstract class GameBody extends GameObject
{
    protected Map<String, PhysicsSegment> segments;

    public GameBody(Environment environment)
    {
        super(environment);
        segments = new HashMap<String, PhysicsSegment>();
    }

    protected void addSegment(String name, PhysicsSegment segment)
    {
        segments.put(name, segment);
    }

    protected PhysicsSegment getSegment(String name)
    {
        return segments.get(name);
    }

    protected Body getBody(String name)
    {
        return ((BodySegment) segments.get(name)).getBody();
    }

    protected Joint getJoint(String name)
    {
        return ((JointSegment) segments.get(name)).getJoint();
    }

    protected RevoluteJoint getMotor(String name)
    {
        return ((MotorSegment) segments.get(name)).getMotor();
    }

    @Override
    public void update(float timeDelta)
    {
        List<PhysicsSegment> segmentList = new ArrayList<PhysicsSegment>(segments.values());
        for(PhysicsSegment segment : segmentList)
            segment.update(timeDelta);
    }

    @Override
    public void render()
    {
        List<PhysicsSegment> segmentList = new ArrayList<PhysicsSegment>(segments.values());
        for(PhysicsSegment segment : segmentList)
            segment.render();
    }
}

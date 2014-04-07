package net.joritan.jlime.world.object.entity;

import net.joritan.jlime.util.Input;
import net.joritan.jlime.util.Vector2;
import net.joritan.jlime.world.Camera;
import net.joritan.jlime.world.Environment;
import net.joritan.jlime.world.object.entity.attribute.Bullet;
import net.joritan.jlime.world.object.entity.segment.SegmentType;
import net.joritan.jlime.world.object.entity.segment.joint.SegmentJointType;
import org.jbox2d.common.Vec2;

public class TE1 extends Entity
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
        addSegmentJoint("motor", "polygon", "circle", SegmentJointType.REVOLUTE,
                new Vector2(0.5f, 0.0f), new Vector2(0.0f, 0.0f), 100.0f);

        setCenterSegment("polygon");

        setAngle(0.0f);
        getSegment("polygon").setLinearDamping(0.3f);
        getSegment("circle").setLinearDamping(0.3f);

        getSegment("polygon").setFixedRotation(true);
    }

    @Override
    public void update(float timeDelta)
    {
        super.update(timeDelta);
        getSegmentJoint("motor").setMotorSpeed(0);
        if(Input.getKey(Input.KEY_A))
            getSegmentJoint("motor").setMotorSpeed(15);
        if(Input.getKey(Input.KEY_D))
            getSegmentJoint("motor").setMotorSpeed(-15);

        if(Input.getKeyDown(Input.KEY_W))
            setLinearVelocity(getLinearVelocity().add(new Vector2(0.0f, 20.0f)));
        if(Input.getKeyDown(Input.KEY_S))
            setLinearVelocity(getLinearVelocity().add(new Vector2(0.0f, -50.0f)));

        if(Input.getKeyDown(Input.KEY_SPACE))
        {
            setLinearVelocity(new Vector2(0.0f, 0.0f));
            setAngularVelocity(0.0f);
            setTransform(new Vector2(0.0f, 0.0f), 0.0f);
        }

        Vector2 cameraPos = getPosition();
        environment.camera = new Camera(cameraPos.x - 10 + 1, cameraPos.y - 10, cameraPos.x + 10 + 1, cameraPos.y + 10);
    }
}

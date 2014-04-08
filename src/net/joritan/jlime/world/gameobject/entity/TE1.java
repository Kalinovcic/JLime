package net.joritan.jlime.world.gameobject.entity;

import net.joritan.jlime.util.Input;
import net.joritan.jlime.util.Vector2;
import net.joritan.jlime.world.Camera;
import net.joritan.jlime.world.Environment;
import net.joritan.jlime.world.gameobject.segment.SegmentType;
import net.joritan.jlime.world.gameobject.segment.joint.SegmentJointType;

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

        getSegment("polygon").setLinearDamping(0.3f);
        getSegment("circle").setLinearDamping(0.3f);

        getSegment("polygon").setTransform(new Vector2(0.0f, 0.0f), 0.0f);
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
            getSegment("polygon").setLinearVelocity(getSegment("polygon").getLinearVelocity().add(new Vector2(0.0f, 20.0f)));
        if(Input.getKeyDown(Input.KEY_S))
            getSegment("polygon").setLinearVelocity(getSegment("polygon").getLinearVelocity().add(new Vector2(0.0f, -50.0f)));

        if(Input.getKeyDown(Input.KEY_SPACE))
        {
            getSegment("polygon").setLinearVelocity(new Vector2(0.0f, 0.0f));
            getSegment("polygon").setAngularVelocity(0.0f);
            getSegment("polygon").setTransform(new Vector2(0.0f, 0.0f), 0.0f);
        }

        Vector2 cameraPos = getSegment("polygon").getPosition();
        environment.camera = new Camera(cameraPos.x - 10 + 1, cameraPos.y - 10, cameraPos.x + 10 + 1, cameraPos.y + 10);
    }
}

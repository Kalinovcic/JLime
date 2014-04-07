package net.joritan.jlime.world.object;

import net.joritan.jlime.util.Input;
import net.joritan.jlime.util.Texture;
import net.joritan.jlime.world.Camera;
import net.joritan.jlime.world.Environment;
import net.joritan.jlime.world.object.mask.Mask;
import net.joritan.jlime.world.object.segment.PhysicsCircle;
import net.joritan.jlime.world.object.segment.PhysicsMotor;
import net.joritan.jlime.world.object.segment.PhysicsPolygon;
import org.jbox2d.common.Vec2;

public class Player extends GameBody
{
    public Player(Environment environment, float x, float y)
    {
        super(environment);

        addSegment("mainBody", new PhysicsPolygon(world, x, y, 1.0f, 1.0f, 1.0f, 0.1f, 0.0f));
        addSegment("circleBody", new PhysicsCircle(world, x, y, 0.5f, 1.0f, 0.1f, 0.1f));

        addSegment("motor", new PhysicsMotor(world, getBody("mainBody"), getBody("circleBody"),
                                             new Vec2(0.5f, 0.0f), new Vec2(0.0f, 0.0f), 100, false));

        getBody("mainBody").setLinearDamping(0.3f);
        getBody("circleBody").setLinearDamping(0.3f);

        getBody("mainBody").setTransform(getBody("mainBody").getPosition(), 0);
        getBody("mainBody").setFixedRotation(true);
    }

    @Override
    public void update(float timeDelta)
    {
        super.update(timeDelta);
        getMotor("motor").setMotorSpeed(0);
        if(Input.getKey(Input.KEY_A))
            getMotor("motor").setMotorSpeed(15);
        if(Input.getKey(Input.KEY_D))
            getMotor("motor").setMotorSpeed(-15);

        if(Input.getKeyDown(Input.KEY_W))
            getBody("mainBody").getLinearVelocity().addLocal(0, 20f);
        if(Input.getKeyDown(Input.KEY_S))
            getBody("mainBody").getLinearVelocity().addLocal(0, -50f);

        if(Input.getKeyDown(Input.KEY_SPACE))
        {
            getBody("mainBody").setLinearVelocity(new Vec2(0.0f, 0.0f));
            getBody("mainBody").setAngularVelocity(0.0f);
            getBody("mainBody").setTransform(new Vec2(0.0f, 0.0f), 0);
        }

        Vec2 cameraPos = getBody("circleBody").getPosition();
        environment.camera = new Camera(cameraPos.x - 10 + 1, cameraPos.y - 10, cameraPos.x + 10 + 1, cameraPos.y + 10);
    }

    @Override
    public void render()
    {
        super.render();
    }
}

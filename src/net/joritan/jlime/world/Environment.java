package net.joritan.jlime.world;

import net.joritan.jlime.util.Input;
import net.joritan.jlime.util.Texture;
import net.joritan.jlime.world.object.Platform;
import net.joritan.jlime.world.object.Player;
import net.joritan.jlime.world.object.mask.Mask;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.World;

import java.util.HashSet;
import java.util.Set;

import static org.lwjgl.opengl.GL11.*;

public class Environment
{
    public static final int velocityIterations = 6;
    public static final int positionIterations = 2;

    public final World world;
    public Camera camera;

    private Set<Mask> masks;
    private Set<GameObject> objects;

    public Environment()
    {
        world = new World(new Vec2(0, -16));
        world.setSleepingAllowed(true);

        camera = new Camera(-65, -65, 65, 65);
        objects = new HashSet<GameObject>();
        masks = new HashSet<Mask>();

        addObject(new Player(this, 0, 10));
        TEMP_addPlatform(-10, -10, 10, -10);
        TEMP_addPlatform(-10, -10, -15, -9);
        TEMP_addPlatform(10, -10, 15, -9);
        TEMP_addPlatform(15, -9, 20, -7);
        TEMP_addPlatform(20, -7, 25, -4);
        TEMP_addPlatform(25, -4, 30, 0);
        TEMP_addPlatform(30, 0, 35, 5);
        TEMP_addPlatform(35, 5, 40, 11);
        TEMP_addPlatform(40, 11, 45, 17);
        TEMP_addPlatform(45, 17, 50, 24);
        TEMP_addPlatform(50, 24, 55, 32);
        TEMP_addPlatform(55, 32, 60, 41);
        TEMP_addPlatform(60, 41, 65, 51);
        TEMP_addPlatform(-10, -10, -15, -9);
        TEMP_addPlatform(-15, -9, -20, -7);
        TEMP_addPlatform(-20, -7, -25, -4);
        TEMP_addPlatform(-25, -4, -30, 0);
        TEMP_addPlatform(-30, 0, -35, 5);
        TEMP_addPlatform(-35, 5, -40, 11);
        TEMP_addPlatform(-40, 11, -45, 17);
        TEMP_addPlatform(-45, 17, -50, 24);
        TEMP_addPlatform(-50, 24, -55, 32);
        TEMP_addPlatform(-55, 32, -60, 41);
        TEMP_addPlatform(-60, 41, -65, 51);
        //TEMP_addPlatform(65, 51, -65, 51);
    }

    private void TEMP_addPlatform(float x1, float y1, float x2, float y2)
    {
        addObject(new Platform(this, x1, y1, x2, y2));
        addMask(new Mask(Texture.getTexture("dirt"),
                new Vec2[] {new Vec2(x1, y1), new Vec2(x2, y2), new Vec2(x2, y2 - 50.0f), new Vec2(x1, y1 - 50.0f)},
                new Vec2(0.0f, 0.0f), 0.0f));
    }

    public void addObject(GameObject object)
    {
        objects.add(object);
    }

    public void removeObject(GameObject object)
    {
        objects.remove(object);
    }

    public void addMask(Mask mask)
    {
        masks.add(mask);
    }

    public void removeMask(Mask mask)
    {
        masks.remove(mask);
    }

    public void update(float timeDelta)
    {
        for(GameObject object : objects)
            object.update(timeDelta);
        for(Mask mask : masks)
            mask.update(timeDelta);
        Input.update();
        world.step(timeDelta, velocityIterations, positionIterations);
    }

    public void render()
    {
        camera.moveCamera();
        for(GameObject object : objects)
        {
            glPushMatrix();
            object.render();
            glPopMatrix();
        }
        for(Mask mask : masks)
        {
            glPushMatrix();
            mask.render();
            glPopMatrix();
        }
    }

    public void destroy()
    {

    }
}

package net.joritan.jlime;

import net.joritan.jlime.util.Texture;
import net.joritan.jlime.util.Timer;
import net.joritan.jlime.world.Environment;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import static org.lwjgl.opengl.GL11.*;

public class JLimeStart
{
    public static final int FPS = 60;

    public static void create()
    {
        try
        {
            Display.setDisplayMode(new DisplayMode(500, 500));
            Display.setTitle("Lime");
            Display.create();
            Keyboard.create();
            Mouse.create();
        }
        catch(LWJGLException e)
        {
            e.printStackTrace();
        }
    }

    public static void run()
    {
        Texture.addTexture("dirt", new Texture("res/dirt2.png"));

        Environment environment = new Environment();

        Timer timer = new Timer();
        timer.reset();

        int frames = 0;
        long t1 = System.currentTimeMillis();
        while (!Display.isCloseRequested())
        {
            long t2 = System.currentTimeMillis();
            if ((t2 - t1) >= 1000)
            {
                System.out.println("FPS: " + frames);
                frames = 0;
                t1 = t2;
            }
            glClear(GL_COLOR_BUFFER_BIT);
            glLoadIdentity();

            float delta = timer.update();
            environment.update(delta);
            environment.render();

            Display.update();
            //Display.sync(FPS);
            frames++;
        }

        environment.destroy();

        Texture.getTexture("dirt").unload();
        Texture.removeTexture("dirt");
    }

    public static void destroy()
    {
        Mouse.destroy();
        Keyboard.destroy();
        Display.destroy();
    }

    public static void main(String[] args)
    {
        create();
        run();
        destroy();
    }
}

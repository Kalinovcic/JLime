package net.joritan.jlime;

import net.joritan.jlime.stage.StageManager;
import net.joritan.jlime.stage.singleplayer.SingleplayerStage;
import net.joritan.jlime.util.Texture;
import net.joritan.jlime.util.Timer;
import net.joritan.jlime.stage.singleplayer.world.Environment;
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
            Display.setDisplayMode(new DisplayMode(600, 600));
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
        StageManager manager = new StageManager();
        manager.push(new SingleplayerStage(null, manager));

        Timer timer = new Timer();
        timer.reset();

        int frames = 0;
        long t1 = System.currentTimeMillis();
        while ((!Display.isCloseRequested()) && (!manager.hasStages()))
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
            manager.update(delta);
            manager.render();

            Display.update();
            Display.sync(FPS);
            frames++;
        }
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

package net.joritan.jlime.world;

import net.joritan.jlime.util.Vector2;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;

public class Camera
{
    private Vector2 camNW;
    private Vector2 camSE;
    private Rectangle.Float cameraRect;

    public Camera(float nwX, float nwY, float seX, float seY)
    {
        camNW = new Vector2(nwX, nwY);
        camSE = new Vector2(seX, seY);
    }

    public void moveCamera()
    {
        glOrtho(camNW.x, camSE.x, camNW.y, camSE.y, -1, 1);
        cameraRect = new Rectangle.Float(camNW.x, camNW.y, camSE.x - camNW.x, camSE.y - camNW.y);
    }

    public boolean onScreen(float nwX, float nwY, float seX, float seY)
    {
        return cameraRect.intersects(nwX, nwY, seX - nwX, seY - nwY);
    }
}

package net.joritan.jlime.util;

import static org.lwjgl.opengl.GL11.*;

public class RenderUtil
{
    public static void drawCircle(float cx, float cy, float r, int num_segments)
    {
        float theta = 2 * 3.1415926f / num_segments;
        float tangetial_factor = (float) Math.tan(theta);
        float radial_factor = (float) Math.cos(theta);

        float x = r;
        float y = 0;

        glBegin(GL_LINE_LOOP);
        for(int ii = 0; ii < num_segments; ii++)
        {
            glVertex2f(x + cx, y + cy);

            float tx = -y;
            float ty = x;
            x += tx * tangetial_factor;
            y += ty * tangetial_factor;
            x *= radial_factor;
            y *= radial_factor;
        }
        glEnd();
    }

    public static void drawArc(float cx, float cy, float r, float start_angle, float arc_angle, int num_segments)
    {
        float theta = arc_angle / (num_segments - 1);
        float tangetial_factor = (float) Math.tan(theta);
        float radial_factor = (float) Math.cos(theta);

        float x = r * (float) Math.cos(start_angle);
        float y = r * (float) Math.sin(start_angle);

        glBegin(GL_LINE_STRIP);
        for(int ii = 0; ii < num_segments; ii++)
        {
            glVertex2f(x + cx, y + cy);

            float tx = -y;
            float ty = x;
            x += tx * tangetial_factor;
            y += ty * tangetial_factor;
            x *= radial_factor;
            y *= radial_factor;
        }
        glEnd();
    }

    public static int getNumCircleSegments(float r)
    {
        return (int) (10 * Math.sqrt(r));
    }
}

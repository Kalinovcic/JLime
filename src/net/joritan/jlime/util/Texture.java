package net.joritan.jlime.util;

import org.lwjgl.BufferUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;

public class Texture
{
    private static final Map<String, Texture> loadedTextures;
    static
    {
        loadedTextures = new HashMap<String, Texture>();
    }

    public static void addTexture(String name, Texture texture)
    {
        loadedTextures.put(name, texture);
    }

    public static Texture getTexture(String name)
    {
        return loadedTextures.get(name);
    }

    public static void removeTexture(String name)
    {
        loadedTextures.remove(name);
    }

    private int id;

    public Texture(String filename)
    {
        loadTexture(filename);
    }

    public void bind()
    {
        glBindTexture(GL_TEXTURE_2D, id);
    }

    public void unload()
    {
        glDeleteBuffers(id);
    }

    private void loadTexture(String fileName)
    {
        try
        {
            BufferedImage image = ImageIO.read(new File(fileName));
            int[] pixels = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());

            ByteBuffer buffer = BufferUtils.createByteBuffer(image.getHeight() * image.getWidth() * 4);
            boolean hasAlpha = image.getColorModel().hasAlpha();

            for(int y = 0; y < image.getHeight(); y++)
            {
                for(int x = 0; x < image.getWidth(); x++)
                {
                    int pixel = pixels[y * image.getWidth() + x];

                    buffer.put((byte)((pixel >> 16) & 0xFF));
                    buffer.put((byte)((pixel >> 8) & 0xFF));
                    buffer.put((byte)((pixel) & 0xFF));
                    if(hasAlpha)
                        buffer.put((byte)((pixel >> 24) & 0xFF));
                    else
                        buffer.put((byte)(0xFF));
                }
            }

            buffer.flip();

            id = glGenTextures();
            glBindTexture(GL_TEXTURE_2D, id);

            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
            glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);

            glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
            glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);

            glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, image.getWidth(), image.getHeight(), 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);

            glBindTexture(GL_TEXTURE_2D, 0);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

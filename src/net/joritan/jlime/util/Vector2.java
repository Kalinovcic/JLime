package net.joritan.jlime.util;

import org.jbox2d.common.Vec2;

public class Vector2
{
    public float x;
    public float y;

    public Vector2()
    {
        x = y = 0;
    }

    public Vector2(float v)
    {
        x = y = v;
    }

    public Vector2(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public Vector2(Vec2 v)
    {
        x = v.x;
        y = v.y;
    }

    public static Vector2 add(Vector2 v1, float v2)
    {
        return new Vector2(v1.x + v2, v1.y + v2);
    }

    public static Vector2 add(Vector2 v1, Vector2 v2)
    {
        return new Vector2(v1.x + v2.x, v1.y + v2.y);
    }

    public Vector2 add(float v)
    {
        return new Vector2(x + v, y + v);
    }

    public Vector2 add(Vector2 v)
    {
        return new Vector2(x + v.x, y + v.y);
    }

    public void addLocal(float v)
    {
        x += v;
        y += v;
    }

    public void addLocal(Vector2 v)
    {
        x += v.x;
        y += v.y;
    }

    public static Vector2 sub(Vector2 v1, float v2)
    {
        return new Vector2(v1.x - v2, v1.y - v2);
    }

    public static Vector2 sub(Vector2 v1, Vector2 v2)
    {
        return new Vector2(v1.x - v2.x, v1.y - v2.y);
    }

    public Vector2 sub(float v)
    {
        return new Vector2(x - v, y - v);
    }

    public Vector2 sub(Vector2 v)
    {
        return new Vector2(x - v.x, y - v.y);
    }

    public void subLocal(float v)
    {
        x -= v;
        y -= v;
    }

    public void subLocal(Vector2 v)
    {
        x -= v.x;
        y -= v.y;
    }

    public static Vector2 mul(Vector2 v1, float v2)
    {
        return new Vector2(v1.x * v2, v1.y * v2);
    }

    public static Vector2 mul(Vector2 v1, Vector2 v2)
    {
        return new Vector2(v1.x * v2.x, v1.y * v2.y);
    }

    public Vector2 mul(float v)
    {
        return new Vector2(x * v, y * v);
    }

    public Vector2 mul(Vector2 v)
    {
        return new Vector2(x * v.x, y * v.y);
    }

    public void mulLocal(float v)
    {
        x *= v;
        y *= v;
    }

    public void mulLocal(Vector2 v)
    {
        x *= v.x;
        y *= v.y;
    }

    public static Vector2 div(Vector2 v1, float v2)
    {
        return new Vector2(v1.x / v2, v1.y / v2);
    }

    public static Vector2 div(Vector2 v1, Vector2 v2)
    {
        return new Vector2(v1.x / v2.x, v1.y / v2.y);
    }

    public Vector2 div(float v)
    {
        return new Vector2(x / v, y / v);
    }

    public Vector2 div(Vector2 v)
    {
        return new Vector2(x / v.x, y / v.y);
    }

    public void divLocal(float v)
    {
        x /= v;
        y /= v;
    }

    public void divLocal(Vector2 v)
    {
        x /= v.x;
        y /= v.y;
    }

    public static Vector2 abs(Vector2 v)
    {
        return new Vector2(v.x < 0 ? -v.x : v.x, v.y < 0 ? -v.y : v.y);
    }

    public Vector2 abs()
    {
        return new Vector2(x < 0 ? -x : x, y < 0 ? -y : y);
    }

    public void absLocal()
    {
        x = x < 0 ? -x : x;
        y = y < 0 ? -y : y;
    }

    public static Vector2 neg(Vector2 v)
    {
        return new Vector2(-v.x, -v.y);
    }

    public Vector2 neg()
    {
        return new Vector2(-x, -y);
    }

    public void negLocal()
    {
        x = -x;
        y = -y;
    }

    public static float magnitude(Vector2 v)
    {
        return (float) Math.sqrt(v.x * v.x + v.y * v.y);
    }

    public static float magnitude(Vector2 v, Vector2 o)
    {
        float dx = v.x - o.x;
        float dy = v.y - o.y;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    public float magnitudeLocal()
    {
        return (float) Math.sqrt(x * x + y * y);
    }

    public float magnitudeLocal(Vector2 o)
    {
        float dx = x - o.x;
        float dy = y - o.y;
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    public static Vector2 normalize(Vector2 v)
    {
        float a = magnitude(v);
        return new Vector2(v.x / a, v.y / a);
    }

    public Vector2 normalize()
    {
        float a = magnitudeLocal();
        return new Vector2(x / a, y / a);
    }

    public void normalizeLocal()
    {
        float a = magnitudeLocal();
        x /= a;
        y /= a;
    }

    public static float dist(Vector2 v1, Vector2 v2)
    {
        return v2.sub(v1).magnitudeLocal();
    }

    public float dist(Vector2 v)
    {
        return sub(v).magnitudeLocal();
    }

    public static Vector2 rotate(Vector2 v, float a)
    {
        float cos = (float) Math.cos(a);
        float sin = -(float) Math.sin(a);
        float nx = v.x * cos - v.y * sin;
        float ny = v.x * sin + v.y * cos;
        return new Vector2(nx, ny);
    }

    public static Vector2 rotateDeg(Vector2 v, float a)
    {
        return rotate(v, (float) Math.toRadians(a));
    }

    public Vector2 rotate(float a)
    {
        float cos = (float) Math.cos(a);
        float sin = -(float) Math.sin(a);
        float nx = x * cos - y * sin;
        float ny = x * sin + y * cos;
        return new Vector2(nx, ny);
    }

    public Vector2 rotateDeg(float a)
    {
        return rotate((float) Math.toRadians(a));
    }

    public void rotateLocal(float a)
    {
        float cos = (float) Math.cos(a);
        float sin = -(float) Math.sin(a);
        float nx = x * cos - y * sin;
        float ny = x * sin + y * cos;
        x = nx;
        y = ny;
    }

    public void rotateLocalDeg(float a)
    {
        rotateLocal((float) Math.toRadians(a));
    }

    public static Vector2 rotateAround(Vector2 c, Vector2 v, float a)
    {
        Vector2 v2 = v.clone();
        v2.subLocal(c);
        v2.rotateLocal(a);
        v2.addLocal(c);
        return v2;
    }

    public static Vector2 rotateAroundDeg(Vector2 c, Vector2 v, float a)
    {
        return rotateAround(c, v, (float) Math.toRadians(a));
    }

    public Vector2 rotateAround(Vector2 c, float a)
    {
        Vector2 v = clone();
        v.subLocal(c);
        v.rotateLocal(a);
        v.addLocal(c);
        return v;
    }

    public Vector2 rotateAroundDeg(Vector2 c, float a)
    {
        return rotateAround(c, (float) Math.toRadians(a));
    }

    public void rotateAroundLocal(Vector2 c, float a)
    {
        subLocal(c);
        rotateLocal(a);
        addLocal(c);
    }

    public void rotateAroundLocalDeg(Vector2 c, float a)
    {
        rotateAroundLocal(c, (float) Math.toRadians(a));
    }

    public static float angle(Vector2 v)
    {
        return (float) Math.atan2(v.x, v.y);
    }

    public static float angleDeg(Vector2 v)
    {
        return (float) Math.toDegrees(Math.atan2(v.x, v.y));
    }

    public float angle()
    {
        return (float) Math.atan2(x, y);
    }

    public float angleDeg()
    {
        return (float) Math.toDegrees(Math.atan2(x, y));
    }

    public static Vector2 floor(Vector2 v)
    {
        return new Vector2((float) Math.floor(v.x), (float) Math.floor(v.y));
    }

    public Vector2 floor()
    {
        return new Vector2((float) Math.floor(x), (float) Math.floor(y));
    }

    public void floorLocal()
    {
        x = (float) Math.floor(x);
        y = (float) Math.floor(y);
    }

    public static Vector2 ceil(Vector2 v)
    {
        return new Vector2((float) Math.ceil(v.x), (float) Math.ceil(v.y));
    }

    public Vector2 ceil()
    {
        return new Vector2((float) Math.ceil(x), (float) Math.ceil(y));
    }

    public void ceilLocal()
    {
        x = (float) Math.ceil(x);
        y = (float) Math.ceil(y);
    }

    public static Vector2 round(Vector2 v)
    {
        return new Vector2(Math.round(v.x), Math.round(v.y));
    }

    public Vector2 round()
    {
        return new Vector2(Math.round(x), Math.round(y));
    }

    public void roundLocal()
    {
        x = Math.round(x);
        y = Math.round(y);
    }

    public static float getX(Vector2 v)
    {
        return v.x;
    }

    public float getX()
    {
        return x;
    }

    public static float getY(Vector2 v)
    {
        return v.y;
    }

    public float getY()
    {
        return y;
    }

    @Override
    public Vector2 clone()
    {
        return new Vector2(x, y);
    }

    @Override
    public String toString()
    {
        return "(" + x + " " + y + ")";
    }
}

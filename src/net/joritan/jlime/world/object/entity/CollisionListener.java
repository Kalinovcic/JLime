package net.joritan.jlime.world.object.entity;

import net.joritan.jlime.world.GameObject;

public interface CollisionListener
{
    public void onCollisionStart(GameObject collidingObject);
    public void onCollisionEnd(GameObject collidingObject);
}

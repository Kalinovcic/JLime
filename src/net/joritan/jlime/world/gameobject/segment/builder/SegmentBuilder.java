package net.joritan.jlime.world.gameobject.segment.builder;

import net.joritan.jlime.world.Environment;
import net.joritan.jlime.world.gameobject.segment.Segment;

public interface SegmentBuilder
{
    public Segment buildSegment(Environment environment, Object... args);
}

package net.joritan.jlime.world.object.entity.segment.builder;

import net.joritan.jlime.world.Environment;
import net.joritan.jlime.world.object.entity.segment.Segment;

public interface SegmentBuilder
{
    public Segment buildSegment(Environment environment, Object... args);
}

package net.joritan.jlime.world.gameobject.segment.builder;

import net.joritan.jlime.world.Environment;
import net.joritan.jlime.world.gameobject.segment.Segment;
import net.joritan.jlime.world.gameobject.segment.SegmentCircle;

public class SegmentBuilderCircle implements SegmentBuilder
{
    private boolean isDynamic;

    public SegmentBuilderCircle(boolean isDynamic)
    {
        this.isDynamic = isDynamic;
    }

    @Override
    public Segment buildSegment(Environment environment, Object... args)
    {
        return new SegmentCircle(environment, isDynamic, args);
    }
}

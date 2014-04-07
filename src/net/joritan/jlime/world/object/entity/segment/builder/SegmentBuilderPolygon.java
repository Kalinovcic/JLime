package net.joritan.jlime.world.object.entity.segment.builder;

import net.joritan.jlime.world.Environment;
import net.joritan.jlime.world.object.entity.segment.Segment;
import net.joritan.jlime.world.object.entity.segment.SegmentPolygon;

public class SegmentBuilderPolygon implements SegmentBuilder
{
    @Override
    public Segment buildSegment(Environment environment, Object... args)
    {
        return new SegmentPolygon(environment, args);
    }
}

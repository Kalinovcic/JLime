package net.joritan.jlime.stage;

import java.util.Stack;

public final class StageManager
{
    private Stack<Stage> stack = new Stack<Stage>();

    public void push(Stage stage)
    {
        stack.push(stage);
        stage.onSelection();
    }

    public void pop()
    {
        Stage stage = stack.pop();
        stage.onDeselection();
    }

    public boolean hasStages()
    {
        return stack.isEmpty();
    }

    public void update(float timeDelta)
    {
        stack.peek().update(timeDelta);
    }

    public void render()
    {
        stack.peek().render();
    }
}

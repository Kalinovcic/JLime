package net.joritan.jlime.stage;

import java.util.Stack;

public final class StageManager
{
    private Stack<Stage> stack = new Stack<Stage>();

    public void push(Stage stage)
    {
        if(!stack.isEmpty()) stack.peek().onDeselection();
        stack.push(stage);
        stage.onCreation();
        stage.onSelection();
    }

    public void pop()
    {
        Stage stage = stack.pop();
        stage.onDeselection();
        stage.onDestruction();
        if(!stack.isEmpty()) stack.peek().onSelection();
    }

    public boolean hasStages()
    {
        return stack.isEmpty();
    }

    public void update(float timeDelta)
    {
        if(stack.isEmpty()) return;
        stack.peek().manageUpdate(timeDelta);
    }

    public void render()
    {
        if(stack.isEmpty()) return;
        stack.peek().manageRender();
    }
}

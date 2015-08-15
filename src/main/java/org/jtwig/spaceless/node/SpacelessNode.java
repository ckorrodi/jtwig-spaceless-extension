package org.jtwig.spaceless.node;

import org.jtwig.context.RenderContext;
import org.jtwig.context.model.EscapeMode;
import org.jtwig.model.position.Position;
import org.jtwig.model.tree.ContentNode;
import org.jtwig.model.tree.Node;
import org.jtwig.render.Renderable;
import org.jtwig.render.StringBuilderRenderResult;
import org.jtwig.render.impl.StringRenderable;
import org.jtwig.spaceless.configuration.SpacelessConfiguration;

public class SpacelessNode extends ContentNode {
    public SpacelessNode(Position position, Node content) {
        super(position, content);
    }

    @Override
    public Renderable render(RenderContext context) {
        StringBuilderRenderResult result = new StringBuilderRenderResult();
        String content = super.render(context).appendTo(result).content();
        String contentWithoutSpaces = SpacelessConfiguration.spaceRemover(context.environment()).removeSpaces(content);
        return new StringRenderable(contentWithoutSpaces, EscapeMode.NONE);
    }
}

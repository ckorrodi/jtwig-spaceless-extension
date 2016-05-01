package org.jtwig.spaceless.render.node;

import org.jtwig.escape.NoneEscapeEngine;
import org.jtwig.render.RenderRequest;
import org.jtwig.render.node.renderer.NodeRender;
import org.jtwig.renderable.Renderable;
import org.jtwig.renderable.StringBuilderRenderResult;
import org.jtwig.renderable.impl.StringRenderable;
import org.jtwig.spaceless.configuration.SpacelessConfiguration;
import org.jtwig.spaceless.node.SpacelessNode;

public class SpacelessNodeRender implements NodeRender<SpacelessNode> {
    @Override
    public Renderable render(RenderRequest request, SpacelessNode node) {
        StringBuilderRenderResult result = new StringBuilderRenderResult();
        Renderable renderable = request.getEnvironment().getRenderEnvironment().getRenderNodeService().render(request, node.getContent());
        String content = renderable.appendTo(result).content();
        String contentWithoutSpaces = SpacelessConfiguration.spaceRemover(request.getEnvironment()).removeSpaces(content);
        return new StringRenderable(contentWithoutSpaces, NoneEscapeEngine.instance());
    }
}

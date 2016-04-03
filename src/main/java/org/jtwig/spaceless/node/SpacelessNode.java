package org.jtwig.spaceless.node;

import org.jtwig.model.position.Position;
import org.jtwig.model.tree.ContentNode;
import org.jtwig.model.tree.Node;

public class SpacelessNode extends ContentNode {
    public SpacelessNode(Position position, Node content) {
        super(position, content);
    }
}

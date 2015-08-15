package org.jtwig.spaceless.parser;

import org.jtwig.parser.parboiled.ParserContext;
import org.jtwig.parser.parboiled.base.LexicParser;
import org.jtwig.parser.parboiled.base.LimitsParser;
import org.jtwig.parser.parboiled.base.PositionTrackerParser;
import org.jtwig.parser.parboiled.base.SpacingParser;
import org.jtwig.parser.parboiled.node.AddonParser;
import org.jtwig.parser.parboiled.node.CompositeNodeParser;
import org.jtwig.spaceless.node.SpacelessNode;
import org.parboiled.Rule;

public class SpacelessNodeParser extends AddonParser {
    public SpacelessNodeParser(ParserContext context) {
        super(SpacelessNodeParser.class, context);
    }

    @Override
    public Rule NodeRule() {
        PositionTrackerParser positionTrackerParser = parserContext().parser(PositionTrackerParser.class);
        LimitsParser limitsParser = parserContext().parser(LimitsParser.class);
        SpacingParser spacingParser = parserContext().parser(SpacingParser.class);
        LexicParser lexicParser = parserContext().parser(LexicParser.class);
        CompositeNodeParser compositeNodeParser = parserContext().parser(CompositeNodeParser.class);
        return Sequence(
                positionTrackerParser.PushPosition(),

                // start
                Sequence(
                        limitsParser.startCode(),
                        spacingParser.Spacing(),
                        lexicParser.Keyword(SpacelessKeywords.SPACELESS.toString()),
                        spacingParser.Spacing(),
                        limitsParser.endCode()
                ),

                // content
                compositeNodeParser.NodeRule(),

                // stop
                Sequence(
                        limitsParser.startCode(),
                        spacingParser.Spacing(),
                        lexicParser.Keyword(SpacelessKeywords.END_SPACELESS.toString()),
                        spacingParser.Spacing(),
                        limitsParser.endCode()
                ),

                push(new SpacelessNode(positionTrackerParser.pop(1), compositeNodeParser.pop()))
        );
    }
}

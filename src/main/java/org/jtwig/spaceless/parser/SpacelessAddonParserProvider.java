package org.jtwig.spaceless.parser;

import org.jtwig.parser.addon.AddonParserProvider;
import org.jtwig.parser.parboiled.node.AddonParser;

import java.util.Collection;

public class SpacelessAddonParserProvider implements AddonParserProvider {
    @Override
    public Class<? extends AddonParser> parser() {
        return SpacelessNodeParser.class;
    }

    @Override
    public Collection<String> keywords() {
        return SpacelessKeywords.all();
    }
}

package org.jtwig.spaceless.configuration;

import org.jtwig.spaceless.remover.HtmlSpaceRemover;

public class DefaultSpacelessConfiguration extends SpacelessConfiguration {
    public DefaultSpacelessConfiguration() {
        super(new HtmlSpaceRemover());
    }
}

package org.jtwig.spaceless;

import org.jtwig.environment.EnvironmentConfigurationBuilder;
import org.jtwig.extension.Extension;
import org.jtwig.spaceless.configuration.SpacelessConfiguration;
import org.jtwig.spaceless.node.SpacelessNode;
import org.jtwig.spaceless.parser.SpacelessAddonParserProvider;
import org.jtwig.spaceless.render.node.SpacelessNodeRender;

public class SpacelessExtension implements Extension {
    private final SpacelessConfiguration configuration;

    public SpacelessExtension(SpacelessConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public void configure(EnvironmentConfigurationBuilder environmentConfigurationBuilder) {
        configuration.configure(environmentConfigurationBuilder);
        environmentConfigurationBuilder.parser()
                .addonParserProviders().add(new SpacelessAddonParserProvider()).and().and()
                .render().nodeRenders().add(SpacelessNode.class, new SpacelessNodeRender());
    }
}

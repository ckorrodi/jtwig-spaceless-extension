package org.jtwig.spaceless.configuration;


import org.jtwig.environment.Environment;
import org.jtwig.environment.EnvironmentConfigurationBuilder;
import org.jtwig.spaceless.remover.SpaceRemover;

public class SpacelessConfiguration {
    private static final String SPACE_REMOVER = "spaceRemover";

    public static SpaceRemover spaceRemover (Environment environment) {
        return environment.parameter(SPACE_REMOVER);
    }

    private final SpaceRemover spaceRemover;

    public SpacelessConfiguration(SpaceRemover spaceRemover) {
        this.spaceRemover = spaceRemover;
    }

    public SpaceRemover getSpaceRemover() {
        return spaceRemover;
    }

    public void configure(EnvironmentConfigurationBuilder environmentConfigurationBuilder) {
        environmentConfigurationBuilder.parameters().add(SPACE_REMOVER, spaceRemover);
    }
}

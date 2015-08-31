package org.jtwig.spaceless.configuration;

import org.apache.commons.lang3.builder.Builder;
import org.jtwig.spaceless.remover.SpaceRemover;

public class SpacelessConfigurationBuilder implements Builder<SpacelessConfiguration> {
    private SpaceRemover spaceRemover;

    public SpacelessConfigurationBuilder(SpacelessConfiguration prototype) {
        this.spaceRemover = prototype.getSpaceRemover();
    }

    public SpacelessConfigurationBuilder() {}

    public SpacelessConfigurationBuilder withSpaceRemover(SpaceRemover spaceRemover) {
        this.spaceRemover = spaceRemover;
        return this;
    }

    @Override
    public SpacelessConfiguration build() {
        return new SpacelessConfiguration(spaceRemover);
    }
}

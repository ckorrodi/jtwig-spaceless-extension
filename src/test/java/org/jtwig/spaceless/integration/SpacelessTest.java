package org.jtwig.spaceless.integration;

import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.jtwig.spaceless.SpacelessExtension;
import org.jtwig.spaceless.configuration.DefaultSpacelessConfiguration;
import org.jtwig.spaceless.configuration.SpacelessConfigurationBuilder;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.jtwig.environment.EnvironmentConfigurationBuilder.configuration;
import static org.jtwig.spaceless.SpacelessExtension.defaultSpacelessExtension;

public class SpacelessTest {
    @Test
    public void simpleSpaceless() throws Exception {
        String result = JtwigTemplate.inlineTemplate("{% spaceless %}<div>\n" +
                "        <strong>foo</strong>\n" +
                "    </div>{% endspaceless %}", configuration()
                .extensions().add(defaultSpacelessExtension()).and()
                .build()).render(JtwigModel.newModel());
        assertThat(result, is("<div><strong>foo</strong></div>"));
    }

    @Test
    public void spacelessNestedWithAutoEspace() throws Exception {
        String result = JtwigTemplate.inlineTemplate("{% autoescape 'html' %}" +
                "{% spaceless %}" +
                "{% autoescape 'html' %}{{ '&amp;' }}{% endautoescape %}" +
                "{% endspaceless %}" +
                "{% endautoescape %}", configuration()
                        .extensions().add(new SpacelessExtension(new SpacelessConfigurationBuilder(new DefaultSpacelessConfiguration()).build())).and().build())
                .render(JtwigModel.newModel());

        assertThat(result, is("&amp;amp;"));
    }
}

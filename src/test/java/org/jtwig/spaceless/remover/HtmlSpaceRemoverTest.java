package org.jtwig.spaceless.remover;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HtmlSpaceRemoverTest {

    private HtmlSpaceRemover underTest = new HtmlSpaceRemover();

    @Test
    public void whiteSpaceRemover() throws Exception {
        String result = underTest.removeSpaces("<div>\n" +
                "        <strong>foo</strong>\n" +
                "    </div>");

        assertThat(result, is("<div><strong>foo</strong></div>"));
    }
}
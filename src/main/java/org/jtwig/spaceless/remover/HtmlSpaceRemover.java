package org.jtwig.spaceless.remover;

public class HtmlSpaceRemover implements SpaceRemover {
    @Override
    public String removeSpaces(String input) {
        return input.replaceAll(">\\s+<", "><");
    }
}

package org.jtwig.spaceless.parser;

import com.google.common.base.Function;
import com.google.common.collect.Collections2;

import java.util.Collection;

import static java.util.Arrays.asList;

public enum SpacelessKeywords {
    SPACELESS("spaceless"),
    END_SPACELESS("endspaceless");

    public static Collection<String> all () {
        return Collections2.transform(asList(values()), new Function<SpacelessKeywords, String>() {
            @Override
            public String apply(SpacelessKeywords input) {
                return input.token;
            }
        });
    }

    private final String token;

    SpacelessKeywords(String token) {
        this.token = token;
    }


    @Override
    public String toString() {
        return token;
    }
}

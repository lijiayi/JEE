package de.spqrinfo.jee.hellosecurity.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

@RunWith(JUnit4.class)
public class IndexBackingTest {

    @Test
    public void testGetSomeMessage() throws Exception {
        final IndexBacking bean = new IndexBacking();
        assertThat(bean.getSomeMessage(), containsString("Hello"));
    }
}

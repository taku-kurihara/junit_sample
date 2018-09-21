import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class AssertionSample {

    @Test
    public void assertIsSample() {
        assertThat(1, is(1));
    }

    @Test
    public void assertNotSample() {
        assertThat(1, is(not(2)));
    }

    @Test
    public void assertNullSample() {
        assertThat(null, is(nullValue()));
    }

    @Test
    public void assertNotNullSample() {
        assertThat(1, is(notNullValue()));
    }
}

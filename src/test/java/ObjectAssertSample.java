import model.Model;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.hamcrest.core.Is.is;

public class ObjectAssertSample {
    @Test
    public void singlePropertyAssert() {
        final Model expect = new Model(1, "name");

        Assert.assertThat(1, is(expect.getId()));
        Assert.assertThat("name", is(expect.getName()));
    }

    @Test
    public void propertiesAssert() {
        final Model expect = new Model(1, "name");
        final Model actual = new Model(1, "name");

        Assert.assertThat(actual, is(samePropertyValuesAs(expect)));
    }
}

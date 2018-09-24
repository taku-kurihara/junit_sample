import model.Model;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class ObjectAssertSample {
    @Test
    public void singlePropertyAssert() {
        final Model expect = new Model(1, "name");

        Assert.assertThat(1, Is.is(expect.getId()));
        Assert.assertThat("name", Is.is(expect.getName()));
    }

    @Test
    public void propertiesAssert() {
        final Model expect = new Model(1, "name");
        final Model actual = new Model(1, "name");

        Assert.assertThat(actual, Is.is(Matchers.samePropertyValuesAs(expect)));
    }
}

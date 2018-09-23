import model.SomeObject;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

public class ObjectAssertSample {
    @Test
    public void singlePropertyAssert() {
        final SomeObject object = new SomeObject(1, "name");

        Assert.assertThat(1, Is.is(object.getId()));
        Assert.assertThat("name", Is.is(object.getName()));
    }

    @Test
    public void propertiesAssert() {
        final SomeObject objectA = new SomeObject(1, "name");
        final SomeObject objectB = new SomeObject(1, "name");

        Assert.assertThat(objectB, Is.is(Matchers.samePropertyValuesAs(objectA)));
    }
}

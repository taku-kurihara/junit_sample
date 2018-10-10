package service.impl;

import mockit.Expectations;
import mockit.Mocked;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import repository.impl.SpyTargetModelRepositoryImpl;
import util.SampleUtil;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;

/**
 * 依存関係を直接注入したサービスクラスのテスト.
 */
public class SpyMethodSample {

    /** 挙動をモックしたいstaticメソッドを持つクラス */
    @Mocked
    private SampleUtil sampleUtil;
    /** テスト対象のクラス. */
    @InjectMocks
    private ModelServiceImplForSpyTest modelService;
    /** 依存関係にあって、挙動を変更したいクラス. */
    @Spy
    private SpyTargetModelRepositoryImpl modelRepository;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * ライブラリでメソッドをモックする方法.
     */
    @Test
    public void mockDependencyMethodByLibrary() {
        // spyした処理をオーバーライドできる.
        doReturn("spied")
                .when(modelRepository)
                .echo(anyString());

        assertThat(
                "spied",
                is(modelService.echo("some message."))
        );
    }

    @Test
    public void staticMethodMockTest() {

        new Expectations() { {
            SampleUtil.increment(anyInt);
            result = 10;

        }};

        assertThat(10, is(modelService.add(1)));
    }
}

package service.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import repository.impl.SpyTargetModelRepositoryImpl;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;

/**
 * 依存関係を直接注入したサービスクラスのテスト.
 */
public class SpyMethodSample {

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
}

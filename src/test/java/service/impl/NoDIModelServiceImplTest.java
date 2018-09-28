package service.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.impl.ModelRepositoryImpl;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

/**
 * 依存関係を直接注入したサービスクラスのテスト.
 */
public class NoDIModelServiceImplTest {

    /** テスト対象のクラス. */
    @InjectMocks
    private NoDIModelServiceImpl noDIModelService;
    /** 依存関係にあって、挙動を変更したいクラス. */
    @Mock
    private ModelRepositoryImpl modelRepository;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * ライブラリでメソッドをモックする方法.
     */
    @Test
    public void mockDependencyMethodByLibrary() {
        try {
            // whenで処理をオーバーライドできる.
            when(modelRepository.findById(anyInt()))
                    .thenReturn(Optional.empty());

        } catch (Exception e) {
            e.printStackTrace();
        }

        assertThat(
                "John Doe",
                is(noDIModelService.getModelById(2).getName())
        );
    }
}

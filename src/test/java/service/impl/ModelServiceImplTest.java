package service.impl;

import model.Model;
import org.junit.Test;
import repository.impl.ModelRepositoryImpl;
import service.ModelService;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Serviceクラスなどの他のクラスと依存関係があるテストケースサンプル.
 */
public class ModelServiceImplTest {

    /**
     * 通常の実装するようにテストケースを記述.<br/>
     * [メリット]<br/>
     * 実装してからであれば、イメージがつかめているので実装スピードは早い.<br/>
     * [デメリット]<br/>
     * {@code ModelRepositoryImpl} の実装に挙動が制限される.
     */
    @Test
    public void simpleTestPattern() {
        final ModelServiceImpl modelService = new ModelServiceImpl(new ModelRepositoryImpl());
        final Model model = new Model(1, "modelName1");

        assertThat(
                model.getName(),
                is(modelService.getModelById(1).getName())
        );
    }

    /**
     * 依存関係をモックしたテストケースを記述.<br/>
     * [メリット]<br/>
     * 依存関係の実装によらないテストが可能(ex: DBアクセス 等)<br/>
     * [デメリット]<br/>
     * {@code ModelRepositoryImpl} の実装に挙動が制限される.
     */
    @Test
    public void methodMockedPattern() {
        final ModelService modelService = new ModelServiceImpl(new ModelRepositoryMock());

        assertThat(
                "John Doe",
                is(modelService.getModelById(2).getName())
        );
    }

    /**
     * {@link ModelRepositoryImpl} のモッククラス.
     */
    private class ModelRepositoryMock extends ModelRepositoryImpl {
        /**
         * {@link ModelRepositoryImpl#findById(int)}のモックメソッド.
         * @param id mode_id
         * @return 中身のない {@link Optional}.
         */
        @Override
        public Optional<Model> findById(final int id) {
            return Optional.empty();
        }
    }

    /**
     * 匿名クラスによるメソッドのスパイ.
     */
    @Test
    public void spyMethodTest() {
        /* インスタンス生成時にモックしたいメソッドをオーバーライドした無名クラスを生成.
             ModelRepositoryMockを作るのと同じことが出来る
         */
        final ModelRepositoryImpl modelRepositoryMock = new ModelRepositoryImpl() {
                    @Override
                    public Optional<Model> findById(final int id) {
                        return Optional.empty();
                    }
                };
        final ModelServiceImpl spiedModelService = new ModelServiceImpl(modelRepositoryMock);

        assertThat(
                "John Doe",
                is(spiedModelService.getModelById(2).getName())
        );
    }
}

package service.impl;

import model.Model;
import org.hamcrest.core.Is;
import org.junit.Test;
import repository.impl.ModelRepositoryImpl;
import service.ModelService;

import java.util.Optional;

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
                Is.is(modelService.getModelById(1).getName())
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
                Is.is(modelService.getModelById(2).getName())
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
        public Optional<Model> findById(int id) {
            return Optional.empty();
        }
    }

    /**
     * テスト対象の異なるメソッドをモック(スパイ)したい時のサンプル.
     */
    @Test
    public void spyMethodTest() {
        // インスタンス生成時にモックしたいメソッドをオーバーライドした無名クラスを生成.
        final ModelServiceImpl spiedModelService = new ModelServiceImpl(new ModelRepositoryMock()) {
            /**
             * {@link ModelServiceImpl#getModelName(Model)} のモックメソッド.
             * @param model {@link Model}
             * @return 固定値: John Doe
             */
            @Override
            public String getModelName(Model model) {
                return "John Doe";
            }
        };

        final Model model = new Model();

        assertThat(
                "John Doe",
                Is.is(spiedModelService.getModelName(model))
        );

    }
}

import controller.ModelController;
import model.Model;
import repository.impl.ModelRepositoryImpl;
import service.ModelService;
import service.impl.ModelServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * <P>
 * 実行するメインクラス.
 * </P>
 */
public class App {

    public static void main(String[] args) {

        final ModelController modelController = new ModelController(new ModelServiceImpl(new ModelRepositoryImpl()));

        System.out.println(modelController.findModel(1));
        // 未実装の部分と依存関係があると他の箇所の実装に影響が出る.
        System.out.println(modelController.findAll());

        // =================================================================================================== //

        // 未実装の部分のみモック(オーバーライド)すれば、実装クラスと別にクラスを作る必要がなくなる.
        final ModelService mockedModelService = new ModelServiceImpl(new ModelRepositoryImpl()) {
            @Override
            public List<Model> getAllModels() {
                return new  ArrayList<Model>() {
                    {
                        add(new Model(1, "Model1"));
                        add(new Model(2, "Model2"));
                        add(new Model(3, "Model3"));
                        add(new Model(4, "Model4"));
                    }
                };
            }
        };

        final ModelController mockedModelController = new ModelController(mockedModelService);

        System.out.println(mockedModelController.findModel(1));
        System.out.println(mockedModelController.findAll());

    }
}

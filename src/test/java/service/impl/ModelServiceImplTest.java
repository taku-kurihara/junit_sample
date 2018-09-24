package service.impl;

import model.Model;
import org.hamcrest.core.Is;
import org.junit.Test;
import repository.ModelRepository;
import repository.impl.ModelRepositoryImpl;
import service.ModelService;

import static org.junit.Assert.assertThat;

public class ModelServiceImplTest {

    @Test
    public void そのまま実装した場合() {
        final ModelServiceImpl modelService = new ModelServiceImpl(new ModelRepositoryImpl());
        final Model model = new Model(1, "modelName1");

        assertThat(
                model.getName(),
                Is.is(modelService.getModelNameById(1))
        );
    }

    @Test
    public void diを利用した方法() {
        final ModelService modelService = new ModelServiceImpl(new ModelRepositoryMock());

        assertThat(
                "mockUser",
                Is.is(modelService.getModelNameById(1))
        );
    }

    public class ModelRepositoryMock implements ModelRepository {
        @Override
        public Model findById(int id) {
            return new Model(99, "mockUser");
        }
    }
}

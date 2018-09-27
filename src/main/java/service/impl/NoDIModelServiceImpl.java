package service.impl;

import model.Model;
import repository.ModelRepository;
import repository.impl.ModelRepositoryImpl;
import service.ModelService;

import java.util.Optional;

public class NoDIModelServiceImpl implements ModelService {

    private ModelRepository modelRepository = new ModelRepositoryImpl();

    @Override
    public Model getModelById(final int id) {

        Optional<Model> model = modelRepository.findById(id);

        return model
                .orElse(new Model(0, "John Doe"));
    }

    public String getModelName(final Model model) {

        return model.getName();
    }
}

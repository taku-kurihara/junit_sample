package service.impl;

import model.Model;
import repository.ModelRepository;
import service.ModelService;

public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    public ModelServiceImpl(final ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public Model getModelById(final int id) {

        return modelRepository
                .findById(id)
                .orElse(new Model(0, "John Doe"));
    }


    public String getModelName(final Model model) {

        return model.getName();
    }
}

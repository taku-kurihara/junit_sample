package service.impl;

import repository.ModelRepository;
import service.ModelService;

public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    public ModelServiceImpl(final ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public String getModelNameById(int id) {
        return modelRepository
                .findById(id)
                .getName();
    }
}

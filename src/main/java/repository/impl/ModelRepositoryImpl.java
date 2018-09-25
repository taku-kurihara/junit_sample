package repository.impl;

import model.Model;
import repository.ModelRepository;

import java.util.Optional;

public class ModelRepositoryImpl implements ModelRepository {

    @Override
    public Optional<Model> findById(int id) {
        return Optional.ofNullable(new Model(id, "modelName" + id));
    }
}

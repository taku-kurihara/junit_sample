package repository.impl;

import model.Model;
import repository.ModelRepository;

public class ModelRepositoryImpl implements ModelRepository {

    @Override
    public Model findById(int id) {
        return new Model(id, "modelName" + id);
    }
}

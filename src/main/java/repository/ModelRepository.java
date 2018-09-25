package repository;

import model.Model;

import java.util.Optional;

public interface ModelRepository {
    Optional<Model> findById(final int id);
}

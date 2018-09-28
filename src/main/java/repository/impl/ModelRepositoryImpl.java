package repository.impl;

import model.Model;
import repository.ModelRepository;

import java.util.Optional;

/**
 * ModelRepositoryの実装クラス.
 */
public class ModelRepositoryImpl implements ModelRepository {

    /**
     * DBからIDをkeyに {@link Model}を検索(今回はDBアクセスしている想定).
     * @param id {@link Model} のID(検索のキー項目).
     * @return {@link Optional<Model>}.
     */
    @Override
    public Optional<Model> findById(int id) {
        return Optional.ofNullable(new Model(id, "modelName" + id));
    }
}

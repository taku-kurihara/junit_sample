package repository.impl;

import model.Model;
import repository.ModelRepository;

import java.util.Optional;

/**
 * <p>
 * Spy用のModelRepositoryの実装クラス.
 * </p>
 */
public class SpyTargetModelRepositoryImpl implements ModelRepository {

    /**
     * DBからIDをkeyに {@link Model}を検索(今回はDBアクセスしている想定).
     * @param id {@link Model} のID(検索のキー項目).
     * @return {@link Optional<Model>}.
     */
    @Override
    public Optional<Model> findById(final int id) {
        return Optional.ofNullable(new Model(id, "modelName" + id));
    }

    public String echo(final String message) {
        return message;
    }
}

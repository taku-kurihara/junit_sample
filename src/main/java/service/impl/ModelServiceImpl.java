package service.impl;

import model.Model;
import repository.ModelRepository;
import service.ModelService;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * {@link ModelService}の実装クラス.
 * </p>
 * DIして、疎結合を保つ実装.
 */
public class ModelServiceImpl implements ModelService {

    /** ModelRepositoryを継承していれば、代入可にする */
    private final ModelRepository modelRepository;

    public ModelServiceImpl(final ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    /**
     * {@inheritDoc}
     * @param id {@link Model}のID.
     * @return {@link Model}.
     */
    @Override
    public Model getModelById(final int id) {

        return modelRepository
                .findById(id)
                .orElse(new Model(0, "John Doe"));
    }

    /**
     * {@inheritDoc}
     * @return {@code null}
     */
    @Override
    public List<Model> getAllModels() {
        // TODO: 実装すること.
        return new ArrayList<>();
    }
}

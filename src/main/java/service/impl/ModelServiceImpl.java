package service.impl;

import model.Model;
import repository.ModelRepository;
import service.ModelService;

/**
 * <p>
 * {@link ModelService}の実装クラス.
 * </p>
 * DIして、疎結合を保つ実装.
 */
public class ModelServiceImpl implements ModelService {

    /** ModelRepositoryを継承していれば、代入可にする */
    private final ModelRepository modelRepository;

    ModelServiceImpl(final ModelRepository modelRepository) {
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
}

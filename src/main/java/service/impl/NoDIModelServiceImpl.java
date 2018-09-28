package service.impl;

import model.Model;
import repository.ModelRepository;
import repository.impl.ModelRepositoryImpl;
import service.ModelService;

/**
 * <p>
 * 依存関係を直接注入したサービスクラス.
 * </p>
 */
public class NoDIModelServiceImpl implements ModelService {

    /** リポジトリーのインスタンスを直接生成している. */
    private ModelRepository modelRepository = new ModelRepositoryImpl();

    /**
     * {@inheritDoc}
     * @param id {@link Model} のID.
     * @return {@link Model}.
     */
    @Override
    public Model getModelById(final int id) {

        return modelRepository
                .findById(id)
                .orElse(new Model(0, "John Doe"));
    }
}

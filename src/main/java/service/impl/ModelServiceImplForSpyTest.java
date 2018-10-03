package service.impl;

import model.Model;
import repository.impl.SpyTargetModelRepositoryImpl;
import service.ModelService;

import java.util.List;

/**
 * <p>
 * Spyテスト用の依存関係を直接注入したサービスクラス.
 * </p>
 */
public class ModelServiceImplForSpyTest implements ModelService {

    /** リポジトリーのインスタンスを直接生成している. */
    private SpyTargetModelRepositoryImpl modelRepository = new SpyTargetModelRepositoryImpl();

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

    /**
     * {@inheritDoc}
     * @return {@code null} 固定.
     */
    @Override
    public List<Model> getAllModels() {
        return null;
    }

    public String echo(final String message) {
        return modelRepository.echo(message);
    }
}

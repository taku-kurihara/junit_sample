package service;

import model.Model;

import java.util.List;

/**
 * サービスクラスのインターフェース.
 */
public interface ModelService {
    /**
     * IDを元にModelの情報を検索.
     * @param id {@link Model} のID.
     * @return {@link Model}.
     */
    Model getModelById(final int id);

    /**
     * {@link Model}を取得する.
     * @return {@link Model} 一覧.
     */
    List<Model> getAllModels();
}

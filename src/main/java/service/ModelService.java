package service;

import model.Model;

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
}

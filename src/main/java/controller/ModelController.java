package controller;

import service.ModelService;

/**
 * コントローラーのサンプルクラス.
 */
public class ModelController {

    private ModelService modelService;

    public ModelController(final ModelService modelService) {
        this.modelService = modelService;
    }

    /**
     * IDの{@link model.Model}を取得する.
     * @param id {@link model.Model}のID.
     * @return {@link model.Model}の文字列.
     */
    public String findModel(final int id) {
        return modelService
                .getModelById(id)
                .toString();
    }

    /**
     * {@link model.Model}の一覧を取得.
     * @return {@link java.util.List<model.Model>}の文字列.
     */
    public String findAll() {

        return modelService
                .getAllModels()
                .toString();
    }
}

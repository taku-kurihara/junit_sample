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

    public String findModel(final int id) {
        return modelService
                .getModelById(id)
                .toString();
    }

    public String findAll() {

        return modelService
                .getAllModels()
                .toString();
    }
}

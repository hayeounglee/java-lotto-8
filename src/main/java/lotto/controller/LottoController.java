package lotto.controller;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService service;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
        this.service = new LottoService();
    }

    public void run() {
        inputView.getPurchaseAmount();
        inputView.getLottoNumber();
    }

}

package lotto.controller;

import lotto.constant.ErrorMessage;
import lotto.model.Lotto;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;
    private LottoService service;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = lottoService;
    }

    public void run() {
        repeatUntilPurchaseValid();
        outputView.printUserLotto(service.getUserLottos());

        repeatUntilLottoValid();
        repeatUntilBonusValid();

        outputView.printResult(service.summarizeResults(), service.calculateProfitRate());
    }

    private void repeatUntilPurchaseValid() {
        while (true) {
            try {
                int purchaseAmount = inputView.getPurchaseAmount();
                service.generateUserLottos(purchaseAmount);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_FORM.getMessage());
            }
        }
    }

    private void repeatUntilLottoValid() {
        while (true) {
            try {
                Lotto lotto = new Lotto(inputView.getLottoNumber());
                service.generateLotto(lotto);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_FORM.getMessage());
            }
        }
    }

    private void repeatUntilBonusValid() {
        while (true) {
            try {
                int bonus = inputView.getBonusNumber();
                service.generateBonus(bonus);
                return;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.INVALID_FORM.getMessage());
            }
        }
    }
}

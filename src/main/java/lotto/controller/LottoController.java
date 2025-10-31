package lotto.controller;

import java.util.Map;
import lotto.constant.Rank;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.UserLottos;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private LottoService service;

    public LottoController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        int purchaseAmount = inputView.getPurchaseAmount();
        UserLottos userLottos = new UserLottos(purchaseAmount);
        Lotto lotto = new Lotto(inputView.getLottoNumber());
        Bonus bonus = new Bonus(inputView.getBonusNumber(), lotto);

        service = new LottoService(userLottos, lotto, bonus);

        Map<Rank, Long> summary = service.summarizeResults();
        double profitRate = service.calculateProfitRate(purchaseAmount);

        outputView.printResult(summary, profitRate);
    }

}

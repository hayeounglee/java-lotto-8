package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.constant.Rank;
import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.UserLottos;
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
        int purchaseAmount = inputView.getPurchaseAmount();
        service.generateUserLottos(purchaseAmount);
        outputView.printUserLotto(service.getUserLottos());

        List<Integer> lottoInput = inputView.getLottoNumber();
        Lotto lotto = new Lotto(lottoInput);
        service.generateLotto(lotto);

        int bonus = inputView.getBonusNumber();
        service.generateBonus(bonus);

        Map<Rank, Long> summary = service.summarizeResults();
        double profitRate = service.calculateProfitRate(purchaseAmount);

        outputView.printResult(summary, profitRate);
    }

}

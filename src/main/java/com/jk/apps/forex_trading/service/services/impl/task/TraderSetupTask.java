package com.jk.apps.forex_trading.service.services.impl.task;

import com.jk.apps.forex_trading.service.common.StaticDataUtil;
import com.jk.apps.forex_trading.service.dto.DataSetupCtx;
import com.jk.apps.forex_trading.service.entity.Trader;
import com.jk.apps.forex_trading.service.repository.TraderRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class TraderSetupTask {

    private final TraderRepository traderRepository;

    public TraderSetupTask(TraderRepository traderRepository) {
        this.traderRepository = traderRepository;
    }

    public void createTraders(DataSetupCtx dataSetupCtx) {
        createTraders();
    }

    public void createTraders() {
        // Check existing trader count
        if (traderRepository.count() >= 15) {
            return; // Traders already exist, skip insertion
        }

        // Insert hardcoded traders
        List<Trader> traders = IntStream.rangeClosed(0, 14)
                .mapToObj(i -> {
                    Trader trader = new Trader();
                    trader.setId(StaticDataUtil.TRADER_IDS.get(i)); // Reuse hardcoded ID
                    trader.setFirstName("Trader" + (i + 1));
                    trader.setLastName("FX");
                    trader.setTraderType(i % 2 == 0 ? "Institutional" : "Individual");
                    trader.setTraderCountry("USA");
                    return trader;
                })
                .toList();

        traderRepository.saveAll(traders);
    }
}

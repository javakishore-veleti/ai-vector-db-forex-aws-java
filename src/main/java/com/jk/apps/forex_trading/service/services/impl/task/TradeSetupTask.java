package com.jk.apps.forex_trading.service.services.impl.task;

import com.jk.apps.forex_trading.service.common.StaticDataUtil;
import com.jk.apps.forex_trading.service.dto.DataSetupCtx;
import com.jk.apps.forex_trading.service.entity.Customer;
import com.jk.apps.forex_trading.service.entity.Trade;
import com.jk.apps.forex_trading.service.entity.Trader;
import com.jk.apps.forex_trading.service.entity.TraderBook;
import com.jk.apps.forex_trading.service.repository.CustomerRepository;
import com.jk.apps.forex_trading.service.repository.TradeRepository;
import com.jk.apps.forex_trading.service.repository.TraderBookRepository;
import com.jk.apps.forex_trading.service.repository.TraderRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@Component
public class TradeSetupTask {
    private final TradeRepository tradeRepository;
    private final CustomerRepository customerRepository;
    private final TraderRepository traderRepository;
    private final TraderBookRepository traderBookRepository;

    public TradeSetupTask(TradeRepository tradeRepository, CustomerRepository customerRepository,
                          TraderRepository traderRepository, TraderBookRepository traderBookRepository) {
        this.tradeRepository = tradeRepository;
        this.customerRepository = customerRepository;
        this.traderRepository = traderRepository;
        this.traderBookRepository = traderBookRepository;
    }

    public void createTrades(DataSetupCtx dataSetupCtx) {
        createTrades();
    }

    public void createTrades() {
        // Generate trade data
        List<Trade> trades = IntStream.rangeClosed(1, 100)
                .mapToObj(i -> {
                    Trade trade = new Trade();
                    trade.setId(UUID.randomUUID().toString());

                    String customerId = StaticDataUtil.CUSTOMER_IDS.get(i % StaticDataUtil.CUSTOMER_IDS.size());
                    Customer customer = this.customerRepository.findById(customerId).orElse(null);
                    trade.setCustomer(customer); // Ensure existing customer ID

                    String traderId = StaticDataUtil.TRADER_IDS.get(i % StaticDataUtil.TRADER_IDS.size());
                    Trader trader = this.traderRepository.findById(traderId).orElse(null);
                    trade.setTrader(trader); // Ensure existing trader ID

                    String traderBookId = StaticDataUtil.TRADER_BOOK_IDS.get(i % StaticDataUtil.TRADER_BOOK_IDS.size());
                    TraderBook traderBook = this.traderBookRepository.findById(traderBookId).orElse(null);
                    trade.setTraderBook(traderBook); // Ensure existing book ID

                    trade.setTradeCategory("SPOT");
                    trade.setTradeOriginCountry("USA");
                    return trade;
                })
                .toList();

        tradeRepository.saveAll(trades);
    }
}

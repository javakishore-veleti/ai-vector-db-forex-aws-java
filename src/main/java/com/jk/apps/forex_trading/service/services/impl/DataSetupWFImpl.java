package com.jk.apps.forex_trading.service.services.impl;

import com.jk.apps.forex_trading.service.dto.DataSetupCtx;
import com.jk.apps.forex_trading.service.services.DataSetupWF;
import com.jk.apps.forex_trading.service.services.impl.task.CustomerSetupTask;
import com.jk.apps.forex_trading.service.services.impl.task.TraderSetupTask;
import com.jk.apps.forex_trading.service.services.impl.task.TradeBookSetupTask;
import com.jk.apps.forex_trading.service.services.impl.task.TradeSetupTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class DataSetupWFImpl implements DataSetupWF {

    private final CustomerSetupTask customerSetupTask;
    private final TraderSetupTask traderSetupTask;
    private final TradeBookSetupTask tradeBookSetupTask;
    private final TradeSetupTask tradeSetupTask;

    public DataSetupWFImpl(CustomerSetupTask customerSetupTask,
                           TraderSetupTask traderSetupTask,
                           TradeBookSetupTask tradeBookSetupTask,
                           TradeSetupTask tradeSetupTask) {
        this.customerSetupTask = customerSetupTask;
        this.traderSetupTask = traderSetupTask;
        this.tradeBookSetupTask = tradeBookSetupTask;
        this.tradeSetupTask = tradeSetupTask;
    }

    @Override
    public void runDataSetupWorkflow() {
        DataSetupCtx dataSetupCtx = new DataSetupCtx(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        CompletableFuture<Void> customerFuture = CompletableFuture.runAsync(() -> {
            customerSetupTask.createCustomers(dataSetupCtx);
            log.info("Customer setup completed.");
        });

        CompletableFuture<Void> traderFuture = CompletableFuture.runAsync(() -> {
            traderSetupTask.createTraders(dataSetupCtx);
            log.info("Trader setup completed.");
            tradeBookSetupTask.createTradeBooks(dataSetupCtx);
            log.info("TradeBook setup completed.");
        });

        tradeSetupTask.createTrades(dataSetupCtx);

        // Wait for all tasks to complete before finishing workflow execution
        CompletableFuture.allOf(customerFuture, traderFuture).join();
        log.info("Data Setup Workflow execution completed.");
    }
}

package com.jk.apps.forex_trading.service.services.impl;

import com.jk.apps.forex_trading.service.dto.DataSetupCtx;
import com.jk.apps.forex_trading.service.services.DataSetupWF;
import com.jk.apps.forex_trading.service.services.impl.task.CustomerSetupTask;
import com.jk.apps.forex_trading.service.services.impl.task.TraderSetupTask;
import com.jk.apps.forex_trading.service.services.impl.task.TradeBookSetupTask;
import com.jk.apps.forex_trading.service.services.impl.task.TradeSetupTask;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class DataSetupWFImpl implements DataSetupWF {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSetupWFImpl.class);

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
    public void runDataSetupWorkflow() throws Exception {
        DataSetupCtx dataSetupCtx = new DataSetupCtx(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        CompletableFuture<Void> customerFuture = CompletableFuture.runAsync(() -> {
            for (String s : Arrays.asList("Corporate", "Retail")) {
                try {
                    customerSetupTask.createCustomers(dataSetupCtx, s);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            LOGGER.info("Customer setup completed.");
        });

        CompletableFuture<Void> traderFuture = CompletableFuture.runAsync(() -> {
            traderSetupTask.createTraders(dataSetupCtx);
            LOGGER.info("Trader setup completed.");
            tradeBookSetupTask.createTradeBooks(dataSetupCtx);
            LOGGER.info("TradeBook setup completed.");
        });

        tradeSetupTask.createTrades(dataSetupCtx);

        // Wait for all tasks to complete before finishing workflow execution
        CompletableFuture.allOf(customerFuture, traderFuture).join();
        LOGGER.info("Data Setup Workflow execution completed.");
    }
}

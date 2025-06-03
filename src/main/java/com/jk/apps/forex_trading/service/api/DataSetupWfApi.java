package com.jk.apps.forex_trading.service.api;

import com.jk.apps.forex_trading.service.services.DataSetupWF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/datasetup-wf")
public class DataSetupWfApi {

    private final DataSetupWF dataSetupWF;

    @Autowired
    public DataSetupWfApi(DataSetupWF dataSetupWF) {
        this.dataSetupWF = dataSetupWF;
    }

    @PostMapping("/generate-initial-data")
    public ResponseEntity<String> generateInitialData() {
        try {
            dataSetupWF.runDataSetupWorkflow();
            return ResponseEntity.ok("Initial Data Setup Completed Successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating Initial Data Setup: " + e.getMessage());
        }
    }
}

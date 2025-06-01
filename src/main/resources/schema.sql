-- Create table for Customer
CREATE TABLE customer (
                          customer_id VARCHAR(36) PRIMARY KEY, -- Using UUID as String
                          first_name VARCHAR(255) NOT NULL,
                          last_name VARCHAR(255) NOT NULL,
                          email VARCHAR(255) UNIQUE NOT NULL,
                          customer_type VARCHAR(50) CHECK (customer_type IN ('Retail', 'Corporate')),
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Create table for Trader
CREATE TABLE trader (
                        trader_id VARCHAR(36) PRIMARY KEY, -- Using UUID as String
                        first_name VARCHAR(255) NOT NULL,
                        last_name VARCHAR(255) NOT NULL,
                        email VARCHAR(255) UNIQUE NOT NULL,
                        trader_type VARCHAR(50) CHECK (trader_type IN ('Individual', 'Institutional')),
                        trader_cntry VARCHAR(100),
                        trader_desk VARCHAR(100),
                        created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);


-- Create table for Trader Book
CREATE TABLE trader_book (
                             trader_book_id VARCHAR(36) PRIMARY KEY, -- Using UUID as String
                             trader_id VARCHAR(36) NOT NULL,
                             book_name VARCHAR(255) NOT NULL,
                             book_type VARCHAR(50) CHECK (book_type IN ('Risk', 'Hedge', 'Liquidity')),
                             created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                             CONSTRAINT fk_trader_by_trader_book FOREIGN KEY (trader_id) REFERENCES trader(trader_id) ON DELETE CASCADE
);


-- Create table for Trade
CREATE TABLE trade (
                       trade_id VARCHAR(36) PRIMARY KEY, -- Using UUID as String
                       customer_id VARCHAR(36) NOT NULL,
                       trader_id VARCHAR(36) NOT NULL,
                       trader_book_id VARCHAR(36) NOT NULL,
                       trade_ctg VARCHAR(50) CHECK (trade_ctg IN ('SPOT', 'FORWARD', 'WINDOW_FORWARD')),
                       trade_req_dt TIMESTAMP NOT NULL,
                       trade_processed_dt TIMESTAMP,
                       trade_completed_dt TIMESTAMP,
                       trade_origin_cntry VARCHAR(100),
                       trade_origin_desk VARCHAR(100),
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                       CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customer(customer_id) ON DELETE CASCADE,
                       CONSTRAINT fk_trader_by_trade FOREIGN KEY (trader_id) REFERENCES trader(trader_id) ON DELETE CASCADE,
                       CONSTRAINT fk_trader_book_by_trade FOREIGN KEY (trader_book_id) REFERENCES trader_book(trader_book_id) ON DELETE CASCADE
);

-- Create table for Trade Line
CREATE TABLE trade_line (
                            trade_line_id VARCHAR(36) PRIMARY KEY, -- Using UUID as String
                            trade_id VARCHAR(36) NOT NULL,
                            from_currency VARCHAR(10) NOT NULL,
                            to_currency VARCHAR(10) NOT NULL,
                            from_amount DECIMAL(18,2) NOT NULL,
                            to_amount DECIMAL(18,2) NOT NULL,
                            unit_price DECIMAL(18,6),
                            trade_discount_total DECIMAL(18,2),
                            trade_discount_percent DECIMAL(5,2),
                            trader_book_id VARCHAR(36),
                            trader_id VARCHAR(36),
                            original_trade_req BOOLEAN,
                            trade_line_status VARCHAR(50) CHECK (trade_line_status IN ('Pending', 'Processed', 'Completed')),
                            trade_line_type VARCHAR(50) CHECK (trade_line_type IN ('Buy', 'Sell', 'Swap')),
                            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                            CONSTRAINT fk_trade FOREIGN KEY (trade_id) REFERENCES trade(trade_id) ON DELETE CASCADE,
                            CONSTRAINT fk_trader_book_by_trade_line FOREIGN KEY (trader_book_id) REFERENCES trader_book(trader_book_id),
                            CONSTRAINT fk_trader_by_trade_line FOREIGN KEY (trader_id) REFERENCES trader(trader_id)
);

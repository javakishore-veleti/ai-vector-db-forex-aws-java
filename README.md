# AI-Powered Vector Database "Based" FOREX Trade Processing (`ai-vector-db-forex-aws-java`)

## Introduction
This project provides an **AI-powered FOREX trade event processing system**. 

This project levarges **Java/Spring Boot**, **vector databases**, and **AWS AI services** for **real-time market intelligence, trade risk analysis, and anomaly detection**. 

This project integrates **Retrieval-Augmented Generation (RAG)** using **AWS Bedrock**, enabling dynamic insights from historical trade data.

## Objective
- Store, retrieve, and analyze **FOREX trade transactions**.
- Perform **high-dimensional trade pattern recognition** using **vector databases**.
- Enhance **market risk forecasting** with **AWS AI models**.
- Detect **anomalies & fraudulent transactions** in currency trading.
- Generate **GenAI-powered insights** using **AWS Bedrock**.
  
## Enterprise Architecture (BDAT)

The **AI-Powered Vector Database for FOREX Trade Processing** system follows the **BDAT (Business, Data, Application, Technology)** architecture framework to ensure scalability, efficiency, and AI-driven insights for **FOREX trade event management**.

### **Business Architecture (B)**
- Automates **FOREX trade event processing** with AI-driven analytics.
- Enhances **trade risk monitoring** using **vector databases & AWS AI models**.
- Supports **real-time liquidity forecasting** and **market anomaly detection**.
- Integrates **RAG-based GenAI insights** for macroeconomic analysis.

### **Data Architecture (D)**
- **Trade Event Data Model**
  - Fields: `fromCurrency`, `toCurrency`, `fromAmount`, `toAmount`, `tradingBook`, `tradingDate`, `fromCustomer`, `toCustomer`, `tradingType`
- **Vectorized Trade Embeddings**
  - Converts trade transactions into **high-dimensional embeddings** for similarity searches.
- **Data Storage Solutions**
  - **PostgreSQL (pgvector)** → Structured trade storage with vector embeddings.
  - **Weaviate / Pinecone** → Trade pattern recognition and nearest-neighbor search.
  - **AWS Glue & S3** → Historical trade data archiving.
- **Data Pipeline**
  - **Kafka & RabbitMQ** → Event-driven trade processing for anomaly detection.
  - **AWS Forecast AI** → Liquidity trend predictions based on historical data.

### **Application Architecture (A)**

### System Architecture Diagram

```ascii
+--------------------------+---------------------------+
|        API Gateway (Spring Boot)                     |
+------------+------------------+----------------+------+
               |                  |                |
+----------+---------+ +-------+--------+ +-----+------+
| Trade Event Service | | Vector DB      | | AWS AI     |
+----------+---------+ +-------+--------+ +-----+------+
               |                  |                |
+------------+------------------+----------------+------+
|  PostgreSQL (pgvector)  |    AWS AI Models     |
|  Pinecone / Weaviate    | Forecast, SageMaker  |
+------------------------+----------------------+

```

### **Application Components**
#### **1 Trade Event Processing (Spring Boot Microservices)**
- Handles **CRUD operations** for trade events.
- Publishes **trade risk alerts** via **Kafka/RabbitMQ**.

#### **2 Vector Database Integration**
- Enables **high-dimensional vector search** to find **similar trades**.
- Supports **pattern recognition for risk detection**.

#### **3 AI-Powered Analytics (AWS AI Services)**
- **AWS Forecast** → Predicts liquidity shifts in currency markets.
- **AWS Fraud Detector** → Identifies suspicious trades.
- **AWS SageMaker** → Executes risk scoring and anomaly detection.

#### **4 RAG-Based GenAI Insights (AWS Bedrock)**
- Uses **Titan, Claude, Jurassic-2 models** to analyze **macro trends**.
- Provides **context-aware financial intelligence**.

### **Technology Architecture (T)**
| **Category**         | **Technology**                                      |
|----------------------|-----------------------------------------------------|
| **Programming Language** | Java (Spring Boot), Python (ML Models)           |
| **Database**         | PostgreSQL (pgvector), Pinecone, Weaviate           |
| **AI & ML**         | AWS Forecast, SageMaker, Fraud Detector             |
| **GenAI RAG**       | AWS Bedrock (Titan, Claude, Jurassic-2)             |
| **Event Streaming** | Apache Kafka, RabbitMQ                              |
| **Cloud Deployment** | AWS ECS, Lambda, S3, API Gateway                    |
| **Containerization** | Docker, Kubernetes                                 |

## API Endpoints

### Trade Event Processing
| **Endpoint**                 | **Method** | **Description** |
|------------------------------|----------|----------------|
| `/api/trades`                | `POST`   | Create a new FOREX trade event |
| `/api/trades/{id}`           | `GET`    | Retrieve trade details by ID |
| `/api/trades/update/{id}`    | `PUT`    | Update an existing trade event |
| `/api/trades/delete/{id}`    | `DELETE` | Remove a trade from the system |

### Trade Risk & Similarity Search
| **Endpoint**                 | **Method** | **Description** |
|------------------------------|----------|----------------|
| `/api/trades/similar`        | `POST`   | Find similar trades using vector database search |
| `/api/risk/analyze`          | `POST`   | Perform risk analysis on a trading book |
| `/api/risk/history/{id}`     | `GET`    | Retrieve historical risk assessment for a trade |
| `/api/trades/hedge-recommendation` | `POST` | Suggest hedging strategies based on historical data |

### AI-Powered Trade Insights (AWS AI + RAG)
| **Endpoint**                 | **Method** | **Description** |
|------------------------------|----------|----------------|
| `/api/ai/generate-insight`   | `POST`   | Generate AI-powered market insights using AWS Bedrock |
| `/api/ai/liquidity-forecast` | `GET`    | Predict future liquidity based on historical trends |
| `/api/ai/anomaly-detection`  | `POST`   | Detect anomalies in trading activity using AI models |
| `/api/ai/news-impact`        | `POST`   | Analyze trade impact based on financial news events |

### System & Configuration
| **Endpoint**                 | **Method** | **Description** |
|------------------------------|----------|----------------|
| `/api/config/vector-db`      | `GET`    | Retrieve current vector database settings |
| `/api/config/aws-services`   | `GET`    | Check AWS AI service integration status |
| `/api/config/logs`           | `GET`    | Fetch system logs related to trade processing |


### **Components**
- **Trade Event Processing** – Spring Boot microservice for storing trade events.
- **Vector Database** – Enables similarity search for trade pattern recognition.
- **AWS AI Integration** – Enhances forecasting, risk detection, and anomaly tracking.
- **GenAI-Based Insights** – Retrieves market intelligence via **AWS Bedrock (Titan, Claude, Jurassic-2)**.
- **Microservices Architecture** – Designed for **Docker & Kubernetes** deployment.

### Core Components
#### **1 Trade Event Processing (Spring Boot Microservices)**
- Handles **CRUD operations** for trade events.
- Publishes **trade risk alerts** via **Kafka/RabbitMQ**.
- Stores structured trade data in **PostgreSQL**.
  
#### **2 Vector Database Integration (pgvector, Weaviate, Pinecone)**
- Enables **high-dimensional vector search** to find **similar trades**.
- Supports **pattern recognition for risk detection**.
  
#### **3 AI-Powered Analytics (AWS AI Services)**
- **AWS Forecast** → Predicts liquidity shifts in currency markets.
- **AWS Fraud Detector** → Identifies suspicious trades.
- **AWS SageMaker** → Executes risk scoring and anomaly detection.
  
#### **4 RAG-Based GenAI Insights (AWS Bedrock)**
- Uses **Titan, Claude, Jurassic-2 models** to analyze **macro trends**.
- Provides **context-aware financial intelligence**.

### Scalability & Deployment
**Microservices-based architecture** optimized for **Docker & Kubernetes**.  
**Event-driven processing** using **Kafka** for real-time trade analytics.  
**Secure & scalable AWS deployment** using **ECS, Lambda, S3, and API Gateway**.

## Technology Stack
| **Category**         | **Technology**                                      |
|----------------------|-----------------------------------------------------|
| **Programming Language** | Java (Spring Boot), Python (ML Models)           |
| **Database**         | PostgreSQL (pgvector), Pinecone, Weaviate           |
| **AI & ML**         | AWS Forecast, SageMaker, Fraud Detector             |
| **GenAI RAG**       | AWS Bedrock (Titan, Claude, Jurassic-2)             |
| **Event Streaming** | Apache Kafka, RabbitMQ                              |
| **Cloud Deployment** | AWS ECS, Lambda, S3, API Gateway                    |
| **Containerization** | Docker, Kubernetes                                 |


## Getting Started
```bash
# Clone the repository
git clone https://github.com/YOUR-USERNAME/ai-vector-db-forex-aws-java.git
cd ai-vector-db-forex-aws-java

# Build & Run the Spring Boot application
mvn clean install
mvn spring-boot:run



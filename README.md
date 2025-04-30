# Distributed Internet Banking System

## System Architecture

```mermaid
graph LR
    Client[Client] --> Gateway[API Gateway :8082]
    Gateway --> KC[Keycloak :8180]
    Gateway --> US[User Service :8083]
    Gateway --> BS[Banking Service :8761]
    Gateway --> FT[Fund Transfer Service]
    Gateway --> UP[Utility Payment Service]
    Gateway --> CB[Core Banking Service]
    
    subgraph Authentication
        KC -- JWT Token --> Gateway
    end
    
    subgraph Service Registry
        BS -- Register --> US
        BS -- Register --> Gateway
        BS -- Register --> FT
        BS -- Register --> UP
        BS -- Register --> CB
    end
```

## Sequence Diagrams

### 1. User Registration Flow
```mermaid
sequenceDiagram
    participant Client
    participant Gateway
    participant UserService
    participant Keycloak

    Client->>Gateway: POST /api/v1/bank-user/register
    Note over Gateway: permitAll
    Gateway->>UserService: Forward Request
    UserService->>Keycloak: Create User in Keycloak
    Keycloak->>UserService: User Created
    UserService->>UserService: Create User in DB
    UserService->>Gateway: Success Response
    Gateway->>Client: Registration Confirmation
```

### 2. Fund Transfer Flow
```mermaid
sequenceDiagram
    participant Client
    participant Gateway
    participant FundTransferService
    participant CoreBankingService

    Client->>Gateway: POST /api/v1/transfer
    Note over Gateway: JWT Validation
    Gateway->>FundTransferService: Forward Request
    FundTransferService->>FundTransferService: Create Transaction (PENDING)
    FundTransferService->>CoreBankingService: POST /api/v1/transaction/fund-transfer
    CoreBankingService->>CoreBankingService: Validate Accounts
    CoreBankingService->>CoreBankingService: Process Debit
    CoreBankingService->>CoreBankingService: Process Credit
    CoreBankingService->>FundTransferService: Transaction Response
    FundTransferService->>FundTransferService: Update Status (SUCCESS)
    FundTransferService->>Gateway: Success Response
    Gateway->>Client: Transfer Confirmation
```

### 3. Utility Payment Flow
```mermaid
sequenceDiagram
    participant Client
    participant Gateway
    participant UtilityPaymentService
    participant CoreBankingService

    Client->>Gateway: POST /api/v1/utility-payment
    Note over Gateway: JWT Validation
    Gateway->>UtilityPaymentService: Forward Request
    UtilityPaymentService->>UtilityPaymentService: Create Payment (PROCESSING)
    UtilityPaymentService->>CoreBankingService: POST /api/v1/transaction/utill-payment
    CoreBankingService->>CoreBankingService: Validate Account
    CoreBankingService->>CoreBankingService: Process Debit
    CoreBankingService->>UtilityPaymentService: Transaction Response
    UtilityPaymentService->>UtilityPaymentService: Update Status (SUCCESS)
    UtilityPaymentService->>Gateway: Success Response
    Gateway->>Client: Payment Confirmation
```

### 4. Service Discovery Flow
```mermaid
sequenceDiagram
    participant UserService
    participant FundTransferService
    participant UtilityPaymentService
    participant Eureka
    participant Gateway

    UserService->>Eureka: Register Service (port 8083)
    FundTransferService->>Eureka: Register Service
    UtilityPaymentService->>Eureka: Register Service
    Gateway->>Eureka: Discover Services
    Eureka->>Gateway: Service List
    Gateway->>UserService: Forward Request
    UserService->>Gateway: Response
```

## Components

1. **API Gateway** (port 8082)
   - Spring Cloud Gateway
   - JWT Validation
   - Service Routing
   - Public/Protected Endpoints

2. **User Service** (port 8083)
   - User Management
   - Keycloak Integration
   - Database Operations
   - REST Endpoints

3. **Fund Transfer Service**
   - Transaction Management
   - Account Operations
   - Core Banking Integration
   - Transaction Status Tracking
   - Endpoint: `/api/v1/transfer`

4. **Utility Payment Service**
   - Payment Processing
   - Provider Management
   - Account Operations
   - Payment Status Tracking
   - Endpoint: `/api/v1/utility-payment`

5. **Core Banking Service**
   - Account Management
   - Transaction Processing
   - Balance Operations
   - Account Validation
   - Endpoints: 
     - `/api/v1/transaction/fund-transfer`
     - `/api/v1/transaction/utill-payment`

6. **Banking Service** (port 8761)
   - Eureka Server
   - Service Registry
   - Service Discovery

7. **Keycloak** (port 8180)
   - Authentication Server
   - User Management
   - JWT Token Issuance


# Network setup

- reverse proxy and cert management for SSL https 443 connections
- vm with dockers for reactjs and expressjs
- dekstop with GPU and LLM capabilities, inside internal network NOT exposed to internet aka behind a strict firewall
- browser and TLD/DNS services in the wild wild web where blackhats hunt for prey


```mermaid
    flowchart TD

%%    subgraph Internet
%%        WildWildOuterWeb
%%    end

    subgraph Intranet
        %%VMwithDocker
        DesktopWithGPUandOllama
        %%VMwithReverseproxy
        Server
    end

    subgraph ContainerVnet
        reactjsDockerContainer
        mongoDB
        expressjsAPI
    end

    %%subgraph VMvnet[vnet of React and  DB VM]
    %%    ContainerVnet
    %%    expressjsAPI
    %%end

    subgraph VMwithDocker[VMwithDocker]
        IP1[192.168.9.2]
        ContainerVnet
        
        %%VMvnet 
    end
    subgraph DesktopWithGPUandOllama[Computer with LLM]
        IP2[192.168.9.9]
        ollama
    end
    subgraph VMwithReverseproxy[VMwithReverseproxy]
        IP3[192.168.9.1]
        reverseproxyAndCerts
    end
    subgraph WildWildOuterWeb
        TLD_domainName
        browser
    end
    subgraph Server
        VMwithDocker
        VMwithReverseproxy
    end

    class IP1,IP2,IP3 ip;
    classDef ip color:#0f0;
    class VMwithReverseproxy,VMwithDocker vm;
    classDef vm color:#f00,stroke:#f00;
    class reactjsDockerContainer,reverseproxyAndCerts,expressjsAPI,mongoDB container;
    classDef container color:#0af;
    class Server,DesktopWithGPUandOllama machine;
    classDef machine color:#0f0,stroke:#0f0;

    %%Internet --> firewall_switch((Firewall/Switch))
%%    firewall_switch --> Intranet
    %%browser --> reverseproxyAndCerts

    TLD_domainName(TLD DNS) --> browser
    browser --> TLD_domainName
    browser(Client Browser) -- domain.TLD --> firewall_switch
    reverseproxyAndCerts(Reverse proxy & Cert Container) -- sub.domain.TLD/APP ==> 192.168.9.2:3000 --> reactjsDockerContainer
    reactjsDockerContainer(React Container) --> browser
%%    browser --> expressjsAPI
    expressjsAPI(Express API Container) -- 192.168.9.9 --> ollama
    ollama(LLM API) -- 192.168.9.2:3001 --> expressjsAPI
    expressjsAPI --> browser
    expressjsAPI -- 172.2.1.2 --> mongoDB
    mongoDB(MongoDB Container) -- 172.2.1.1 --> expressjsAPI

    firewall_switch((Firewall/Switch))  -- sub.domain.TLD ==> 192.168.9.1 --> reverseproxyAndCerts
    reverseproxyAndCerts -- sub.domain.TLD/API ==> 192.168.9.2 --> expressjsAPI



```


## DB structure

```mermaid
    erDiagram

    User ||--o{ Card : owns
    User ||--o{ Pack : owns
    User ||--o{ Item : sells
    User ||--|| Person : is
    User ||--o{ Deck : owns
    Pack ||--|{ Card : contains
    Item ||--|| Pack : consists-of
    Item ||--|| Card : consists-of
    Deck ||--o{ Card : contains


    User {
        int id
        string userName
        string password
        array cards
        array packs
    }

    Person {
        int id
        int userId
        string firstName
        string lastName
        string address
        string phoneNum
        string email
    }

    Card {
        int id
        string faction
        string character
        string name
        int rarity
        int attack
        int defense
        int etc-etc-etc
        string description
    }

    Pack {
        int id
        array cards
        string faction
        string specialtyType
        boolean unOpened
    }

    Item {
        int id
        int itemId
        int userId
        string type
        float price
        float discount
        boolean onSale
    }

    Deck {
        int id
        int userId
        string name
        string faction
    }

    
```

## Card generation


### Pack generation


```mermaid
    stateDiagram

    state GeneratePack {
        [*] --> Rarity
        Rarity --> Faction
        Faction --> [*]
    }

    [*] --> NeedPacks?
    NeedPacks? --> GeneratePack
    GeneratePack --> GenerateCard
    GenerateCard --> [*]



```


### Card generation

```mermaid
    stateDiagram-v2

    %%state allCards <<choice>>

    state MLgeneration {
        [*] --> GenerateName
        GenerateName --> GenerateDescription
        GenerateDescription --> GenerateImage
    }

    state RuleBasedRandomization {
        [*] --> Faction
        Faction --> CharacterClass
        CharacterClass --> RandomizeSpecs
    }

%%    state PackGeneration{
%%        [*] --> GeneratePack
%%        GeneratePack --> [*]
%%    }


    [*] --> RuleBasedRandomization
    %%GenerateCard --> RuleBasedRandomization
    RuleBasedRandomization --> MLgeneration
    MLgeneration --> [*]

    %%MLgeneration --> allCards
    %%allCards --> True : all cards generated for the pack
    %%allCards --> False : more cards to be generated
    %%False --> GenerateCard
    %%True --> [*]

    



```

## Work plan

## Project

```mermaid
    stateDiagram

    state join2 <<join>>



    state Project {
        [*] --> CreateTrello
        CreateTrello --> PlanSprint
        PlanSprint --> FigmaUI
        FigmaUI --> CreateRepo
        CreateRepo --> DecideRulesForPacks
        DecideRulesForPacks --> HowManyCards_etc
        HowManyCards_etc --> WhatTypes
        WhatTypes --> join2

        CreateRepo --> DecideRulesForCards
        DecideRulesForCards --> WhatSpecs_etc
        WhatSpecs_etc --> join2

        join2 --> [*]
        
    }

    
```


### Technical

```mermaid
    stateDiagram

    state join1 <<join>>
    state join3 <<join>>

    state Technical {
        [*] --> Containers
        Containers --> React
        Containers --> MongoDB
        Containers --> ExpressJS_API
        ExpressJS_API --> join1
        MongoDB --> join1
        React --> FigmaExport
        FigmaExport --> FrontEndReact
        
        join1 --> LLM_API
        LLM_API --> BackEndAPI
        [*] --> PromptEngineering
        PromptEngineering --> Chaining
        
        Chaining --> join3
        BackEndAPI --> join3
        FrontEndReact --> join3

        join3 --> [*]

    }


```


## Forms and routes

```mermaid
    flowchart

    %%[*] --> FrontPage

    NavBar --> Frontpage

    NavBar --> Signing(Login form)
    NavBar --> Registering(Registration form)
    NavBar --> Store(Store page)
    NavBar --> Market(Trading market page)
    NavBar --> Inventory(Personal inventory)
    NavBar --> Basket(Shopping basket)

    Inventory --> Card(Trading card)
    Inventory --> Deck(Decks set up by user)
    Deck --> Card

    Store --> Item(Shopping item <br> Card or Pack)

    Market --> Item

    Basket --> Item

    %%Item --> Pack(Unopened pack)
    %%Item --> Card

    Signing --> Registering




```

# Network setup

- reverse proxy and cert management for SSL https 443 connections
- vm with dockers for reactjs and expressjs
- dekstop with GPU and LLM capabilities, inside internal network NOT exposed to internet aka behind a strict firewall
- browser and TLD/DNS services in the wild wild web where blackhats hunt for prey


```mermaid
    flowchart LR

    subgraph Internet
        WildWildOuterWeb
    end

    subgraph Intranet
        VMvnet
        DesktopWithGPUandOllama
        VMwithReverseproxy
    end

    subgraph ContainerVnet
        reactjsDockerContainer
        mongoDB
    end

    subgraph VMvnet
        VMwithDocker
    end

    subgraph VMwithDocker
        ContainerVnet
        expressjsAPI
    end
    subgraph DesktopWithGPUandOllama
        ollama
    end
    subgraph VMwithReverseproxy
        reverseproxyAndCerts
    end

    subgraph WildWildOuterWeb
        TLD_domainName
        browser
    end

    %%Internet --> firewall_switch((Firewall/Switch))
%%    firewall_switch --> Intranet
    %%browser --> reverseproxyAndCerts
    browser --> firewall_switch
    reverseproxyAndCerts --> reactjsDockerContainer
    reactjsDockerContainer --> browser
%%    browser --> expressjsAPI
    expressjsAPI --> ollama
    ollama --> expressjsAPI
    expressjsAPI --> browser
    expressjsAPI --> mongoDB
    mongoDB --> expressjsAPI

    firewall_switch((Firewalll/Switch)) --> reverseproxyAndCerts
    reverseproxyAndCerts --> expressjsAPI



```
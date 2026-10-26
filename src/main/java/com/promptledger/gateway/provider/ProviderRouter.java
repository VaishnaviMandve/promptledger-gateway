package com.promptledger.gateway.provider;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProviderRouter {

    private final List<LlmProvider> providers;

    public ProviderRouter(List<LlmProvider> providers) {
        this.providers = providers;
    }

    public ChatResponse route(ChatRequest request) {
        LlmProvider provider = providers.stream()
                .filter(p -> p.supports(request.model()))
                .findFirst()
                .orElseThrow(() -> new UnsupportedModelException(request.model()));

        return provider.chat(request);
    }
}

package com.promptledger.gateway.provider;

public interface LlmProvider {

    String name();

    boolean supports(String model);

    ChatResponse chat(ChatRequest request);
}

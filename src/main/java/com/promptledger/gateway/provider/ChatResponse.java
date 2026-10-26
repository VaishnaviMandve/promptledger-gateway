package com.promptledger.gateway.provider;

public record ChatResponse(
        String provider,
        String model,
        String content,
        int inputTokens,
        int outputTokens) {
}

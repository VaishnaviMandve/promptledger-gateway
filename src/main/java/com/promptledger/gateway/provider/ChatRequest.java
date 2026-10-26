package com.promptledger.gateway.provider;

import java.util.List;

public record ChatRequest(String model, List<ChatMessage> messages) {
}

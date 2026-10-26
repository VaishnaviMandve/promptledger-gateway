package com.promptledger.gateway.provider.mock;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.promptledger.gateway.provider.ChatMessage;
import com.promptledger.gateway.provider.ChatRequest;
import com.promptledger.gateway.provider.ChatResponse;
import com.promptledger.gateway.provider.LlmProvider;

@Component
class MockLlmProvider implements LlmProvider {

    @Override
    public String name() {
        return "mock";
    }

    @Override
    public boolean supports(String model) {
        return model != null && model.startsWith("mock");
    }

    @Override
    public ChatResponse chat(ChatRequest request) {
        String prompt = request.messages().stream()
                .map(ChatMessage::content)
                .collect(Collectors.joining(" "));

        simulateLatency();

        String reply = "This is a mock reply to: " + prompt;

        return new ChatResponse(
                name(),
                request.model(),
                reply,
                estimateTokens(prompt),
                estimateTokens(reply));
    }

    private int estimateTokens(String text) {
        return Math.max(1, text.length() / 4);
    }

    private void simulateLatency() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

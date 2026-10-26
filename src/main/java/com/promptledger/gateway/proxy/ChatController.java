package com.promptledger.gateway.proxy;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promptledger.gateway.provider.ChatRequest;
import com.promptledger.gateway.provider.ChatResponse;
import com.promptledger.gateway.provider.ProviderRouter;

@RestController
@RequestMapping("/v1/chat")
class ChatController {

    private final ProviderRouter providerRouter;

    ChatController(ProviderRouter providerRouter) {
        this.providerRouter = providerRouter;
    }

    @PostMapping("/completions")
    ChatResponse complete(@RequestBody ChatRequest request) {
        return providerRouter.route(request);
    }
}

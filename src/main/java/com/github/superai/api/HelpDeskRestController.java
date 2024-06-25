package com.github.superai.api;


import com.github.superai.assistant.CustomerSupportAssistant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/v1/api")
@Slf4j
@RequiredArgsConstructor
public class HelpDeskRestController {

    private final CustomerSupportAssistant customerSupportAssistant;


    @GetMapping("/helpdesk")
    public Flux<String> chat(
            @RequestParam(value = "chatId") String chatId,
            @RequestParam(value = "message") String message) {
        log.info("Meesage = {}", message);
        log.info("chatId = {}", chatId);

        return
        customerSupportAssistant.chat(chatId, message);



    }

}
package com.example.quick.poll.app.controllers;

import com.example.quick.poll.app.models.Poll;
import com.example.quick.poll.app.services.PollService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/polls")
@RequiredArgsConstructor
@Slf4j
public class PollController {

    private final PollService pollService;

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        log.info("test endpoint hit");
        return new ResponseEntity<>("working perfectly", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createPoll(@RequestBody Poll poll) {
        try {
            log.info("received request to create poll: {}", poll);
            pollService.savePoll(poll);
            return ResponseEntity.ok("Created poll successfully");
        } catch (Exception e) {
            log.error("Exception while creating polls", e);
            return new ResponseEntity<>("Exception occurred while creating polls", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Poll> getPoll(@PathVariable Long id) {
        return ResponseEntity.ok(pollService.findPoll(id));
    }

    @GetMapping
    public ResponseEntity<List<Poll>> getAllPolls() {
        return ResponseEntity.ok(pollService.findAllPolls());
    }

}

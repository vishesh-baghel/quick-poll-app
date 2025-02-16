package com.example.quick.poll.app.controllers;

import com.example.quick.poll.app.dtos.PollResults;
import com.example.quick.poll.app.models.Vote;
import com.example.quick.poll.app.services.VoteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/votes")
@RequiredArgsConstructor
@Slf4j
public class VoteController {

    private final VoteService voteService;

    @PostMapping
    public ResponseEntity<String> castVote(@RequestBody Vote vote) {
        log.info("received request to save vote");
        voteService.castVote(vote);
        return ResponseEntity.ok("Saved vote successfully");
    }

    @GetMapping("/results/{pollId}")
    public ResponseEntity<List<PollResults>> getPollResults(@PathVariable Long pollId) {
        return ResponseEntity.ok(voteService.getPollResults(pollId));
    }
}


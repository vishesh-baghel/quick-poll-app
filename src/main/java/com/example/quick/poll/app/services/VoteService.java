package com.example.quick.poll.app.services;

import com.example.quick.poll.app.dtos.PollResults;
import com.example.quick.poll.app.dtos.VoteRequest;
import com.example.quick.poll.app.models.Vote;

import java.util.List;

public interface VoteService {

    void castVote(VoteRequest request);

    List<PollResults> getPollResults(Long pollId);
}

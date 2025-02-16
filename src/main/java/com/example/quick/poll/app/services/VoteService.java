package com.example.quick.poll.app.services;

import com.example.quick.poll.app.dtos.PollResults;
import com.example.quick.poll.app.models.Vote;

import java.util.List;

public interface VoteService {

    void castVote(Vote vote);

    List<PollResults> getPollResults(Long pollId);
}

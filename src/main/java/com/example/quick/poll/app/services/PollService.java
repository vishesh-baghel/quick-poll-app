package com.example.quick.poll.app.services;

import com.example.quick.poll.app.models.Poll;

import java.util.List;
import java.util.Optional;

public interface PollService {

    Long savePoll(Poll poll);

    Poll findPoll(long id);

    List<Poll> findAllPolls();
}

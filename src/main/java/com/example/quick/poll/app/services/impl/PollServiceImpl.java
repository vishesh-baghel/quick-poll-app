package com.example.quick.poll.app.services.impl;

import com.example.quick.poll.app.models.Poll;
import com.example.quick.poll.app.repositories.PollRepository;
import com.example.quick.poll.app.services.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PollServiceImpl implements PollService {

    private final PollRepository pollRepository;

    @Override
    public void savePoll(Poll poll) {
        pollRepository.save(poll);
    }

    @Override
    public Poll findPoll(long id) {
        return pollRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Poll> findAllPolls() {
        return pollRepository.findAll();
    }
}

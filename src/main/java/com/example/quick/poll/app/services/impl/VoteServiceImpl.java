package com.example.quick.poll.app.services.impl;

import com.example.quick.poll.app.dtos.PollResults;
import com.example.quick.poll.app.dtos.VoteRequest;
import com.example.quick.poll.app.models.Poll;
import com.example.quick.poll.app.models.User;
import com.example.quick.poll.app.models.Vote;
import com.example.quick.poll.app.repositories.UserRepository;
import com.example.quick.poll.app.repositories.VoteRepository;
import com.example.quick.poll.app.services.PollService;
import com.example.quick.poll.app.services.VoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {

    private final VoteRepository voteRepository;

    private final UserRepository userRepository;

    private final PollService pollService;

    @Override
    public Long castVote(VoteRequest request) {
        Poll poll = pollService.findPoll(request.getPollId());
        User user = userRepository.findById(request.getUserId()).orElseThrow();

        Vote vote = new Vote();
        vote.setPoll(poll);
        vote.setUser(user);
        vote.setSelectedOption(request.getSelectedOption());

        Vote voteObj = voteRepository.save(vote);

        return voteObj.getId();
    }

    @Override
    public List<PollResults> getPollResults(Long pollId) {
        List<Vote> votes = voteRepository.findByPollId(pollId);

        Map<String, Long> voteCountMap = votes.stream()
                .collect(Collectors.groupingBy(Vote::getSelectedOption, Collectors.counting()));

        return voteCountMap.entrySet().stream()
                .map(entry -> new PollResults(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}

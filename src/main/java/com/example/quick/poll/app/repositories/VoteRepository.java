package com.example.quick.poll.app.repositories;

import com.example.quick.poll.app.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {

    List<Vote> findByPollId(Long id);
}

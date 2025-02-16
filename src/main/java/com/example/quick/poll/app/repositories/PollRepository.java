package com.example.quick.poll.app.repositories;

import com.example.quick.poll.app.models.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PollRepository extends JpaRepository<Poll, Long> {

    @Query("SELECT p FROM Poll p JOIN FETCH p.options WHERE p.id = :pollId")
    Optional<Poll> findPollWithOptions(@Param("pollId") Long pollId);
}

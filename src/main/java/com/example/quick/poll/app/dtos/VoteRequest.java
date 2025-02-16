package com.example.quick.poll.app.dtos;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class VoteRequest {
    private Long pollId;
    private Long userId;
    private String selectedOption;
}

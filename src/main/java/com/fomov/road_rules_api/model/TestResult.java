package com.fomov.road_rules_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "test_result")
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "topic")
    private Topic topic;

    @Column(name = "test_date")
    private LocalDateTime testDate;

    @Column(name = "score", nullable = false)
    private int score;

    @Column(name = "time_spent", nullable = false)
    private int timeSpent;
}
package tddmicroexercises.leaderboard.models;

import java.util.Map;

public record Race(Map<Driver, Integer> results) {}
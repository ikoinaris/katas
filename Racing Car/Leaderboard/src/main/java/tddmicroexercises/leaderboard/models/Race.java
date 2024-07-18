package tddmicroexercises.leaderboard.models;

import tddmicroexercises.leaderboard.interfaces.Competitor;

import java.util.Map;

public record Race(Map<Competitor, Integer> results) {}
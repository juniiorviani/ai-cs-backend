package com.nukk.model;

public record Ticket(
    String id,
    String subject,
    String priority,
    String status,
    String openedAt,
    String sentiment
) {
}

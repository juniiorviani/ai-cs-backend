package com.nukk.model;

import java.util.List;

public record Customer(
    String id,
    String company,
    double mrr,
    int healthScore,
    int usageLast30Days,
    int previousUsage,
    int openTickets,
    List<Ticket> recentTickets,
    String lastLogin,
    String accountAge
) {
}

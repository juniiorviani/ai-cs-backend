package com.nukk.model;

import java.util.List;

public record Customer(
    String id,
    String company,
    String domain,
    String industry,
    String plan,
    double mrr,
    int healthScore,
    int usage30d,
    double usageChangePct,
    List<Integer> usageTrend,
    int seats,
    int activeSeats,
    int openTickets,
    List<Ticket> tickets,
    List<FeatureAdoption> featureAdoption,
    List<TimelineEvent> timeline,
    String csm,
    String contactName,
    String contactEmail,
    String customerSince,
    String renewalDate,
    String lastLogin,
    Integer nps
) {
}

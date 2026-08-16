package com.nukk.model;

public record TimelineEvent(
    String date,
    String title,
    String detail,
    String icon,
    String color
) {
}

package com.vantageCircle.User.Aggregate.Report.dto;

public class UserAggregateReport {

    private Long userId;
    private int totalDays;
    private long daysInGold;
    private long daysInSilver;
    private long daysInBronze;
    private double percentageInGold;
    private double percentageInSilver;
    private double percentageInBronze;
    private String primaryLeague;

    public UserAggregateReport(Long userId, int totalDays, long daysInGold, long daysInSilver, long daysInBronze,
                               double percentageInGold, double percentageInSilver, double percentageInBronze, String primaryLeague) {
        this.userId = userId;
        this.totalDays = totalDays;
        this.daysInGold = daysInGold;
        this.daysInSilver = daysInSilver;
        this.daysInBronze = daysInBronze;
        this.percentageInGold = percentageInGold;
        this.percentageInSilver = percentageInSilver;
        this.percentageInBronze = percentageInBronze;
        this.primaryLeague = primaryLeague;
    }
    //Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public long getDaysInGold() {
        return daysInGold;
    }

    public long getDaysInSilver() {
        return daysInSilver;
    }

    public long getDaysInBronze() {
        return daysInBronze;
    }

    public double getPercentageInGold() {
        return percentageInGold;
    }

    public double getPercentageInSilver() {
        return percentageInSilver;
    }

    public double getPercentageInBronze() {
        return percentageInBronze;
    }

    public String getPrimaryLeague() {
        return primaryLeague;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public void setDaysInGold(long daysInGold) {
        this.daysInGold = daysInGold;
    }

    public void setDaysInSilver(long daysInSilver) {
        this.daysInSilver = daysInSilver;
    }

    public void setDaysInBronze(long daysInBronze) {
        this.daysInBronze = daysInBronze;
    }

    public void setPercentageInGold(double percentageInGold) {
        this.percentageInGold = percentageInGold;
    }

    public void setPercentageInSilver(double percentageInSilver) {
        this.percentageInSilver = percentageInSilver;
    }

    public void setPercentageInBronze(double percentageInBronze) {
        this.percentageInBronze = percentageInBronze;
    }

    public void setPrimaryLeague(String primaryLeague) {
        this.primaryLeague = primaryLeague;
    }
}

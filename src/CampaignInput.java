public class CampaignInput {
    private String customer;
    private double impressionPerCampaign;
    private double pricePerCampaign;

    private Rank rank;

    public CampaignInput(String customer, double impressionPerCampaign, double pricePerCampaign) {
        this.customer = customer;
        this.impressionPerCampaign = impressionPerCampaign;
        this.pricePerCampaign = pricePerCampaign;
        rank = new Rank(calculateRankAvg(impressionPerCampaign, pricePerCampaign));
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public double getImpressionPerCampaign() {
        return impressionPerCampaign;
    }

    public void setImpressionPerCampaign(double impressionPerCampaign) {
        this.impressionPerCampaign = impressionPerCampaign;
    }

    public double getPricePerCampaign() {
        return pricePerCampaign;
    }

    public void setPricePerCampaign(double pricePerCampaign) {
        this.pricePerCampaign = pricePerCampaign;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    double calculateRankAvg(double impressionPerCampaign, double pricePerCampaign) {
        return pricePerCampaign / impressionPerCampaign;
    }
}

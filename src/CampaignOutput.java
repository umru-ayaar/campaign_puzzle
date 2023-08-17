public class CampaignOutput {
    private final String customer;
    private double numberOFCampaignsToSell;
    private final double totalImpressionsForCustomer;
    private final double totalRevenueForCustomer;

    public CampaignOutput(String customer, double numberOFCampaignsToSell, double totalImpressionsForCustomer, double totalRevenueForCustomer) {
        this.customer = customer;
        this.numberOFCampaignsToSell = numberOFCampaignsToSell;
        this.totalImpressionsForCustomer = totalImpressionsForCustomer;
        this.totalRevenueForCustomer = totalRevenueForCustomer;
    }

    public String getCustomer() {
        return customer;
    }

    public double getNumberOFCampaignsToSell() {
        return numberOFCampaignsToSell;
    }

    public void setNumberOFCampaignsToSell(double numberOFCampaignsToSell) {
        this.numberOFCampaignsToSell = numberOFCampaignsToSell;
    }

    public double getTotalImpressionsForCustomer() {
        return totalImpressionsForCustomer;
    }

    public double getTotalRevenueForCustomer() {
        return totalRevenueForCustomer;
    }

}

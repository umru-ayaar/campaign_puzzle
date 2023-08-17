import java.util.List;

public class CampaignOutputManager {
    private final List<CampaignOutput> campaignOutputList;
    private Integer totalNumberOfImpressions;
    private Integer totalRevenue;

    public CampaignOutputManager(List<CampaignOutput> campaignOutputList) {
        this.campaignOutputList = campaignOutputList;
    }

    public List<CampaignOutput> getCampaignOutputList() {
        return campaignOutputList;
    }


    public Integer getTotalNumberOfImpressions() {
        return totalNumberOfImpressions;
    }

    public void setTotalNumberOfImpressions(Integer totalNumberOfImpressions) {
        this.totalNumberOfImpressions = totalNumberOfImpressions;
    }

    public Integer getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Integer totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}

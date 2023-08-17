import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CampaignInputManager {
    private Integer impressionInventory;
    private List<CampaignInput> campaignInputs;

    public CampaignInputManager() {
    }

    public CampaignInputManager(Integer impressionInventory, List<CampaignInput> campaignInputs) {
        this.impressionInventory = impressionInventory;
        this.campaignInputs = campaignInputs;
    }

    public Integer getImpressionInventory() {
        return impressionInventory;
    }

    public void setImpressionInventory(Integer impressionInventory) {
        this.impressionInventory = impressionInventory;
    }

    public List<CampaignInput> getCampaigns() {
        return campaignInputs;
    }

    public void setCampaigns(List<CampaignInput> campaignInputs) {
        this.campaignInputs = campaignInputs;
    }

}

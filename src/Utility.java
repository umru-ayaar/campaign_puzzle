import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Utility {
    public static int extractIntegerPart(double number) {
        return (int) number;
    }

    public static String fullForm(double number){
        return String.format("%.0f", number);
    }

    public static CampaignInputManager loadData(String[] args) throws IOException {
        CampaignInputManager campaignInputManager=new CampaignInputManager();

        FileInputStream inputStream = new FileInputStream(args[0]);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        List<CampaignInput> campaignInputList = new ArrayList<>();

        int lineTraversed=0;
        String line;
        while ((line = reader.readLine()) != null) {
            if(lineTraversed==0){
                campaignInputManager.setImpressionInventory(Integer.parseInt(line.trim()));
                lineTraversed++;
                continue;
            }

            String[] tokens = line.split(",");
            String customer = tokens[0];
            double impressionsPerCampaign = Double.parseDouble(tokens[1]);
            double pricePerCampaign = Double.parseDouble(tokens[2]);
            campaignInputList.add(new CampaignInput(customer, impressionsPerCampaign, pricePerCampaign));
        }

        campaignInputManager.setCampaigns(campaignInputList);

        return campaignInputManager;
    }


}

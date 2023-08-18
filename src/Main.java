import java.io.*;
import java.util.*;

public class Main {
    public static List<CampaignInput> campaignInputList=new ArrayList<>();
    public static CampaignInputManager campaignInputManager;
    public static CampaignOutputManager campaignOutputManager;

    public static List<CampaignOutput> campaignOutputList=new ArrayList<>();

    static int inventoryLeft =0;

    public static void main(String[] args) throws IOException {


        campaignInputManager=Utility.loadData(args);
        campaignInputList=campaignInputManager.getCampaigns();

        findAndSetRank();
        assignCampaigns();
        calculateImpressionAndRevenue();
        printOutputStatus();
    }

    static void findAndSetRank() {

        for (CampaignInput campaignInput : campaignInputList) {
            double rankValue = calculateRankValue(campaignInput.getRank().getAvg());
            campaignInput.getRank().setRankValue(rankValue);
        }

        campaignInputList.sort(new Comparator<CampaignInput>() {
            @Override
            public int compare(CampaignInput o1, CampaignInput o2) {
                if (o1.getRank().getRankValue() != o2.getRank().getRankValue()) {
                    return Integer.compare((int) o1.getRank().getRankValue(), (int) o2.getRank().getRankValue());
                } else {
                    return Integer.compare((int) o1.getImpressionPerCampaign(), (int) o2.getImpressionPerCampaign());
                }
            }
        });

            for (int k = 0; k < campaignInputList.size(); k++) {
                int tempVal=k+1;
                campaignInputList.get(k).getRank().setRankValue(tempVal);
            }

    }

    static double calculateRankValue(double avg) {
        List<Double> avgValues = new ArrayList<>();
        for (CampaignInput campaignInput : campaignInputList) {
            avgValues.add(campaignInput.getRank().getAvg());
        }

        avgValues.sort(Collections.reverseOrder());
        return avgValues.indexOf(avg) + 1;
    }


    static void assignCampaigns()
    {
        inventoryLeft =campaignInputManager.getImpressionInventory();

        for (int i = 0; i < campaignInputManager.getCampaigns().size(); i++) {
            double modStatus = inventoryLeft % campaignInputManager.getCampaigns().get(i).getImpressionPerCampaign();

            double value = inventoryLeft / campaignInputManager.getCampaigns().get(i).getImpressionPerCampaign();

            double impressionsForSingleCampaign=campaignInputManager.getCampaigns().get(i).getImpressionPerCampaign();
            double rate=campaignInputManager.getCampaigns().get(i).getPricePerCampaign();
            String name=campaignInputManager.getCampaigns().get(i).getCustomer();

            double inventoryUsed;
            double integerPart;


            if(modStatus==0){
                inventoryUsed=value*impressionsForSingleCampaign;
                inventoryLeft = (int) (inventoryLeft -inventoryUsed);
                campaignOutputList.add(new CampaignOutput(name,value,inventoryUsed,value*rate));
                continue;
            }else {

                integerPart=Utility.extractIntegerPart(value);

                inventoryUsed=integerPart*impressionsForSingleCampaign;

                inventoryLeft = (int) (inventoryLeft -inventoryUsed);


            }

            if(integerPart==1||integerPart<1){
                campaignOutputList.add(new CampaignOutput(name,integerPart,inventoryUsed,integerPart*rate));

            } else {
                boolean isEnoughInventory=false;
                for (int j = i+1; j < campaignInputManager.getCampaigns().size(); j++) {
                    if (inventoryLeft > campaignInputManager.getCampaigns().get(j).getImpressionPerCampaign()) {

                        isEnoughInventory = true;
                        break;
                    }
                }

                if(!isEnoughInventory){
                    inventoryLeft= inventoryLeft+(int) (impressionsForSingleCampaign);
                    campaignOutputList.add(new CampaignOutput(name,integerPart-1,inventoryUsed-impressionsForSingleCampaign,(integerPart-1)*rate));

                }else {
                    campaignOutputList.add(new CampaignOutput(name,integerPart,inventoryUsed,integerPart*rate));

                }


            }

        }

    }


    static void printOutputStatus(){
        for (CampaignOutput campaignOutput : campaignOutputManager.getCampaignOutputList()) {
            System.out.print( campaignOutput.getCustomer()+",");
            System.out.print( (int)campaignOutput.getNumberOFCampaignsToSell()+",");
            System.out.print( Utility.fullForm(campaignOutput.getTotalImpressionsForCustomer())+",");
            System.out.print( Utility.fullForm(campaignOutput.getTotalRevenueForCustomer()));
            System.out.println();
        }
        System.out.print(campaignOutputManager.getTotalNumberOfImpressions()+",");
        System.out.print(campaignOutputManager.getTotalRevenue());

    }

    static void calculateImpressionAndRevenue(){
         campaignOutputManager=new CampaignOutputManager(campaignOutputList);
        double totalImpression=0;
        double totalRevenue=0;
        for (CampaignOutput campaignOutput : campaignOutputList) {
            totalImpression = totalImpression + campaignOutput.getTotalImpressionsForCustomer();
            totalRevenue = totalRevenue + campaignOutput.getTotalRevenueForCustomer();
        }
        campaignOutputManager.setTotalRevenue((int) totalRevenue);
        campaignOutputManager.setTotalNumberOfImpressions((int) totalImpression);

    }
}
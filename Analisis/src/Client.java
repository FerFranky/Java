
public class Client {
	public static void main(String[] args){
		String filePath = "C:\\Users\\FerFranky\\Documents\\8 semestre\\taller de investigacion\\dm\\DataMiningAlgorithm-master\\StatisticalLearning\\DataMining_EM\\input.txt";
		
		EMTool tool = new EMTool(filePath);
		try{
		Thread.sleep(10000);
		}catch(Exception e){
			
		}
		tool.readDataFile();
		tool.exceptMaxStep();
	}
}

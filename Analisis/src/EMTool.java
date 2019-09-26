
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;

public class EMTool {

	private String dataFilePath;

	private String[][] data;
	
	private ArrayList<Point> pointArray;
	
	public Point p1;
	
	public Point p2;

	public EMTool(String dataFilePath) {
            
		this.dataFilePath = dataFilePath;
		pointArray = new ArrayList<>();
                
	}

    EMTool() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



	
	public void readDataFile() {
            long tInicio=System.currentTimeMillis();
		File file = new File(dataFilePath);
		ArrayList<String[]> dataArray = new ArrayList<String[]>();

		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			String str;
			String[] tempArray;
			while ((str = in.readLine()) != null) {
				tempArray = str.split(" ");
				dataArray.add(tempArray);
			}
			in.close();
		} catch (IOException e) {
			e.getStackTrace();
		}

		data = new String[dataArray.size()][];
		dataArray.toArray(data);

		
		p1 = new Point(Integer.parseInt(data[0][0]),
				Integer.parseInt(data[0][1]));
		p2 = new Point(Integer.parseInt(data[1][0]),
				Integer.parseInt(data[1][1]));

		Point p;
		for (String[] array : data) {
			
			p = new Point(Integer.parseInt(array[0]),
					Integer.parseInt(array[1]));
			pointArray.add(p);
		}
                long tEjecucion=System.currentTimeMillis()-tInicio;
                System.out.println("Tiempo"+tEjecucion);
	}
double distance1 = 0;
double distance2 = 0;
	private void computeMemberShip(Point p) {
		long tInicio=System.currentTimeMillis();
		
		
		

		
		distance1 = Math.pow(p.getX() - p1.getX(), 2)
				+ Math.pow(p.getY() - p1.getY(), 2);
		distance2 = Math.pow(p.getX() - p2.getX(), 2)
				+ Math.pow(p.getY() - p2.getY(), 2);

		p.setMemberShip1(distance2 / (distance1 + distance2));
		p.setMemberShip2(distance1 / (distance1 + distance2));
                long tEjecucion=System.currentTimeMillis()-tInicio;
                System.out.println("Tiempo"+tEjecucion);
	}

	public void exceptMaxStep() {
		double p1X = 0;
		double p1Y = 0;
		double p2X = 0;
		double p2Y = 0;
		double temp1 = 0;
		double temp2 = 0;
		double errorValue1 = 0;
		double errorValue2 = 0;
		Point lastP1 = null;
		Point lastP2 = null;

		while (lastP1 == null || errorValue1 > 1.0 || errorValue2 > 1.0) {
                    long tInicio=System.currentTimeMillis();
			for (Point p : pointArray) {
				computeMemberShip(p);
				p1X += p.getMemberShip1() * p.getMemberShip1() * p.getX();
				p1Y += p.getMemberShip1() * p.getMemberShip1() * p.getY();
				temp1 += p.getMemberShip1() * p.getMemberShip1();
                                 System.out.println("p1x "+p1X);
                                 System.out.println("p1y "+p1Y);
				p2X += p.getMemberShip2() * p.getMemberShip2() * p.getX();
				p2Y += p.getMemberShip2() * p.getMemberShip2() * p.getY();
				temp2 += p.getMemberShip2() * p.getMemberShip2();
                                System.out.println("p2x "+p1X);
                                 System.out.println("p2y "+p1Y);
			}

			lastP1 = new Point(p1.getX(), p1.getY());
			lastP2 = new Point(p2.getX(), p2.getY());

			p1.setX(p1X / temp1);
			p1.setY(p1Y / temp1);
			p2.setX(p2X / temp2);
			p2.setY(p2Y / temp2);

			errorValue1 = Math.abs(lastP1.getX() - p1.getX())
					+ Math.abs(lastP1.getY() - p1.getY());
			errorValue2 = Math.abs(lastP2.getX() - p2.getX())
					+ Math.abs(lastP2.getY() - p2.getY());
                        long tEjecucion=System.currentTimeMillis()-tInicio;
                System.out.println("Tiempo"+tEjecucion);
		}

		System.out.println(MessageFormat.format(
				"Obteniendo resultados:\n\t->Valores con tendencia a crecimiento: ({0}, {1}), \n\t->Porcentaje de efectividad: ({2}, {3})", p1.getX(), p1.getY(),
				p2.getX(), p2.getY()));
                
	}

}

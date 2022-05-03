package oldmutualtechasses;

import java.util.Random;

public class Main{

	public static void main(String[] args) throws java.io.IOException{
		String file1 = "Question 1 input.csv";
		String file2 = "Question 2 input.csv";
		String[] files = {file1, file2};
		Random rn = new Random();
		String file = files[rn.nextInt(files.length)];
		
		java.util.Map<String, Office> vertices = new java.util.HashMap<>();
		java.util.Map<String, java.util.Set<String>> neighbors = new java.util.HashMap<>();

		String[] tempArray;
		StringBuilder line = new StringBuilder();
		
		try {
			java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.FileReader(file));
			reader.readLine();
			System.out.println("====================== "+ file + " Data =================================");
			System.out.println();
			while(true){
				String reader1 = reader.readLine();
				if(reader1.split(",").length != 3) {
					System.out.println("Line " + reader1 + " in " + file + " is wrongly formated" );
					System.exit(0);
				}
				line.append(reader1);
				if(line.toString().equals("null")){
					break;
					}
				System.out.println(line);
				tempArray = line.toString().split(",");
				String officeName = tempArray[0].toLowerCase();
				String parentOffice = tempArray[1].toLowerCase();
				double amount = Double.parseDouble(tempArray[2]);
				var office = new Office(officeName, parentOffice, amount);
				vertices.put(officeName, office);
				if(neighbors.containsKey(parentOffice)){
					java.util.Set<String> set = neighbors.get(parentOffice);
					set.add(officeName);
					neighbors.put(parentOffice, set);
				}
				else{
					neighbors.put(parentOffice, new java.util.HashSet<>());
				}
				if(!neighbors.containsKey(officeName)){
					neighbors.put(officeName, new java.util.HashSet<>());
				}
				line.setLength(0);
				
			}
		}catch(Exception e){
			//System.out.println(file + " cannot be found");
			//System.exit(0);
		}
		

		Graph graph = new Graph(vertices, neighbors);
		System.out.println(graph.getNeighbors("HeadOffice"));


		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.println();
		System.out.println("Question 1");
		System.out.print("Enter Office to calculate Nett Profit For : ");
		String userInput = input.nextLine().toLowerCase();
		try {
			System.out.println("Total Amount = R "+ graph.bfs(userInput));
			
		}catch(Exception e){
			System.out.println("Invalid input!!!");
		}
		
		System.out.println();
		System.out.println("Question 2");
		System.out.println("The office with the largest nett Profit is : ");
		System.out.println(graph.getOfficeWithLargestProfit());
		System.out.println();
		System.out.println("======================end=================================");
	
	}
}

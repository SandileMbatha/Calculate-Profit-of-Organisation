package oldmutualtechasses;

import java.util.*;
public class Graph{

	private Map<String,Office> vertices;
	private Map<String,Set<String>> neighbors;

	public Graph(Map<String,Office> vertices, Map<String,Set<String>> neigh){
		this.vertices = vertices;
		neighbors = neigh;
	}

	public boolean addVertex(String vertex, Office office){
		if(!vertices.containsKey(vertex)){
			vertices.put(vertex, office);
			neighbors.put(vertex, new java.util.HashSet<>());
			return true;
		}
		return false;
	}

	public boolean addEdge(String parent, String child){

		if(neighbors.containsKey(parent)){
			Set<String> set = neighbors.get(parent);
			set.add(child);
			return true;
		}

		return false;
	}

	public void printEdges(){
		for(Map.Entry<String, Set<String>> entry : neighbors.entrySet()){
			System.out.println(entry.getKey());
			for(String office : entry.getValue()){
				System.out.print(office);
			}
			System.out.println();
		}
	}

	/**
	 * Method to retrieve all offices reporting to this one.
	 * @param officeName
	 * @return
	 */
	public Set<String> getNeighbors(String officeName){
		if(neighbors.containsKey(officeName)){
			return neighbors.get(officeName);
		}
		return null;
	}

	/**
	 * Breath-First Search
	 * @param office
	 * @return
	 */
	public double bfs(String office){
		Queue<String> queue = new LinkedList<>();
		double amount = vertices.get(office).amount;
		Map<String,Boolean> isVisited = new java.util.HashMap<>();
		for(Map.Entry<String,Office> entry : vertices.entrySet()){
			isVisited.put(entry.getKey(), false);
		}
		queue.offer(office);
		isVisited.put(office, true);
		StringBuilder officeName = new StringBuilder();

		while(!queue.isEmpty()){
			officeName.append(queue.poll());
			Set<String> set = neighbors.get(officeName.toString());
			for(String st : set){
				if(!isVisited.get(st)){
					queue.offer(st);
					amount += vertices.get(st).amount;
					isVisited.put(st, true);
				}
			}
			officeName.setLength(0);
		}
		return amount;
	}

	/**
	 * Depth-First Search
	 * @param office
	 * @return
	 */
	public double dfs(String office){
		Stack<String> stack = new Stack<>();
		double amount = vertices.get(office).amount;
		Map<String,Boolean> isVisited = new java.util.HashMap<>();
		for(Map.Entry<String,Office> entry : vertices.entrySet()){
			isVisited.put(entry.getKey(), false);
		}
		stack.push(office);
		isVisited.put(office, true);
		StringBuilder officeName = new StringBuilder();

		while(!stack.isEmpty()){
			officeName.append(stack.pop());
			Set<String> set = neighbors.get(officeName.toString());
			for(String st : set){
				if(!isVisited.get(st)){
					stack.push(st);
					amount += vertices.get(st).amount;
					isVisited.put(st, true);
				}
			}
			officeName.setLength(0);
		}
		return amount;
	}

	public String getOfficeWithLargestProfit(){
		double profit = 0;
		StringBuilder office = new StringBuilder();
		for(Map.Entry<String,Office> entry : vertices.entrySet()){
			if(neighbors.get(entry.getKey()).size() < 1){
				continue;
			}
			double amount = bfs(entry.getKey());
			if(amount > profit){
				if(!office.isEmpty()){
					office.setLength(0);
				}
				profit = amount;
				office.append(entry.getKey());
			}
		}
		return office.toString() +" = "+profit;
	}

}

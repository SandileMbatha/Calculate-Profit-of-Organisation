# OldMutualAssessment
Calculating the profit of an organisation

Requirements: 

       - Install java Jdk latest version.
       
       
How to execute
1.	Download the “Old Mutual – Developer Screening test” file and save it to your preferred location. 
2.	The folder that contains a runnable Ass.jar file and two datasets
        - Question 1 input.csv
        - Question 2 input.csv
3.	Open the command line
4.	Use the cd Browse to the folder where you have saved the downloaded file. e.g 
cd …../……/Old Mutual – Developer Screening Test
5.	Then execute the Ass.jar file like this:
java -jar Ass.jar

Output Description
1.	The dataset is randomly chosen from the two datasets. 
2.	The first line displays the dataset that has been chosen randomly. 
3.	The contents of that chosen are then displayed for the user to see them and see the available offices to choose from. 
4.	The user is then prompted to enter a valid office name having seen the available offices to calculate the net profit. 
5.	The net profit of the given office is then displayed. 
6.	Followed by the Name and the net profit of the office that had the largest net profit. 
7.	If an invalid office name is entered it outputs “Invalid input” 
8.	Repeat the process if you want to check for another dataset until it is randomly chosen. 

Algorithms used and Approach to a problem

The structure or hierarchy of the given dataset can be modeled using a graph as there are relationships among entities (Offices).  With that in mind, it will be easy to traverse through the entities with the graph traversal algorithms which are Breath first search (BFS) and Depth first Search Algorithm (DFS).

I have also stored the entities on a Map data structure for a fast retrieving, add and delete operations. 

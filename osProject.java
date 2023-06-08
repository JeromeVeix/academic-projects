class fcfs{
public static void fcfsTime(int burst[], int processid, int arrival[])
{
    // Declaration of multiple arrays that represent the waiting time, turn around time, and finishing time
    int []waiting = new int[processid];
    int []turning = new int[processid];
    int []finish = new int[processid];
    //Represent how the waiting time for the first process is always 0
    waiting[0] = 0;
    //Signifies how the first index of the turn arround time and finish time in this case is 3
    turning[0] = 3;
    finish[0] = 3;
  
    // Printing a table and each categories' first index
    System.out.print("First Come First Serve" + "\n");
    System.out.print("ID\tArrival\t" + "Burst\t  Waiting\t  Turn around\t  Finish\n");
    System.out.print("1"+ "\t\t" + arrival[0]+ "\t\t" + burst[0]+ "\t\t\t" + waiting[0] + "\t\t\t\t" + turning[0] + "\t\t\t\t\t" + 
    finish[0]+"\n");
           
    //For loop that computes the completion time
    for (int i = 1; i < 10; i++) { //10 is the length of processes
        finish[i] = (finish[i-1] + burst[i]);} //finish time = previous finish time + current burst time

    // Initializing the neccessary variables for finding the average waiting time and turn around time
    float averagewt;
    float averagett;
    float sum = 0;
    float sum1 = 0;
         
     //Computations of turn around time
     for (int i = 1; i < 10; i++) {
          turning[i] = (finish[i] - arrival[i]); } //turn around time = current finish time - current arrival time
          
     //Calculations for wait time
     for (int i = 1; i < 10; i++) {
          waiting[i] = (turning[i] - burst[i]); //waiting time = current turn around time - current burst time
     
// Print the each process' information
          System.out.print(i + 1+ "\t\t" +  arrival[i] + "\t\t" +  burst[i]+ "\t\t\t" + waiting[i] + "\t\t\t\t" + turning[i] + 
          "\t\t\t\t\t" + finish[i] +"\n");}
          
     for (int i = 0; i < 10; i++) {
        sum = sum + waiting[i];
        sum1 = sum1 + turning[i];}
     // Divide the sum of the waiting times and turn around times by 10 (number of processes) to find their averages
    averagewt = sum / 10;
    averagett = sum1 / 10;
    // Outputting the Average Waiting Time and Turning Time
    System.out.print("Average waiting time = "+ averagewt + "\n");
    System.out.print("Average turn around time = "+ averagett);
}


//public class osProject{

// Main code
public static void main(String[] args){ 
    int processid = 10; //establishment of number of processes
    int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8,9}; //declaring an array for arrival time
    int bur[] = {3, 5, 1, 4, 2, 9, 7, 6, 8, 10}; //declaring an array for burst time
  
    fcfsTime(bur, processid, arr); //Calling the First Come First Serve function

//Code to conduct the Shortest Job First Scheduling
    //Initializing all of these integer arrays based on the number of processes
    int systemtime=0, total=0; //system time is current time; total represents the max process IDs
    int id[] = new int[processid]; //represents the number of processes
    int arrival[] = new int[processid]; 
    int burst[] = new int[processid]; 
    int waiting[] = new int[processid];  
    int turning[] = new int[processid]; 
    int finish[] = new int[processid]; 
    int flag[] = new int[processid]; //The signifier of whether a process is finished or not
    float averagewt=0, averagett=0; //variables for average waiting time and average turn around time

    for(int i=0;i<processid;i++){
        arrival[i] = arr[i]; //equates the newly created integer array for arrival and the arrival array containing the arrival times
        burst[i] = bur[i]; //equates the newly created integer array for burst and the burst array containing the burst times
        id[i] = i+1; //tells the index to update by 1 each time the loop is completed
        flag[i] = 0;} //process is still not done 
    
    while(true){ //infinitive while loop
    int p=processid, low=11; //creates another int variable for processid and initializes a number that all burst times must be lower than
    if (total == processid) //Loop will stop if the max process IDs == the process number (10)
        break;
        
    for (int i=0; i<processid; i++) {
/*
*If the process is still unfnished, burst time is less than the lowest value, and arrival time <= system time, that process will
*be first in the execution cycle
*/
    if ((arrival[i] <= systemtime) && (flag[i] == 0) && (burst[i]<low)) {
        low=burst[i]; //low is updated to be the burst
        p=i;} //new processid variable has the value of the index
}
// If the new variable for the processid equals the original processid, the system time will escalate  
if (p==processid)
    systemtime++;
else /* Will run for each process id */
{
finish[p]=systemtime+burst[p]; //completed time of a process is the burst time + current time
systemtime+=burst[p]; //next, the systemtime will be updated by adding the burst times to it 
turning[p]=finish[p]-arrival[p]; //turn around time is calculated by the finish time - arrival time
waiting[p]=turning[p]-burst[p]; //waiting time is calculated by the turn around time - burst time
flag[p]=1; //signifies the process is now finished
total++; //displays the sequence of the total
}
}
System.out.println("\n\nShortest Job First");
System.out.println("ID  Arrival    Burst    Waiting    Turn around     Finished"); //Establishing the columns of the table

for(int i=0;i<processid;i++) {
averagewt = averagewt + waiting[i]; //average waiting time is calculated by first adding all of the waiting times for each process
averagett = averagett + turning[i]; //average turn around time is calculated by first adding all of the turn around time times for each process

//Inputting the data within the table
System.out.println(id[i]+"\t\t\t"+arrival[i]+"\t\t\t"+burst[i]+"\t\t\t"+waiting[i]+"\t\t\t"+turning[i]+"\t\t\t\t\t"+finish[i]);}
// Divide the sum of the waiting times and turn around times by 10 (number of processes) to find their averages
System.out.println ("Average waiting time = "+ (averagewt/processid));
System.out.println ("Average turn around time = "+ (averagett/processid) + "\n");


//Code for Round Robin with quantum=2
//Initializing all of these integer arrays based on the number of processes
    //int id[] = new int[processid]; //represents the number of processes
    int arrival1[] = new int[processid]; 
    int burst1[] = new int[processid]; 
    int waiting1[] = new int[processid];  
    int turning1[] = new int[processid]; 
    int finish1[] = new int[processid]; 
    float averagewt1=0, averagett1=0; //variables for average waiting time and average turn around time
    int i,iteration=0,timeq=0,bt1[];  
    int buffer;
    int quantumt =2; //setting up the quantum 2 which will be the max a burst can go for before switching
    bt1 = new int[processid];  

for (i=0;i<processid;i++) {
arrival1[i] = arr[i]; //equates the newly created integer array for arrival and the arrival array containing the arrival times
burst1[i] = bur[i]; //equates the newly created integer array for burst and the burst array containing the burst times
bt1[i] = burst1[i]; //will represent the new burst
}  
while(true)  {  //infinite while loop
for (i=0, iteration=0;i<processid;i++)  {  
buffer = quantumt;  //temporary variable/buffer = time slice
if(bt1[i] == 0) { //if new burst time = 0
    iteration++;
    continue;  }  
if(bt1[i]>quantumt) //if new burst time is greater than the quantum time
    bt1[i]= bt1[i] - quantumt; //new burst will equal new burst - quantum time
else  //performs when the new burst is less than the quantum time
if(bt1[i]>=0)  {  //executes as long as new burst time is greater than or larger than 0
    buffer = bt1[i]; //buffer will now equal new burst
    bt1[i] = 0;  //new burst equals 0 to signify its ending
}  
timeq = timeq + buffer; //newfound time quantum will be calculated from the new burst times
turning1[i] = timeq; //turn around time for a process is derived from the newfound time quantum
}  
if(processid == iteration)  //loop will stop when maxid of processes is met
    break;  
}  
System.out.print("\nRound Robin (q=2)");  
System.out.print("\nProcess\t      Arrival\t       Burst\t          Waiting\t         Turn around\t         Finished\n");  

for(i=0;i<processid;i++) {  
waiting1[i]=turning1[i]-burst1[i]; //waiting time = turn around time - burst time
finish1[i] = turning1[i]+arrival1[i]; //finish time = turn around time + arrival
arrival[i] = finish1[i]-turning1[i]; //arrival time = finish time - turn around time
averagewt1=averagewt+waiting1[i]; //First step to calculating average waiting time is to add all of the waiting times
averagett1=averagett+turning1[i]; //First step to calculating average turn around time is to add all of the turn around times
//printing the subsequent data within the table  
System.out.print("\n "+(i+1)+"\t\t\t\t\t"+arrival1[i]+"\t\t\t\t\t"+burst1[i]+"\t\t\t\t\t\t"+waiting1[i]+"\t\t\t\t\t\t"+turning1[i]+
"\t\t\t\t\t\t\t"+finish1[i]+"\n");  
}  
averagewt1=averagewt1/processid; //divide the average by the number of processes
averagett1=averagett1/processid;  
System.out.println("Average waiting Time = "+averagewt1);  
System.out.println("Average turnaround time = "+averagett1);  
    
}    
}

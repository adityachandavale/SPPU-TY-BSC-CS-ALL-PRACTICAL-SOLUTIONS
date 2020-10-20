#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#define MAX 10

typedef struct PROCESS
{
 char name[80] ;
 int at,bt,ct,wt,tat,tbt,priority;
}PROCESS ;

PROCESS p[10] ;
int time,processCount;
float totaltat,totalwt,avgtat,avgwt ;

void sort()
{
 PROCESS p1 ;
 int i,j;
 for(i=0;i<processCount;i++)
    {
     for(j=i+1;j<processCount;j++)
		{
		 if(p[j].at < p[i].at)
			{
			 p1 = p[i] ;
			 p[i] = p[j] ;
			 p[j] = p1 ;
			}
		}
    }
}


void readProcess()
{
 int i ;
 printf("\nEnter the number of processes: ") ;
 scanf("%d",&processCount) ;
 for(i=0;i<processCount;i++)
    {
     printf("\nEnter the process name: ") ;
     scanf("%s",p[i].name) ;
     printf("Enter the CPU Burst time: ") ;
     scanf("%d",&p[i].bt) ;
     printf("Enter the Arrival time: ") ;
     scanf("%d",&p[i].at) ;
	 
     p[i].tbt = p[i].bt ; //extra from fcfs
	 
     printf("Enter the process priority: ") ;
     scanf("%d",&p[i].priority) ;
    }
 sort() ;
}

int getProcess()
{
 int i , min = 999 , p1 ;
 for(i=0;i<processCount;i++)
    {
     if(p[i].at <= time && p[i].tbt!=0)
       {
		if(p[i].priority < min)
		  {
		   min = p[i].priority ;
		   p1 = i ;
		  }
		}
	}
 return p1 ;
}
void scheduleProcess()
{
 int i , count = 0  ;
 char currentprocess[10] , prevprocess[10] = "NULL" ;
 printf("\tGantt Chart\n\n") ;
 printf("_________________________________________________\n") ;
 while(1)
      {
       i = getProcess() ;
       p[i].tbt-- ;
	   strcpy(currentprocess,p[i].name) ;
		if(strcmp(currentprocess,prevprocess) !=0 )
		  {
		   printf("%d|%d  %s  ",time , time , currentprocess) ;
		  }
		time++ ;
   
       if(p[i].tbt==0)
		 {
		  p[i].ct = time ;
		  p[i].tat = p[i].ct - p[i].at ; //finishtime-arrival time
		  p[i].wt = p[i].tat-p[i].bt ; //total existence-working time
		  count++ ;
		  totaltat += p[i].tat ;
		  totalwt+=p[i].wt ;
		 }
       strcpy(prevprocess , currentprocess) ;
       if(count==processCount)
			break ;
     }
 printf("%d|",time) ;
 printf("\n_________________________________________________\n") ;
 avgtat = totaltat/processCount ;
 avgwt = totalwt/processCount ;
}


void display()
{
 int i;
 printf("\n--------------------------------------------------------------------------------\n") ;
 printf("Process  ArrivalTime  BurstTime  CPUTime  TurnAroundtime  WaitTime\n");
 printf("--------------------------------------------------------------------------------\n");
 for(i=0 ; i<processCount ; i++)
    printf("%s\t  %d\t\t%d\t  %d\t   %d\t\t   %d\n",p[i].name,p[i].at,p[i].bt,p[i].ct,p[i].tat,p[i].wt) ;
 printf("--------------------------------------------------------------------------------") ;
 printf("\n\nTotal Turn Around Time: %f",totaltat) ;
 printf("\nTotal Wait Time: %f",totalwt) ;
 printf("\n\nAverage Turn Around Time: %f",avgtat) ;
 printf("\nAverage Wait Time: %f\n",avgwt) ;
}

main()
{
 clrscr();
 readProcess();
 scheduleProcess();
 getch();
 display();
 getch();
 return 0;
}

/*
Output:


Enter the number of processes: 4

Enter the process name: j1
Enter the CPU Burst time: 4
Enter the Arrival time: 0
Enter the process priority: 4

Enter the process name: j2
Enter the CPU Burst time: 1
Enter the Arrival time: 1
Enter the process priority: 3

Enter the process name: j3
Enter the CPU Burst time: 2
Enter the Arrival time: 2
Enter the process priority: 2

Enter the process name: j4
Enter the CPU Burst time: 1
Enter the Arrival time: 3
Enter the process priority: 1
        Gantt Chart

______________________________________________________________
|0  j1  0|0   j2  1|1   j3  2|2   j4  3|3   j3  4|4   j1  5|5 
______________________________________________________________


---------------------------------------------------------------------------------------------------
Process name    Arrival Time    Burst Time      CPU Time        Turn Around timeWait Time
---------------------------------------------------------------------------------------------------
  j1    0       4       8       8       4
  j2    1       1       2       1       0
  j3    2       2       5       3       1
  j4    3       1       4       1       0
---------------------------------------------------------------------------------------------------

Total Turn Around Time: 13
Total Waiting Time: 5

Average Turn Around Time: 3.250000
Average Waiting Time: 1.250000



*/

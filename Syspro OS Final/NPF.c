#include<stdio.h>
#include<stdlib.h>
#define MAX 10

typedef struct PROCESS
{
 char name[20];
 int tat,wt,at,bt,ct;
}PROCESS ;

PROCESS p[MAX] ;
int processCount,i,j,k;
float totaltat,totalwt,avgtat,avgwt;

void sort()
{
 PROCESS p1;
 for(i=0;i<processCount;i++)
    {
     for(j=i+1;j<processCount;j++)
		 {
		  if(p[j].at < p[i].at)
			{
			 p1=p[j];
			 p[j]=p[i];
			 p[i]=p1;
			}
	     }
	 }
}

void readProcess()
{
 printf("\nEnter the number of processes: ") ;
 scanf("%d",&processCount) ;
 for(i=0 ; i<processCount ; i++)
    {
     printf("\nEnter the process name: ") ;
     scanf("%s",p[i].name) ;
     printf("Enter the Burst time: ") ;
     scanf("%d",&p[i].bt) ;
     printf("Enter the CPU Arrival time: ") ;
     scanf("%d",&p[i].at) ;
    }
 sort() ;
}

void scheduleProcess()
{
 int time = 0 ;
 i = 0 ;
 printf("\n\n  GanttChart:\n") ;
 printf("________________________________________\n") ;
 printf("|%d   ",time) ;
 while(i<processCount)
      {
       p[i].wt=time-p[i].at ;//currenttime-arrival time
       time=time+p[i].bt;
       p[i].ct=time;
       p[i].tat=p[i].bt+p[i].wt;//workingtime+waiting time
	   //p[i].tat=time-p[i].at;//finishtime-arrival time

       printf("%s   ",p[i].name);
       printf("%d|%d   ",time,time);

       totaltat+=p[i].tat ;
       totalwt+=p[i].wt ;
       i++ ;
      }
 printf("\n________________________________________\n\n") ;
 avgtat = totaltat / processCount ;
 avgwt = totalwt / processCount ;
}

void display()
{
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
 display();
 getch();

 return 0;
}

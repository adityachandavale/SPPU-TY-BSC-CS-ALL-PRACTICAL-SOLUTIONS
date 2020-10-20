#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>
#include<dirent.h>

void count(char ch,char* fname)
{
	int lc=0,wc=0,cc=0,handle;
	char c;
	
	if((handle=open(fname,O_RDONLY))==-1)
	{
		printf("\nFile doesn't exist")
		return;
	}
	while(read(handle,&c,1)!=0)
	{
		if(c=='\n')
		{
			lc++;
			wc++;
			cc++;
		}
		else if(c==' ')
		{
			wc++;
			cc++;
		}
		else
		{
			cc++;
		}
	}
	close(handle);
	
	switch(ch)
	{
		case 'c':printf("\nTotal characters count is: %d",cc);
				 break;
		case 'w':printf("\nTotal words count is: %d",wc);
				 break;
		case 'l':printf("\nTotal lines count is: %d",lc);
				 break;
		default :printf("\nInvalid choice");		 
	}
}
void main()
{
	char cmd[80],t1[20],t2[20],t3[20],t4[20];
	int n;
	system(clear);
	while(1)
	{
		printf("$AP$");
		fgets(cmd,80,stdin);
		n=sscanf(cmd,"%s%s%s%s",t1,t2,t3,t4)
		switch(n)
		{
			case 1: if(!fork())
					{
						execlp(t1,t1,NULL);
						perror(t1);
					}
					break;
			case 2: if(!fork())
					{
						execlp(t1,t1,t2,NULL);
						perror(t1);
					}
					break;
			case 3: if(strcmp(t1,"count")==0)
						count(t2[0],t3);
					else{
						if(!fork())
						{
							execlp(t1,t1,t2,t3,NULL);
							perror(t1);
						}
					}
					break;
			case 4: if(!fork())
					{
						execlp(t1,t1,t2,t3,t4,NULL)
						perror(t1);
					}
					break;		
		}
	}
}
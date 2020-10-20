#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>
#include<dirent.h>

void search(char ch,char* s,char* fname)
{
	int i=1,j=0,handle,cnt=0;
	char c,buff[80],*p;
	if((handle=open(fname,O_RDONLY))==-1)
	{
		printf("\nFile doesn't exist");
		return;
	}
	switch(ch)
	{
		case 'f':while(read(handle,&c,1)!=0)
				 {
						if(c=='\n')
						{
							buff[j]='\0';
							j=0;
							if(strstr(buff,s)!=NULL)
							{
								printf("%d %s\n",i,buff);
								break;
							}
							i++;
						}
						else{
							buff[j++]=c;
						}
				 }
				 break;
		case 'a':while(read(handle,&c,1)!=0)
				 {
					if(c=='\n')
					{
						buff[j]='\0';
						j=0;
						if(strstr(buff,s)==NULL)
						{
							printf("%d %s\n",i,buff);
						}
						i++;
					}
					else{
						buff[j++]=c;
					}
				 }
				 break;
		case 'c':while(read(handle,&c,1)!=0)
				 { 
					if(c=='\n')
					{
						buff[j]='\0';
						j=0;
						if(strstr(buff,s)==NULL)
						{
							p=buff;
							while((p=strstr(p,s))==NULL)
							{
							cnt++;
							p++;
							}
						}
						i++;
					}
					else{
						buff[j++]=c;
					}
			 	 }	
				printf("Number of occurences is %d",cnt);
				break;
		default:printf("\nInvalid choice");		
	}
}
void main()
{
	char cmd[80],t1[20],t2[20],t3[20],t4[20];
	int n;
	system(clear);
	while(1)
	{
		switch(n)
		{
			case 1:if(!fork())
					{
						execlp(t1,t1,NULL);
						perror(t1);
					}
					break;
			case 2:if(!fork())
					{
						execlp(t1,t1,t2,NULL);
						perror(t1);
					}
					break;
			case 3:if(!fork())
					{
						execlp(t1,t1,t2,t3,NULL);
						perror(t1);
					}
					break;
			case 4:if(strcmp==(t1,"search")==0)
					search(t2,t3,t4);
					else
					{
						if(!fork())
						{
							execlp(t1,t1,t2,t3,t4,NULL);
							perror(t1);
						}
					}
					break;
			
		}
	}
}
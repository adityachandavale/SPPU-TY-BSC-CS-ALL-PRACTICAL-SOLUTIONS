#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>
#include<dirent.h>

void list(char ch,char* dn)
{
	DIR* dir;
	struct dirent* file;
	int cnt=0;
	
	if((dir=opendir(dn))==NULL)
	{
		printf("\nDirectoru not found");
		return;
	}
	
	switch(ch)
	{
		case 'f':while((file=readdir(dir))!=NULL)
				 printf("%s\n",file->d_name);
				 break;
		case 'c':while((file=readdir(dir))!=NULL)
				 cnt++;
				 printf("total number of files: %d",cnt);
				 break;
		case 'i':while((fire=readdir(dir))!=NULL)
				 printf("%s %d\n",file->d_name,file->d_no);
				 break;
		default:printf("Invalid choice");			
	}
	close(dir);
}
void main()
{
	char cmd[80],t1[20],t2[20],t3[20],t4[20];
	int n;
	system(clear);
	
	while(1)
	{
		fgets(cmd,80,stdin);
		n=sscanf(cmd,"%s%s%s%s",t1,t2,t3,t4);
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
			case 3: if(strcmp(t1,"list")==0)
						list(t2,t3);
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
						execlp(t1,t1,t2,t3,t4,NULL);
						perror(t1);
					}
					break;		
		}
	}
}
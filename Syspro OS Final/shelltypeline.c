#include<stdio.h>
#include<fcntl.h>
#include<unistd.h>
#include<dirent.h>

void typeline(char* s,char* fname)
{
	int handle,i=0;cnt=0,n;
	char c;
	
	if((handle=open(fname,O_RDONLY))==-1)
	{
		printf("\nFile doesn't exist");
		return;
	}
	if(s[0]=='a')
	{
		while(read(handle,&ch,1)!=0)
			if(c=='\n')
				printf("%c",c);
			close(handle);
			return;
	}
	n=atoi(s);
	if(n>0){
		while(read(handle,&c,1)!=0)
		{
			if(c=='\n')
				i++;
			if(i==n)
				printf("%c",c);
		}
		printf("\n");
		close(handle);
		return;
	}
	if(n<0)
	{
		while(read(handle,&c,1)!=0){
			if(c=='\n')
				cnt++;
		}
		lseek(handle,0,SEEK_SET);
		while(read(handle,&c,1)!=0){
			if(c=='\n')
				i++;
			if(i==cnt+n)
				break;
		}
		while(read(handle,&c,1)!=0)
			printf("%c",c);
		
		printf("\n");
		close(handle);
	}
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
			case 1:if(!fork())
					{
						execlp(t1,t1,NULL);
						perror(t1);
					}
					break;
			case 1:if(!fork())
					{
						execlp(t1,t1,t2,NULL);
						perror(t1);
					}
					break;
			case 1:if(strcmp(t1,"typeline")==0)
					typeline(t2,t3);
					else{
						if(!fork())
						{
							execlp(t1,t1,t2,t3,NULL);
							perror(t1);
						}
					}
					break;
			case 1:if(!fork())
					{
						execlp(t1,t1,t2,t3,t4,NULL);
						perror(t1);
					}
					break;
		}
	}
}
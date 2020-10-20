#include<stdio.h>
#include<string.h>
#include<stdlib.h>

int address,lc,pc;
long content;
long MEM[1000];
FILE *fp;
char fname[80];
int cc[6]={0,0,0,0,0,1};
int reg[4];
int flag;
int opcode,r,operand;
void load()
{
	while(!feof(fp))
	{
		fscanf(fp,"%d %ld",&address,&content);
		if(address==-1)
			pc=content;
		else
		{
			lc=address;
			MEM[lc]=content;
		}
	}		
}

void print()
{
	int i;
	printf("pc %d\n",pc);
	for(i=pc;i<=lc;i++)
		printf("%d %ld\n",i,MEM[i]);
}
void trace()
{
		int i;
		printf("\nContents of registers:");
		for(i=0;i<4;i++)
			printf("%d\t",reg[i]);
		
		printf("\nContents CC array:");
		for(i=0;i<6;i++)
			printf("%d\t",cc[i]);
		printf("\n");			
		
}
void Execute()
{
	
	int i;
	while(1)
	{
		opcode=MEM[pc]/10000;
		r=(MEM[pc]%10000)/1000-1;
		operand=(MEM[pc]%10000)%1000;
		//printf("%d\n",opcode);
		pc++;
		switch(opcode)
		{
			case 0:return;
				break;
			
			case 1:reg[r]+=MEM[operand];
				break;
		
			case 2:reg[r]-=MEM[operand];
				break;

			case 3:reg[r]*=MEM[operand];
				break;
			
			case 8:reg[r]=reg[r]/MEM[operand];
				break;

			case 4:reg[r]=MEM[operand];
				break;

			case 5:MEM[operand]=reg[r];
				break;

			case 6:if(reg[r]<MEM[operand])
				cc[0]=1;
				if(reg[r]<=MEM[operand])
				cc[1]=1;
				if(reg[r]==MEM[operand])
				cc[2]=1;
				if(reg[r]>MEM[operand])
				cc[3]=1;
				if(reg[r]>=MEM[operand])
				cc[4]=1;
				break;
			
			case 7:
				if(cc[r]==1)
				pc=operand;
				for(i=0;i<5;i++)
					cc[i]=0;
				break;
				
			case 9:printf("Enter a no ");	
				scanf("%d",&MEM[operand]);
				break;
	
			case 10:printf("Result is %d\n",MEM[operand]);
				break;
		}
		//printf("PC is %d\n",pc);
		if(flag==1)
			trace();

		
		
	}
	flag=0;
}

void accept()
{
	int i;
	//fp=fopen(fname,"w");
		
	while(1)
	{
		printf("Enter address ");
		scanf("%d",&address);
		printf("Enter content ");
		scanf("%ld",&content);
		if(address==-1)
		{
			pc=content;
			break;
		}
		else
		{
			lc=address;
			MEM[lc]=content;
		}
	}
	i=pc;
	while(i<=lc)
	{
		printf("%d %ld\n",i,MEM[i]);
		i++;
	}
	printf("-1 %ld",pc);
}
void main(int argc,char* argv[])
{
	int ch;
	if(argc==2)
		strcpy(fname,argv[1]);
	else
	{
		printf("Enter name of file ");
		scanf("%s",fname);
	}

	fp=fopen(fname,"r");
	
		

		do
		{
			printf("1:Load\n2:Print\n3:Execute\n4:Trace\n5:Accept\n6:Exit\n");
			printf("Enter your choice ");
			scanf("%d",&ch);
			switch(ch)
			{
				case 1:load();
					break;
			
				case 2:print();
					break;
		
				case 3:Execute();
					break;
			
				case 4:flag=1;
					Execute();
					break;

				case 5:accept();
					break;
			}
		}while(ch!=6);
	fclose(fp);
}	

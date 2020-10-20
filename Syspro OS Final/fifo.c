#include<stdio.h>
void main(){

	int ref[20],mem[3]={0},i,j,n,fault=0;

		printf("\n Enter No. String");
		scanf("%d",&n);

		printf("\n Enter The Ref. string");
			for(i=0;i<n;i++)
			{
				printf("\n reference[%d]",i);
				scanf("%d",&ref[i]);
			}

				for(i=0;i<n;i++){
					for(j=0;j<3;j++){
						if(ref[i]==mem[j]){
							printf("\n No page fault at %d",i);
							break;
						}
						if(mem[j]==0){
							mem[j]=ref[i];
							fault++;
							printf("\n Fault at %d",i);
							break;
						}
					}
					if(j==3){
						mem[0]=mem[1];
						mem[1]=mem[2];
						mem[2]=ref[i];
						fault++;
						printf("\n Fault at %d",i);
					}
					for(j=0;j<3;j++)
					{
						if(mem[j]!=0)
						printf("\n %d",mem[j]);

					}
			}
			printf("\n Page fault at %d",fault);
}
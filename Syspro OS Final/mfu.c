#include<stdio.h>
void main(){

	int ref[20],mem[3]={0},n,i,j,k,fault,cnt=99,max=0,victim;

	printf("\n Enter Total no. of string");
	scanf("%d",&n);

	printf("\n Enter Reference String");
		for(i=0;i<n;i++)
		{
			printf("Reference[%d]",i);
			scanf("%d",&ref[i]);
		}


		for(i=0;i<n;i++){
			for(j=0;j<3;j++){

				if(mem[j]==ref[i]){
					printf("\n No page fault at %d",i);
					break;
				}
				if(mem[j]==0){
					mem[j]=ref[i];
					fault++;
					printf("\n Page fault at %d",i);
					break;
				}
			}
			if(j==3){
				for(k=0;k<3;k++){
					cnt=0;
						for(j=i-1;j>=0;j--){
							if(mem[k]==ref[j]){
								cnt++;
							}
						}
			if(max<cnt){
				max=cnt;
				victim=k;
				}
			}
			mem[victim]=ref[i];
			fault++;
			printf("\n Fault at %d",i);			
			}
			for(j=0;j<3;j++)
				if(mem[j]!=0)
				printf(" \n %d",mem[j]);
		}
		printf("\n Page fault = %d",fault);
}
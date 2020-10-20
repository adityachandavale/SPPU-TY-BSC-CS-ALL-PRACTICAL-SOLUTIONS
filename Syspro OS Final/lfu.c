#include<stdio.h>
void main(){

	int mem[3]={0},ref[20],i,j,k,n,victim,min=99,fault=0,cnt;

	printf("\n Enter no. reference string");
	scanf("%d",&n);

	printf("\n Enter reference string");
	for(i=0;i<n;i++){
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
				printf("\n Page Fault at %d",i);
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
				if(min>cnt){
					min=cnt;
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

import java.util.*;

class SetMatrixZeros{
	public static void main(String [] args){
		int arr[][]= new int[3][3];
		Scanner sc= new Scanner(System.in);
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				arr[i][j]=sc.nextInt();
			}
		}
		int [] row =new int[3];
		int [] col = new int [3];
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(arr[i][j]==0){
				row[i]=-1;
				col[i]=-1;
				}
			}
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(row[i]==-1 || col[j]==-1){
					arr[i][j]=0;
				}
			}
		}
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(arr[i][j]  +" ");
			}
			System.out.println("");
		}
		}

	}
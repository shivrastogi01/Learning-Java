class DiagonalTraversalOfMatrix{
    public int[] findDiagonalOrder(int[][] mat) {
        int size = mat.length * mat[0].length;
        int count = 0;
        int[] arr = new int[size];
        boolean flag = true; // true -> up false -> down
        
        int i = 0;
        int j = 0;
        while(count < size){
            if(flag == true){ // go up 
                arr[count] = mat[i][j];
                if(i - 1 >= 0 && j + 1 < mat[0].length){ // can go up again
                    i--;
                    j++;
                    count++;
                    flag = true;
                }else if(i - 1 < 0 && j + 1 == mat[0].length){ // diagonal end up
                    i++;
                    count++;
                    flag = false;
                }else if(i - 1 < 0){ // up border end
                    j++;
                    count++;
                    flag = false;
                }else if(j + 1 == mat[0].length){ // right side border end
                    i++;
                    count++;
                    flag = false;
                }
            }else{ // go down
                arr[count] = mat[i][j];
                if(i + 1 < mat.length && j - 1  >= 0){ // can go down again
                    i++;
                    j--;
                    count++;
                    flag = false;
                }else if(i + 1 == mat.length && j - 1 < 0){ // diagonal end down
                    j++;
                    count++;
                    flag = true;
                }else if(i + 1 == mat.length){ // down border end
                    j++;
                    count++;
                    flag = true;
                }else if(j - 1 < 0){ // left side border end
                    i++;
                    count++;
                    flag = true;
            }
        }
        
    }
    return arr;
}      
}
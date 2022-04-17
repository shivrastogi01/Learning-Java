class BinaryTreeCameras {
    static int camera;                            // works in stages 
    public int minCameraCover(TreeNode root) {    // -1 represents a camera is needed 
                                                  //0 represents a camera is placed 
                                 // 1 represents the area is covered not by the current node but by some previous node       
       camera =0;
       if(countCameras(root)==-1) 
       {
           camera++;
       }
        return camera;
        
    }
  
    public int countCameras(TreeNode root)
    {
        if(root==null)
        {
            return 1;
        }
         int rc = countCameras(root.left);
         int lc =  countCameras(root.right);
		 //upvote if you like 
        //dry run with the image given
        // will need atleast a camera 
        if(rc == -1 || lc ==-1)
        {
            camera++;
            return 0;
        // here camera is present so return area is covered     
        }
        if(rc ==0 || lc ==0)
        {
            return 1;
        }
        // condition when leaf node arises when both lc and rc are 1 and 1
        return -1;
    }
}
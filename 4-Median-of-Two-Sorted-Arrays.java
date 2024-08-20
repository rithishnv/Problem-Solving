class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0;
        int j=0;
        int m=(int)(nums1.length + nums2.length)/2;
        double arr[]=new double[2];
        int g=0;
        int c=0;
        // System.out.println("m="+m);
        if((nums1.length + nums2.length)%2==0){
            while(i < nums1.length && j<nums2.length){
                c++;
                if(c==m+2){
                    break;
                }
                if(c==m || c==m+1){ 
                    if(nums1[i]<=nums2[j]){
                        arr[g++]=nums1[i++];
                    }
                    else{
                        arr[g++]=nums2[j++];
                    }
                }
                else{
                    if(nums1[i]<=nums2[j]){
                        i++;
                    }
                    else{
                        j++;
                    }
                }
            }
            while(i<nums1.length){
                c++;
                if(c==m || c==m+1){
                    arr[g++]=nums1[i++];
                }
                else{
                    i++;
                }
            }
            while(j<nums2.length){
                c++;
                if(c==m || c==m+1){
                    arr[g++]=nums2[j++];
                }
                else{
                    j++;
                }
            }
            // System.out.println("1="+arr[0]+"2="+arr[1]);
        return (double)(arr[0]+arr[1])/2d;
        }
        else{
            while(i < nums1.length && j<nums2.length){
                c++;
                if(c==m+1){
                    return(double) nums1[i]<=nums2[j] ?nums1[i]:nums2[j];
                }
                else{
                    if(nums1[i]<=nums2[j]){
                        i++;
                    }
                    else{
                        j++;
                    }
                }
                
            }
            while(i<nums1.length){
                c++;
                if(c==m+1){
                    // System.out.println("1="+nums1[i]);
                    return (double)(nums1[i]);
                }
                else{
                    i++;
                }
            }
            while(j<nums2.length){
                c++;
                if(c==m+1){
                    // System.out.println("1="+nums2[j]);
                    return (double)(nums2[j]);
                }
                else{
                    j++;
                }
            }
        }
        return 0;
    }
}
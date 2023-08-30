package datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Sort{

    public static <T extends Comparable<T> > void InsertionSort(List<T> l){
        for (int i=1; i<l.size();i++){
            int index=i;
            while (index >0 && l.get(index).compareTo(l.get(index-1))<0){
                    T tmp=l.get(index-1);
                    l.set(index-1,l.get(index));
                    l.set(index,tmp);
                    index--;

                }

            }

    }

    public static <T extends Comparable<T> > void SelectionSort(List<T> l){
        for (int i =0; i<l.size();i++){
            int min =i;
            for(int j=i;j<l.size();j++){
                if(l.get(j).compareTo(l.get(min))<0){
                    min=j;
                }
            }
            T tmp=l.get(min);
            l.set(min,l.get(i));
            l.set(i,tmp);
        }

    }


    public static <T extends Comparable<T> > void BubbleSort(List<T> l){
        for (int i =0; i<l.size();i++){
            for(int j=0;j<l.size()-i-1;j++){
                if(l.get(j+1).compareTo(l.get(j))<0){
                    T tmp=l.get(j);
                    l.set(j,l.get(j+1));
                    l.set(j+1,tmp);
                }
            }

        }

    }

    private static <T extends Comparable<T> > void Merge(int l, int r, List<T> arr){
        int m = l + (r - l) / 2;
        int nL=m-l+1, nR=r-m;
        int i=0,j=0, k=l;
        List<T> left=new ArrayList<>(arr.subList(l,m+1));
        List<T> right =new ArrayList<>(arr.subList(m+1,r+1));

        while(i<nL && j<nR){

            if(left.get(i).compareTo(right.get(j))<=0){
                arr.set(k,left.get(i));
                i++;
            }
            else{
                arr.set(k,right.get(j));
                j++;
            }

            k++;
        }

        while (i < nL) {
            arr.set(k,left.get(i));
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < nR) {
            arr.set(k,right.get(j));
            j++;
            k++;
        }

    }

    private static <T extends Comparable<T> > void MergeSort(int l, int r, List<T> arr){
        if (l<r){
            int m =  l+(r - l) / 2;
            MergeSort(l,m,arr);
            MergeSort(m+1,r,arr);
            Merge(l,r,arr);
        }

        return;


    }

    public static <T extends Comparable<T> > void MergeSort(List<T> arr){
        MergeSort(0,arr.size()-1,arr);
    }


    private static <T extends Comparable<T> > void QuickSort(List<T> arr, int l, int r){
        if (l<r){
            T pivot=arr.get(r);
            int i=l-1;
            for (int j=l;j<r;j++){
                if(arr.get(j).compareTo(pivot)<0){
                    i++;
                    T tmp=arr.get(j);
                    arr.set(j,arr.get(i));
                    arr.set(i,tmp);
                }
            }
            i++;
            T tmp=arr.get(i);
            arr.set(i,arr.get(r));
            arr.set(r,tmp);

            QuickSort(arr,l,i-1);
            QuickSort(arr,i+1,r);
        }


    }

    public static <T extends Comparable<T> > void QuickSort(List<T> arr){
        QuickSort(arr,0,arr.size()-1);
    }
}


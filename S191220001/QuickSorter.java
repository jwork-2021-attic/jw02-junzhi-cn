package S191220001;
public class QuickSorter implements Sorter {

    private int[] a;

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }

    private String plan = "";

    @Override
    public void sort() {
        QuickSort(0, a.length - 1);
    }

    private void QuickSort(int left, int right) {
		if(left>=right) {
			return;
		}
		int key=a[left];
		int i=left;
		int j=right;
		while(i<j){
			while(a[j]>=key && i<j){
				j--;
			}
			while(a[i]<=key && i<j){
				i++;
			}
			if(i<j){
				swap(i,j);
			}
		}
       // if (i!=left)
        swap(i,left);
		QuickSort(left,i-1);
		QuickSort(i+1,right);
	}

    @Override
    public String getPlan() {
        return this.plan;
    }

}

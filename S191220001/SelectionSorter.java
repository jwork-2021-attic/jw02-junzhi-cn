package S191220001;
public class SelectionSorter implements Sorter {

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
    private int min;
    private int minj;
    @Override
    public void sort() {
        for(int i=0;i<a.length;i++)
        {
            min=999999999;
            for(int j=i;j<a.length;j++)
            {
                if(a[j]<min) 
                {
                    min=a[j];
                    minj=j;
                }
            }
            if(min!=999999999)
            swap(i, minj);
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

}

package S191220001;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Scene {

    public static void main(String[] args) throws IOException {
        Monster[] m;
        m=new Monster[256];
        Matrix matrix = new Matrix(256);
        int[] a;
        a=new int[256];
        int[] r;
        r=new int[256];
        int[] g;
        g=new int[256];
        int[] b;
        b=new int[256];
        int rand;
        
        int rr=255;
        int gg=255;
        int bb=255;
        int i=0;
        int j=0;
        for(i=0;i<=31;i++)
        {
            a[j] = j;
            if(bb>=8)
                bb=bb-8;
            else
                bb=0;
            r[j]=rr;
            b[j]=bb;
            g[j]=gg;
            j++;
        }
        for(i=0;i<=31;i++)
        {
            a[j] = j;
            if(rr>=8)
                rr=rr-8;
            else
                rr=0;
              
                r[j]=rr;
                b[j]=bb;
                g[j]=gg;
            j++;
        }
        for(i=0;i<=31;i++)
        {
            a[j] = j;
            if(bb<=255-8)
                bb=bb+8;
            else
                bb=255;
              
                r[j]=rr;
                b[j]=bb;
                g[j]=gg;
            j++;
        }for(i=0;i<=31;i++)
        {
            a[j] = j;
            if(gg>=8)
                gg=gg-8;
            else
                gg=0;
              
                r[j]=rr;
                b[j]=bb;
                g[j]=gg;
            j++;
        }for(i=0;i<=31;i++)
        {
            a[j] = j;
            if(rr<=255-8)
                rr=rr+8;
            else
                rr=255;
              
                r[j]=rr;
                b[j]=bb;
                g[j]=gg;
            j++;
        }for(i=0;i<=31;i++)
        {
            a[j] = j;
            if(bb>=8)
                bb=bb-8;
            else
                bb=0;
              
                r[j]=rr;
                b[j]=bb;
                g[j]=gg;
            j++;
        }for(i=0;i<=31;i++)
        {
            a[j] = j;
            if(rr>=8)
                rr=rr-8;
            else
                rr=0;
              
                r[j]=rr;
                b[j]=bb;
                g[j]=gg;
            j++;
        }
        for(i=0;i<=31;i++)
        {
            a[j] = j;
            
            if(rr<=255-8)
                rr=rr+8;
            else
                rr=255;
            if(gg<=255-8)
                gg=gg+8;
            else
                gg=255;
            if(bb<=255-8)
            bb=bb+8;
            else
            bb=255;
            r[j]=rr;
            b[j]=bb;
            g[j]=gg;
            j++;
        }
        for(int k=0;k<255;k++)
        {
            rand=(int) (System.currentTimeMillis()%(256-k));
            int temp=a[k];
            a[k]=a[rand];
            a[rand]=temp;
            temp=r[k];
            r[k]=r[rand];
            r[rand]=temp;
            temp=g[k];
            g[k]=g[rand];
            g[rand]=temp;
            temp=b[k];
            b[k]=b[rand];
            b[rand]=temp;
        }
        for(int k=0;k<256;k++)
        {
            m[k]=new Monster(r[k], g[k], b[k], a[k]);
            matrix.put(m[k], k);
        }

        Snake theSnake = Snake.getTheSnake();

        Sorter sorter = new QuickSorter();

        theSnake.setSorter(sorter);

        String log = theSnake.matrixUp(matrix,m);

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}

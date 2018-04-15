/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JUNAID
 */
public class Lm extends Thread {
    double qw;
    Lm(double x)
    {
        this.qw=x;
    }

    double calc(int action1,int action2,int action3) throws InterruptedException
    {   
        JDBC j=new JDBC();
        j.dbms();
       int n= j.nvalue();
       int ni=0;
        int MAXN = 1000;
        int z[]=new int[1000];
        int b[]=new int[1000];
        int s[]=new int[1000];
        int i=0;
        double y[]=new double[1000];
        double x[] = new double[1000];
         x = j.xvalue();
        double x1[] = new double[1000];
         y = j.yvalue();
        double y1[]=new double[1000];
       z=j.zvalue();
        b=j.bvalue();
        s=j.svalue();
       for(i=0;i<n;++i)
       {
           System.out.println(x[i]+","+y[i]+","+z[i]+","+b[i]);
       }
       if(action1==0)
       {
           for(i=0;i<n;++i)
           {
               if(z[i]==1)
               {
                   x1[ni]=x[i];
                   y1[ni]=y[i];
                   ++ni;
               }
           }
            x=x1;
           y=y1;
           n=ni;
       }
       else if(action1==1)
       {
           for(i=0;i<n;++i)
           {
               if(z[i]==2)
               {
                   x1[ni]=x[i];
                   y1[ni]=y[i];
                   ++ni;
               }
           }
           x=x1;
           y=y1;
           n=ni;
       }
       else if(action1==2)
       {
           for(i=0;i<n;++i)
           {
               if(z[i]==3)
               {
                   x1[ni]=x[i];
                   y1[ni]=y[i];
                   ++ni;
               }
           }
           x=x1;
           y=y1;
           n=ni;
       }
       ni=0;
       if(action2==1)
       {
           for(i=0;i<n;++i)
           {
               if(b[i]==1)
               {
                   x1[ni]=x[i];
                   y1[ni]=y[i];
                   ++ni;
               }
           }
           x=x1;
           y=y1;
           n=ni;
       }
       ni=0;
       if(action3==1)
       {
           for(i=0;i<n;++i)
           {
               if(s[i]==1)
               {
                   x1[ni]=x[i];
                   y1[ni]=y[i];
                   ++ni;
               }
           }
           x=x1;
           y=y1;
           n=ni;
           
       }
              for(i=0;i<n;++i)
       {
           System.out.println("#"+x[i]+","+y[i]+","+z[i]+","+b[i]);
       }
        // first pass: read in data, compute xbar and ybar
        double sumx = 0.0, sumy = 0.0, sumx2 = 0.0;
        while(i!=n) {
          //  x[n] = s[i];
            //y[n] = r[i];
            sumx  += x[n];
            sumx2 += x[n] * x[n];
            sumy  += y[n];
            i++;
        }
        double xbar = sumx / n;
        double ybar = sumy / n;

        // second pass: compute summary statistics
        double xxbar = 0.0, yybar = 0.0, xybar = 0.0;
        for ( i = 0; i < n; i++) {
            xxbar += (x[i] - xbar) * (x[i] - xbar);
            yybar += (y[i] - ybar) * (y[i] - ybar);
            xybar += (x[i] - xbar) * (y[i] - ybar);
        }
        double beta1 = xybar / xxbar;
        double beta0 = ybar - beta1 * xbar;

        // print results
        System.out.println("y   = " + beta1 + " * x + " + beta0);
        
System.out.println("x="+qw+","+"y?"+(beta1*qw+beta0));
        // analyze results-
        int df = n - 2;
        double rss = 0.0;      // residual sum of squares
        double ssr = 0.0;      // regression sum of squares
        for ( i = 0; i < n; i++) {
            double fit = beta1*x[i] + beta0;
            rss += (fit - y[i]) * (fit - y[i]);
            ssr += (fit - ybar) * (fit - ybar);
        }
        double R2    = ssr / yybar;
        double svar  = rss / df;
        double svar1 = svar / xxbar;
        double svar0 = svar/n + xbar*xbar*svar1;
         System.out.println("R^2                 = " + R2);
         System.out.println("std error of beta_1 = " + Math.sqrt(svar1));
         System.out.println("std error of beta_0 = " + Math.sqrt(svar0));
        svar0 = svar * sumx2 / (n * xxbar);
         System.out.println("std error of beta_0 = " + Math.sqrt(svar0));

         System.out.println("SSTO = " + yybar);
         System.out.println("SSE  = " + rss);
        System.out.println("SSR  = " + ssr);
        double fina1=(double)(beta1*qw+beta0);
        return(fina1);
    }
}

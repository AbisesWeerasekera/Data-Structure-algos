import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1 {
    
    static class Wine {
        public int price;
        public int vol;
        public double pricePerBot;
        
        public Wine(int price, int vol){
            this.price = price;
            this.vol = vol;
            this.pricePerBot = price/vol;
        }
    }
    
    public static void main(String[] args) throws IOException{
        
        int N, M, rem, max=0, j;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] line1 = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        
        if(line1.length!=2){
            System.out.println("Invalid input!");
        }
        
        N = line1[0];
        M = line1[1];
        
        int[] vol = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        
        if(vol.length!=M){
            System.out.println("Number of inputs doesn't match with the previous value!");
        }
        
        int[] price = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        
        if(price.length!=M){
            System.out.println("Number of inputs doesn't match with the previous value!");
        }
        
        Wine[] wine = new Wine[M];
        
        for(int i=0; i<M; i++){
            wine[i] = new Wine(price[i],vol[i]);
        }
        
        Arrays.sort(wine,(a,b)->Double.valueOf(a.pricePerBot).compareTo(Double.valueOf(b.pricePerBot)));
        
        rem = N;
        j=M-1;
        
        while(rem!=0 && j>=0){
            if(rem<wine[j].vol){
                max += wine[j].pricePerBot*rem;
                rem = 0;
            } else{
                rem -= wine[j].vol;
                max += wine[j].price;
            }
            j--;
        }
        
        System.out.println(max);
            
    }
    
}

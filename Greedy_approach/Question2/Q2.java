import java.util.Scanner;
import java.io.IOException;
import java.util.stream.IntStream;

public class Q2up {
    
    public static void main(String[] args) throws IOException{
        
        int n, score[], masks[];
        
        Scanner br = new Scanner(System.in);
        
        n = br.nextInt();
        
        score = new int[n];
        
        for(int i=0; i<n; i++){
            score[i] = br.nextInt();
        }
        
        masks = new int[n];
        
        for(int i=0; i<n; i++){
            masks[i] = 1;
        }
        
        for(int i=0; i<n-1; i++){
            if(score[i+1]>score[i]){
                masks[i+1]=masks[i]+1;
            }
        }
            
        for(int i=n-1; i>0; i--){
            if(score[i-1]>score[i] && masks[i-1]<=masks[i]){
                masks[i-1]=masks[i]+1;
            }
        }

        System.out.println(IntStream.of(masks).sum());
            
    }
}

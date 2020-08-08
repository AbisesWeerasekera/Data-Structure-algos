import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q3 {
    
    public static void main(String[] args) throws IOException{
        
        int n, conCount = 0, maxWeight, i=0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        int[] weights = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        
        if(weights.length!=n){
            System.out.println("Number of inputs doesn't match with the previous value!");
        }
        
        Arrays.sort(weights);
        
        
        while(i<weights.length){
            maxWeight = weights[i]+4;
            
            for(int j=i; j<weights.length; j++){
                
                if(weights[j]>maxWeight){
                  break;  
                }else{
                    i=j;
                }  
            }
            
            conCount++;
            i++;
        }
        
        System.out.println(conCount);
            
    }
    
}

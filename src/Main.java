/* IMPORTANT: Multiple classes and nested static classes are supported */


//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
class Solve
{

    public void reverseArray(long arr[]) {
        long temp;
        for(int i=0;i<arr.length-1-i;i++) {
            temp=arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
        }

    }
    public void findNextGreater(final long arr[],long ans[]) {
        // Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();
        int index;
        for (int i = 0; i < arr.length; i++) {

            if (!st.empty() && arr[st.peek()] < arr[i]) {
                do {
                    index = st.pop();
                    ans[index] = i+1;
                }while (!st.empty() && arr[st.peek()] < arr[i]);
            }
            st.push(i);

        }
        while(!st.empty())
        {
            index=st.pop();
            ans[index]=-1;
        }



    }
    public void solve(final long arr[])
    {
        long ans[]=new long[arr.length];
        findNextGreater(arr,ans);

        long reverse[]=new long[arr.length];
        reverseArray(arr);
        findNextGreater(arr,reverse);
        for(int i=0;i<arr.length;i++)
        {
            if(reverse[i]!=-1)
            {
                reverse[i]=arr.length+1-reverse[i];
            }
        }
        //    reverseArray(reverse);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++)
        {
            sb.append(ans[i]+reverse[arr.length-1-i]).append(" ");

        }
        System.out.print(sb);

    }
}

class Main {
    public static void main(String args[] ) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String size=br.readLine();
        String arraystring=br.readLine();
        StringTokenizer st=new StringTokenizer(arraystring);
        String token=null;
        final long arr[]=new long[Integer.parseInt(size)];
        int index=0;
        while(st.hasMoreTokens())
        {
            token=st.nextToken();
            arr[index++]=Long.parseLong(token);
        }
        new Solve().solve(arr);
    }
}


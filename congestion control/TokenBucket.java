/*Token Bucket for congestion control*/

/* In this the bucket is filled with constant rate called token_generation_rate untill the bucket is full */

import java.util.Scanner;

public class TokenBucket {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter bucket capacity:");
            int bucket_capacity = in.nextInt();

            System.out.println("Enter token generation rate:");
            int token_gen_rate = in.nextInt();

            System.out.println("Enter number of cycles:");
            int n = in.nextInt();

            int token_remaining = 0;
            System.out.printf("%s\t%s\t%s\t%s\n", "Time", "Tokens Requested", "Tokens Sent", "Tokens Remaining");

            for (int i = 1; i <= n; i++) {
                int token_sent = Math.min(token_gen_rate, bucket_capacity - token_remaining);
                token_remaining += token_sent;
                System.out.printf("%d\t\t%d\t\t%d\t\t%d\n", i, token_gen_rate, token_sent, token_remaining);
            }
        }
    }


/*OUTPUT:-
Enter the bucket capacity
5
Enter the Token generation rate (Rate at which tokens are sent to the bucket)
2
Enter the number of Cycles the host computer sends the Tokens to the bucket(at constant rate)
6
Time_t  Tokens Requested    Tokens Sent   Tokens Remaining in bucket
1             2                    2       2
2             2                    2       4
3             2                    1       5
4             2                    0       5
5             2                    0       5
6             2                    0       5
*/    

/*OUTPUT:-
Enter the bucket capacity
5
Enter the Token generation rate (Rate at which tokens are sent to the bucket)
2
Enter the number of Cycles the host computer sends the Tokens to the bucket(at constant rate)
6
Time_t  Tokens Requested    Tokens Sent   Tokens Remaining in bucket
1             2                    2       2
2             2                    2       4
3             2                    1       5
4             2                    0       5
5             2                    0       5
6             2                    0       5
*/
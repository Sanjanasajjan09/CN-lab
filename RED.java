/*Write a program to implement random early detection (RED) 
congestion control algorithm*/

import java.util.Random;
import java.util.Scanner;

public class RED {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Max packets: ");
        int maxPackets = sc.nextInt();
        System.out.print("Queue size: ");
        int queueSize = sc.nextInt();
        System.out.print("Max probability: ");
        double maxProb = sc.nextDouble();
        System.out.print("Min probability: ");
        double minProb = sc.nextDouble();
        System.out.print("Threshold: ");
        int threshold = sc.nextInt();

        simulateRED(maxPackets, queueSize, maxProb, minProb, threshold);
    }

    private static void simulateRED(int maxPackets, int queueSize, double maxProb, double minProb, int threshold) {
        Random rand = new Random();
        int queueLength = 0;

        for (int i = 1; i <= maxPackets; i++) {
            double dropProb = (queueLength >= threshold) ? 
                minProb + (maxProb - minProb) * (queueLength - threshold) / (queueSize - threshold) : 0;

            if (queueLength >= threshold && rand.nextDouble() < dropProb) 
                System.out.println("Packet dropped (CONGESTION AVOIDANCE)");
            else {
                System.out.println("Packet accepted " + i);
                queueLength++;
            }
        }
    }
}


/*
Enter the maximum number of packets:
100
Enter the queue size:
20
Enter the maximum probability:
0.8
Enter the minimum probability:
0.2
Enter the threshold value:
10
Packet accepted 1
Packet accepted 2
Packet accepted 3
Packet dropped (CONGESTION AVOIDANCE)
Packet dropped (CONGESTION AVOIDANCE)

output 2:
Enter the maximum number of packets:
50
Enter the queue size:
10
Enter the maximum probability:
0.6
Enter the minimum probability:
0.4
Enter the threshold value:
5
Packet accepted 1
Packet accepted 2
Packet accepted 3
Packet accepted 4
Packet accepted 5
Packet dropped (CONGESTION AVOIDANCE)
Packet dropped (CONGESTION AVOIDANCE)
Packet accepted 8
Packet dropped (CONGESTION AVOIDANCE)
Packet accepted 10

*/
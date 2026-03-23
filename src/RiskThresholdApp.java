import java.util.*;

class Client {
    String name;
    int risk;

    Client(String name, int risk) {
        this.name = name;
        this.risk = risk;
    }
}

 class RiskRankingApp {

    static void bubbleSort(Client[] arr) {
        int swaps = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].risk > arr[j + 1].risk) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swaps++;
                }
            }
        }

        System.out.print("Bubble (asc): [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].name.charAt(arr[i].name.length()-1) + ":" + arr[i].risk);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("] // Swaps: " + swaps);
    }

    static void insertionSort(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].risk < key.risk) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }

        System.out.print("Insertion (desc): [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].name.charAt(arr[i].name.length()-1) + ":" + arr[i].risk);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    static void topRisks(Client[] arr) {
        System.out.print("Top " + arr.length + " risks: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].name.charAt(arr[i].name.length()-1) + "(" + arr[i].risk + ")");
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Client[] clients = {
                new Client("clientC", 80),
                new Client("clientA", 20),
                new Client("clientB", 50)
        };

        System.out.println("Input: [clientC:80, clientA:20, clientB:50]");

        Client[] b = clients.clone();
        Client[] i = clients.clone();

        bubbleSort(b);
        insertionSort(i);
        topRisks(i);
    }
}
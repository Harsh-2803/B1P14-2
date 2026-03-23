class RiskClient {
    String name;
    int risk;

    RiskClient(String name, int risk) {
        this.name = name;
        this.risk = risk;
    }
}

public class RiskRankingApp2 {

    static void bubbleSort(RiskClient[] arr) {
        int swaps = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].risk > arr[j + 1].risk) {
                    RiskClient temp = arr[j];
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

    static void insertionSort(RiskClient[] arr) {
        for (int i = 1; i < arr.length; i++) {
            RiskClient key = arr[i];
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

    static void topRisks(RiskClient[] arr) {
        System.out.print("Top " + arr.length + " risks: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].name.charAt(arr[i].name.length()-1) + "(" + arr[i].risk + ")");
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        RiskClient[] clients = {
                new RiskClient("clientC", 80),
                new RiskClient("clientA", 20),
                new RiskClient("clientB", 50)
        };

        System.out.println("Input: [clientC:80, clientA:20, clientB:50]");

        RiskClient[] b = clients.clone();
        RiskClient[] i = clients.clone();

        bubbleSort(b);
        insertionSort(i);
        topRisks(i);
    }
}
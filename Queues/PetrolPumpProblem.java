package Queues;

class PetrolPump{
    int petrol;
    int distance;
    PetrolPump(int petrol,int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}
public class PetrolPumpProblem {
    public static int findPetrolPump(PetrolPump[] arr)
    {
        int start = 0;
        int end = 1;
        int n = arr.length ; // size of array
        int surplus_petrol = arr[start].petrol - arr[start].distance;

        while(start != end || surplus_petrol < 0)
        {
            while(start != end && surplus_petrol < 0)
            {
                surplus_petrol -= arr[start].petrol - arr[start].distance;
                start = (start+1)%n;

                // If o is being considered again , then there is no possible tour .
                if(start == 0)
                    return -1;
            }

            surplus_petrol += arr[end].petrol - arr[end].distance;
            end = (end+1)%n;
        }

        return start;
    }
    public static void main(String[] args) {
        PetrolPump[] pumps = new PetrolPump[4];
        pumps[0] = new PetrolPump(4,6);
        pumps[1] = new PetrolPump(6,5);
        pumps[2] = new PetrolPump(7,3);
        pumps[3] = new PetrolPump(4,5);
        int pump = findPetrolPump(pumps);
        if(pump == -1)
            System.out.println("No circular tour is possible .");
        else
            System.out.println("Circular tour is possible from petrol pump no "+pump);
    }
}

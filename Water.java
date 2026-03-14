import java.util.*;

// Stack Implementation
class StackDS {
    int top = -1;
    int stack[] = new int[10];

    void push(int data){
        if(top == stack.length-1){
            System.out.println("Stack Overflow");
        }else{
            stack[++top] = data;
        }
    }

    int pop(){
        if(top == -1){
            System.out.println("Stack Underflow");
            return -1;
        }else{
            return stack[top--];
        }
    }

    void display(){
        for(int i=0;i<=top;i++){
            System.out.print(stack[i]+" ");
        }
    }
}

// Queue Implementation
class QueueDS{
    int front = 0, rear = -1;
    int queue[] = new int[10];

    void enqueue(int data){
        if(rear == queue.length-1){
            System.out.println("Queue Full");
        }else{
            queue[++rear] = data;
        }
    }

    int dequeue(){
        if(front > rear){
            System.out.println("Queue Empty");
            return -1;
        }else{
            return queue[front++];
        }
    }

    void display(){
        for(int i=front;i<=rear;i++){
            System.out.print(queue[i]+" ");
        }
    }
}

public class GroundwaterDSAProject {

    // Bubble Sort
    static void bubbleSort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // Linear Search
    static int linearSearch(int arr[], int key){
        for(int i=0;i<arr.length;i++){
            if(arr[i] == key)
                return i;
        }
        return -1;
    }

    // Display Array
    static void display(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Groundwater Monitoring System ===");

        System.out.print("Enter Username: ");
        String user = sc.next();

        System.out.print("Enter Password: ");
        String pass = sc.next();

        if(user.equals("admin") && pass.equals("1234")){

            System.out.println("\nLogin Successful!\n");

            int waterLevels[] = {150,170,190,210,240};

            System.out.println("Groundwater Levels:");
            display(waterLevels);

            // Stack usage
            StackDS st = new StackDS();
            for(int i=0;i<waterLevels.length;i++){
                st.push(waterLevels[i]);
            }

            // Queue usage
            QueueDS q = new QueueDS();
            for(int i=0;i<waterLevels.length;i++){
                q.enqueue(waterLevels[i]);
            }

            // Sorting
            bubbleSort(waterLevels);

            System.out.println("\nSorted Groundwater Levels:");
            display(waterLevels);

            // Searching
            System.out.print("\n\nEnter water level to search: ");
            int key = sc.nextInt();

            int result = linearSearch(waterLevels,key);

            if(result != -1)
                System.out.println("Water level found at index: "+result);
            else
                System.out.println("Water level not found");

            // Borewell Recommendation
            System.out.print("\nEnter Rainfall (mm): ");
            int rainfall = sc.nextInt();

            System.out.print("Enter Soil Factor (1-5): ");
            int soil = sc.nextInt();

            System.out.print("Enter Current Borewell Depth (ft): ");
            int depth = sc.nextInt();

            int recommendedDepth = depth + (soil * 15);
            double score = rainfall/10.0 - soil*5;

            System.out.println("\nRecommended Depth: "+recommendedDepth+" ft");
            System.out.println("Sustainability Score: "+score);

            if(score > 60)
                System.out.println("Status: Safe Zone");
            else if(score > 30)
                System.out.println("Status: Moderate Risk");
            else
                System.out.println("Status: High Risk");

        }
        else{
            System.out.println("Invalid Login!");
        }

    }
}
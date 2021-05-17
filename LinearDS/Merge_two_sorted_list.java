public class Merge_two_sorted_list
{
    Node head;
            class Node
            {
                int data;
                Node next;
                Node(int d)
                {
                    data = d;
                    next = null;
                }
            }
            /* Function to insert element at front of linked list */
            public void push(int new_data)
            {
                Node new_node = new Node(new_data);
                if(head == null)
                {
                    head = new_node;
                    return;
                }

                new_node.next = head;
                head = new_node;
                return;
            }
            /* Function to insert element at end of linked list */
            public void append(int new_data)
            {
                Node new_node = new Node(new_data);
                Node current = head;
                if(head == null)
                {
                    head = new_node;
                    return;
                }
                while(current.next != null)
                {
                    current = current.next;
                }

                current.next = new_node;
                return;
            }
            /* Function to insert element after given node */
            public void InsertAfter(int key,int new_data)
            {
                Node new_node = new Node(new_data);
                Node current = head;
                while(current.data != key)
                {
                    current = current.next;
                    if(current.next == null) // Condition to check whether node exist or not
                    {
                        System.out.println("Given node does not exist in linked list .");
                        return;
                    }
                }

                new_node.next = current.next;
                current.next = new_node;
                return;
            }
            /* Function to insert element before given node */
            public void InsertBefore(int key, int new_data)
            {
                Node new_node = new Node(new_data);
                Node current = head;
                Node previous = null;
                while(current.data != key)
                {
                    previous = current;
                    current = current.next;
                    if(current.next == null) //Condition if current.next == null means current pointer has reached to end which means key does not exist in linked list .
                    {
                        System.out.println("Given node does not exist in linked list.");
                        return;
                    }
                }
                previous.next = new_node;
                new_node.next = current;
                return;

            }
            /* Function to perform delete operation of linked list */
            public void deleteNode(int key)
            {
                Node current = head;
                Node previous = null;
                // condition to check if list is empty
                if(head == null)
                    return;
                while(current.data != key)
                {
                    previous = current;
                    current = current.next;
                    if(current.next == null && current.data != key)  // 1. key does not exist
                    {
                        System.out.println("Deleting node does not exist .");
                        return;
                    }
                }
                // 2. if deleting node is head of list
                if(current == head)
                {
                    head = current.next;
                }
                // 3. if deleting node is last node of list
                // 4. if it's in between
                else
                {
                    previous.next = current.next;
                }

                if(current == head && current.next == null)
                    head =null;
                return;
            }

            /* Function to swap nodes without swapping the data */
            public void swapNodes(int X, int Y)
            {
                // 1. either node does not exist in linked list
                // 2. x and y are same
                // 3. either x or y can be head element
                // 4.

                if(X == Y)
                {
                    System.out.println("Both nodes can not be same .");
                    return;
                }

                Node currX = head;
                Node prevX = null;
                while(currX != null && currX.data != X)
                {
                    prevX = currX;
                    currX = currX.next;
                }

                Node currY = head;
                Node prevY = null;
                while(currY != null && currY.data != Y)
                {
                    prevY = currY;
                    currY = currY.next;
                }

                if(currX == null || currY == null)
                {
                    System.out.println("Either node is not present .");
                    return;
                }
                if(prevX != null)
                {
                    prevX.next = currY;
                }
                else
                    head = currY;
                if(prevY != null)
                    prevY.next = currX;
                else
                    head = currX;

                Node temp = currX.next;
                currX.next = currY.next;
                currY.next = temp;

                return;
            }
            /* Function to reverse the linked list */
            public Node reverseLL()
            {
                Node current = head;
                Node prev = null;
                Node next = null;
                while(current != null)
                {
                    next = current.next;
                    current.next = prev;
                    prev = current;
                    current = next;
                }
                head = prev;
                return head;
            }

            /* Function Merge Two Sorted Linked List */
            public static Node MergeList(Node A , Node B)
            {
                Node result = null;
                if (A == null)
                    return B;
                if (B == null)
                    return A;

                if(A.data <= B.data)
                {
                    result = A;
                    result.next = MergeList(A.next,B);
                }
                else
                {
                    result = B;
                    result.next = MergeList(A,B.next);
                    return B;
                }
                    return result;
            }

            /* Function to traverse the linked list*/
            public void display()
            {
                Node current = head;
                System.out.print("[");
                while(current != null)
                {
                    System.out.print(" "+current.data+" ");
                    current = current.next;
                }
                System.out.print("]");
                System.out.println();
                return;
            }
            public static void main(String[] args)
            {
                Merge_two_sorted_list list1 = new Merge_two_sorted_list();
                Merge_two_sorted_list list2 = new Merge_two_sorted_list();
                list1.push(24);
                list1.push(25);
                list1.push(26);
                list1.push(27);
                list1.append(23);
                list1.append(22);
                list1.append(21);
                list1.display();
                list1.InsertAfter(26,72);
                list1.display();
                list1.InsertBefore(26,78);
                list1.display();
                list1.deleteNode(23);
                list1.display();
                list1.swapNodes(21,24);
                list1.display();
                list1.reverseLL();
                System.out.println("List 1:");
                list1.display();

                list2.push(87);
                list2.push(45);
                list2.append(96);
                list2.append(67);
                list2.push(34);
                System.out.println("List 2 :");
                list2.display();


            }
        }


import java.util.*;
class Dll{
    Node head;
    class Node{
		int data;
		Node previous;
		Node next;
		Node(int data){
			this.data=data;
		}
	}
    void add(int data){
        Node nn=new Node(data);
    	Node last=head;
    	nn.next=null;
    	if(head==null){
    		nn.previous=null;
    		head=nn;
    		return;
    	}
    	while(last.next!=null){
    		last=last.next;
    	}
    	last.next=nn;
    	nn.previous=last;
    }
    void display(){
        System.out.println("The current List is: ");
        Node t=head;
        while(t!=null){
            System.out.print(t.data+" ");
            t=t.next;
        }
        System.out.println();
    }
    void insert(int p,int q){
        Node ins=new Node(p);
        if(q==1){            	
        	ins.next=head;
        	ins.previous=null;
        	head=ins;
        }else{
            Node temp=head;
            for(int i=2;i<q;i++){
        		temp=temp.next;
            }
            ins.next=temp.next;
            temp.next=ins;
            ins.previous=temp;
        }            
    }
    void delete(int r){
        Node temp=head;
        for(int i=1;i<r;i++){
            temp=temp.next;
        }
        Node temp1=temp.previous;
        Node temp2=temp.next;
        temp2.previous=temp1;
        temp1.next=temp2;
    }
    void find(int t){
        int a=0;
        int count=0;
        Node temp=head;
        while(temp!=null){
            count++;
            if(temp.data==t){
                a=1;
                break;
            }
            temp=temp.next;
        }
        if(a==0){
            System.out.println("The element "+t+" is not found in the list");
        }else{
            System.out.println("The position of the element is "+count);
        }
    }
    public static void main(String[] args){
        Dll dll=new Dll();
        dll.add(5);
        dll.add(3);
        dll.add(7);
        dll.add(9);
        dll.add(10);
        dll.display();
        outer:
        while(true){
            Scanner s=new Scanner(System.in);
            System.out.println("Choose one of the following:\n1.Insert element\n2.Remove element\n3.Find element\n4.Exit\n");
            int x=s.nextInt();
            switch(x){
                case 1:
                    System.out.println("Enter the value to be inserted: ");
                    int p=s.nextInt();
                    System.out.println("Enter the position to be inserted: ");
                    int q=s.nextInt();
                    dll.insert(p,q);
                    dll.display();
                    break;
                case 2:
                    System.out.println("Enter the position of the element to be removed: ");
                    int r=s.nextInt();
                    dll.delete(r);
                    dll.display();
                    break;
                case 3:
                    System.out.println("Enter the element to find: ");
                    int t=s.nextInt(); 
                    dll.find(t);
                    break;
                default:
                    break outer;
            }
        }
    }
}
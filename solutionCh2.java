class solutionCh2{

	public static void print(linkedList head){
		linkedList temp =head;
		while(temp!=null){
			System.out.print(temp.val+" ");
			temp=temp.next;
		}
		System.out.println();
	}

	public static boolean checkCircularity(linkedList head){
		if(head==null) return false;
		linkedList slowPtr=head;
		linkedList fastPtr=head.next;
		while(true){
			if(slowPtr==fastPtr)
				return true;
			else if(fastPtr==null||slowPtr==null)
				return false;
			else {
				fastPtr=fastPtr.next.next;
				slowPtr=slowPtr.next;
			}
		}
	}

	public static linkedList reverse(linkedList head){
		linkedList current=head;
		linkedList previous=null;
		while(current!=null){
			linkedList temp=current;
			current=current.next;
			temp.next=previous;
			previous=temp;
		}
		return previous;
	}

	public static int findKthlastElement(linkedList head, int k){
		linkedList firstPtr=head;
		linkedList secondPtr=head;
		int i=1;
		while(i<=k){
			if(firstPtr==null) return -1;
			firstPtr=firstPtr.next;
			i++;
		}
		while(firstPtr!=null){
			firstPtr=firstPtr.next;
			secondPtr=secondPtr.next;
		}
		return secondPtr.val;
	}

	public static void delete(linkedList ptr){
		while(ptr.next.next!=null){
			ptr.val=ptr.next.val;
			ptr=ptr.next;
		}
		ptr.val=ptr.next.val;
		ptr.next=null;
	}

	public static void main(String[] args) {
		linkedList l1=new linkedList(5);
		linkedList l2=new linkedList(6);
		l1.next=l2;
		linkedList l3=new linkedList(1);
		l2.next=l3;
		linkedList l4=new linkedList(8);
		l3.next=l4;
		linkedList l5=new linkedList(10);
		l4.next=l5;
		linkedList l6=new linkedList(0);
		l5.next=l6;
		print(l1);
		linkedList head =reverse(l1);
		print(head);
		System.out.println(findKthlastElement(head,7));
		delete(l4);
		print(head);
		System.out.println(checkCircularity(head));

	}
}
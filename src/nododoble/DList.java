/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nododoble;

/**
 *
 * @author Osiris
 */
public class DList <T> {
    Node first = null;
    Node last = null;
    Node pointer = null;
    int length;
    
    DList(){
        this.length = 0;
    }
    
    DList(T d){
        Node<T> a = new Node<T>(d);
        this.first = this.last = a;
        this.length = 1;
    }
    
    public boolean isEmpty(){
        return length == 0;
    }
    
    public void insertFirst(T d){
        Node<T> a = new Node<T>(d);
        if (isEmpty()){
            first = a;
            last = a;
        }else{
            a.next = first;
            first.back = a;
            first = a;
        }
        length++;
    }
    
    public void insertLast(T d){
        Node<T> a = new Node<T>(d);
        if (isEmpty()){
            first = a;
            last = a;
        }else{
            last.next = a;
            a.back = last;
            last = a;
        }
        length++;
    }
    
    public void deleteFirst(){
        if (!isEmpty()){
            if (first.next == null){
                first = last = null;
            }else{
                first = first.next;
                first.back = null;
            }
            length--;
        }
    }
    
    public void deleteLast(){
        if (!isEmpty()){
            if (first.next == null){
                first = last = null;
            }else{
                last = last.back;
                last.next = null;
            }
            length--;
        }
    }
    
    public void deletNode(T d){
        if (!isEmpty()){
            pointer = first;
            for (int i = 0; i < this.length; i++){
                if (pointer.data == d){
                    if (pointer.next == null && pointer.back == null){
                        first = last = null;
                        length--;
                    }else{
                        pointer.back.next = pointer.next;
                        pointer.next.back = pointer.back;
                        pointer = null;
                        length--;
                    }
                    i = length + 1;
                }
            }
        }
    }
    
    public void showList(){
        pointer = first;
        for (int i = 0; i < length; i++){
            System.out.print("["+pointer.data.toString()+"]");
            if (pointer.next != null){
                System.out.println("<->");
            }
            pointer = pointer.next;
        }
    }
}

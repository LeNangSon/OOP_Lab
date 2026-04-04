package General;

public class Cart {
    public static final int MAX_NUMBER_ORDERED = 20;
    private int qtyOrdered = 0;
    private DigitalVideoDisc itemsOrdered[] =
            new DigitalVideoDisc[MAX_NUMBER_ORDERED];
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered == MAX_NUMBER_ORDERED) {
            System.out.println("The cart is full !!");
            return;
        }
        itemsOrdered[qtyOrdered] = disc;
        qtyOrdered += 1;
        System.out.println("The disc has been added");
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        boolean found = false;
        if(qtyOrdered == 0){
            System.out.println("The cart is empty. Nothing to remove !");
            return;
        }
        for(int i = 0; i < qtyOrdered;i++){
            if(itemsOrdered[i] == disc) {
                found = true;
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null;
                qtyOrdered -= 1;

                System.out.println("The disc has been removed");
                break;
            }
        }
        if(!found)  System.out.println("No matched disc. Please check again !!!");
    }
    public float totalCost(){
        float sum =  0;
        for(int i = 0; i < qtyOrdered; i++){
            sum += itemsOrdered[i].getCost();
        }
        return sum;
    }
    public void viewCart(){
        if(qtyOrdered == 0){
            System.out.println("The cart is empty");
            return;
        }
        for(int i = 0; i < qtyOrdered;i++){
            System.out.println(itemsOrdered[i].getTitle());
        }
    }
}

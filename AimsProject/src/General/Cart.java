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
    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList){
        if(dvdList == null){
            System.out.println("Input list is null");
            return;
        }
        for(int i = 0; i < dvdList.length;i++) {
            if(qtyOrdered == MAX_NUMBER_ORDERED){
                System.out.println("The cart is full !!");
                break;
            }
            if(dvdList[i] == null) continue;
            itemsOrdered[qtyOrdered] = dvdList[i];
            qtyOrdered += 1;
        }
        System.out.println("Disc list has been added");
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2){

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
    public void viewCart1(){
        if(qtyOrdered == 0){
            System.out.println("The cart is empty");
            return;
        }
        for(int i = 0; i < qtyOrdered;i++){
            System.out.println(itemsOrdered[i].getTitle());
        }
    }
    public void viewCart2(){
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for(int i = 0; i < qtyOrdered; i++){
            System.out.println(itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }
}

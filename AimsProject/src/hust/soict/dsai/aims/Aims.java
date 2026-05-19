package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.*;

import java.util.Collections;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Thêm một số dữ liệu mẫu vào cửa hàng để test
        initSetup();

        int choice;
        do {
            showMenu();
            choice = getIntChoice();

            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCurrentCart();
                    break;
                case 0:
                    System.out.println("Exiting AIMS. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a number: 0-1-2-3");
            }
        } while (choice != 0);

        scanner.close();
    }


    public static void showMenu() {
        System.out.println("\nAIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void mediaDetailsMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("\nOptions: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    private static void viewStore() {
        int choice;
        do {
            System.out.println("\n--- ITEMS IN STORE ---");
            for (Media m : store.getItemsInStore()) {
                System.out.println(m.toString());
            }

            storeMenu();
            choice = getIntChoice();

            switch (choice) {
                case 1:
                    System.out.print("Enter the title of the media to view details: ");
                    String titleDetails = scanner.nextLine();
                    Media foundDetails = store.searchByTitle(titleDetails);
                    if (foundDetails != null) {
                        System.out.println(foundDetails.toString());
                        handleMediaDetails(foundDetails);
                    } else {
                        System.out.println("Media not found!");
                    }
                    break;
                case 2:
                    System.out.print("Enter the title of the media to add to cart: ");
                    String titleAdd = scanner.nextLine();
                    Media foundAdd = store.searchByTitle(titleAdd);
                    if (foundAdd != null) {
                        cart.addMedia(foundAdd);
                        if (foundAdd instanceof DigitalVideoDisc) {
                            System.out.println("Current number of DVDs in cart: " + countDVDsInCart());
                        }
                    } else {
                        System.out.println("Media not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter the title of the media to play: ");
                    String titlePlay = scanner.nextLine();
                    Media foundPlay = store.searchByTitle(titlePlay);
                    if (foundPlay != null) {
                        playMedia(foundPlay);
                    } else {
                        System.out.println("Media not found!");
                    }
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void handleMediaDetails(Media media) {
        int choice;
        do {
            mediaDetailsMenu();
            choice = getIntChoice();
            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    if (media instanceof DigitalVideoDisc) {
                        System.out.println("Current number of DVDs in cart: " + countDVDsInCart());
                    }
                    break;
                case 2:
                    playMedia(media);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0 && choice != 1);
        // Lặp lại menu trừ khi chọn Back (0) hoặc Add thành công (1)
    }

    private static void updateStore() {
        System.out.println("\n--- UPDATE STORE ---");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");
        System.out.print("Your choice: ");
        int choice = getIntChoice();

        if (choice == 1) {
            System.out.println("Enter Media Type (1. Book | 2. CD | 3. DVD): ");
            int type = getIntChoice();
            System.out.print("Enter ID: ");
            int id = getIntChoice();
            System.out.print("Enter Title: ");
            String title = scanner.nextLine();
            System.out.print("Enter Category: ");
            String category = scanner.nextLine();
            System.out.print("Enter Cost: ");
            float cost = scanner.nextFloat();
            scanner.nextLine();

            if (type == 1) {
                store.addMedia(new Book(id, title, category, cost));
                System.out.println("Book added to store.");
            } else if (type == 2) {
                System.out.print("Enter Artist: ");
                String artist = scanner.nextLine();
                store.addMedia(new CompactDisc(id, title, category, cost, artist));
                System.out.println("CD added to store.");
            } else if (type == 3) {
                System.out.print("Enter Director: ");
                String director = scanner.nextLine();
                System.out.print("Enter Length: ");
                int length = getIntChoice();
                store.addMedia(new DigitalVideoDisc(id, title, category, cost, director, length));
                System.out.println("DVD added to store.");
            }
        } else if (choice == 2) {
            System.out.print("Enter the title of the media to remove: ");
            String title = scanner.nextLine();
            Media m = store.searchByTitle(title);
            if (m != null) {
                store.removeMedia(m);
            } else {
                System.out.println("Media not found in store.");
            }
        }
    }

    private static void seeCurrentCart() {
        int choice;
        do {
            System.out.println("\n--- CURRENT CART ---");
            cart.print();

            cartMenu();
            choice = getIntChoice();

            switch (choice) {
                case 1:
                    System.out.println("Filter by: 1. ID | 2. Title");
                    int filterOpt = getIntChoice();
                    if (filterOpt == 1) {
                        System.out.print("Enter ID: ");
                        cart.filterById(getIntChoice());
                    } else if (filterOpt == 2) {
                        System.out.print("Enter Title: ");
                        cart.filterByTitle(scanner.nextLine());
                    }
                    break;
                case 2:
                    System.out.println("Sort by: 1. Title then Cost | 2. Cost then Title");
                    int sortOpt = getIntChoice();
                    if (sortOpt == 1) {
                        Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
                        System.out.println("Cart sorted by Title then Cost.");
                    } else if (sortOpt == 2) {
                        Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
                        System.out.println("Cart sorted by Cost then Title.");
                    }
                    break;
                case 3:
                    System.out.print("Enter title to remove from cart: ");
                    Media toRemove = cart.searchByTitle(scanner.nextLine());
                    if (toRemove != null) {
                        cart.removeMedia(toRemove);
                    } else {
                        System.out.println("Media not found in cart.");
                    }
                    break;
                case 4:
                    System.out.print("Enter title to play: ");
                    Media toPlay = cart.searchByTitle(scanner.nextLine());
                    if (toPlay != null) {
                        playMedia(toPlay);
                    } else {
                        System.out.println("Media not found in cart.");
                    }
                    break;
                case 5:
                    System.out.println("An order has been created. Your cart will now be emptied.");
                    cart.getItemsOrdered().clear();
                    choice = 0;
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static int getIntChoice() {
        try {
            int choice = scanner.nextInt();
            scanner.nextLine();
            return choice;
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }

    private static void playMedia(Media media) {
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    private static int countDVDsInCart() {
        int count = 0;
        for (Media m : cart.getItemsOrdered()) {
            if (m instanceof DigitalVideoDisc) {
                count++;
            }
        }
        return count;
    }

    private static void initSetup() {
        store.addMedia(new DigitalVideoDisc(1, "The Lion King", "Animation", 19.95f, "Roger Allers", 87));
        store.addMedia(new DigitalVideoDisc(2, "Star Wars", "Science Fiction", 24.95f, "George Lucas", 124));
        store.addMedia(new Book(3, "The Hobbit", "Fantasy", 15.5f));
        CompactDisc cd = new CompactDisc(4, "Greatest Hits", "Music", 18.99f, "Queen");
        cd.addTrack(new Track("Bohemian Rhapsody", 354));
        store.addMedia(cd);
    }
}
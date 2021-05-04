package petsuppliesproducts;

public class ProductTest {
        public static void main(String[] args) {
        SortedADT sorted = new Product();
        String product;
        Integer option;
        do {
            System.out.println("0: quit");
            System.out.println("1: Insert product");
            System.out.println("2: Remove product");
            System.out.println("3: Find product");
            System.out.println("4: Display product(s)");
            option = Input.getInteger("option: ");
            switch (option) {
                case 0:
                    System.out.println("quitting program");
                    break;
                case 1:
                    product=Input.getString("product: ");
                    try{
                        sorted.insert(product);
                        System.out.println("inserted");
                    }
                    catch(SortedADT.NotUniqueException e){
                        System.out.println("insert invalid - product not unique");
                    }
                   break;
                case 2:
                    product=Input.getString("product: ");
                    try{
                        //product=(String)sorted.remove(product);
                        sorted.remove(product);
                        System.out.println(product+" removed");
                    }
                    catch(SortedADT.NotFoundException e){
                        System.out.println("remove invalid - product not found");
                    }
                    break;
                case 3:
                    product=Input.getString("product: ");
                    try{
                        product=(String)sorted.find(product);
                        System.out.println(product+" found");
                    }
                    catch(SortedADT.NotFoundException e){
                        System.out.println("product not found");
                    }
                    break;
               case 4:
                    System.out.println(sorted);
                    break;
                default:
                    System.out.println("invalid option");
            }
        } while (option != 0);
    }    
}

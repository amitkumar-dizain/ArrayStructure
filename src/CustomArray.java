public class CustomArray {

    private int[] items;
    private int count ;

    public CustomArray(int length){
        items = new int[length];
    }

    public void printCustomArray (){
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    public  void  insertElement(int value){

        if (items.length <= count){
            int[] newItem = new int[count + 1];
            for (int i = 0; i < items.length; i++) {
                newItem[i] = items[i];
            }
            newItem[count++] = value;
            System.out.println("---- size of item" + items.length);
            items = newItem;
        }else {
            items[count++] = value;
        }

    }
}

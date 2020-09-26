package lesson2;

public class Main {
//1
    public static void main(String[] args) {

        String[][] arr = new String[][]{{"1", "2", "4", "4"}, {"5", "6", "7", "8"}, {"3", "8", "1", "2"}, {"2", "6", "7", "3"}};
        try {
            try {
                int result = checkChar(arr);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                e.printStackTrace();
                System.out.println("Размер массива превышен");
            }
        }
        catch (MyArrayDataException e) {
            System.out.println("Неправильное значение массива");
            System.out.println("Ошибка в ячейке: " + e.i + "-" + e.j);
        }

    }


    public static int checkChar(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return count;
    }

}
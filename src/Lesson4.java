import java.util.Random;
import java.util.Scanner;

public class Lesson4 {

    static char [][] map;
    static final int SIZE =3;
    static final int DOT_TO_WIN =3;

    static final char DOT_EMPTY ='.';
    static final char DOT_X ='X';
    static final char DOT_0 ='0';
    static Random rand=new Random();
    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checWin0(DOT_X)) {
                System.out.println("победил человек");
                break;
            }
            if (isFull()) {
                System.out.println("ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checWin0(DOT_0)) {
                System.out.println("победил комп");
                break;
            }
            if (isFull()) {
                System.out.println("ничья");
                break;
            }
        }
        System.out.println("game over");
    }
    public static boolean isFull(){
        int k=0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j <SIZE ; j++) {
                if(map[i][j]==DOT_EMPTY){
                    k++;
                }
            }

        }
        return k==0;
    }

    public static void initMap() {
        map=new char[SIZE][SIZE];
        for(int i=0; i<SIZE; i++){
            for (int j = 0; j <SIZE ; j++) {
                map[i][j]=DOT_EMPTY;
            }

        }
    }
    public static void printMap(){
        for (int i = 0; i <=SIZE; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i+1)+" ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j]+" ");

            }
            System.out.println();
        }
        System.out.println();
    }



    //проверка ячеек метод isCellVal()

    public static boolean isCellValid(int x, int y){
        if (x<0|| x>=SIZE||y<0||y>=SIZE)return false;
        return map[y][x]==DOT_EMPTY;
    }

    //ход человека

    public static void humanTurn(){
        int x,y;
        do {
            System.out.println("введите координаты X, Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        }while (!isCellValid(x,y));
        map[y][x]=DOT_X;

    }
    //Ход комп.


    public static void aiTurn(){
        int x,y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);

        }while (!isCellValid(x,y));
        System.out.println("комп сходил в точку" +(x+1)+" "+(y+1));
        map[y][x]=DOT_0;
    }

    //алгоритм победы

    public static boolean checWin0(char symb){
        if (map[0][0]==symb&& map[0][1]==symb&&map[0][2]==symb) return true;
        if (map[1][0]==symb&& map[1][1]==symb&&map[1][2]==symb) return true;
        if (map[2][0]==symb&& map[2][1]==symb&&map[2][2]==symb) return true;
        if (map[0][0]==symb&& map[1][0]==symb&&map[2][0]==symb) return true;
        if (map[0][1]==symb&& map[1][1]==symb&&map[2][1]==symb) return true;
        if (map[0][2]==symb&& map[1][2]==symb&&map[2][2]==symb) return true;
        if (map[0][0]==symb&& map[1][1]==symb&&map[2][2]==symb) return true;
        if (map[2][0]==symb&& map[1][1]==symb&&map[0][2]==symb) return true;
        return false;
    }
}




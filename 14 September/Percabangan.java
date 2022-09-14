import java.util.*;
public class Percabangan {
    public static void main(String[] args) {
      String nama;
      int nilai;
      String keterangan;
      Scanner np = new Scanner(System.in);
      System.out.print("Masukkan nama : ");
      nama = np.nextLine();
      System.out.print("Masukkan nilai : ");
      nilai = np.nextInt();
      if (nilai >=60){
        keterangan = "Lulus";
      }
      else {
        keterangan = "Tidak Lulus";
        }
        System.out.println(nama + " " + keterangan);
     }
}
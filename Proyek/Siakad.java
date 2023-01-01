package com.company;

import java.util.Scanner;
public class Siakad {
    static int jumlahData = 0;
    static Mahasiswa[] mahasiswa = new Mahasiswa[1000];

    public static void tambahData() {
        System.out.println("Silahkan tambah data");
        Scanner scan = new Scanner(System.in);
        System.out.print("Masukan NIM = ");
        String nim = scan.nextLine();
        System.out.print("Masukan Nama = ");
        String nama = scan.nextLine();
        mahasiswa[jumlahData] = new Mahasiswa();
        mahasiswa[jumlahData].setNim(nim);
        mahasiswa[jumlahData].setNama(nama);
        jumlahData = jumlahData + 1;
    }

    public static void tampilData() {
        System.out.println("Berikut data Anda");
        int i = 0;
        while (i < jumlahData) {
            System.out.println(mahasiswa[i].getNim() + "  " + mahasiswa[i].getNama());
            i++;
        }
    }

    public static void urutkanData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pilih algoritma pengurutan");
        System.out.println("1. EXCHANGE SORT");
        System.out.println("2. SELECTION SORT");
        System.out.println("3. QUICK SORT");
        System.out.print("Pilih algoritma = ");
        int algo = scanner.nextInt();
        switch (algo) {
            case 1: {
                exchangeSort();
                break;
            }
            case 3: {
                quickSort(mahasiswa, 0, jumlahData - 1);
                break;
            }
        }
    }

    public static void quickSort(Mahasiswa[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    static int partition(Mahasiswa[] arr, int low, int high) {
        int p = low, j;
        for (j = low + 1; j <= high; j++)
            if (arr[j].getNim().compareTo(arr[low].getNim()) <= -1)
                swap(arr, ++p, j);

        swap(arr, low, p);
        return p;
    }

    static void swap(Mahasiswa[] arr, int low, int pivot) {
        Mahasiswa tmp = arr[low];
        arr[low] = arr[pivot];
        arr[pivot] = tmp;
    }

    public static void exchangeSort() {
        for (int x = 0; x < jumlahData; x++) {
            for (int y = x + 1; y < jumlahData; y++) {
                if (mahasiswa[x].getNim().compareTo(mahasiswa[y].getNim()) >= 1) {
                    Mahasiswa temp = mahasiswa[x];
                    mahasiswa[x] = mahasiswa[y];
                    mahasiswa[y] = temp;
                }
            }
        }
    }

    public static void cariData() {
        Scanner search = new Scanner(System.in);
        System.out.print("Masukkan NIM mahasiswa yang ingin dicari : ");
        String cari = search.nextLine();
        for (i = 0; i < 1000; i++) {
            if (mahasiswa[i].getNim() == cari) {
                System.out.println(mahasiswa[i].getNim() + "  " + mahasiswa[i].getNama());
            } else {
                System.out.println("Mahasiswa tidak ada dalam daftar");
            }
        }
    }

    public static void editData() {
        Scanner editing = new Scanner(System.in);
        System.out.println("Data yang ingin diganti");
        System.out.println("1. NIM");
        System.out.println("2. Nama");
        System.out.print("Masukkan data yang ingin diganti : ");
        int edit = editing.nextInt();
        if (edit == 1){
            System.out.print("Masukkan NIM yang ingin diganti: ");
            String nimLama= editing.nextLine();
            for (int i=0; i<1000 ; i++ ){
                if(mahasiswa[i].getNim() == nimLama){
                    System.out.print("Masukkan NIM baru : ");
                    String newNim = editing.nextLine();
                    mahasiswa[i].getNim() = newNim;
                    }
                else {
                    System.out.println("NIM yang Anda masukkan salah!");
                }
            }
        }
        else if(edit== 2){
            System.out.print("Masukkan nama yang ingin diganti: ");
            String namaLama= editing.nextLine();
            for (int i=0; i<1000 ; i++ ){
                if(mahasiswa[i].getNama() == namaLama){
                    System.out.print("Masukkan Nama baru : ");
                    String newNama = editing.nextLine();
                    mahasiswa[i].getNama() = newNama;
                }
                else {
                    System.out.println("Nama yang yang Anda masukkan salah!");
                }
            }
        }
        else {
            System.out.println("Menu yang anda masukkan tidak valid!");
        }
    }

    public static void hapusData() {
        Scanner delete = new Scanner(System.in);
        System.out.print("Masukkan NIM mahasiswa yang ingin dihapus : ");
        String hapus = delete.nextLine();
        for (i = 0; i < 1000; i++) {
            if (mahasiswa[i].getNim() == hapus) {
                mahasiswa[i].getNim()= null;
                mahasiswa[i].getNama() = null;
            } else {
                System.out.println("Mahasiswa tidak ada dalam daftar");
            }
        }
    }
	
	public static void UAS(){
	if (jumlahData==0) {
            System.out.println("Tidak ada data");
        } else {
            int jarak = jumlahData;
            int susut = 13;
            int urut = 0;
            while(urut == 0) {
                jarak = (jarak*10) / susut;
                if(jarak <= 1) {
                    jarak = 1;
                    urut = 1;
                }
                for(int i=0; (i+jarak)<jumlahData; i++) {
                    if(mahasiswa[i].getNim() > mahasiswa[i+jarak].getNim()) {
                        Mahasiswa temp = mahasiswa[i];
                        mahasiswa[i] = mahasiswa[i+jarak];
                        mahasiswa[i+jarak] = temp;
                        urut = 0;
                    }
                }
            }
            System.out.println("Data telah diurutkan. Silahkan tampilkan data");
			}
	}
	
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int menu;
        do {
            System.out.println("Menu Siakad");
            System.out.println("1. Tambah Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Urutkan Data");
            System.out.println("4. Cari Data");
            System.out.println("5. Edit Data");
            System.out.println("6. Hapus Data");
            System.out.println("7. UAS");
			System.out.println("8. Keluar");
            System.out.print("Pilih menu = ");
            menu = scan.nextInt();
            if (menu==1) {
                tambahData();
            } else if (menu==2) {
                tampilData();
            } else if (menu==3) {
                urutkanData();
            } else if (menu==4) {
                cariData();
            } else if (menu==5) {
                editData();
            }else if (menu==6){
                hapusData();
            }else if (menu==7){
                UAS();
            }

        } while (menu!=8);
    }
}